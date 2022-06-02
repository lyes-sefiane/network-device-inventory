package com.lyess.network_device_inventory_service.exception;

import com.lyess.network_device_inventory_service.domain.entites.NetworkDevice;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-31 9:25 a.m.
 */
public class NetworkDeviceAlreadyExistsException extends RuntimeException {

    private final static String DEFAULT_MESSAGE = "network device already exists.";

    public NetworkDeviceAlreadyExistsException(NetworkDevice networkDevice) {
        super(networkDevice.getClass().getCanonicalName() + " with id " + networkDevice.getIpAddress() + " already exists");
    }

}
