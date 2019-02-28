package com.lee.happy.util;

import java.io.InputStream;

/**
 * @author lee
 * @date 2019/2/26
 */

public class FileUtil {
    public static InputStream getResourcesFileInputStream(String fileName) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream("" + fileName);
    }
}
