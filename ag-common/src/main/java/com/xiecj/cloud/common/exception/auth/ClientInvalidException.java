package com.xiecj.cloud.common.exception.auth;

import com.xiecj.cloud.common.constants.CommonConstants;
import com.xiecj.cloud.common.exception.BaseException;

/**
 * Created by ace on 2017/9/10.
 */
public class ClientInvalidException extends BaseException {
    public ClientInvalidException(String message) {
        super(message, CommonConstants.EX_CLIENT_INVALID_CODE);
    }
}
