package com.lyess.network_device_inventory.service;

import com.lyess.network_device_inventory.converter.IModelMapper;
import com.lyess.network_device_inventory.domain.entites.Connection;
import com.lyess.network_device_inventory.domain.entites.Neighbor;
import com.lyess.network_device_inventory.domain.entites.NetworkDevice;
import com.lyess.network_device_inventory.dto.entities.NetworkDeviceDto;
import com.lyess.network_device_inventory.exception.NetworkDeviceAlreadyExistsException;
import com.lyess.network_device_inventory.exception.NetworkDeviceNotFoundException;
import com.lyess.network_device_inventory.repository.INeighborRepository;
import com.lyess.network_device_inventory.repository.INetworkDeviceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-25 2:31 p.m.
 */
@Service
@Transactional
public class NetworkDeviceService implements IService<NetworkDeviceDto> {

    private static final Logger logger = LoggerFactory.getLogger(NetworkDeviceService.class);

    private final INetworkDeviceRepository networkDeviceRepository;

    private final INeighborRepository neighborRepository;

    private final IModelMapper<NetworkDeviceDto, NetworkDevice> modelMapper;

    @Autowired
    public NetworkDeviceService(INetworkDeviceRepository networkDeviceRepository, INeighborRepository neighborRepository, IModelMapper<NetworkDeviceDto, NetworkDevice> modelMapper) {
        this.networkDeviceRepository = networkDeviceRepository;
        this.neighborRepository = neighborRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<NetworkDeviceDto> findAll() {
        return networkDeviceRepository.findAll()
                .stream()
                .map(modelMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public NetworkDeviceDto findById(String id) {
        return modelMapper.toDto(networkDeviceRepository.findById(id).orElseThrow(NetworkDeviceNotFoundException::new));
    }

    @Override
    public NetworkDeviceDto save(NetworkDeviceDto networkDeviceDto) {
        networkDeviceRepository.findById(networkDeviceDto.getAddress()).ifPresent(networkDevice -> {
            throw new NetworkDeviceAlreadyExistsException(networkDevice);
        });

        NetworkDevice networkDevice = modelMapper.toEntity(networkDeviceDto);

        Set<Neighbor> neighbors = getNeighbors(networkDevice);

        Neighbor neighborFromNetworkDeviceSelf = new Neighbor(networkDevice.getIpAddress());

        neighbors.add(neighborFromNetworkDeviceSelf);

        neighborRepository.saveAll(neighbors);

        return modelMapper.toDto(networkDeviceRepository.save(networkDevice));
    }

    @Override
    public NetworkDeviceDto update(NetworkDeviceDto networkDeviceDto, String id) {
        NetworkDevice existingNetworkDevice = networkDeviceRepository.findById(id).orElseThrow(NetworkDeviceNotFoundException::new);
        NetworkDevice receivedNetworkDevice = modelMapper.toEntity(networkDeviceDto);
        BeanUtils.copyProperties(receivedNetworkDevice, existingNetworkDevice);
        Set<Neighbor> neighbors = getNeighbors(receivedNetworkDevice);
        neighborRepository.saveAll(neighbors);
        return modelMapper.toDto(networkDeviceRepository.save(existingNetworkDevice));
    }

    @Override
    public void delete(String id) {
        networkDeviceRepository.delete(networkDeviceRepository.findById(id).orElseThrow(NetworkDeviceNotFoundException::new));
    }

    private Set<Neighbor> getNeighbors(NetworkDevice networkDevice) {
        return networkDevice.getConnections()//
                .stream()//
                .map(Connection::getNeighbor)//
                .collect(Collectors.toSet());
    }

}
