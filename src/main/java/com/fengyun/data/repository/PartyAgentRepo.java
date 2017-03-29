package com.fengyun.data.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fengyun.data.entity.UserAgentManage;

public interface PartyAgentRepo extends JpaRepository<UserAgentManage,Serializable>{

}
