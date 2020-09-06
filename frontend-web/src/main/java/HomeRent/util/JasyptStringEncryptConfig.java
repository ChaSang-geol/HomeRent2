package HomeRent.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Configuration
//@EnableAutoConfiguration
public class JasyptStringEncryptConfig {
    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor(Environment environment) {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(environment.getProperty("jasypt.encryptor.password", "#$%^&*OdysseyMoon*&^%$#"));
        config.setAlgorithm("PBEWithSHA1AndDESede");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProvider(new BouncyCastleProvider());
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }


}