package com.lyess.network_device_inventory.controller;

import com.lyess.network_device_inventory.dto.entities.NetworkDeviceDto;
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


}
