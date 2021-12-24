package com.lyess.network_device_inventory.domain.entites;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-24 12:06 p.m.
 */
@Embeddable
public class ConnectionId implements Serializable {

    @Column(name = "network_device_ip_address")
    private String network_device_ip_address;

    @Column(name = "neighbor_ip_address")
    private String neighbor_ip_address;

    public ConnectionId() {
        //
    }

    public ConnectionId(String network_device_ip_address, String neighbor_ip_address) {
        this.network_device_ip_address = network_device_ip_address;
        this.neighbor_ip_address = neighbor_ip_address;
    }

    public String getNetwork_device_ip_address() {
        return network_device_ip_address;
    }

    public void setNetwork_device_ip_address(String network_device_ip_address) {
        this.network_device_ip_address = network_device_ip_address;
    }

    public String getNeighbor_ip_address() {
        return neighbor_ip_address;
    }

    public void setNeighbor_ip_address(String neighbor_ip_address) {
        this.neighbor_ip_address = neighbor_ip_address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConnectionId that = (ConnectionId) o;
        return network_device_ip_address.equals(that.network_device_ip_address) && neighbor_ip_address.equals(that.neighbor_ip_address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(network_device_ip_address, neighbor_ip_address);
    }

    @Override
    public String toString() {
        return "ConnectionId{" +
                "network_device_ip_address='" + network_device_ip_address + '\'' +
                ", neighbor_ip_address='" + neighbor_ip_address + '\'' +
                '}';
    }
}
