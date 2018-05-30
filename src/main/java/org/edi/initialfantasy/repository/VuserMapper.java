package org.edi.initialfantasy.repository;

import org.apache.ibatis.annotations.Mapper;
import org.edi.initialfantasy.bo.user.Vuser;
import org.springframework.stereotype.Repository;



public interface VuserMapper {
	 Vuser getUserBySelect(String account, String password);
	 Vuser getUserByName(String account);
}
