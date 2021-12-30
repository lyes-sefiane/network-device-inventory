package com.lyess.network_device_inventory.service;

import com.lyess.network_device_inventory.converter.ModelMapper;
import com.lyess.network_device_inventory.domain.entites.NetworkDevice;
import com.lyess.network_device_inventory.domain.enums.ElementType;
import com.lyess.network_device_inventory.dto.entities.NetworkDeviceDto;
import com.lyess.network_device_inventory.exception.NetworkDeviceNotFoundException;
import com.lyess.network_device_inventory.repository.INetworkDeviceRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-28 1:16 p.m.
 */
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NetworkDeviceServiceUnitTest {

    @Mock
    private INetworkDeviceRepository networkDeviceRepository;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private NetworkDeviceService networkDeviceService;

    private NetworkDevice networkDevice;

    @BeforeEach
    void setUp() {
        networkDevice = NetworkDevice.builder()
                .ipAddress("10.133.10.20")
                .elementType(ElementType.LAPTOP)
                .connections(new HashSet<>())
                .build();
    }

    @Test
    @Order(1)
    @DisplayName("CREATE Network Device")
    public void testSave() {
        // Given networkDevice

        // When
        when(networkDeviceRepository.save(any(NetworkDevice.class))).thenReturn(networkDevice);

        // Save NetworkDevice
        NetworkDeviceDto networkDeviceDto = networkDeviceService.save(modelMapper.toDto(networkDevice));

        // Then
        assertNotNull(networkDeviceDto);
        assertEquals("10.133.10.20", networkDeviceDto.getAddress());
        assertEquals(ElementType.LAPTOP.getValue(), networkDeviceDto.getElementType());
        assertEquals(0, networkDeviceDto.getNeighbors().size());
    }

    @Test
    @Order(2)
    @DisplayName("READ Network Device")
    public void testFindById() {
        // Given networkDevice

        // When
        when(networkDeviceRepository.findById(networkDevice.getIpAddress())).thenReturn(Optional.of(networkDevice));

        // Find NetworkDevice By Id
        NetworkDeviceDto networkDeviceDto = networkDeviceService.findById(networkDevice.getIpAddress());

        // Then
        assertNotNull(networkDeviceDto);
        assertEquals("10.133.10.20", networkDeviceDto.getAddress());
        assertEquals(ElementType.LAPTOP.getValue(), networkDeviceDto.getElementType());
        assertEquals(0, networkDeviceDto.getNeighbors().size());
    }


    @Test
    @Order(3)
    @DisplayName("UPDATE Network Device")
    public void testUpdate() {
        // Given networkDevice
        networkDevice.setElementType(ElementType.SWITCH);

        // When
        when(networkDeviceRepository.save(networkDevice)).thenReturn(networkDevice);
        when(networkDeviceRepository.findById(networkDevice.getIpAddress())).thenReturn(Optional.of(networkDevice));

        // Update NetworkDevice
        NetworkDeviceDto updatedNetworkDeviceDto = networkDeviceService.update(modelMapper.toDto(networkDevice), networkDevice.getIpAddress());

        // Then
        assertNotNull(updatedNetworkDeviceDto);
        assertEquals(updatedNetworkDeviceDto.getElementType(), networkDevice.getElementType().getValue());
    }

    @Test
    @Order(4)
    @DisplayName("DELETE Network Device")
    public void testDelete() {
        // Given networkDevice

        // When
        when(networkDeviceRepository.findById(networkDevice.getIpAddress())).thenReturn(Optional.of(networkDevice));
        doNothing().when(networkDeviceRepository).delete(networkDevice);

        // Delete NetworkDevice
        networkDeviceService.delete(networkDevice.getIpAddress());

        // Then
        verify(networkDeviceRepository, times(1)).delete(networkDevice);
    }

    @Test
    @Order(5)
    @DisplayName("EXCEPTION NetworkDeviceNotFoundException")
    public void testThrowExceptionFindById() {
        // Given networkDevice

        // When
        when(networkDeviceRepository.findById(networkDevice.getIpAddress())).thenReturn(Optional.ofNullable(null));

        // Then
        assertThrows(NetworkDeviceNotFoundException.class, () -> networkDeviceService.findById(networkDevice.getIpAddress()));
    }
}
