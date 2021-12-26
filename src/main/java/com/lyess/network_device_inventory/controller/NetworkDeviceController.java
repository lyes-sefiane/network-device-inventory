package com.lyess.network_device_inventory.controller;

import com.lyess.network_device_inventory.dto.entities.NetworkDeviceDto;
import com.lyess.network_device_inventory.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-25 1:55 p.m.
 */
@RestController
@RequestMapping(value = "/v1/network-devices", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class NetworkDeviceController {

    private final IService networkDeviceService;

    @Autowired
    public NetworkDeviceController(IService networkDeviceService) {
        this.networkDeviceService = networkDeviceService;
    }


    @GetMapping("/")
    public List<NetworkDeviceDto> findAllNetworkDevice(){
        return networkDeviceService.findAll();
    }
}
