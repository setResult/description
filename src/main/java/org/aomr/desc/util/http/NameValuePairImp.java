package org.aomr.desc.util.http;

import org.aomr.desc.exception.ErrCodeException;
import org.springframework.util.StringUtils;

/**
 * Copyright (C), 2017-2020, org.tianli
 * PackageName: org.aomr.desc.controller
 * Author:      aomr
 * Date:        2019/3/5 下午5:50
 * Description:
 */
public class NameValuePairImp implements org.apache.http.NameValuePair {
    private String name;
    private String value;

    public NameValuePairImp(String name, String value) {
        this.name = name;
        this.value = value;
        if (StringUtils.isEmpty(name) || value == null)
            throw new ErrCodeException();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getValue() {
        return value;
    }
}
