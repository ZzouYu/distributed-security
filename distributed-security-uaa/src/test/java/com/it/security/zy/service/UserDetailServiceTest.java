package com.it.security.zy.service;

import com.it.security.zy.dao.UserDao;
import com.it.security.zy.model.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailServiceTest {

    @Autowired
    UserDao userDao;
    @Test
   public void test(){
        UserDto byUsername = userDao.findByUsername("13904211939");
        System.out.println(byUsername);
   }
}