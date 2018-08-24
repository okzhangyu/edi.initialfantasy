package org.edi.initialfantasy.mapper;

import org.edi.initialfantasy.bo.user.User;

import java.util.HashMap;

public interface UserMapper {
	 User getUserBySelect(String account, String password);
	 User getUserByCompany(HashMap<String,String> params);
	 User getUserByName(String account);
	 User getUserByToken(String token);
}
