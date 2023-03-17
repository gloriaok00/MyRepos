package org.example.edge;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

@Service("edgeService")
public interface EdgeService {

    /**
     * 获取mx xml
     */
    String getMxXml(MxXmlRequest mxXmlRequest);

    /**
     * 获取边缘计算中文信息
     */
    JSONObject getZh();

}
