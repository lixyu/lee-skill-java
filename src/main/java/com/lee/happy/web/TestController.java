package com.lee.happy.web;

import com.alibaba.fastjson.JSON;
import com.lee.happy.input.ValidInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author lee
 * @date 2019/2/14
 */

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping("/input")
    public void input(@Valid ValidInput input){

        log.info("入参:"+JSON.toJSONString(input));
    }
}
