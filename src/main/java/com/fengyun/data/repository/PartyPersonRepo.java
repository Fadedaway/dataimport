package com.fengyun.data.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fengyun.data.entity.PartyPerson;

public interface PartyPersonRepo extends JpaRepository<PartyPerson,Serializable>{

}
