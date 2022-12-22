package com.gl.repository;

import org.springframework.data.repository.CrudRepository;

import com.gl.entity.Card;

public interface CardRepository extends CrudRepository<Card, Integer> {

}
