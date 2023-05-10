package com.klinnovations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klinnovations.binding.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
