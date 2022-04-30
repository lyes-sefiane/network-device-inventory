package com.lyess.network_device_inventory_service.domain.entites;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-24 12:05 p.m.
 */
@Entity
@Table(name = "Connection")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Connection implements Serializable {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private ConnectionId connectionId;

    @ManyToOne
    @MapsId("network_device_ipaddress")
    @JoinColumn(name = "network_device_ipaddress")
    private NetworkDevice networkDevice;

    @ManyToOne
    @MapsId("neighbor_ipaddress")
    @JoinColumn(name = "neighbor_ipaddress")
    private Neighbor neighbor;

    @Column(name = "cost")
    private int cost;

    public Connection(NetworkDevice networkDevice, Neighbor neighbor, int cost) {
        this.connectionId = new ConnectionId(networkDevice.getIpAddress(), neighbor.getIpAddress());
        this.networkDevice = networkDevice;
        this.neighbor = neighbor;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "connectionId=" + connectionId +
                ", cost=" + cost +
                '}';
    }
}
