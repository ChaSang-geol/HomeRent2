package HomeRent.contract;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EncryptTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword("#$%^&*OdysseyMoon*&^%$#");

        String url = "jdbc:mysql://localhost:3306/toma";
        String username = "test";
        String password = "test";

        System.out.println("기존  URL :: " + url + " | 변경 URL :: " + pbeEnc.encrypt(url));
        System.out.println("기존  username :: " + username + " | 변경 username :: " + pbeEnc.encrypt(username));
        System.out.println("기존  password :: " + password + " | 변경 password :: " + pbeEnc.encrypt(password));
    }

}

