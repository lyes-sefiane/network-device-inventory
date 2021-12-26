package com.lyess.network_device_inventory.domain.entites;

import com.lyess.network_device_inventory.domain.enums.ElementType;
import com.lyess.network_device_inventory.domain.enums.converter.ElementTypeConverter;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-23 10:23 a.m.
 */
@Entity
@Table(name = "network_device")
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class NetworkDevice implements Serializable {

    @Id
    @Column(name = "ipaddress")
    @EqualsAndHashCode.Include
    private String ipAddress;

    @Column(name = "element_type")
    @Convert(converter = ElementTypeConverter.class)
    private ElementType elementType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "networkDevice", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Connection> connections = new HashSet<>();
}
