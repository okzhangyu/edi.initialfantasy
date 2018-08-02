package org.edi.initialfantasy.service;

import org.edi.initialfantasy.dto.IResult;

/**
 * @author Fancy
 * @date 2018/8/1
 */
public interface IAuthrizationService {

    IResult authrizeForErrorToken(String message);
}
