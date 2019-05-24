package com.litl.www.util;

import java.io.*;
import java.util.Properties;

public class ProUtil {
    private  Properties prop;
    private  String filepath;

    public ProUtil(String filepath) {
        this.filepath = filepath;
        this.prop = readProp();
    }

    private Properties readProp() {
        Properties prop = new Properties();
        try {
            InputStream is = new FileInputStream(filepath);
            BufferedInputStream bis = new BufferedInputStream(is);
            prop.load(bis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

    public String getPro(String key) {
        if (prop.containsKey(key)) {
            String value = prop.getProperty(key);
            return value;
        }
        return "";
    }


    public void writePro(String key, String value) {
        Properties prop = new Properties();
        try {
            FileOutputStream fos = new FileOutputStream(filepath);
            prop.setProperty(key, value);
            prop.store(fos, key);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ProUtil pro = new ProUtil("src/element.properties");
        System.out.println(pro.readProp());
    }
}
