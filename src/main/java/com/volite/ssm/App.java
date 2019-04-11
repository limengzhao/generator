package com.volite.ssm;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;


public class App {
    public static void main(String[] args) {
         List<String> warnings = new ArrayList<String>();
           boolean overwrite = true;
           String path = System.getProperty("user.dir")+"\\src\\generatorConfig.xml";//这个路径要注意
          System.out.println(path);
           File configFile = new File(path);
           ConfigurationParser cp = new ConfigurationParser(warnings);
           Configuration config = null;
        try {
            config = cp.parseConfiguration(configFile);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (XMLParserException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
           DefaultShellCallback callback = new DefaultShellCallback(overwrite);
           MyBatisGenerator myBatisGenerator = null;
        try {
            myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        } catch (InvalidConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           try {
            myBatisGenerator.generate(null);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
        

}