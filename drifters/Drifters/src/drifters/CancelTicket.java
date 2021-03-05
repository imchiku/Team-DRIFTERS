/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drifters;

import java.io.*;
import java.util.*;
/**
 *
 * @author monu
 */
public class CancelTicket {
    private String fileName = "./src/drifters/ticketDB.txt";
    private List<BookTicket> ticketList;

    public CancelTicket() {
        this.ticketList = new ArrayList<BookTicket>();
    }
    
    public boolean init(String fileName) {

        boolean result = false;
        BufferedReader bufReader = null;
        try {
            bufReader = new BufferedReader(new FileReader(fileName));
            bufReader.readLine();
            String oneLine = bufReader.readLine();
//            System.out.println(oneLine);
            BookTicket myticket = null;
            while (oneLine != null) {
                StringTokenizer st = new StringTokenizer(oneLine, "|");
                myticket = new BookTicket();
                myticket.setPnr(st.nextToken());
                myticket.setTrainNo(st.nextToken());
                User u = new User();
                u.setName(st.nextToken());
                u.setAge(Integer.parseInt(st.nextToken()));
                u.setGender(st.nextToken());
                u.setDOB(st.nextToken());
                u.setMob(st.nextToken());
                u.setNat(st.nextToken());
                myticket.setUser(u);
                
                this.ticketList.add(myticket);
                oneLine = bufReader.readLine();
            }
            bufReader.close();
//             System.out.println(this.ticketList);
            result = true;

        } catch (FileNotFoundException e) {
            System.out.println("File Not Foutrain");
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
//        System.out.println(this.trainList);
        return result;
        
    }
    
    public boolean write(String fileName) {
        boolean flag = false;
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(fileName));
            bw.write("PNR|TRAIN NUMBER|NAME|AGE|GENDER|DOB|MOBILE|NATIONALITY\n");
            for (int i = 0; i < this.ticketList.size(); i++) {
                bw.write(this.ticketList.get(i).toString());
            }
            flag = true;
            bw.close();
        } catch (IOException e) {
            System.out.println("Error Occurred." + e);
        }
        return flag;
    }
    
    public boolean cancelticket(BookTicket tn) {
        boolean flag = false;
        for (int i = 0; i < this.ticketList.size(); i++) {
            if (this.ticketList.get(i).getPnr().equals(tn.getPnr())) {
                this.ticketList.remove(i);
                write(this.fileName);
                flag = true;
                break;
            }
        }
        return flag;
    }
    
     public static void main(String[] args) {
         CancelTicket ct = new CancelTicket();
         ct.init(ct.fileName);
         BookTicket bt = new BookTicket();
         bt.setPnr("1234");
        // Unit Testing 
//        assert(ct.ticketList.size()==9);
//        assert(ct.ticketList.get(0).getPnr().equals("1234567"));

         
         
         
         
//         ct.cancelticket(bt);
     }
}
