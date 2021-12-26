package com.lyess.network_device_inventory.converter;

import com.lyess.network_device_inventory.domain.entites.NetworkDevice;
import com.lyess.network_device_inventory.dto.entities.NetworkDeviceDto;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-25 12:14 p.m.
 */
public interface IConverter<S extends NetworkDeviceDto,T extends NetworkDevice> {

     T toEntity(S s);

     S toDto(T t);

}
