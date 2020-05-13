package com.it.security.zy.service;

import com.it.security.zy.dao.UserDao;
import com.it.security.zy.model.UserDto;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zouyu
 * @description
 * @date 2020/5/12
 */
@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if(StringUtils.isEmpty(s)){
            return null;
        }
        UserDto userDto = userDao.findByUsername(s);
        if(userDto == null){
            return null;
        }
        //根据用户的id查询用户的权限
        List<String> permissions = new ArrayList<>();
        permissions.add("p1");
        permissions.add("p2");

        String[] ss = permissions.toArray(new String[permissions.size()]);
        UserDetails userDetails = User.withUsername(userDto.getUsername()).password(userDto.getPassword()).authorities(ss).build();
        return userDetails;
    }
}
