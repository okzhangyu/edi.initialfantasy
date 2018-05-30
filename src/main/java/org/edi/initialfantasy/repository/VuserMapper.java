package org.edi.initialfantasy.repository;

import org.edi.initialfantasy.bo.user.Vuser;

public interface VuserMapper {
	 Vuser getUserBySelect(String account, String password);
	 Vuser getUserByName(String account);
}
