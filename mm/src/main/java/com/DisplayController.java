package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DisplayController {

    @RequestMapping("/play")
    public String index() {
        return "playtime";
    }

}
