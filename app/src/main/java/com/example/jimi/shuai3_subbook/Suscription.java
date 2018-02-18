/*
 * Suscription
 *
 * Version 1.0
 *
 *
 * February 04 2018
 *
 *
 * Copyright @ 2018 Shuai Li, COMPUT301, University of Alberta - All Rights Reserved.
 * You may use, distribute, or modify this code under teams and conditions of the Code of
 *    Student Behavior at Univertity of Alberta.
 * You can find a cope of the license in this porject. Otherwise please contact contact@abc.ca.
 */


package com.example.jimi.shuai3_subbook;

/**
 * @author Shuai Li
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
