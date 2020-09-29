package HomeRent.contract;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.core.env.Environment;

import java.nio.charset.Charset;

@SpringBootTest
public class EncryptTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PooledPBEStringEncryptor pbeEnc = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setAlgorithm("PBEWITHSHA256AND256BITAES-CBC-BC");
        config.setPassword("DefaultPassword");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProvider(new BouncyCastleProvider());
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        pbeEnc.setConfig(config);

//        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
//        pbeEnc.setAlgorithm("PBEWITHSHA256AND256BITAES-CBC-BC");
//        pbeEnc.setPassword("DefaultPassword");

        String url = "jdbc:mysql://localhost:3306/testDB";
        String username = "test";
        String password = "test";

        System.out.println("기존  URL :: " + url + " | 변경 URL :: " + pbeEnc.encrypt(url));
        System.out.println("기존  username :: " + username + " | 변경 username :: " + pbeEnc.encrypt(username));
        System.out.println("기존  password :: " + password + " | 변경 password :: " + pbeEnc.encrypt(password));
        System.out.println(Charset.defaultCharset().displayName());
    }

}

