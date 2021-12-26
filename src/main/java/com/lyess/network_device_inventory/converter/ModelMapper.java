package com.lyess.network_device_inventory.converter;

import com.lyess.network_device_inventory.domain.entites.Connection;
import com.lyess.network_device_inventory.domain.entites.Neighbor;
import com.lyess.network_device_inventory.domain.entites.NetworkDevice;
import com.lyess.network_device_inventory.domain.enums.ElementType;
import com.lyess.network_device_inventory.dto.entities.NeighborDto;
import com.lyess.network_device_inventory.dto.entities.NetworkDeviceDto;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

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

        return networkDeviceDto;
    }
}
