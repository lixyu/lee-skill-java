package com.lee.happy.service;


import com.alibaba.fastjson.JSON;
import com.lee.happy.exception.HttpRequestException;
import com.lee.happy.po.CustQuotaPo;
import com.lee.happy.util.HttpUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 手动调接口提额
 * @author lee
 * @date 2019/2/14
 */

public class ImproveAmountService {

    public static void main(String[] args) throws IOException {
        String url = "http://10.1.13.21:10000/api/submitCustQuota";
       // String url="http://10.138.61.57:30000/boltloan-api/submitCustQuota";
        File file=new File("E:\\lee\\github\\lee-skill-java\\src\\main\\resources\\data\\imp.txt");
        List<String> list=FileUtils.readLines(file);
        list.forEach(id->{
            Integer custId=Integer.valueOf(StringUtils.deleteWhitespace(id));
            Integer amount=50000;
            CustQuotaPo quotaPo=new CustQuotaPo(custId,amount);
            String param= JSON.toJSONString(quotaPo);
            System.out.println(param);
            try {
                String result=HttpUtils.doJson(url,param,30);
                System.out.println(result);
            } catch (HttpRequestException e) {
                e.printStackTrace();
            }

        });

    }
}
