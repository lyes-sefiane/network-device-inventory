package com.lyess.network_device_inventory.dto.entities;

import com.lyess.network_device_inventory.utils.Defines;
import lombok.Builder;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Objects;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-25 11:55 a.m.
 */
@Builder
public class NeighborDto {

    @Pattern(regexp = Defines.IP_REGEX, message = "Invalid Format")
    private String address;

    @NotBlank(message="Cost should not be blank !")
    @Digits(integer=10, fraction=0, message = "Cost value constraints : integer=10, fraction=0")
    private int cost;

    public NeighborDto() {
        //
    }

    public NeighborDto(String address, int cost) {
        this.address = address;
        this.cost = cost;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        NeighborDto that = (NeighborDto) o;
        return address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    @Override
    public String toString() {
        return "NeighborDto{" +
                "address='" + address + '\'' +
                ", cost=" + cost +
                '}';
    }
}