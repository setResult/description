package org.aomr.desc.controller;

import org.aomr.desc.dto.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright (C), 2017-2020, org.tianli
 * PackageName: org.aomr.desc.controller
 * Author:      aomr
 * Date:        2019/3/5 下午3:03
 * Description:
 */
@RestController
@RequestMapping("/api/index")
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping("/")
    public Result index() {
        return new Result<>("Hello World");
    }

}
