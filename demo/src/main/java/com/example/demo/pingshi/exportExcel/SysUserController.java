package com.example.demo.pingshi.exportExcel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 后台用户-controller
 * @author libo
 */
@Controller
public class SysUserController {

/*
    @Value(value="${headImgPath}")    //后台图片保存地址
    private String headImgPath;

    @Value(value="${uploadHost}")
    private String uploadHost;    //项目host路径

    @Value(value="${sysUserDefImg}")
    private String sysUserDefImg;    //系统用户默认头像*/
    /**
     * 导出系统用户数据
     * @param req
     * @param res
     * @param name
     * @param phone
     * @param email
     * @param roleId
     * @param createTimeStart
     * @param createTimeEnd
     * @param status
     * @param departmentId
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value="/sysUser", method= RequestMethod.GET)
    public void exportSysUsers(HttpServletRequest req, HttpServletResponse res,
                               String name, String phone, String email, Integer roleId, String createTimeStart, String createTimeEnd,
                               Integer status, Integer departmentId) throws IOException{
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("name", "".equals(name) || null == name ? null : name);
        params.put("phone", "".equals(phone) || null == phone ? null : phone);
        params.put("email", "".equals(email) || null == email ? null : email);
        params.put("roleId", "".equals(roleId) || null == roleId ? null : roleId);
        params.put("createTimeStart", "".equals(createTimeStart) || null == createTimeStart ? null : createTimeStart+" 00:00:00");
        params.put("createTimeEnd", "".equals(createTimeEnd) || null == createTimeEnd ? null : createTimeEnd+" 23:59:59");
        params.put("status", "".equals(status) || null == status ? null : status);
        params.put("departmentId", "".equals(departmentId) || null == departmentId ? null : departmentId);

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HHmm");
        String formatTime = sdf.format(d);
        String fileName="工地告警表-"+formatTime;
        //填充projects数据
        List<SysUser> userList = new ArrayList<>();
        SysUser s1=new SysUser(1,"zhangyu");
        SysUser s2=new SysUser(2,"kui");
        userList.add(s1);
        userList.add(s2);
        List<Map<String,Object>> list=createExcelRecord(userList);
        String columnNames[]={"姓名", "性别", "邮箱", "电话", "部门", "角色", "状态", "创建时间"};//列名
        String keys[] = {"name", "gender", "email", "phone", "department", "role", "status", "createTime"};//map中的key
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ExcelUtil.createWorkBook(list,keys,columnNames).write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        res.reset();
        res.setContentType("application/vnd.ms-excel;charset=utf-8");
        res.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
        ServletOutputStream out = res.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
            {
                bis.close();
            }
            if (bos != null){
                bos.close();
            }
        }
    }

    /**
     * 生成Excel数据
     * @param userList
     * @return
     */
    private List<Map<String, Object>> createExcelRecord(List<SysUser> userList) {
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        listmap.add(map);
        SysUser user = null;
        for (int j = 0; j < userList.size(); j++) {
            user = userList.get(j);
            Map<String, Object> mapValue = new HashMap<String, Object>();
            mapValue.put("id", user.getId());
            mapValue.put("name", user.getName());
         /*   mapValue.put("gender", (user.getGender()==1) ? "男":((user.getGender()==0) ? "女" : "保密"));
            mapValue.put("email", user.getEmail());
            mapValue.put("phone", user.getPhone());
            mapValue.put("department", user.getDepartment().getName());
            mapValue.put("role", user.getRole().getName());
            mapValue.put("status", user.getStatus()==1 ? "启用" : "禁用");
            mapValue.put("createTime", user.getCreateTime().substring(0, 19));*/
            listmap.add(mapValue);
        }
        return listmap;
    }
}
