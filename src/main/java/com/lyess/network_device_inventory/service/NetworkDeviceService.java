package com.lyess.network_device_inventory.service;

import com.lyess.network_device_inventory.converter.IModelMapper;
import com.lyess.network_device_inventory.domain.entites.NetworkDevice;
import com.lyess.network_device_inventory.dto.entities.NetworkDeviceDto;
import com.lyess.network_device_inventory.exception.NetworkDeviceNotFoundException;
import com.lyess.network_device_inventory.repository.INetworkDeviceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
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

    private final IModelMapper<NetworkDeviceDto, NetworkDevice> modelMapper;

    @Autowired
    public NetworkDeviceService(INetworkDeviceRepository networkDeviceRepository, IModelMapper<NetworkDeviceDto, NetworkDevice> modelMapper) {
        this.networkDeviceRepository = networkDeviceRepository;
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
        return modelMapper.toDto(findOrElseThrow(id));
    }

    @Override
    public NetworkDeviceDto save(NetworkDeviceDto networkDeviceDto) {
        return modelMapper.toDto(networkDeviceRepository.save(modelMapper.toEntity(networkDeviceDto)));
    }

    @Override
    public NetworkDeviceDto update(NetworkDeviceDto networkDeviceDto, String id) {
        NetworkDevice existingNetworkDevice = findOrElseThrow(id);
        NetworkDevice receivedNetworkDevice = modelMapper.toEntity(networkDeviceDto);
        BeanUtils.copyProperties(receivedNetworkDevice, existingNetworkDevice);
        return modelMapper.toDto(networkDeviceRepository.save(existingNetworkDevice));
    }

    @Override
    public void delete(String id) {
        networkDeviceRepository.delete(findOrElseThrow(id));
    }

    private NetworkDevice findOrElseThrow(String id) {
        return networkDeviceRepository.findById(id).orElseThrow(NetworkDeviceNotFoundException::new);
    }

}
