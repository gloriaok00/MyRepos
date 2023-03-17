package org.example.edge.pojo;


import lombok.Getter;

public enum SiddhiItemEnum {

    /**
     * source节点
     */
    source("1", "sourceList"),

    /**
     * sink节点
     */
    sink("2", "sinkList"),

    /**
     * stream节点
     */
    stream("3", "streamList"),

    /**
     * 表节点
     */
    table("4", "tableList"),

    /**
     * 定时器节点
     */
    trigger("5", "triggerList"),

    /**
     * 窗口节点
     */
    window("6", "windowList"),

    /**
     * 聚合节点
     */
    aggregation("7", "aggregationList"),

    /**
     * 功能节点
     */
    function("8", "functionList"),

    /**
     * 查询节点
     */
    query("9", "queryLists"),

    /**
     * 功能节点
     */
    partition("10", "partitionList");


    @Getter
    private String code;

    @Getter
    private String message;

    SiddhiItemEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
