package com.tony.learnconcurrency.singleton;

// 饿汉模式
public class SingletonExample2 {

    // 私有构造函数
    private SingletonExample2(){
    }

    private static SingletonExample2 instance = new SingletonExample2();

    public static SingletonExample2 getInstance() {
        return instance;
    }

}
