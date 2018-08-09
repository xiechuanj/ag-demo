package com.xiecj.cloud.zuul.exception;

import com.xiecj.cloud.common.constants.CommonConstants;
import com.xiecj.cloud.common.exception.BaseException;



public class UserInvalidException extends BaseException {
    public UserInvalidException(String message) {
        super(message, CommonConstants.EX_USER_INVALID_CODE);
    }
}
