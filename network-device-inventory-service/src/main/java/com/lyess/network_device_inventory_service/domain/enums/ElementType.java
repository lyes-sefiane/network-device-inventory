package com.lyess.network_device_inventory_service.domain.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-23 10:39 a.m.
 */
public enum ElementType {

    ROUTER("router"), //
    SERVER("server"), //
    WIRELESS_ROUTER("wireless router"), //
    SWITCH("switch"),
    LAPTOP("laptop"), //
    DESKTOP_COMPUTER("desktop computer"),//
    UNKNOWN("unknown");

    private static final Logger log = LoggerFactory.getLogger(ElementType.class);

    private static final Map<String, ElementType> mapOfEnumsByValue = Arrays.stream(ElementType.values()).collect(Collectors.toMap(entry -> entry.value, entry -> entry));

    private final String value;

    ElementType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Map<String, ElementType> getMapOfEnumsByValue() {
        return mapOfEnumsByValue;
    }

    /**
     * Get Enum By Value
     *
     * @param value
     * @return elementType
     */
    public static ElementType getEnumByValue(String value) {

        if (value == null) {
            log.trace("In getEnumByValue : the value is null !");
            throw new IllegalArgumentException("In getEnumByValue : the value is null !");
        }

        final ElementType result = mapOfEnumsByValue.get(value);

        if (result == null) {
            log.trace("In getEnumByValue : the result is null !");
            throw new IllegalArgumentException("In getEnumByValue : the Enum of " + value + " is null !");
        }
        return result;
    }
}
