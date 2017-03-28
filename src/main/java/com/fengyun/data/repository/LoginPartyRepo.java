package com.fengyun.data.repository;

import com.fengyun.data.entity.LoginParty;
import org.springframework.data.jpa.repository.JpaRepository;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/28.
 */
public interface LoginPartyRepo extends JpaRepository<LoginParty, Serializable>  {
}
