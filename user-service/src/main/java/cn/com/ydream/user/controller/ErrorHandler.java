package cn.com.ydream.user.controller;

import cn.com.ydream.common.enums.ErrorCodeEnum;
import cn.com.ydream.common.exception.ServiceException;
import cn.com.ydream.common.wrapper.WrapMapper;
import cn.com.ydream.common.wrapper.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controller层异常统一处理
 */
@ControllerAdvice
@Slf4j
public class ErrorHandler {

    /**
     * 处理参数异常
     * @param e
     * @return
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Wrapper illegalArgumentException(IllegalArgumentException e) {
        log.error("参数非法异常={}", e.getMessage(), e);
        return WrapMapper.wrap(ErrorCodeEnum.GL1001.code(), e.getMessage());
    }

    /**
     * 处理方法参数异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Wrapper methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("方法参数非法异常={}", e.getMessage(), e);
        return WrapMapper.wrap(ErrorCodeEnum.GL1003.code(), e.getMessage());
    }

    /**
     * 业务异常
     *
     * @param e the e
     * @return the wrapper
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Wrapper businessException(ServiceException e) {
        log.error("业务异常={}", e.getMessage(), e);
        return WrapMapper.wrap(e.getCode() == 0 ? Wrapper.ERROR_CODE : e.getCode(), e.getMessage());
    }

    /**
     * 全局异常
     *
     * @param e the e
     *
     * @return the wrapper
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Wrapper exception(Exception e) {
        log.error("全局异常={}", e.getMessage(), e);
        return WrapMapper.error();
    }

}
