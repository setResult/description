package org.aomr.desc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Copyright (C), 2017-2020, org.tianli
 * PackageName: org.tianli.server.annotation
 * Author:      aomr
 * Date:        2019/3/6 下午2:18
 * Description: 自定义注解(强制登录)
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginMust {
}
