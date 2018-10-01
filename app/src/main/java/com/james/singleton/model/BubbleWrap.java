package com.james.singleton.model;

public class BubbleWrap {

    private static final int ADD_MORE_BUBBLES = 10;
    private int numberBubbles;
 /*
            Singleton Object Code
  */

    private static BubbleWrap instance;

    private BubbleWrap(){
         // private to prevent anyone else from instantiating
    }
    public static BubbleWrap getInstance(){
        if(instance == null){
            instance = new BubbleWrap();
        }
        return instance;
    }


    /*
            Normal Object Code
     */

    public int getNumberBubbles() {
        return numberBubbles;
    }

    public void addMoreBubbles(){
        numberBubbles += ADD_MORE_BUBBLES;
    }

    public void pupBubble() {
        numberBubbles --;
    }

}
