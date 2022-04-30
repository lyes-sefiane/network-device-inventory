package com.lyess.network_device_inventory_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyess.network_device_inventory_service.domain.enums.ElementType;
import com.lyess.network_device_inventory_service.dto.entities.NetworkDeviceDto;
import com.lyess.network_device_inventory_service.exception.NetworkDeviceNotFoundException;
import com.lyess.network_device_inventory_service.service.IService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.HashSet;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-29 1:14 p.m.
 */
@WebMvcTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NetworkDeviceControllerUnitTest {

    @MockBean
    private IService<NetworkDeviceDto> networkDeviceService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private  NetworkDeviceDto networkDeviceDto;

    @BeforeEach
    void setUp() {
        // given
        networkDeviceDto = NetworkDeviceDto.builder()
                .address("10.133.10.20")
                .elementType(ElementType.LAPTOP.getValue())
                .neighbors(new HashSet<>())
                .build();
    }

    @Test
    @Order(1)
    @DisplayName("CREATE Network Device")
    public void testSave() throws Exception {
        // given networkDeviceDto

        // when
        when(networkDeviceService.save(networkDeviceDto)).thenReturn(networkDeviceDto);

        // then
        mockMvc.perform(post("/v1/network-devices")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(networkDeviceDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.address").value(networkDeviceDto.getAddress()))
                .andExpect(jsonPath("$.elementType").value(networkDeviceDto.getElementType()))
                .andExpect(jsonPath("$.neighbors").isArray())
                .andExpect(jsonPath("$.neighbors", hasSize(0)));

    }

    @Test
    @Order(2)
    @DisplayName("READ Network Devices")
    public void testGetAll() throws Exception {
        // given existing sql data + previous POST ~ 9 networkDeviceDto

        // when
        when(networkDeviceService.findAll()).thenReturn(Arrays.asList(networkDeviceDto));

        // then
        mockMvc.perform(get("/v1/network-devices")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(1)));

    }

    @Test
    @Order(3)
    @DisplayName("READ Network Device")
    public void testGet() throws Exception {
        // given networkDeviceDto

        // when
        when(networkDeviceService.findById(networkDeviceDto.getAddress())).thenReturn(networkDeviceDto);

        // then
        mockMvc.perform(get("/v1/network-devices/{id}", "10.133.10.20")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.address").value(networkDeviceDto.getAddress()))
                .andExpect(jsonPath("$.elementType").value(networkDeviceDto.getElementType()))
                .andExpect(jsonPath("$.neighbors").isArray())
                .andExpect(jsonPath("$.neighbors", hasSize(0)));
    }

    @Test
    @Order(4)
    @DisplayName("UPDATE Network Device")
    public void testPut() throws Exception {
        // given networkDeviceDto
        networkDeviceDto.setElementType(ElementType.DESKTOP_COMPUTER.getValue());

        // when
        when(networkDeviceService.update(networkDeviceDto, networkDeviceDto.getAddress())).thenReturn(networkDeviceDto);

        // then
        mockMvc.perform(put("/v1/network-devices/{id}", "10.133.10.20")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(networkDeviceDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.address").value("10.133.10.20"))
                .andExpect(jsonPath("$.elementType").value(ElementType.DESKTOP_COMPUTER.getValue()))
                .andExpect(jsonPath("$.neighbors", hasSize(0)));
    }

    @Test
    @Order(5)
    @DisplayName("DELETE Network Device")
    public void testDelete() throws Exception {
        // given networkDeviceDto

        // when
        doNothing().when(networkDeviceService).delete(networkDeviceDto.getAddress());

        // then
        mockMvc.perform(delete("/v1/network-devices/{id}", "10.133.10.20")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(result -> verify(networkDeviceService, times(1)).delete(networkDeviceDto.getAddress()));
    }

    @Test
    @Order(6)
    @DisplayName("EXCEPTION NetworkDeviceNotFoundException")
    public void testThrowNotFoundException() throws Exception {
        // given
        String networkDeviceId = "10.133.13.255";

        // when
        when(networkDeviceService.findById(networkDeviceId)).thenThrow(NetworkDeviceNotFoundException.class);

        // then
        mockMvc.perform(get("/v1/network-devices/{id}", networkDeviceId)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof NetworkDeviceNotFoundException));
    }

}
