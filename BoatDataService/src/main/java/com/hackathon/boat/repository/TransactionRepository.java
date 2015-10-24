package com.hackathon.boat.repository;

import com.hackathon.boat.data.TransactionEntity;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by awmishra on 10/24/2015.
 */
@Transactional
public interface TransactionRepository extends CrudRepository<TransactionEntity, Long> {
}
