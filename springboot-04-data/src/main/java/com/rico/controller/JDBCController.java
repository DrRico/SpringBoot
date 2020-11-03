package com.rico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Rico_dds
 * @date 2020/11/2 21:46
 */

@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // 查询所有连接信息
    @GetMapping("/userList")
    public List<Map<String,Object>> userlist(){
        String sql = "select * from sys_user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

// 查询所有连接信息
//    @GetMapping("/addList")
//    public String addList(){
//        String sql = "insert into";
//
//    }


}
