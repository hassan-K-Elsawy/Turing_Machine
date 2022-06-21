package com.company;

import java.util.ArrayList;
import static java.lang.System.exit;

public class Automata {
    AutomataHead head;
    ArrayList<String> states;
    String initState;
    String currState;
    ArrayList<Rule> rules;
    ArrayList<Rule> traceRules;

    public Automata(ArrayList<String> states, String initState, InputStrip strip){
        this.states = states;
        this.initState = initState;
        this.currState = initState;
        this.rules = new ArrayList<Rule>();
        this.head = new AutomataHead(strip);
        this.traceRules = new ArrayList<Rule>();
    }

    public void addRule(Rule r){
        rules.add(r);
    }

    private int action(String action){
        /*switch(action) {
            case "R":
                head.moveRight();
                return 0;

            case "L":
                head.moveLeft();
                return 0;

            case "Y":
                printTrace();
                return 1;

            case "N":
                printTrace();
                return 1;

            default:
                System.out.println("Incorrct Action");
                exit(1);
                return 1;
        }*/
        if(action.equals("R")){
            head.moveRight();
            return 0;
        }else if(action.equals("L")){
            head.moveLeft();
            return 0;
        }else if(action.equals("Y")){
            printTrace();
            return 1;
        }else if(action.equals("N")){
            printTrace();
            return 1;
        }else{
            System.out.println("Incorrct Action");
            exit(1);
            return 1;
        }
    }

    public void start(){

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
