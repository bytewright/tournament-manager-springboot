package org.bytewright.springbootvue.jpa.converter;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


@Converter(autoApply = false)
public class RoleConverter implements AttributeConverter<Set<String>, String> {

    @Override
    public String convertToDatabaseColumn(Set<String> attribute) {
        return String.join(";", attribute);
    }

    @Override
    public Set<String> convertToEntityAttribute(String dbData) {
        return Arrays.stream(dbData.split(";"))
                .filter(StringUtils::isNotBlank)
                .map(String::trim)
                .collect(Collectors.toSet());
    }
}
