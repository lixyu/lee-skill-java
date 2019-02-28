package com.lee.happy.service;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.lee.happy.listen.ExcelListener;
import com.lee.happy.model.ReadModel;
import com.lee.happy.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 使用alibaba easyexcel读写excel
 * 官网https://github.com/alibaba/easyexcel
 *
 * @author lee
 * @date 2019/2/26
 */
@Service
@Slf4j
public class ExcelService {

    /*public static void main(String[] args) throws IOException {

        InputStream inputStream= FileUtils.openInputStream(new File("E:\\lee\\github\\lee-skill-java\\src\\main\\resources\\data\\2003.excel"));
        List<Object> data=EasyExcelFactory.read(inputStream,new Sheet(1,0));
    }*/

    @Test
    public void simpleReadJavaModelV2007() throws IOException {
        //InputStream inputStream = new FileInputStream(new File("E:\\lee\\github\\lee-skill-java\\src\\main\\resources\\data\\2003.xls"));
        InputStream inputStream = null;
        try {
            inputStream = FileUtils.openInputStream(new File("E:\\lee\\github\\lee-skill-java\\src\\main\\resources\\data\\2007.xlsx"));
            List<Object> data = (List<Object>) EasyExcelFactory.read(inputStream, new Sheet(1, 0, ReadModel.class));
            print(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
        }
        //System.out.println(JSON.toJSONString(data));
    }

    @Test
    public void simpleReadListStringV2007() throws IOException {
        //InputStream inputStream = new FileInputStream(new File("E:\\lee\\github\\lee-skill-java\\src\\main\\resources\\data\\2003.xls"));
        InputStream inputStream = FileUtils.openInputStream(new File("E:\\lee\\github\\lee-skill-java\\src\\main\\resources\\data\\2007.xlsx"));
        ExcelListener listener = new ExcelListener();
        EasyExcelFactory.readBySax(inputStream, new Sheet(1, 0, ReadModel.class), listener);
        inputStream.close();
        //print(data);
        //System.out.println(JSON.toJSONString(data));
    }

    @Test
    public void simpleReadListStringV2003() throws IOException {
        InputStream inputStream = FileUtil.getResourcesFileInputStream("2003.xls");
        List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(1, 0));
        inputStream.close();
        print(data);
    }

    public void print(List<Object> datas) {
        int i = 0;
        for (Object ob : datas) {
            System.out.println(i++);
            System.out.println(ob);
        }
    }
}
