package cn.com.ydream.common.exception;

import cn.com.ydream.common.enums.ErrorCodeEnum;
import lombok.Data;

/**
 * 业务异常
 */
@Data
public class ServiceException extends RuntimeException{

    protected int code;

    public ServiceException(){}

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
    }

    public ServiceException(ErrorCodeEnum codeEnum, Object... args) {
        super(String.format(codeEnum.msg(), args));
        this.code = codeEnum.code();
    }
}
