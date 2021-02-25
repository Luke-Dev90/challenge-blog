package com.challenge.alkemy.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.challenge.alkemy.blog.commons.GenericServiceImpl;
import com.challenge.alkemy.blog.dao.PosteoDao;
import com.challenge.alkemy.blog.model.Posteo;
import com.challenge.alkemy.blog.service.PosteoService;

@Service
public class PosteoServiceImpl extends GenericServiceImpl<Posteo, Long> implements PosteoService{

	@Autowired
	private PosteoDao posteoDao;
	
	@Override
	public CrudRepository<Posteo, Long> getDao() {
		return posteoDao;
	}

}
