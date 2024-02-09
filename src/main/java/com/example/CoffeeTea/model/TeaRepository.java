package com.example.CoffeeTea.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.data.rest.core.annotation.RestResource;


@RepositoryRestResource
public interface TeaRepository extends CrudRepository<Tea, Integer> {
	List<Tea> findById(@Param("id") int id);
}
