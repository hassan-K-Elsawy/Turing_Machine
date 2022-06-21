package com.company;

public class AutomataHead {
    private InputStrip strip;
    private int pos;

    public AutomataHead(){
        strip = new InputStrip();
        pos = 0;
    }

    public AutomataHead(InputStrip strip){
        this.strip = strip;
        pos = 0;
    }

    public String getCurrent(){
        return strip.getIndex(pos);
    }
    public void modifyCurrent(String input){
        strip.setIndex(input, pos);
    }
    public void moveRight(){
        pos += 1;
    }
    public void moveLeft(){
        pos -= 1;
    }
    public void setStrip(InputStrip strip){this.strip = strip;}
    public void parkHead(){
        pos = 0;
    }
}
