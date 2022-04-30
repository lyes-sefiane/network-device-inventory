package com.lyess.network_device_inventory.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyess.network_device_inventory.domain.enums.ElementType;
import com.lyess.network_device_inventory.dto.entities.NetworkDeviceDto;
import com.lyess.network_device_inventory.exception.NetworkDeviceNotFoundException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import java.util.HashSet;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-29 10:43 a.m.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
public class NetworkDeviceControllerIntegrationTest {

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
        ResultActions resultActions = mockMvc.perform(post("/v1/network-devices")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(networkDeviceDto)));

        // then
        resultActions.andDo(print())
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
        ResultActions resultActions = mockMvc.perform(get("/v1/network-devices")
                .contentType(MediaType.APPLICATION_JSON));

        // then
        resultActions.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(9)));

    }

    @Test
    @Order(3)
    @DisplayName("READ Network Device")
    public void testGet() throws Exception {
        // given existing sql data + previous POST ~ 9 networkDeviceDto

        // when
        ResultActions resultActions = mockMvc.perform(get("/v1/network-devices/{id}", "10.133.13.12")
                .contentType(MediaType.APPLICATION_JSON));

        // then
        resultActions.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.address").value("10.133.13.12"))
                .andExpect(jsonPath("$.elementType").value("router"))
                .andExpect(jsonPath("$.neighbors", hasSize(3)));
    }

    @Test
    @Order(4)
    @DisplayName("UPDATE Network Device")
    public void testPut() throws Exception {
        // given networkDeviceDto
        networkDeviceDto.setElementType(ElementType.DESKTOP_COMPUTER.getValue());

        // when
        ResultActions resultActions = mockMvc.perform(put("/v1/network-devices/{id}", "10.133.10.20")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(networkDeviceDto)));

        // then
        resultActions.andDo(print())
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
        ResultActions resultActions = mockMvc.perform(delete("/v1/network-devices/{id}", "10.133.10.20")
                .contentType(MediaType.APPLICATION_JSON));

        // then
        resultActions.andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Order(6)
    @DisplayName("EXCEPTION NetworkDeviceNotFoundException")
    public void testThrowNotFoundException() throws Exception {
        // given existing sql data + previous POST ~ 9 networkDeviceDto

        // when
        ResultActions resultActions = mockMvc.perform(get("/v1/network-devices/{id}", "10.133.13.255")
                .contentType(MediaType.APPLICATION_JSON));

        // then
        resultActions.andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof NetworkDeviceNotFoundException));
    }

    @Test
    @Order(7)
    @DisplayName("EXCEPTION HttpRequestMethodNotSupportedException")
    public void testThrowHttpRequestMethodNotSupportedException() throws Exception {
        // given networkDeviceDto

        // when
        ResultActions resultActions = mockMvc.perform(patch("/v1/network-devices/{id}", "10.133.10.20")
                .contentType(MediaType.APPLICATION_JSON));

        // then
        resultActions.andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof HttpRequestMethodNotSupportedException));
    }

    @Test
    @Order(8)
    @DisplayName("EXCEPTION HttpMediaTypeNotSupportedException")
    public void testThrowHttpMediaTypeNotSupportedException() throws Exception {
        // given networkDeviceDto

        // when
        ResultActions resultActions = mockMvc.perform(get("/v1/network-devices")
                .contentType(MediaType.APPLICATION_XHTML_XML));

        // then
        resultActions.andDo(print())
                .andExpect(status().isUnsupportedMediaType())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof HttpMediaTypeNotSupportedException));
    }


}
