package com.example.jimi.shuai3_subbook;

/**
 * Created by jimi on 2018-02-08.
 */

public class Suscription {
    private String name;
    private String amount;
    private String date;
    private String comment;

    public Suscription(String name,String amount,String date,String comment){
        this.name=name;
        this.amount=amount;
        this.date=date;
        this.comment=comment;

    }


    public String getName(){
        return name;
    }
    public String getAmount(){return amount;}
    public String getDate(){return date;}
    public String getComment() {
        return comment;
    }
    public String toString(){return this.name+"  "+this.amount+ "  " +this.date;}



}
