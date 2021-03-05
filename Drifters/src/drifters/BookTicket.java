/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drifters.src.drifters;

/**
 *
 * @author monu
 */
public class BookTicket {
    private String PNR="";
    private User user=null;
    private String trainNo=null;
     
    public void setPnr(String PNR){
        this.PNR=PNR;
    }
    public void setUser(User user){
        this.user=user;
    }
    public void setTrainNo(String trainNo){
        this.trainNo=trainNo;
    }
    public String getPnr(){
        return this.PNR;
    }
    public User getUser(){
        return this.user;
    }
    public String getTrainNo(){
        return this.trainNo;
    }

    public String displayString(){
        return "PNR: " + this.PNR + "\nTrain info: " + this.trainNo
                + "\nUser info " + this.user.toString() ;
    }
    @Override
    public String toString(){
        return this.PNR + "|" + this.trainNo + "|" + this.user.toString() + "\n";
    }
}
