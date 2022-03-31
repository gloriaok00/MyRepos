package com.example.demo.pingshi.datatype.fanxing.fx1;


/**
 * @description 泛型类学习
 * @date 2022-02-05 22:04
 * @date 2022-03-31 10:40
 */

public class Generic<TVNM>{

    private TVNM key;

    public TVNM getKey() {
        return key;
    }

    public void setKey(TVNM key) {
        this.key = key;
    }

    public Generic(TVNM key) {
        this.key = key;
    }

    public Generic() {
    }

    public void show(){
        System.out.println("不和泛型有联系也是可以的");
    }
}
