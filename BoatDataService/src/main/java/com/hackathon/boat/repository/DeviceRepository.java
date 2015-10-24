package com.hackathon.boat.repository;

import com.hackathon.boat.data.DeviceEntity;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by awmishra on 10/24/2015.
 */
@Transactional
public interface DeviceRepository extends CrudRepository <DeviceEntity, Long>{
}
