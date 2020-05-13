package com.it.security.zy.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zouyu
 * @description
 * @date 2020/5/12
 */
@RestController
public class OrderController {
   @RequestMapping("r1")
   @PreAuthorize("hasAnyAuthority('p1')")
    public String r1(){
       return "有权限访问r1";
   }
}
