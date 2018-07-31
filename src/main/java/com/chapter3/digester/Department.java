package com.chapter3.digester;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sen.huang
 *         Date: 2018/7/31
 */
public class Department {
    private String name;
    private int age;

    private Map<String,String> extension = new HashMap<String, String>();

    private List<User> users = new ArrayList<User>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, String> getExtension() {
        return extension;
    }

    public void setExtension(Map<String, String> extension) {
        this.extension = extension;
    }

    public void putExtension(String name,String value){
        this.extension.put(name,value);
    }

    public void addUser(User user){
        this.users.add(user);
    }
}
