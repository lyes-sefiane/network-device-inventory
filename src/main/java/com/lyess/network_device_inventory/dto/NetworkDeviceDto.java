package com.lyess.network_device_inventory.dto;

import lombok.Builder;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-25 12:08 p.m.
 */
@Builder
public class NetworkDeviceDto {

    private String address;

    private String elementType;

    private Set<NeighborDto> neighbors = new HashSet<>();

    public NetworkDeviceDto () {
        //
    }

    public NetworkDeviceDto(String address, String elementType, Set<NeighborDto> neighbors) {
        this.address = address;
        this.elementType = elementType;
        this.neighbors = neighbors;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public Set<NeighborDto> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Set<NeighborDto> neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetworkDeviceDto that = (NetworkDeviceDto) o;
        return address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    @Override
    public String toString() {
        return "NetworkDeviceDto{" +
                "address='" + address + '\'' +
                ", elementType='" + elementType + '\'' +
                ", neighbors=" + neighbors +
                '}';
    }
}
