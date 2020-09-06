package HomeRent.contract;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
//import org.assertj.core.api.Assertions;
//import org.jasypt.encryption.StringEncryptor;
//import org.junit.FixMethodOrder;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.*;

@SpringBootTest
@Slf4j
class ContractApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public void encryptSimpleTest() {
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
		encryptor.setPassword("somePassword");
		encryptor.setAlgorithm("PBEWithMD5AndDES");
		encryptor.setPoolSize(1);
		String str = "testString";
		String encStr = encryptor.encrypt(str);
		String decStr = encryptor.decrypt(encStr);
		log.debug("str : {}, encStr : {}, decStr : {}", str, encStr, decStr);
	}


}
