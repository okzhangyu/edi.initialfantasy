package org.edi.initialfantasy.repository;

import org.edi.initialfantasy.bo.Vuser;
import org.springframework.stereotype.Repository;


@Repository
public interface VuserMapper {
	 Vuser getUserBySelect(String account, String password);
	 Vuser getUserByName(String account);
}
