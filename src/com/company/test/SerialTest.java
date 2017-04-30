package com.company.test;

import java.io.*;

/**
 * Created by asus on 2017/4/28.
 */
public class SerialTest {

    public static void main(String[] args) {
        Person robin = new Person("robin", 29);
        String savePath = "D:\\object.txt";

        SerialTest test = new SerialTest();
        try {
            test.serialize(robin, savePath);
            Person person = (Person) test.deSerialize(savePath);
            System.out.println("Name:" + person.getName() + "   Age:"
                    + person.getAge());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 实现序列化
     *
     * @param obj
     *            要被序列化保存的对象
     * @param path
     *            保存地址
     * @throws IOException
     */
    public void serialize(Object obj, String path) throws IOException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(obj);
        } finally {
            if (null != oos)
                oos.close();
        }
    }

    /**
     * 反序列化取出对象
     *
     * @param path
     *            被序列化对象保存的位置
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Object deSerialize(String path) throws IOException,
            ClassNotFoundException {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(path));
            return ois.readObject();
        } finally {
            if (null != ois)
                ois.close();
        }
    }
}
