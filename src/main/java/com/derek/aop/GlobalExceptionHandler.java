package com.derek.aop;

import com.derek.exception.BaseException;
import com.derek.exception.StorageFileNotFoundException;
import com.derek.model.response.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Derek
 * @date 2018/3/28 09:02
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public BaseResponse handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return BaseResponse.fail(exc.getMessage());
    }

    @ExceptionHandler(BaseException.class)
    public BaseResponse handleBaseException(BaseException exc) {
        return BaseResponse.fail(exc.getMessage(), exc.getCode());
    }
}
