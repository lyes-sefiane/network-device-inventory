package com.lyess.network_device_inventory.controller;

import com.lyess.network_device_inventory.dto.entities.NetworkDeviceDto;
import com.lyess.network_device_inventory.service.IService;
import com.lyess.network_device_inventory.utils.Defines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-25 1:55 p.m.
 */
@Validated
@RestController
@RequestMapping(value = "/v1/network-devices", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class NetworkDeviceController {

    private final IService<NetworkDeviceDto> networkDeviceService;

    @Autowired
    public NetworkDeviceController(IService<NetworkDeviceDto> networkDeviceService) {
        this.networkDeviceService = networkDeviceService;
    }


    @GetMapping("/")
    public List<NetworkDeviceDto> findAllNetworkDevice() {
        return networkDeviceService.findAll();
    }

    @GetMapping("/{id}")
    public NetworkDeviceDto findById(@PathVariable @Pattern(regexp = Defines.IP_REGEX, message = "Invalid Format") String id) {
        return networkDeviceService.findById(id);
    }

    @PostMapping("/")
    public NetworkDeviceDto save (@RequestBody @Valid NetworkDeviceDto networkDeviceDto) {
        return networkDeviceService.save(networkDeviceDto);
    }
}
