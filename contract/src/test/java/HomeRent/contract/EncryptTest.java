package HomeRent.contract;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.Charset;

@SpringBootTest
public class EncryptTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithSHA1AndDESede");
        pbeEnc.setPassword("DefaultPassword");

        String url = "jdbc:mysql://localhost:3306/testDB";
        String username = "test";
        String password = "test";

        System.out.println("기존  URL :: " + url + " | 변경 URL :: " + pbeEnc.encrypt(url));
        System.out.println("기존  username :: " + username + " | 변경 username :: " + pbeEnc.encrypt(username));
        System.out.println("기존  password :: " + password + " | 변경 password :: " + pbeEnc.encrypt(password));
        System.out.println(Charset.defaultCharset().displayName());
    }

}

