package org.aomr.desc.annotation.support;

import org.aomr.desc.annotation.LoginMust;
import org.aomr.desc.service.TokenService;
import org.aomr.desc.util.spring.SpringUtil;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class LoginMustHandler implements HandlerMethodArgumentResolver {

    private TokenService tokenService = SpringUtil.getBean(TokenService.class);

    private static final String LOGIN_TOKEN_KEY = "X-Shop-Token";

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(Integer.class) && parameter.hasParameterAnnotation(LoginMust.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,
                                  NativeWebRequest request, WebDataBinderFactory factory) throws Exception {

        return tokenService.analyzeTokenMust(request.getHeader(LOGIN_TOKEN_KEY));
    }
}
