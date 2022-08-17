package com.example.demo.pingshi.http.retry;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pingshi.http.retry.model.AppData;
import com.example.demo.pingshi.http.retry.model.AppFull;
import com.github.rholder.retry.*;
import com.google.common.base.Predicates;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @description 重试机制练习
 * @date 2022/8/16 10:57
 * @date 2022/8/17 14:24
 */

@Slf4j
public class HttpRetry {

    public static String token="Yzc1ZjcwZjItNGRhMy00NTM2LTg1YzQtOGQ2MjJjZDI4Nzc1";

    public static void main(String[] args) throws ExecutionException, RetryException {
        System.out.println("1");

        //定义重试机制
        Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
                //retryIf 重试条件
                .retryIfException()
                .retryIfRuntimeException()
                .retryIfExceptionOfType(Exception.class)
                .retryIfException(Predicates.equalTo(new Exception()))
                .retryIfResult(Predicates.equalTo(false))

                //等待策略：每次请求间隔1s
                .withWaitStrategy(WaitStrategies.fixedWait(1000, TimeUnit.MILLISECONDS))

                //停止策略 : 尝试请求3次
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))

                .build();

        //定义请求实现
        Callable<Boolean> callable = new Callable<Boolean>() {

            @Override
            public Boolean call() throws Exception {
                JSONObject param=new JSONObject();
                param.put("name","");
                //true 1556569114460291072
                //false 1549747556349640704
                param.put("orgUuid","1556569114460291072");
                String result = HttpRequest.post("http://dev.gemcoder.com/project/queryProjects")
                        .header("Cookie", "RUBIKSESSIONID=" + token)
                        .body(param.toJSONString())
                        .execute().body();
                System.out.println(result);
                if (StrUtil.isBlank(result)) {
                    log.info("全空");
                    return false;
                }
                AppFull full=JSONObject.parseObject(result, AppFull.class);
                AppData data=full.getData();
                if (Objects.isNull(data.getPartakeList())) {
                    log.info("空了");
                    return false;
                } else {
                    log.info("不空");
                    return true;
                }

            }
        };

        System.out.println("2");
        System.out.println(retryer.call(callable));
        System.out.println("3");

    }
}
