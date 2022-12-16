package com.akashk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.akashk.entity.Contact;



@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{
	
	public List<Contact> findByactiveFlag(boolean flag); 

	
}
