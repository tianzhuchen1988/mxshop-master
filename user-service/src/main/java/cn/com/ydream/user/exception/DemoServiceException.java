package cn.com.ydream.user.exception;

import cn.com.ydream.common.enums.ErrorCodeEnum;
import cn.com.ydream.common.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;

/**
 * demo模块 业务异常
 */
@Slf4j
public class DemoServiceException extends ServiceException {

    public DemoServiceException() {
    }

    /**
     * Instantiates a new exception.
     *
     * @param code      the code
     * @param msgFormat the msg format
     * @param args      the args
     */
    public DemoServiceException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
        log.info("<== DemoServiceException, code:" + this.code + ", message:" + super.getMessage());

    }

    /**
     * Instantiates a new exception.
     *
     * @param code the code
     * @param msg  the msg
     */
    public DemoServiceException(int code, String msg) {
        super(code, msg);
        log.info("<== DemoServiceException, code:" + this.code + ", message:" + super.getMessage());
    }

    /**
     * Instantiates a new exception.
     *
     * @param codeEnum the code enum
     */
    public DemoServiceException(ErrorCodeEnum codeEnum) {
        super(codeEnum.code(), codeEnum.msg());
        log.info("<== DemoServiceException, code:" + this.code + ", message:" + super.getMessage());
    }

    /**
     * Instantiates a new exception.
     *
     * @param codeEnum the code enum
     * @param args     the args
     */
    public DemoServiceException(ErrorCodeEnum codeEnum, Object... args) {
        super(codeEnum, args);
        log.info("<== DemoServiceException, code:" + this.code + ", message:" + super.getMessage());
    }
}
