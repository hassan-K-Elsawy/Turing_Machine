package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        InputStrip  s = new InputStrip("0,1,1,0,#");

        Rule r1 = new Rule("q0", "0", "q0", "1", "R");
        Rule r2 = new Rule("q0", "1", "q0", "0", "R");
        Rule r3 = new Rule("q0", "#", "q0", "#", "Y");

        String state = "q0";
        ArrayList<String> als = new ArrayList<String>();
        als.add(state);

        Automata a = new Automata(als, state, s);
        a.addRule(r1);
        a.addRule(r2);
        a.addRule(r3);
        a.start();
    }
}

