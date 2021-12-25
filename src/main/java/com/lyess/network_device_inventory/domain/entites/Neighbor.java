package com.lyess.network_device_inventory.domain.entites;

import lombok.Builder;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-23 10:53 a.m.
 */
@Entity
@Table(name = "neighbor")
@Builder
public class Neighbor {

    @Id
    @Column(name = "ipaddress")
    private String ipAddress;

    public Neighbor(){
        //
    }
    public Neighbor(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighbor neighbor = (Neighbor) o;
        return ipAddress.equals(neighbor.ipAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipAddress);
    }

    @Override
    public String toString() {
        return "Neighbor{" +
                "ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
