/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drifters;

/**
 *
 * @author monu
 */
public class User {
    private String pname="";
    private int age=0;
    private String gender="";
    private String dob = "";
    private String mob="";
    private String nationality="";
    
    public void setName(String pname){
        this.pname=pname;
    } 
    public void setAge(int age ){
        this.age=age;
    } 
    public void setGender(String gender){
        this.gender=gender;
    } 
    public void setDOB(String dob){
        this.dob=dob;
    } 
    public void setMob(String mob){
        this.mob=mob;
    } 
    public void setNat(String nationality){
         this.nationality=nationality;
    }
    public String getName(){
        return this.pname;
    }
    public int getAge(){
        return this.age;
    }
    public String getGender(){
        return this.gender;
    }
    public String getDOB(){
        return this.dob;
    }
    public String getMob(){
        return this.mob;
    }
    public String getNat(){
        return this.nationality;
    }

    public String displayString(){
        return "Name: " + pname + "\nAge: " + String.valueOf(age) + "\nGender: " + gender + "\nDateOfBirth: " + dob
                + "\nMob No: " + mob + "\nNationality: " + nationality;
    }
    @Override
    public String toString(){
        return pname + "|" + String.valueOf(age) + "|" + gender + "|" + dob
        + "|" + mob + "|" + nationality ;
    }
}
