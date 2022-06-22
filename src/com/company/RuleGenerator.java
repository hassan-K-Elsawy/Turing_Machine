package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class RuleGenerator {
    private ArrayList<String> inputString;
    private Automata a;

    public RuleGenerator(String  rules, Automata a){

        String[] str = rules.split(",");
        inputString = new ArrayList<>();
        inputString.addAll(Arrays.asList(str));

        Rule temp;
        for (int i=0; i<inputString.size()/5; i++){
            temp = new Rule(inputString.get(5*i), inputString.get((5*i)+1), inputString.get((5*i)+2), inputString.get((5*i)+3), inputString.get((5*i)+4));
            a.addRule(temp);
        }


    }

}
