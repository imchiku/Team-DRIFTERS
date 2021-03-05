/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drifters.src.drifters;
import java.io.*;
import java.util.*;
/**
 *
 * @author monu
 */
public class TicketManager {
    private String fileName = "./src/drifters/ticketDB.txt";
    private static List<BookTicket> booklist ;

    public TicketManager() {
        this.booklist = new ArrayList<BookTicket>();
    }
    public boolean init(String fileName){
        boolean res=false;
        BufferedReader bfr=null;
        try{
            bfr = new BufferedReader(new FileReader(fileName));
            bfr.readLine();
            String var= bfr.readLine();
            BookTicket tdetail = null;
            // System.out.println(var);
            while(var != null)
            {
                StringTokenizer st=new StringTokenizer(var, "|");
                if (st.countTokens() == 0){
                    break;
                }
                tdetail=new BookTicket();
                tdetail.setPnr(st.nextToken());
                tdetail.setTrainNo(st.nextToken());
                User us = new User();
                us.setName(st.nextToken());
                us.setAge(Integer.parseInt(st.nextToken()));
                us.setGender(st.nextToken());
                us.setDOB(st.nextToken());
                us.setMob(st.nextToken());
                us.setNat(st.nextToken());
                tdetail.setUser(us);
                
                             
                this.booklist.add(tdetail);
                var = bfr.readLine();
            }
            bfr.close();
            res = true;
        }
        catch(FileNotFoundException e)
        {
            // unexpected input
            System.out.println("File Not Found");
        }
        catch(IOException e)
        {
            System.out.println("IO Exception");              
        }
        
        return res;
    }
    
    public boolean write(String fileName){
        boolean flag = false;
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(fileName));
            bw.write("PNR|TRAIN_NUMBER|NAME|AGE|GENDER|DOB|MOB_NO|NATIONALITY\n");
            for(int i=0;i<this.booklist.size();i++){
                bw.write(this.booklist.get(i).toString());
            }
            flag = true;
            bw.close();
        } catch (IOException e) {
            System.out.println("Error Occurred." + e);
        }
        return flag;
    }

    public boolean TicketBooking(BookTicket bt){
        boolean flag = false;
        try{
//            bt.setPnr(generatePnr(us));
            this.booklist.add(bt);
            write(this.fileName);
        }
        finally{
            flag = true;
        }
        return flag;
    }
    
    public static String generatePnr(User bkt){
        String pnr=bkt.getAge()+bkt.getMob() ;
        return(pnr);
    }
    
    
    public static void main(String[] args) {
        TicketManager tm = new TicketManager();
        tm.init(tm.fileName);
        BookTicket btt=new BookTicket();

        User uss=new User();
        uss.setName("rohit");
        uss.setAge(25);
        uss.setGender("M");
        uss.setMob("9254879574");
        uss.setDOB("02/2/1999");
        uss.setNat("Indian");
        btt.setUser(uss);
        btt.setPnr(generatePnr(uss));
        btt.setTrainNo("90867876");
        // Unit Testing 
        assert(tm.booklist.size()==7);
//        assert(ct.ticketList.get(0).getPnr().equals("1234567"));

        
        tm.TicketBooking(btt);
        
         

        
    }
}
