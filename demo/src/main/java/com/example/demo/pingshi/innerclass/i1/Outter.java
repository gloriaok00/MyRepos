package com.example.demo.pingshi.innerclass.i1;

public class Outter {
    private Inner inner = null;
    public Outter() {

    }

    public Inner getInnerInstance() {
        if(inner == null)
            inner = new Inner();
        return inner;
    }

    protected class Inner {
        public Inner() {

        }
    }
}
