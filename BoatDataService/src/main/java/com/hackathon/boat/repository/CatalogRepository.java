package com.hackathon.boat.repository;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by awmishra on 10/24/2015.
 */
@Transactional
public interface CatalogRepository extends CrudRepository <CatalogRepository, Long> {
}
