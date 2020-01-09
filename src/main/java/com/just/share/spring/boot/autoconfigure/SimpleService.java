package com.just.share.spring.boot.autoconfigure;

public class SimpleService {

    private String name;

    private String filed;

    private String add;

    public SimpleService(String name, String filed, String add) {
        this.name = name;
        this.filed = filed;
        this.add = add;
    }

    /**
     *  处理业务
     * @return
     */
    public String dealSimple() {
        String data ="hello" + name + "world" + filed + "simple" + add;
        System.out.println(data);
        return data;
    }
}
