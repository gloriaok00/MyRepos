package com.example.demo.mianshi.lambda.practise;

/**
 * @description 模仿consumer的功能
 * @date 2022-04-07 10:14
 */

@FunctionalInterface
public interface FakeConsumer<TG> {

    void fakeConsume(TG tg);

}
