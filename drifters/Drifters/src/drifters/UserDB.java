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
public class UserDB {
    private String fileName = "./src/drifters/userDB.txt";
    private List<User> UserList ;

    public UserDB() {
        this.UserList = new ArrayList<User>();
    }

    public boolean init(String fileName){
        boolean res=false;
        BufferedReader bfr=null;
        try{
            bfr = new BufferedReader(new FileReader(fileName));
            bfr.readLine();
            String var= bfr.readLine();
            User pdetail = null;
            // System.out.println(var);
            while(var != null)
            {
                StringTokenizer st=new StringTokenizer(var, "|");
                if (st.countTokens() == 0){
                    break;
                }
                pdetail=new User();
                pdetail.setName(st.nextToken());
                pdetail.setAge(Integer.parseInt(st.nextToken()));
                pdetail.setGender(st.nextToken());
                pdetail.setDOB((st.nextToken()));
                pdetail.setMob(st.nextToken());
                pdetail.setNat(st.nextToken());
               
                this.UserList.add(pdetail);
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
            bw.write("NAME|AGE|GANDER|DOB|MOB_NUMBER|NATIONALITY\n");
            for(int i=0;i<this.UserList.size();i++){
                bw.write(this.UserList.get(i).toString()+"\n");
            }
            flag = true;
            bw.close();
        } catch (IOException e) {
            System.out.println("Error Occurred." + e);
        }
        return flag;
    }
    public boolean addUserDetails(User pd){
        boolean flag = false;
        try{
            this.UserList.add(pd);
            write(this.fileName);
        }
        finally{
            flag = true;
        }
        return flag;
    }  
    public boolean deletePasssengerDetails(User pd){
        boolean flag = false;
        for (int i=0;i<this.UserList.size();i++){
            if (this.UserList.get(i).getName().equals(pd.getName())){
                this.UserList.remove(i);
                write(this.fileName);
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        UserDB pdb = new UserDB();
        pdb.init(pdb.fileName);
        // System.out.println(pdb.UserList);

        // Unit Testing 
        assert(pdb.UserList.size()==4);
        assert(pdb.UserList.get(0).getName().equals("MONU KUMAR"));


        // Adding User
         User User = new User();
         User.setName("Nitesh");
         User.setAge(21);
         User.setGender("M");
         User.setMob("9254879644");
         User.setDOB("02/2/1999");
         User.setNat("Indian");
         pdb.addUserDetails(User);

        // pdb.deletePasssengerDetails(User);
    }
}
