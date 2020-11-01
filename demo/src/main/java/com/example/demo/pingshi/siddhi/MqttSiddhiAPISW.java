package com.example.demo.pingshi.siddhi;

import io.siddhi.core.SiddhiAppRuntime;
import io.siddhi.core.SiddhiManager;
import io.siddhi.core.event.Event;
import io.siddhi.core.stream.input.InputHandler;
import io.siddhi.core.stream.output.StreamCallback;
import io.siddhi.core.util.EventPrinter;

/**
 * siddhi sw temp save
 *
 * @author zhangyu
 * @date 2020/8/21 10:09
 */

public class MqttSiddhiAPISW {

    public static void main(String[] args) throws InterruptedException {

        // Create Siddhi Manager
        SiddhiManager siddhiManager = new SiddhiManager();

        //Siddhi Application
        String siddhiApp1 = "" +
                "define stream StockStream (symbol string, price float, volume long); " +
                "" +
                "@info(name = 'query1') " +
                "from StockStream[volume < 150] " +
                "select symbol, price " +
                "insert into OutputStream;";

        String siddhiApp = "" +
                "@source(type='mqtt', url= 'tcp://39.100.14.20:30003',topic='SiteWhere/default/input/json', @map(type='json',@attributes(deviceToken='deviceToken', originator='originator',type='type',eventType='request.eventType',updateState='request.updateState',name='request.name',value='request.value',metadata='request.metadata')))" +
                "define stream SweetProductionStream (deviceToken string,originator string,type string,eventType string, updateState bool,name string,value double,metadata object);"+
                "" +
                "@info(name='query1')" +
                "from SweetProductionStream" +
                "select deviceToken as deviceToken,originator as originator,type as type,eventType as eventType,updateState as updateState,name as name,value as value,metadata as metadata" +
                "insert into LowProductionAlertStream"+
                "" +
                "@sink(type='log',@map(type='json'))"+
                "define stream LowProductionAlertStream (deviceToken string,originator string,type string,eventType string,updateState bool,name string,value double,metadata object)";


        //Generate runtime
        SiddhiAppRuntime siddhiAppRuntime = siddhiManager.createSiddhiAppRuntime(siddhiApp);

        //Adding callback to retrieve output events from stream
        siddhiAppRuntime.addCallback("OutputStream", new StreamCallback() {
            @Override
            public void receive(Event[] events) {
                EventPrinter.print(events);
                //To convert and print event as a map
                //EventPrinter.print(toMap(events));
            }
        });

        //Get InputHandler to push events into Siddhi
        InputHandler inputHandler = siddhiAppRuntime.getInputHandler("SweetProductionStream");

        //Start processing
        siddhiAppRuntime.start();

        //Sending events to Siddhi
      /*  inputHandler.send(new Object[]{"IBM", 700f, 100L});
        inputHandler.send(new Object[]{"WSO2", 60.5f, 200L});
        inputHandler.send(new Object[]{"GOOG", 50f, 30L});
        inputHandler.send(new Object[]{"IBM", 76.6f, 400L});
        inputHandler.send(new Object[]{"WSO2", 45.6f, 50L});*/
        //Thread.sleep(500);

        //Shutdown runtime
        siddhiAppRuntime.shutdown();

        //Shutdown Siddhi Manager
        siddhiManager.shutdown();

    }
}