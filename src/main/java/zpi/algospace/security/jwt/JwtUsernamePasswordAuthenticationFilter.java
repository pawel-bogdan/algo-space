package zpi.algospace.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@RequiredArgsConstructor
public class JwtUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UsernamePasswordAuthenticationRequest authenticationRequest;
        try {
            authenticationRequest = new ObjectMapper().readValue(request.getInputStream(), UsernamePasswordAuthenticationRequest.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Authentication authentication =
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword());

        return this.authenticationManager.authenticate(authentication);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) {
        var expirationDate = java.util.Date
                .from(LocalDateTime.now().plusMinutes(jwtConfig.getMinutesToTokenExpiration())
                        .atZone(ZoneId.systemDefault())
                        .toInstant());

        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities", authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(secretKey)
                .compact();
        response.addHeader(JwtConfig.AUTHORIZATION_HEADER, jwtConfig.getTokenPrefix() + token);
    }
}
