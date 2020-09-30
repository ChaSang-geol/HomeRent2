package HomeRent.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class Seed {

//    public static Environment environment ;

    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    private static  byte[] pbszUserKey;
    private static  byte[] pbszIV ;

//    private static final byte[] pbszUserKey = seedkey1.getBytes();
//    private static final byte[] pbszIV      = seedkey2.getBytes();

//    private static String seedkey1;
    @Value("${my.seedkey.key1}")
    public void setKey1(String key1) {
//        this.seedkey1 = key1;
        pbszUserKey = key1.getBytes();
    }

//    private static String seedkey2;
    @Value("${my.seedkey.key2}")
    public void setKey2(String key2) {
//        this.seedkey2 = key2 ;
        pbszIV = key2.getBytes();
    }

    public void Seed() {}
//    @PostConstruct
//    private void initialize() {
//
//        String seedkey1 = environment.getProperty("my.seedkey.key1");
//        String seedkey2 = environment.getProperty("my.seedkey.key2");
//        System.out.println(seedkey1 + " : ### SEED KEY");
//        pbszUserKey = seedkey1.getBytes();
//        pbszIV = seedkey2.getBytes();
//    }



    public static String encrypt(String plainMessage) {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] message = plainMessage.getBytes(UTF_8);
        byte[] encryptedMessage = KISA_SEED_CBC.SEED_CBC_Encrypt(pbszUserKey, pbszIV, message, 0, message.length);
        return new String(encoder.encode(encryptedMessage), UTF_8);
    }

    public static String decrypt(String encryptedMessage) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] message = decoder.decode(encryptedMessage);
        byte[] decryptedMessage = KISA_SEED_CBC.SEED_CBC_Decrypt(pbszUserKey, pbszIV, message, 0, message.length);
        return new String(decryptedMessage, UTF_8);
    }

}
