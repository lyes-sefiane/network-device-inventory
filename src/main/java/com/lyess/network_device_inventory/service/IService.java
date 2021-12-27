package com.lyess.network_device_inventory.service;

import java.util.List;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-25 3:59 p.m.
 */
public interface IService<T> {

    List<T> findAll();

    T findById(String id);

    T save(T networkDeviceDto);

    T update(T networkDeviceDto, String id);
}
