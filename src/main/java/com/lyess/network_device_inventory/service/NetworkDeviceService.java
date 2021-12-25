package com.lyess.network_device_inventory.service;

import com.lyess.network_device_inventory.dto.converter.DtoEntityConverter;
import com.lyess.network_device_inventory.repository.NetworkDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-25 2:31 p.m.
 */
@Service
public class NetworkDeviceService {

    private final NetworkDeviceRepository networkDeviceRepository;

    private final DtoEntityConverter dtoEntityConverter;

    @Autowired
    public NetworkDeviceService(NetworkDeviceRepository networkDeviceRepository, DtoEntityConverter dtoEntityConverter) {
        this.networkDeviceRepository = networkDeviceRepository;
        this.dtoEntityConverter = dtoEntityConverter;
    }
}
