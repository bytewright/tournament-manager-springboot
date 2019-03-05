package org.bytewright.springbootvue.jpa.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class DataProtectionConverter implements AttributeConverter<String, String> {
  private static final Logger LOGGER = LoggerFactory.getLogger(DataProtectionConverter.class.getSimpleName());

//  private static final String SALT = new String(Base64.getDecoder().decode("MySaltBecauseOfEuDP"));
//  private static final String PASSWORD = new String(Base64.getDecoder().decode("MyPWBecauseOfEuDP"));
//  private TextEncryptor encryptor = Encryptors.queryableText(PASSWORD, SALT);

  @Override
  public String convertToDatabaseColumn(String attribute) {
    return attribute;
//    LOGGER.info("SALT:{}", SALT);
//    return encryptor.encrypt(attribute);
  }

  @Override
  public String convertToEntityAttribute(String dbData) {
    return dbData;
//    return encryptor.decrypt(dbData);
  }
}
