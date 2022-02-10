package com.cob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cob.entity.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {
}
