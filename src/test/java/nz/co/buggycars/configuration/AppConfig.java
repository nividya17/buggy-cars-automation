package nz.co.buggycars.configuration;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.Getter;

import java.util.Objects;

@Getter
public class AppConfig {

    private final String webAppUrl;
    private final String testUserLoginId;
    private final String testUserPassword;
    public static final AppConfig INSTANCE = new AppConfig();


    private AppConfig() {
        Dotenv dotenv = Dotenv.configure().load();
        this.webAppUrl = Objects.requireNonNull(dotenv.get(EnvVar.WEB_APP_URL.name()), errorMessage(EnvVar.WEB_APP_URL));
        this.testUserLoginId = Objects.requireNonNull(dotenv.get(EnvVar.REGISTERED_TEST_USER.name()), errorMessage(EnvVar.REGISTERED_TEST_USER));
        this.testUserPassword = Objects.requireNonNull(dotenv.get(EnvVar.TEST_USER_PASSWORD.name()), errorMessage(EnvVar.TEST_USER_PASSWORD));
    }

    private String errorMessage(EnvVar envVar) {
        return String.format("%s env variable is not configured", envVar.name());
    }

    private enum EnvVar {
        WEB_APP_URL,
        REGISTERED_TEST_USER,
        TEST_USER_PASSWORD
    }
}
