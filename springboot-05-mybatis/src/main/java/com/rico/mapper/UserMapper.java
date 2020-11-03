package com.rico.mapper;

import com.rico.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rico_dds
 * @date 2020/11/3 16:52
 */
@Mapper
@Repository
public interface UserMapper {
    List<User> getUserList();

    User getUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUserById(int id);
}
