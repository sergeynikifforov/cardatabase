package com.packt.cardatabase.domain;

import java.util.List;
import java.lang.String;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;


public interface CarRepository extends CrudRepository <Car, Long>{
    // Fetch cars by brand
    // List<Car> findByColor(String color);
    // Fetch cars by year
    // List<Car> findByYear(int year);
    // Fetch cars by brand using SQL
    // @Query("select c from Car c where c.brand = ?1")
    List<Car> findByBrand(String brand);
}


/*
##############################################
Creating PagingAndSortingRepository which offers methods for fetching entities using pagination and
sorting.(similar to CrudRepository)

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CarRepository extends PagingAndSortingRepository<Car, Long> {
}

##############################################

CrudRepository methods:

long count() #Returns the number of entities
Iterable<T> #findAll() Returns all items of given type
Optional<T> #findById(ID Id) Returns one item by id
void delete(T entity) #Deletes an entity
void deleteAll() #Deletes all entities of the repository
<S extends T> save(S entity) #Saves an entity

###############################################

2 additional methods for PagingAndSortingRepository (compare to CrudRepository)

Iterable<T> findAll(Sort sort)  #Returns all entities sorted by the given options
Page<T> findAll(Pageable pageable) #Returns all entities according to given paging options

###############################################
 */