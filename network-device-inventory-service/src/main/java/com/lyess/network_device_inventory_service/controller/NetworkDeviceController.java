package com.lyess.network_device_inventory_service.controller;

import com.lyess.network_device_inventory_service.dto.entities.NetworkDeviceDto;
import com.lyess.network_device_inventory_service.exception.entities.ExceptionResponse;
import com.lyess.network_device_inventory_service.service.IService;
import com.lyess.network_device_inventory_service.utils.Defines;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
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
@Tag(name = "Network Device Controller")
@PropertySource("${springdoc.api-docs.messages}")
@CrossOrigin(origins = "http://localhost")
public class NetworkDeviceController {

    private final IService<NetworkDeviceDto> networkDeviceService;

    @Autowired
    public NetworkDeviceController(IService<NetworkDeviceDto> networkDeviceService) {
        this.networkDeviceService = networkDeviceService;
    }

    @GetMapping
    @Operation(summary = "${findAllNetworkDevice}")
    @ApiResponse(responseCode = "200",
            description = "OK",
            content = @Content(schema = @Schema(implementation = NetworkDeviceDto.class)))
    public List<NetworkDeviceDto> findAllNetworkDevice() {
        return networkDeviceService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "${findById}")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = NetworkDeviceDto.class)))
    @ApiResponse(responseCode = "404", description = "NOT_FOUND", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "400", description = "BAD_REQUEST", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "415", description = "UNSUPPORTED_MEDIA_TYPE", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    public NetworkDeviceDto findById(@PathVariable @Pattern(regexp = Defines.IP_REGEX, message = "Invalid Format") String id) {
        return networkDeviceService.findById(id);
    }

    @PostMapping
    @Operation(summary = "${save}")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = NetworkDeviceDto.class)))
    @ApiResponse(responseCode = "404", description = "NOT_FOUND", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "422", description = "UNPROCESSABLE_ENTITY", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "400", description = "BAD_REQUEST", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "415", description = "UNSUPPORTED_MEDIA_TYPE", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    public NetworkDeviceDto save(@RequestBody @Valid NetworkDeviceDto networkDeviceDto) {
        return networkDeviceService.save(networkDeviceDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "${update}")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = NetworkDeviceDto.class)))
    @ApiResponse(responseCode = "404", description = "NOT_FOUND", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "422", description = "UNPROCESSABLE_ENTITY", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "400", description = "BAD_REQUEST", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "415", description = "UNSUPPORTED_MEDIA_TYPE", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    public NetworkDeviceDto update(@RequestBody @Valid NetworkDeviceDto networkDeviceDto,
                                   @PathVariable @Pattern(regexp = Defines.IP_REGEX, message = "Invalid Format") String id) {
        return networkDeviceService.update(networkDeviceDto, id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "${delete}")
    @ApiResponse(responseCode = "404", description = "NOT_FOUND", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "400", description = "BAD_REQUEST", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "415", description = "UNSUPPORTED_MEDIA_TYPE", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    public void delete(@PathVariable @Pattern(regexp = Defines.IP_REGEX, message = "Invalid Format") String id) {
        networkDeviceService.delete(id);
    }
}
