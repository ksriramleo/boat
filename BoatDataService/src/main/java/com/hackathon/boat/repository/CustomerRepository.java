package com.hackathon.boat.repository;

import com.hackathon.boat.data.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by awmishra on 10/24/2015.
 */
@Transactional
public interface CustomerRepository extends CrudRepository<CustomerEntity , Long> {
    public CustomerEntity findByBtCustomerId(String btCustomerId);
}
