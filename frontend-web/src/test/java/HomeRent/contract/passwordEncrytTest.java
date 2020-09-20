package HomeRent.contract;

import antlr.BaseAST;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.nio.charset.Charset;

@SpringBootTest
public class passwordEncrytTest {


    @Autowired
    private static BCryptPasswordEncoder pwEncoder;

    public static void main(String[] args) {
        //
        pwEncoder = new BCryptPasswordEncoder();
        String url = "jdbc:mysql://localhost:3306/testDB";
        String username = "test";
        String password = "test";

        System.out.println("기존  URL :: " + url + " | 변경 URL :: " + pwEncoder.encode(url));
        System.out.println("기존  username :: " + username + " | 변경 username :: " + pwEncoder.encode(username));
        System.out.println("기존  password :: " + password + " | 변경 password :: " + pwEncoder.encode(password));

    }
}
