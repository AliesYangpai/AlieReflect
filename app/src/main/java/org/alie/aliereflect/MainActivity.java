package org.alie.aliereflect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reflectToGetMethod();
        reflectToConstructWithParam();
    }

    /**
     * 反射获取类名
     * getDeclaredField() 获取的是 Class 中被 private 修饰的属性
     * etField() 方法获取的是非私有属性，并且 getField() 在当前 Class 获取不到时会向祖先类获取。
     */

    private void reflectToGetClassName() {
        try {
            Class<?> aClass = Class.forName("org.alie.aliereflect.StudentManager");
            Field age = aClass.getDeclaredField("age");
            age.set(int.class, 12);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射调用静态方法
     */
    private void reflectToGetMethod() {
        try {
            Class<?> aClass = Class.forName("org.alie.aliereflect.StudentManager");
            Method getStudentList = aClass.getDeclaredMethod("deleteStudentByName", String.class);
            getStudentList.invoke(null, "西瓜");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void reflectToConstruct() {
        try {
            Class<?> aClass = Class.forName("org.alie.aliereflect.StudentManager");
            Object o = aClass.newInstance();
            StudentManager studentManager = (StudentManager) o;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    private void reflectToConstructWithParam(){
        try {
            Class<?> aClass = Class.forName("org.alie.aliereflect.StudentManager");
            Constructor<?> constructor = aClass.getConstructor(new Class[]{String.class, int.class, String.class});
            Object o = constructor.newInstance("南瓜", 12, "女");
            StudentManager studentManager = (StudentManager) o;
            studentManager.getStudentInfo();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}
