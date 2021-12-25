package com.lyess.network_device_inventory.dto.converter;

import com.lyess.network_device_inventory.domain.entites.Connection;
import com.lyess.network_device_inventory.domain.entites.Neighbor;
import com.lyess.network_device_inventory.domain.entites.NetworkDevice;
import com.lyess.network_device_inventory.domain.enums.ElementType;
import com.lyess.network_device_inventory.dto.NeighborDto;
import com.lyess.network_device_inventory.dto.NetworkDeviceDto;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-25 12:17 p.m.
 */
public class DtoEntityConverter implements CustomConverter<NetworkDeviceDto, NetworkDevice> {

    /**
     * Convert DTO to Entity
     *
     * @param networkDeviceDto
     * @return networkDevice
     */
    @Override
    public NetworkDevice convert(NetworkDeviceDto networkDeviceDto) {

        NetworkDevice networkDevice = NetworkDevice.builder()//
                .ipAddress(networkDeviceDto.getAddress())//
                .elementType(ElementType.getEnumByValue(networkDeviceDto.getElementType()))//
                .build();

        Set<Connection> connections = networkDeviceDto.getNeighbors()//
                .stream()//
                .map(neighborDto -> new Connection(networkDevice, new Neighbor(neighborDto.getAddress()), neighborDto.getCost()))//
                .collect(Collectors.toSet());

        return networkDevice;
    }

    /**
     * Convert Entity to DTO
     *
     * @param networkDevice
     * @return networkDeviceDto
     */
    @Override
    public NetworkDeviceDto convertEntityToDto(NetworkDevice networkDevice) {

        NetworkDeviceDto networkDeviceDto = NetworkDeviceDto.builder()//
                .address(networkDevice.getIpAddress())//
                .elementType(networkDevice.getElementType().getValue())//
                .build();

        Set<NeighborDto> neighbors = networkDevice.getConnections()//
                .stream()//
                .map(connection -> new NeighborDto(connection.getConnectionId().getNeighbor_ipaddress(), connection.getCost()))//
                .collect(Collectors.toSet());

        networkDeviceDto.setNeighbors(neighbors);

        return networkDeviceDto;
    }

}
