package com.lyess.network_device_inventory_service.domain.enums.converter;

import com.lyess.network_device_inventory_service.domain.enums.ElementType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-24 11:05 a.m.
 */
@Converter
public class ElementTypeConverter implements AttributeConverter<ElementType, String>  {

    @Override
    public String convertToDatabaseColumn(ElementType elementType) {
        return elementType.getValue();
    }

    @Override
    public ElementType convertToEntityAttribute(String value) {
        return ElementType.getEnumByValue(value);
    }
}
