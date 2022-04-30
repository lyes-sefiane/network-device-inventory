package com.lyess.network_device_inventory_service.repository;

import com.lyess.network_device_inventory_service.domain.entites.Neighbor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-01-02 7:56 p.m.
 */
@Repository
public interface INeighborRepository extends CrudRepository<Neighbor, String> {
}
