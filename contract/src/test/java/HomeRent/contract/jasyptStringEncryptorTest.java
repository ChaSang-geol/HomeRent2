package HomeRent.contract;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.jasypt.encryption.StringEncryptor;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Slf4j
public class jasyptStringEncryptorTest {

    @Autowired
    public  StringEncryptor jasyptStringEncryptor ;

    @Test
    public void _0_testInit() {
        assertThat(jasyptStringEncryptor).isNotNull();
    }

    @Test
    public void _1_encrypt_decrypt() {

        String orgText = "TestValue";

        String encText = jasyptStringEncryptor.encrypt(orgText);
        log.info("##### encText : {}", encText);

        String decText = jasyptStringEncryptor.decrypt(encText);
        log.info("##### decText : {}", decText);

        Assertions.assertThat(decText).isEqualTo(orgText);

        String str1 = "test";
        String str2 = "1111111";
        String str3 = "010-1234-1234";
        System.out.println("원본 문자열 :: " + str1 + " | 암호화 문자열 :: " + jasyptStringEncryptor.encrypt(str1));
        System.out.println("원본 문자열 :: " + str2 + " | 암호화 문자열 :: " + jasyptStringEncryptor.encrypt(str2));
        System.out.println("원본 문자열 :: " + str3 + " | 암호화 문자열 :: " + jasyptStringEncryptor.encrypt(str3));

    }
}
