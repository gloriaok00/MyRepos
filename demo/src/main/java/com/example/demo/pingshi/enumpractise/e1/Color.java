package com.example.demo.pingshi.enumpractise.e1;

import lombok.Getter;

@Getter
public enum Color {
    RED(1){
        @Override
        public String showCode() {
            return "1";
        }
    }, GREEN(2){
        @Override
        public String showCode() {
            return "2";
        }
    }, BLUE(3){
        @Override
        public String showCode() {
            return "3";
        }
    };

    private int code;
    private String name;

    Color(int code){
        this.code=code;
    }

    public abstract String showCode();

}
