package HomeRent.contract;

import HomeRent.util.KISA_SEED_CBC;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SeedTest {

    private final byte[] pbszUserKey = "MySevurityKey123".getBytes();
    private final byte[] pbszIV = "1234567890123456".getBytes();
    private static final Charset UTF_8 = StandardCharsets.UTF_8;

    @Test
    public void 암복호화_테스트() {
        // given
        String rawMessage = "1111111";
        log.info("원본 데이터 =>" + rawMessage);

        Base64.Encoder encoder = Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();

        // when
        byte[] encryptedMessage = KISA_SEED_CBC.SEED_CBC_Encrypt(pbszUserKey, pbszIV, rawMessage.getBytes(), 0, rawMessage.getBytes(UTF_8).length);
        log.info("암호화된 데이터1 => " + new String(encryptedMessage));
        log.info("암호화된 데이터2 => " + encryptedMessage.toString());
        String encryptedMessageString = new String(encoder.encode(encryptedMessage), UTF_8);
        log.info("암호화된 데이터3 => " + encryptedMessageString);

        byte[] message = decoder.decode(encryptedMessageString);
        byte[] decryptedMessage = KISA_SEED_CBC.SEED_CBC_Decrypt(pbszUserKey, pbszIV, message, 0, message.length);

        String decryptedMessageString = new String(decryptedMessage, UTF_8);

        log.info("복호화된 데이터 => " + new String(decryptedMessage));
        log.info("복호화된 데이터2 => " + decryptedMessageString);
        // then
        assertThat(rawMessage).isEqualTo(decryptedMessageString);
        assertThat(rawMessage).isNotEqualTo(encryptedMessageString);
    }
}

        //출처: https://prohannah.tistory.com/80?category=870127 [Hello, Hannah!]

