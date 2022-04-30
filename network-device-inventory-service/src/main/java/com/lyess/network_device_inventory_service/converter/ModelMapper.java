package com.lyess.network_device_inventory_service.converter;

import com.lyess.network_device_inventory_service.controller.NetworkDeviceController;
import com.lyess.network_device_inventory_service.domain.entites.Connection;
import com.lyess.network_device_inventory_service.domain.entites.Neighbor;
import com.lyess.network_device_inventory_service.domain.entites.NetworkDevice;
import com.lyess.network_device_inventory_service.domain.enums.ElementType;
import com.lyess.network_device_inventory_service.dto.entities.NeighborDto;
import com.lyess.network_device_inventory_service.dto.entities.NetworkDeviceDto;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-25 12:17 p.m.
 */
@Component
public class ModelMapper implements IModelMapper<NetworkDeviceDto, NetworkDevice> {

    /**
     * Convert DTO to Entity
     *
     * @param networkDeviceDto
     * @return networkDevice
     */
    @Override
    public NetworkDevice toEntity(NetworkDeviceDto networkDeviceDto) {

        NetworkDevice networkDevice = NetworkDevice.builder()//
                .ipAddress(networkDeviceDto.getAddress())//
                .elementType(ElementType.getEnumByValue(networkDeviceDto.getElementType()))//
                .build();

        Set<Connection> connections = networkDeviceDto.getNeighbors()//
                .stream()//
                .map(neighborDto -> new Connection(networkDevice, new Neighbor(neighborDto.getAddress()), neighborDto.getCost()))//
                .collect(Collectors.toSet());

        networkDevice.setConnections(connections);

        return networkDevice;
    }

    /**
     * Convert Entity to DTO
     *
     * @param networkDevice
     * @return networkDeviceDto
     */
    @Override
    public NetworkDeviceDto toDto(NetworkDevice networkDevice) {

        NetworkDeviceDto networkDeviceDto = NetworkDeviceDto.builder()//
                .address(networkDevice.getIpAddress())//
                .elementType(networkDevice.getElementType().getValue())//
                .build();

        Set<NeighborDto> neighbors = networkDevice.getConnections()//
                .stream()//
                .map(connection -> new NeighborDto(connection.getConnectionId().getNeighbor_ipaddress(), connection.getCost()))//
                .collect(Collectors.toSet());

        networkDeviceDto.setNeighbors(neighbors);

        Link link = linkTo(methodOn(NetworkDeviceController.class).findById(networkDeviceDto.getAddress())).withSelfRel();

        networkDeviceDto.add(link);

        return networkDeviceDto;
    }
}
