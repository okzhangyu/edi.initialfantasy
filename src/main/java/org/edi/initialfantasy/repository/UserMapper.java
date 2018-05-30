package org.edi.initialfantasy.repository;

import org.edi.initialfantasy.bo.user.User;

public interface UserMapper {
	 User getUserBySelect(String account, String password);
	 User getUserByName(String account);
}
