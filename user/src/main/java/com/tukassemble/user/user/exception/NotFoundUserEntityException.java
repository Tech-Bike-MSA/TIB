package com.tukassemble.user.user.exception;


import com.tukassemble.user.global.exception.BusinessException;

public class NotFoundUserEntityException extends BusinessException {

    public NotFoundUserEntityException() {
        super("user를 찾을 수 없습니다.");
    }
}
