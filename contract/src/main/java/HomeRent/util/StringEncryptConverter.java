package HomeRent.util;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

@Converter
public class StringEncryptConverter implements AttributeConverter<String, String> {

    @Autowired
    public  StringEncryptor jasyptStringEncryptor ;;
/*
    @Autowired
    @Qualifier("jasyptStringEncryptor")
    public void setStringEncryptor(StringEncryptor encryptor) {
        StringEncryptConverter.jasyptStringEncryptor = encryptor;
    }

    @Override
    public String convertToDatabaseColumn(String entityString) {

        return Optional.ofNullable(entityString)
                .filter(s -> !s.isEmpty())
                .map(StringEncryptConverter.jasyptStringEncryptor::encrypt)
                .orElse("");
    }

    @Override
    public String convertToEntityAttribute(String dbString) {

        return Optional.ofNullable(dbString)
                .filter(s -> !s.isEmpty())
                .map(StringEncryptConverter.jasyptStringEncryptor::decrypt)
                .orElse("");
    }

 */
    @Override
    public String convertToDatabaseColumn(String entityString) {
        if (entityString == null) return null;
        return jasyptStringEncryptor.encrypt(entityString);
    }
    @Override
    public String convertToEntityAttribute(String dbString) {
        if (dbString == null) return null;
        return jasyptStringEncryptor.decrypt(dbString);
    }

}