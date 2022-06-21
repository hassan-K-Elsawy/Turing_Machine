package com.company;

public class Rule {
    public String initState;
    public String input;
    public String nextState;
    public String output;
    public String move;

    public Rule(){}

    public Rule(String init, String input, String nextState, String output, String move){
        this.initState = init;
        this.input = input;
        this.nextState = nextState;
        this.output = output;
        this.move = move;
    }

    public void print(){
        System.out.println("(" + initState + ", " + input + ") -> (" + nextState + ", " + output + ", " + move +")");
    }
}
