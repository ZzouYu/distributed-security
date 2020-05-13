package com.it.security.zy.dao;

import com.it.security.zy.model.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zouyu
 * @description
 * @date 2020/5/12
 */
public interface UserDao extends JpaRepository<UserDto,String> {
   public  UserDto findByUsername(String username);
}
