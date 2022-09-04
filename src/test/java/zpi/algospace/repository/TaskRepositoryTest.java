package zpi.algospace.repository;

import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.config.MysqldConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

import static com.wix.mysql.EmbeddedMysql.anEmbeddedMysql;
import static com.wix.mysql.ScriptResolver.classPathScript;
import static com.wix.mysql.config.MysqldConfig.aMysqldConfig;
import static com.wix.mysql.distribution.Version.v5_7_latest;
import static java.lang.System.setProperty;

@ActiveProfiles("mysql-test")
class TaskRepositoryTest {

    private static String DB_USER = "testUser";
    private static String DB_PASS = "testPass";
    private TaskRepository taskRepository;
    private static EmbeddedMysql embeddedMysql;
    private static String CONNECTION_STRING;

    @BeforeAll
    private static void setUp() throws IOException {
        MysqldConfig config = aMysqldConfig(v5_7_latest)
                .withFreePort()
                .withUser(DB_USER, DB_PASS)
                .build();

        CONNECTION_STRING = String.format("jdbc:mysql://localhost:%d/test", config.getPort());
        setProperty("spring.datasource.url", CONNECTION_STRING);

        embeddedMysql = anEmbeddedMysql(config)
                .addSchema("test", classPathScript("init.sql"))
                .start();
    }

    @AfterAll
    private static void tearDown(){
        embeddedMysql.stop();
    }
}