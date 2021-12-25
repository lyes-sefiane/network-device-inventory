package com.lyess.network_device_inventory.domain.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-24 12:05 p.m.
 */
@Entity
@Table(name = "Connection")
public class Connection implements Serializable {

    @EmbeddedId
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

    public Connection() {
        //
    }

    public Connection(NetworkDevice networkDevice, Neighbor neighbor, int cost) {
        this.connectionId = new ConnectionId(networkDevice.getIpAddress(), neighbor.getIpAddress());
        this.networkDevice = networkDevice;
        this.neighbor = neighbor;
        this.cost = cost;
    }

    public ConnectionId getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(ConnectionId connectionId) {
        this.connectionId = connectionId;
    }

    public NetworkDevice getNetworkDevice() {
        return networkDevice;
    }

    public void setNetworkDevice(NetworkDevice networkDevice) {
        this.networkDevice = networkDevice;
    }

    public Neighbor getNeighbor() {
        return neighbor;
    }

    public void setNeighbor(Neighbor neighbor) {
        this.neighbor = neighbor;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connection that = (Connection) o;
        return connectionId.equals(that.connectionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connectionId);
    }

    @Override
    public String toString() {
        return "Connection{" +
                "connectionId=" + connectionId +
                ", networkDevice=" + networkDevice +
                ", neighbor=" + neighbor +
                ", cost=" + cost +
                '}';
    }
}
