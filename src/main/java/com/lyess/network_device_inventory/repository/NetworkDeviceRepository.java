package com.lyess.network_device_inventory.repository;

import com.lyess.network_device_inventory.domain.entites.NetworkDevice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-25 1:36 p.m.
 */
@Repository
public interface NetworkDeviceRepository extends CrudRepository<NetworkDevice, String> {
}
