package com.company;

import java.util.ArrayList;
import static java.lang.System.exit;

public class Automata {

    //TM = (k, Sig, Gam, S, del)

    //k = set of states inferred from rules
    //Sig = input lang {0,1} constant
    //Gam = machine lang {0, 1, #} constant
    //S = init state
    //del = rules

    AutomataHead head;
    ArrayList<String> states;
    String initState;
    String currState;
    ArrayList<Rule> rules;
    ArrayList<Rule> traceRules;

    public Automata(String initState, InputStrip strip){

        this.states = new ArrayList<>();
        this.initState = initState;
        this.currState = initState;
        this.rules = new ArrayList<>();
        this.head = new AutomataHead(strip);
        this.traceRules = new ArrayList<>();

    }

    public void addRule(Rule r){
        rules.add(r);
    }

    private int action(String action){

        switch (action) {
            case "R" -> {
                head.moveRight();
                return 0;
            }
            case "L" -> {
                head.moveLeft();
                return 0;
            }
            case "Y", "N" -> {
                printTrace();
                return 1;
            }
            default -> {
                System.out.println("Incorrct Action");
                exit(1);
                return 1;
            }
        }
    }

    public void start(){

        for (Rule r:rules){
            String temp = r.initState;
            if(!states.contains(temp)){
                states.add(temp);
            }
        }

        String temp = head.getCurrent();
        boolean accRej = false;

        currState = initState;
        head.parkHead();

        while(!accRej){
            for(Rule r:rules){
                if(r.initState.equals(currState) && r.input.equals(temp)){

                    head.modifyCurrent(r.output);
                    currState = r.nextState;
                    accRej = (action(r.move) == 1) ;
                    traceRules.add(r);
                    temp = head.getCurrent();
                    break;

                }
            }
        }

    }

    public void printTrace(){
        for(Rule t: traceRules){
            t.print();
        }
    }

}
