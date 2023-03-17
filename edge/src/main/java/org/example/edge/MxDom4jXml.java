package org.example.edge;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.wso2.carbon.siddhi.editor.core.util.designview.beans.EventFlow;
import org.wso2.carbon.siddhi.editor.core.util.designview.beans.configs.Edge;
import org.wso2.carbon.siddhi.editor.core.util.designview.beans.configs.SiddhiAppConfig;
import org.wso2.carbon.siddhi.editor.core.util.designview.beans.configs.siddhielements.*;
import org.wso2.carbon.siddhi.editor.core.util.designview.beans.configs.siddhielements.aggregation.AggregationConfig;
import org.wso2.carbon.siddhi.editor.core.util.designview.beans.configs.siddhielements.partition.PartitionConfig;
import org.wso2.carbon.siddhi.editor.core.util.designview.beans.configs.siddhielements.query.QueryConfig;
import org.wso2.carbon.siddhi.editor.core.util.designview.beans.configs.siddhielements.sourcesink.SourceSinkConfig;
import org.wso2.carbon.siddhi.editor.core.util.designview.constants.query.QueryListType;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MxDom4jXml {

    public static String createXml(EventFlow eventFlow) {
        try {
            // 1、创建document对象
            Document document = DocumentHelper.createDocument();
            // 2、创建根节点root
            Element mxGraphModel = document.addElement("mxGraphModel");
            Element root = mxGraphModel.addElement("root");
            Element parentZero = root.addElement("mxCell");
            parentZero.addAttribute("id", "0");
            Element parentDoubleZero = root.addElement("mxCell");
            parentDoubleZero.addAttribute("id", "00");
            parentDoubleZero.addAttribute("parent", "0");


            // 3、边
            Set<Edge> edgeSet = eventFlow.getEdgeList();
            Element mxCell;
            Element mxGeometry;
            for (Edge edge : edgeSet) {
                String[] ids = edge.getId().split("_");
                mxCell = root.addElement("mxCell");
                mxCell.addAttribute("id", edge.getId());
                mxCell.addAttribute("edge", "1");
                mxCell.addAttribute("source", ids[0]);
                mxCell.addAttribute("target", ids[1]);
                mxCell.addAttribute("parent", "00");
                mxGeometry = mxCell.addElement("mxGeometry");
                mxGeometry.addAttribute("relative", "1");
                mxGeometry.addAttribute("as", "geometry");
            }
            // 4、顶点信息
            SiddhiAppConfig siddhiAppConfig = eventFlow.getSiddhiAppConfig();
            //source
            List<SourceSinkConfig> sourceList = siddhiAppConfig.getSourceList();
            if (sourceList.size() != 0) {
                for (SourceSinkConfig temp : sourceList) {
                    addVertex(root, temp.getId(), SiddhiItemEnum.source.getMessage(), temp.getType());
                }
            }
            //sink
            List<SourceSinkConfig> sinkList = siddhiAppConfig.getSinkList();
            if (sinkList.size() != 0) {
                for (SourceSinkConfig temp : sinkList) {
                    addVertex(root, temp.getId(), SiddhiItemEnum.sink.getMessage(), temp.getType());
                }
            }
            //stream
            List<StreamConfig> streamList = siddhiAppConfig.getStreamList();
            if (streamList.size() != 0) {
                for (StreamConfig temp : streamList) {
                    addVertex(root, temp.getId(), SiddhiItemEnum.stream.getMessage(), temp.getName());
                }
            }
            //table
            List<TableConfig> tableList = siddhiAppConfig.getTableList();
            if (tableList.size() != 0) {
                for (TableConfig temp : tableList) {
                    addVertex(root, temp.getId(), SiddhiItemEnum.table.getMessage(), temp.getName());
                }
            }
            //trigger
            List<TriggerConfig> triggerList = siddhiAppConfig.getTriggerList();
            if (triggerList.size() != 0) {
                for (TriggerConfig temp : triggerList) {
                    addVertex(root, temp.getId(), SiddhiItemEnum.trigger.getMessage(), temp.getName());
                }
            }
            //window
            List<WindowConfig> windowList = siddhiAppConfig.getWindowList();
            if (windowList.size() != 0) {
                for (WindowConfig temp : windowList) {
                    addVertex(root, temp.getId(), SiddhiItemEnum.window.getMessage(), temp.getName());
                }
            }
            //aggregation
            List<AggregationConfig> aggregationList = siddhiAppConfig.getAggregationList();
            if (aggregationList.size() != 0) {
                for (AggregationConfig temp : aggregationList) {
                    addVertex(root, temp.getId(), SiddhiItemEnum.aggregation.getMessage(), temp.getName());
                }
            }
            //function
            List<FunctionConfig> functionList = siddhiAppConfig.getFunctionList();
            if (functionList.size() != 0) {
                for (FunctionConfig temp : functionList) {
                    addVertex(root, temp.getId(), SiddhiItemEnum.function.getMessage(), temp.getName());
                }
            }
            //query
            Map<QueryListType, List<QueryConfig>> queryList = siddhiAppConfig.getQueryLists();
            if (queryList.size() != 0) {
                queryList.entrySet().forEach(tempEntry -> {
                    if (tempEntry.getValue().size() != 0) {
                        tempEntry.getValue().forEach(e -> {
                            addVertex(root, e.getId(), SiddhiItemEnum.query.getMessage() + "." + tempEntry.getKey().toString(), e.getQueryName());
                        });
                    }
                });
            }
            //partition
            List<PartitionConfig> partitionList = siddhiAppConfig.getPartitionList();
            if (partitionList.size() != 0) {
                //分区
                for (PartitionConfig temp : partitionList) {
                    addVertex(root, temp.getId(), SiddhiItemEnum.partition.getMessage(), "partition");
                    //分区内部数据流
                    Map<QueryListType, List<QueryConfig>> qQueryList = temp.getQueryLists();
                    if (qQueryList.size() != 0) {
                        qQueryList.entrySet().forEach(tempEntry -> {
                            if (tempEntry.getValue().size() != 0) {
                                tempEntry.getValue().forEach(e -> {
                                    addVertex(root, e.getId(), SiddhiItemEnum.query.getMessage() + "." + tempEntry.getKey().toString(), e.getQueryName());
                                });
                            }
                        });
                    }
                }
            }

            //调试开发时生成xml文件
			/*
            // 5、设置生成xml的格式
			OutputFormat format = OutputFormat.createPrettyPrint();
			// 设置编码格式
			format.setEncoding("UTF-8");
			// 6、生成xml文件
			File file = new File("siddhi.xml");
			XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
			// 设置是否转义，默认使用转义字符
			writer.setEscapeText(false);
			writer.write(document.getRootElement());
			writer.close();
			System.out.println("生成siddhi.xml成功");
            */
            //去掉xml头部
            return document.getRootElement().asXML();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addVertex(Element root, String id, String type, String name) {
        Element mxCell;
        Element mxGeometry;
        mxCell = root.addElement("mxCell");
        mxCell.addAttribute("id", id);
        mxCell.addAttribute("type", type);
        mxCell.addAttribute("title", name);
        mxCell.addAttribute("parent", "00");
        mxCell.addAttribute("vertex", "1");
        mxGeometry = mxCell.addElement("mxGeometry");
        mxGeometry.addAttribute("x", "0");
        mxGeometry.addAttribute("y", "0");
        mxGeometry.addAttribute("width", "100");
        mxGeometry.addAttribute("height", "30");
        mxGeometry.addAttribute("as", "geometry");
    }
}
