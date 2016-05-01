package com.atlsmall.handler;

import com.alibaba.fastjson.JSON;
import com.atlsmall.common.enums.StatusCode;
import com.atlsmall.common.exceptions.ServiceException;
import com.atlsmall.common.resp.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by sxw on 2015/9/3.
 */
public class GlobalExceptionResolver extends ExceptionHandlerExceptionResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionResolver.class);
    @Override
    public ModelAndView doResolveHandlerMethodException(HttpServletRequest request, HttpServletResponse response, HandlerMethod handlerMethod, Exception ex) {

        if (ex == null) {
            return null;
        }
        if (handlerMethod == null) {
            return null;
        }
        Method method = handlerMethod.getMethod();
        if (method == null) {
            return null;
        }
        ResponseBody responseAnnotation = AnnotationUtils.findAnnotation(method, ResponseBody.class);
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        Result result = null;
        if (responseAnnotation != null) {
            try {
                if (ex instanceof ServiceException) {
                    ServiceException e = ((ServiceException) ex);
                    result = Result.error(e.getStatusCode(), e.getData(), e.getMsg());
                } else if (ex instanceof MissingServletRequestParameterException) {
                    String parameterName = ((MissingServletRequestParameterException) ex).getParameterName();
                    result = Result.error(StatusCode.ERROR_REQUIRED_PARAM, null, parameterName);
                } else if (ex instanceof TypeMismatchException) {
                  result = Result.error(StatusCode.ERROR_INPUT,  null, "类型不匹配");
                } else {
                    ex.printStackTrace();
                    result = Result.error(StatusCode.ERROR_INTERNAL);
                }
                String resultJson = JSON.toJSONString(result);
                LOGGER.error("响应结果:{}", resultJson);
                response.getWriter().write(resultJson);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    response.getWriter().flush();
                    response.getWriter().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
