package org.alie.aliereflect;

import android.util.Log;

/**
 * Created by Alie on 2019/9/6.
 * 类描述 这个类用来进行反射的测试
 * 版本
 */
public class StudentManager {
    private static final String TAG = "StudentManager";
    private String name;
    private int age;
    public String gender;


    /**
     * 测试反射一个构造方法
     */
    public StudentManager() {
    }

    /**
     * 测试反射一个构造方法（有参）
     */
    public StudentManager(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    /**
     * 测试反射一个方法（无参）
     */
    public void getStudentList() {
        Log.i(TAG,"===getStudentList() 调用了学生列表");
    }

    /**
     * 测试反射一个方法（有参）
     */
    public void getStudentByName(String name) {
        Log.i(TAG,"===getStudentByName() 根据 "+name+" 查询");
    }

    /**
     * 测试反射一个静态方法（有参）
     */
    public static void deleteStudentByName(String name) {
        Log.i(TAG,"===deleteStudentByName() 根据 "+name+" 删除");
    }

    public void getStudentInfo() {
        Log.i(TAG,"===getStudentInfo() name:"+name+" age:"+age+" gender:"+gender);
    }
}
