package com.example.demo.pingshi.siddhi;

import io.siddhi.core.SiddhiAppRuntime;
import io.siddhi.core.SiddhiManager;
import io.siddhi.core.event.Event;
import io.siddhi.core.stream.input.InputHandler;
import io.siddhi.core.stream.output.StreamCallback;
import io.siddhi.core.util.EventPrinter;
import io.siddhi.core.util.SiddhiConstants;
import io.siddhi.core.util.statistics.metrics.Level;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.testng.AssertJUnit;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * 研究性能数据
 * @author zhangyu
 * @date 2021/04/29 14:56
 */

@Slf4j
public class TestStatistics {

    private int count;
    private boolean eventArrived;

    @Test
    public void testStat() throws InterruptedException {

        // Create Siddhi Manager
        SiddhiManager siddhiManager = new SiddhiManager();

        //Siddhi Application
        String siddhiApp = "" +
                "@app:statistics(reporter = 'console', interval = '2' )" +
                " " +
                "@async(buffer.size='2') " +
                "define stream cseEventStream (symbol string, price float, volume int);" +
                "define stream cseEventStream2 (symbol string, price float, volume int);" +
                "" +
                "@info(name = 'query1') " +
                "from cseEventStream[70 > price] " +
                "select * " +
                "insert into outputStream ;" +
                "" +
                "@info(name = 'query2') " +
                "from cseEventStream[volume > 90] " +
                "select * " +
                "insert into outputStream ;";

        SiddhiAppRuntime siddhiAppRuntime = siddhiManager.createSiddhiAppRuntime(siddhiApp);
        siddhiAppRuntime.addCallback("outputStream", new StreamCallback() {
            @Override
            public void receive(Event[] events) {
                EventPrinter.print(events);
                eventArrived = true;
                for (Event event : events) {
                    count++;
                    AssertJUnit.assertTrue("IBM".equals(event.getData(0)) || "WSO2".equals(event.getData(0)));
                }
            }
        });

        InputHandler inputHandler = siddhiAppRuntime.getInputHandler("cseEventStream");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        siddhiAppRuntime.start();
        siddhiAppRuntime.setStatisticsLevel(Level.BASIC);
        inputHandler.send(new Object[]{"WSO2", 55.6f, 100});
        inputHandler.send(new Object[]{"IBM", 75.6f, 100});

        Thread.sleep(3010);
        siddhiAppRuntime.shutdown();
        AssertJUnit.assertTrue(eventArrived);
        AssertJUnit.assertEquals(3, count);

        System.out.flush();
        String output = baos.toString();
        log.info(output);

        AssertJUnit.assertTrue(output.contains("Gauges"));
        AssertJUnit.assertTrue(output.contains("cseEventStream.size"));
        AssertJUnit.assertFalse(output.contains("query1.memory"));
        AssertJUnit.assertTrue(output.contains("io.siddhi." + SiddhiConstants.METRIC_INFIX_SIDDHI_APPS));
        AssertJUnit.assertTrue(output.contains("Meters"));
        AssertJUnit.assertTrue(output.contains(SiddhiConstants.METRIC_INFIX_SIDDHI + SiddhiConstants.METRIC_DELIMITER +
                SiddhiConstants.METRIC_INFIX_STREAMS + SiddhiConstants.METRIC_DELIMITER + "cseEventStream"));
        AssertJUnit.assertTrue(output.contains("Timers"));
        AssertJUnit.assertTrue(output.contains("query1.latency"));

        System.setOut(old);

    }
}
