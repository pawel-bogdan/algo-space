package zpi.algospace.complementer;

import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.config.MysqldConfig;
import lombok.SneakyThrows;
import org.springframework.test.context.ActiveProfiles;

import static com.wix.mysql.EmbeddedMysql.anEmbeddedMysql;
import static com.wix.mysql.ScriptResolver.classPathScript;
import static com.wix.mysql.config.MysqldConfig.aMysqldConfig;
import static com.wix.mysql.distribution.Version.v5_7_latest;
import static java.lang.System.setProperty;

@ActiveProfiles("mysql-test")
public class EmbeddedMysqlForComplementers {

    private static EmbeddedMysql embeddedMysql;
    private static final String DB_USER = "testUser";
    private static final String DB_PASS = "testPass";

    @SneakyThrows
    public EmbeddedMysqlForComplementers() {
        MysqldConfig config = aMysqldConfig(v5_7_latest)
                .withFreePort()
                .withUser(DB_USER, DB_PASS)
                .build();

        String connectionString = String.format("jdbc:mysql://localhost:%d/test", config.getPort());
        setProperty("spring.datasource.url", connectionString);
        setProperty("spring.datasource.username", DB_USER);
        setProperty("spring.datasource.password", DB_PASS);

        embeddedMysql = anEmbeddedMysql(config)
                .addSchema("test", classPathScript("initTasks.sql"))
                .start();
    }

    public void stopMysql(){
        embeddedMysql.stop();
    }
}
