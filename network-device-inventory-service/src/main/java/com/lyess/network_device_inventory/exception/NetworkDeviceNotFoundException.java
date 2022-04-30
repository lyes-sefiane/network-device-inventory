package com.lyess.network_device_inventory.exception;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-26 12:44 p.m.
 */
public class NetworkDeviceNotFoundException extends RuntimeException {

    private final static String DEFAULT_MESSAGE = "network device not found";

    public NetworkDeviceNotFoundException() {
        this(DEFAULT_MESSAGE);
    }

    public NetworkDeviceNotFoundException(String message) {
        super(message);
    }

}
