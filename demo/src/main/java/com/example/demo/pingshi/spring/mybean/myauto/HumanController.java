package com.example.demo.pingshi.spring.mybean.myauto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/an")
public class HumanController {

    //启动时会报错，当没指定name或type时，@resource也去按type去装配了，但有两个，所以也不行了
    //@Resource()
    //@Autowired
    @Resource(name="woman")
    //@Qualifier("woman")
    private Human human;

    @RequestMapping("/run")
    public String runMarathon() {
        return human.runMarathon();
    }
}
