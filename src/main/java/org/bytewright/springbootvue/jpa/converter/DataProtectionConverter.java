package org.bytewright.springbootvue.jpa.converter;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

import javax.persistence.AttributeConverter;

public class DataProtectionConverter implements AttributeConverter<String, String> {

    private static final String SALT = "MySaltBecauseOfEuDP";
    private static final String PASSWORD = "MyEuDP-PW";
    private TextEncryptor encryptor = Encryptors.text(PASSWORD, SALT);

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return encryptor.encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return encryptor.decrypt(dbData);
    }
}
