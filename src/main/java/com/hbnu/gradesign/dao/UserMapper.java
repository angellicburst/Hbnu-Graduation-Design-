package com.hbnu.gradesign.dao;

import com.hbnu.gradesign.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
	User findUserByUsername(String username);

	User findUserById(Integer userId);

	Integer addUser(User users);

	Integer deleteUser(Integer id);

	Integer updateUser(User user);
}
