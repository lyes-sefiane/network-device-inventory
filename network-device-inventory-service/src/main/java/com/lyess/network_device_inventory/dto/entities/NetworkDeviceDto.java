package com.lyess.network_device_inventory.dto.entities;

import com.lyess.network_device_inventory.domain.enums.validator.ElementTypeValidator;
import com.lyess.network_device_inventory.utils.Defines;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-25 12:08 p.m.
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class NetworkDeviceDto extends RepresentationModel<NetworkDeviceDto> {

    @Pattern(regexp = Defines.IP_REGEX, message = "Invalid Format")
    @EqualsAndHashCode.Include
    private String address;

    @ElementTypeValidator
    private String elementType;

    private Set<NeighborDto> neighbors = new HashSet<>();
}
