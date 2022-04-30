package com.lyess.network_device_inventory_service.repository;

import com.lyess.network_device_inventory_service.domain.entites.NetworkDevice;
import com.lyess.network_device_inventory_service.domain.enums.ElementType;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-29 2:30 p.m.
 */
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NetworkDeviceRepositoryIntegrationTest {

    @Autowired
    private INetworkDeviceRepository networkDeviceRepository;

    private NetworkDevice networkDevice;

    @BeforeEach
    void setUp() {
        // given
        networkDevice = NetworkDevice.builder()
                .ipAddress("10.133.10.20")
                .elementType(ElementType.LAPTOP)
                .connections(new HashSet<>())
                .build();
    }

    @Test
    @Order(1)
    @DisplayName("CREATE Network Device")
    @Rollback(value = false)
    public void testSave() {
        // given networkDevice
        // when
        NetworkDevice savedNetworkDevice = networkDeviceRepository.save(networkDevice);
        // then
        assertEquals(savedNetworkDevice, networkDevice);
    }

    @Test
    @Order(2)
    @DisplayName("READ Network Devices")
    public void testGetAll() {
        // given existing sql data + previous save ~ 9 networkDeviceDto

        // when
        List<NetworkDevice> networkDevices = networkDeviceRepository.findAll();
        // then
        assertEquals(networkDevices.size(), 9);
    }

    @Test
    @Order(3)
    @DisplayName("READ Network Device")
    public void testGet() {
        // given existing sql data + previous save ~ 9 networkDeviceDto

        // when
        NetworkDevice existingNetworkDevice = networkDeviceRepository.findById(networkDevice.getIpAddress()).orElse(null);
        // then
        assertEquals(existingNetworkDevice, networkDevice);
    }

    @Test
    @Order(4)
    @DisplayName("UPDATE Network Device")
    public void testUpdate() {
        // given existing sql data + previous save ~ 9 networkDeviceDto
        networkDevice.setElementType(ElementType.SERVER);
        // when
        NetworkDevice updatedNetworkDevice = networkDeviceRepository.save(networkDevice);
        // then
        assertEquals(updatedNetworkDevice, networkDevice);
    }

    @Test
    @Order(5)
    @DisplayName("DELETE Network Device")
    public void testDelete() {
        // given existing sql data + previous save ~ 9 networkDeviceDto

        // when
        networkDeviceRepository.delete(networkDevice);
        // then
        assertEquals(networkDeviceRepository.count(), 8);
    }
}
