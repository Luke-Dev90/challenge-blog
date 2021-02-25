package com.challenge.alkemy.blog.dao;

import org.springframework.data.repository.CrudRepository;

import com.challenge.alkemy.blog.model.Posteo;

public interface PosteoDao extends CrudRepository<Posteo, Long> {

}
