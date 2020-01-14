package com.tony.learnconcurrency.singleton;

import lombok.extern.slf4j.Slf4j;

// 懒汉模式
@Slf4j
public class SingletonExample1 {

    // 私有构造函数
    private SingletonExample1(){
        log.info("SingletonExample1 初始化");
    }

    // 单例对象
    private volatile static SingletonExample1 instance = null;

    public static SingletonExample1 getInstance(){
        if(instance == null){
            synchronized (SingletonExample1.class){
                if(instance == null){
                    instance = new SingletonExample1();
                }
            }
        }
        return instance;
    }



}
