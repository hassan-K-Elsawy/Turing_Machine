package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        InputStrip  s = new InputStrip("0,1,1,0,#");
        Automata a = new Automata("0", s);
        RuleGenerator r = new RuleGenerator("0,0,0,1,R,0,1,0,0,R,0,#,0,#,Y", a);
        /*
        Rule r1 = new Rule("0", "0", "0", "1", "R");
        Rule r2 = new Rule("0", "1", "0", "0", "R");
        Rule r3 = new Rule("0", "#", "0", "#", "Y");
        */

        //ArrayList<String> als = new ArrayList<String>();
        //als.add(state);

        /*
        a.addRule(r1);
        a.addRule(r2);
        a.addRule(r3);
        */
        a.start();

        s.printStrip();
    }
}

