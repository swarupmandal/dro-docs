package com.drofile.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.drofile.Entity.User;

@Component
public class UserMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		user.setUserId(rs.getLong("DRO_USER_ID"));
		user.setUserName(rs.getString("USER_NAME"));
		return user;
	}

}
