package com.fengyun.data.repository;

import com.fengyun.data.entity.AgentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/29.
 */
public interface AgentInfoRepo extends JpaRepository<AgentInfo, Serializable> {
}
