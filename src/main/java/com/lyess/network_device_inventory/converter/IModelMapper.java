package com.lyess.network_device_inventory.converter;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-25 12:14 p.m.
 */
public interface IModelMapper<S,T> {

     T toEntity(S s);

     S toDto(T t);

}
