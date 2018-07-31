package com.chapter3;

import com.chapter3.digester.Department;
import com.chapter3.digester.User;
import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

/**
 * @author sen.huang
 *         Date: 2018/7/31
 */
public class DigesterTest {
    public static void main(String[] args) {
        Digester digester = new Digester();
        digester.setValidating(false);
        
        //匹配department节点时，创建类
        digester.addObjectCreate("department", Department.class);
        //匹配department节点时，设置对象的属性
        digester.addSetProperties("department");
        //匹配department/user节点时，创建User对象
        digester.addObjectCreate("department/user", User.class);
        //匹配department/user时设置对象属性
        digester.addSetProperties("department/user");
        //匹配department/user时。调用Department对象的addUser方法
        digester.addSetNext("department/user","addUser");
        //匹配department/extension节点时，调用department 的putExtension方法
        digester.addCallMethod("department/extension","putExtension",2);
        //调用方法的第一个参数为节点的 department/extension/property-name
        digester.addCallParam("department/extension/property-name",0);
        digester.addCallParam("department/extension/property-value",1);

        try {
            Department department = (Department)digester.parse(new File("C:\\Java\\idea-workspace\\tomcatDemo\\src\\main\\resources\\chapter3\\digester-test.xml"));
            System.out.println(department);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }


    }
}
