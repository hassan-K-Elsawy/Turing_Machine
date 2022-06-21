package com.company;

import java.util.*;


public class InputStrip {
    private ArrayList<String> strip ;

    public InputStrip(){
        strip = new ArrayList<String>();
    }

    public InputStrip(String inputString){
        String str[] = inputString.split(",");
        strip = new ArrayList<String>();
        strip.addAll(Arrays.asList(str));
    }

    public String getIndex(int pos){

        try{
            return strip.get(pos);
        } catch (Exception e) {
            return "";
        }

    }

    public void setIndex(String input, int pos){
        int cap = strip.size();

        if( cap - 1 < pos ){
            for(int i = cap; i <= 2*pos; i++)
                strip.add("#");
        }

        strip.set(pos, input);
    }

    public void printStrip(){
        for(String string:strip)
            System.out.println(string);
    }

}
