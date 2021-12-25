package com.lyess.network_device_inventory.dto.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-25 12:14 p.m.
 */
public interface CustomConverter<S,T> extends Converter<S, T> {

    public S convertEntityToDto(T t);

}
