package org.example.edge.rest;

import com.alibaba.fastjson.JSONObject;
import org.example.edge.pojo.CommonResult;
import org.example.edge.pojo.MxXmlRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 边缘计算
 */

@RestController
@RequestMapping("/edge")
public class EdgeCtrl {

    @Autowired
    private EdgeService edgeService;

    @PostMapping("/mxxml")
    public CommonResult<String> getMxXml(@RequestBody @Valid MxXmlRequest content) {
        return CommonResult.success(edgeService.getMxXml(content));
    }

    @GetMapping("/zh")
    public CommonResult<JSONObject> getZh() {
        return CommonResult.success(edgeService.getZh());
    }

}
