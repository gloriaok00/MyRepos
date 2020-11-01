package com.example.demo.pingshi.监听器;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author zhangyu
 * @description
 * @date 2020-05-01 19:28
 */

public class TimePrinter implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("每一秒，我响一次");
    }
}
