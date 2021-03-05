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
public class Train {
     private String name="";
    private int number=0;
    private String src="";
    private String dest="";
    private String arrTime="";
    private String deptTime="";
    
    public void setName(String name){
        this.name=name;
    }
    
    public void setNumber(int number){
        this.number=number;
    }
    
    public void setSource(String src){
        this.src=src;
    }
    
    public void setDestination(String dest){
        this.dest=dest;
    }
    
    public void setArrTime(String arrTime){
        this.arrTime=arrTime;
    }
    
    public void setDeptTime(String deptTime){
        this.deptTime=deptTime;
    }
    
    

    public String getName(){
        return this.name;
    }
    
    public int getNumber(){
        return this.number;
    }
    
    public String getSource(){
        return this.src;
    }
    
    public String getDestination(){
        return this.dest;
    }
    
    public String getArrTime(){
        return this.arrTime;
    }
    
    public String getDeptTime(){
        return this.deptTime;
    }
    
     @Override
    public String toString(){
        return name + "|" + number + "|" + src + "|" + dest + "|" + arrTime + "|" + deptTime + "\n";
    }

    public String displayTrain(){
        String res = " Train Name: " + name +
                    "\n Train Number: "+ number +
                    "\n Train Source: "+ src +
                    "\n Train Destination: "+ dest+
                    "\n Train Arrival-Time: "+ arrTime +
                    "\n Train Departure-Time: "+ deptTime+
                    "\n";
                return res;
    }
}
    

