package com.lyess.network_device_inventory_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class NetworkDeviceInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetworkDeviceInventoryApplication.class, args);
	}

}
