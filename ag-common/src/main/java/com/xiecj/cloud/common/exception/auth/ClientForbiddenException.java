package com.xiecj.cloud.common.exception.auth;

import com.xiecj.cloud.common.constants.CommonConstants;
import com.xiecj.cloud.common.exception.BaseException;

/**
 * Created by ace on 2017/9/12.
 */
public class ClientForbiddenException extends BaseException {
    public ClientForbiddenException(String message) {
        super(message, CommonConstants.EX_CLIENT_FORBIDDEN_CODE);
    }

}
