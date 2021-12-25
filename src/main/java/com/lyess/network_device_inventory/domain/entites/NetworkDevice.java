package com.lyess.network_device_inventory.domain.entites;

import com.lyess.network_device_inventory.domain.enums.ElementType;
import com.lyess.network_device_inventory.domain.enums.converter.ElementTypeConverter;
import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-23 10:23 a.m.
 */
@Entity
@Table(name = "network_device")
@Builder
public class NetworkDevice implements Serializable {

    @Id
    @Column(name = "ipaddress")
    private String ipAddress;

    @Column(name = "element_type")
    @Convert(converter = ElementTypeConverter.class)
    private ElementType elementType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "networkDevice", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Connection> connections = new HashSet<>();

    public NetworkDevice(){
        //
    }

    public NetworkDevice(String ipAddress, ElementType elementType, Set<Connection> connections) {
        this.ipAddress = ipAddress;
        this.elementType = elementType;
        this.connections = connections;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public ElementType getElementType() {
        return elementType;
    }

    public void setElementType(ElementType elementType) {
        this.elementType = elementType;
    }

    public Set<Connection> getConnections() {
        return connections;
    }

    public void setConnections(Set<Connection> connections) {
        this.connections = connections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetworkDevice that = (NetworkDevice) o;
        return ipAddress.equals(that.ipAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipAddress);
    }

    @Override
    public String toString() {
        return "NetworkDevice{" +
                "ipAddress='" + ipAddress + '\'' +
                ", elementType=" + elementType +
                ", connections=" + connections +
                '}';
    }
}
