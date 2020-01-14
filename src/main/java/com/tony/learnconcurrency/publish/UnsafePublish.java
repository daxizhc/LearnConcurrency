package com.tony.learnconcurrency.publish;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class UnsafePublish {

    private String[] states = {"a", "b", "c"};

    public String[] getStates(){
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

        // 不安全发布对象
        unsafePublish.getStates()[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.getStates()));
    }

}
