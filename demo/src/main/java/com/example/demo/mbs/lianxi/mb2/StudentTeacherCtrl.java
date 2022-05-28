package com.example.demo.mbs.lianxi.mb2;

import com.example.demo.mbs.cus.dao.StuTeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @date 2022/5/28 14:06
 */

@RestController
@RequestMapping("/zz")
public class StudentTeacherCtrl {

    @Autowired
    private StuTeacherDao nn;

    @GetMapping("/cc")
    public void testAssociation(){
        Student student = nn.getById(1);
        System.out.println(student.getName()+"的指导老师是:"+student.getSupervisor().getName());
    }
}
