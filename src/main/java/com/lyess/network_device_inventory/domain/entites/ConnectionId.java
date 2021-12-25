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

    @Column(name = "network_device_ipaddress")
    private String network_device_ipaddress;

    @Column(name = "neighbor_ipaddress")
    private String neighbor_ipaddress;

    public ConnectionId() {
        //
    }

    public ConnectionId(String network_device_ipaddress, String neighbor_ipaddress) {
        this.network_device_ipaddress = network_device_ipaddress;
        this.neighbor_ipaddress = neighbor_ipaddress;
    }

    public String getNetwork_device_ipaddress() {
        return network_device_ipaddress;
    }

    public void setNetwork_device_ipaddress(String network_device_ipaddress) {
        this.network_device_ipaddress = network_device_ipaddress;
    }

    public String getNeighbor_ipaddress() {
        return neighbor_ipaddress;
    }

    public void setNeighbor_ipaddress(String neighbor_ipaddress) {
        this.neighbor_ipaddress = neighbor_ipaddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConnectionId that = (ConnectionId) o;
        return network_device_ipaddress.equals(that.network_device_ipaddress) && neighbor_ipaddress.equals(that.neighbor_ipaddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(network_device_ipaddress, neighbor_ipaddress);
    }

    @Override
    public String toString() {
        return "ConnectionId{" +
                "network_device_ipaddress='" + network_device_ipaddress + '\'' +
                ", neighbor_ipaddress='" + neighbor_ipaddress + '\'' +
                '}';
    }
}
