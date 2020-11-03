package com.rico.controller;

import com.rico.mapper.UserMapper;
import com.rico.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Rico_dds
 * @date 2020/11/3 17:00
 */
@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;

    // 查询全部用户
    @GetMapping("/getUserList")
    public List<User> getUserList(){
        List<User> userList = userMapper.getUserList();
        for(User user : userList){
            System.out.println(user);
        }
        return userList;
    }

    // 通过Id查询用户
    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable("id")Integer id){
        User user = userMapper.getUserById(id);
        System.out.println(user);
        return user;
    }

    //添加一个用户
    @GetMapping("addUser/{id}&{name}&{pwd}")
    public String addUser(@PathVariable("id")Integer id,
                          @PathVariable("name")String name,
                          @PathVariable("pwd")String pwd){
        userMapper.addUser(new User(id,name,pwd));
        System.out.println("添加用户成功："+name);
        return "添加用户成功："+name;
    }

    // 删除一个用户
    @GetMapping("deleteUserById/{id}")
    public String deleteUserById(@PathVariable("id")Integer id){
        String name = userMapper.getUserById(id).getName();
        userMapper.deleteUserById(id);
        System.out.println("删除成功：" + name);
        return "删除成功：" + name;
    }


}
