package org.edi.initialfantasy.mapper;

import org.edi.initialfantasy.bo.user.User;

public interface UserMapper {
	 User getUserBySelect(String account, String password);
	 User getUserByCompanyId(String account,Integer companyId);
	 User getUserByName(String account);
	 User getUserByToken(String token);
}
