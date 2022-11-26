package zpi.algospace;

import com.wix.mysql.config.MysqldConfig;
import lombok.SneakyThrows;
import org.springframework.test.context.ActiveProfiles;

import static com.wix.mysql.EmbeddedMysql.anEmbeddedMysql;
import static com.wix.mysql.ScriptResolver.classPathScript;
import static com.wix.mysql.config.MysqldConfig.aMysqldConfig;
import static com.wix.mysql.distribution.Version.v5_7_latest;
import static java.lang.System.setProperty;

@ActiveProfiles("mysql-test")
public class EmbeddedMysql {
    private static final String DB_USER = "testUser";
    private static final String DB_PASS = "testPass";

    private static com.wix.mysql.EmbeddedMysql embeddedMysql;

    @SneakyThrows
    public EmbeddedMysql(String pathToSqlScript) {
        MysqldConfig config = aMysqldConfig(v5_7_latest)
                .withFreePort()
                .withUser(DB_USER, DB_PASS)
                .build();

        String url = String.format("jdbc:mysql://localhost:%d/test", config.getPort());
        setProperty("spring.datasource.url", url);
        setProperty("spring.datasource.username", DB_USER);
        setProperty("spring.datasource.password", DB_PASS);

        embeddedMysql = anEmbeddedMysql(config)
                .addSchema("test", classPathScript(pathToSqlScript))
                .start();
    }

    public void stopMySql(){
        embeddedMysql.stop();
    }
}
