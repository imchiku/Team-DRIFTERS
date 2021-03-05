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
public class TrainManager {
    private String fileName = "./src/drifters/trainDb.txt";
    private List<Train> trainList;

    public TrainManager() {
        this.trainList = new ArrayList<Train>();
    }

    public boolean init(String fileName) {

        boolean result = false;
        BufferedReader bufReader = null;
        try {
            bufReader = new BufferedReader(new FileReader(fileName));
            bufReader.readLine();
            String oneLine = bufReader.readLine();
//            System.out.println(oneLine);
            Train myTrain = null;
            while (oneLine != null) {
                StringTokenizer st = new StringTokenizer(oneLine, "|");
                myTrain = new Train();
                myTrain.setName(st.nextToken());
                myTrain.setNumber(Integer.parseInt(st.nextToken()));
                myTrain.setSource(st.nextToken());
                myTrain.setDestination(st.nextToken());
                myTrain.setArrTime(st.nextToken());
                myTrain.setDeptTime(st.nextToken());
//                 System.out.println(myTrain.toString());
                this.trainList.add(myTrain);
                oneLine = bufReader.readLine();
            }
            bufReader.close();
//             System.out.println(trainList);
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
            bw.write("NAME|TRAIN_NUMBER|SOURCE|DESTINATION|ARRIVALTIME|DEPARTURETIME\n");
            for (int i = 0; i < this.trainList.size(); i++) {
                bw.write(this.trainList.get(i).toString());
            }
            flag = true;
            bw.close();
        } catch (IOException e) {
            System.out.println("Error Occurred." + e);
        }
        return flag;
    }

    public boolean addTrain(Train train_data) {
        boolean flag = false;
        try {
            this.trainList.add(train_data);
//            System.out.println(this.trainList);
            write(this.fileName);
        } finally {
            flag = true;
        }
        return flag;
    }

    public String displayTrain(Train train) {
        for (int i = 0; i < this.trainList.size(); i++) {

            if (this.trainList.get(i).getSource().equals(train.getSource())
                    && this.trainList.get(i).getDestination().equals(train.getDestination())) {
                return this.trainList.get(i).displayTrain();
            }
        }
        return "You havn't added any Train data yet.";
    }

    public boolean deleteTrain(Train trainNum) {
        boolean flag = false;
        for (int i = 0; i < this.trainList.size(); i++) {
            if (this.trainList.get(i).getNumber() == (trainNum.getNumber())) {
                this.trainList.remove(i);
                write(this.fileName);
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean updateTrain(Train train) {
        boolean flag = false;
        for (int i = 0; i < this.trainList.size(); i++) {

            if (this.trainList.get(i).getNumber() == (train.getNumber())) {

                this.trainList.get(i).setName(train.getName());
                this.trainList.get(i).setSource(train.getSource());
                this.trainList.get(i).setDestination(train.getDestination());
                this.trainList.get(i).setArrTime(train.getArrTime());
                this.trainList.get(i).setDeptTime(train.getDeptTime());

                write(this.fileName);
                flag = true;
                break;
            }
        }

        return flag;
    }

    public static void main(String[] args) {

        TrainManager TD = new TrainManager();

        // Initializing the data into arraylist of trains
        TD.init(TD.fileName);

        // Unit Testing
//        assert(TD.trainList.size()==9);
//        assert(TD.trainList.get(0).getName().equals("PNBE"));

         Train train = new Train();
        // train.setName("KLAS");
        // train.setNumber(23030);
        // train.setSource("KOLKATA");
        // train.seTDestination("AASONSOL");
        // train.setArrTime("20:00");
        // train.seTDeptTime("21:10");
        // TD.addTrain(train);
         train.setName("DNPH");
         train.setNumber(12341);
         train.setSource("DHANBAD");
         train.setDestination("PAHARPUR");
         train.setArrTime("20:25");
         train.setDeptTime("21:05");
         TD.addTrain(train);
//         TD.deleteTrain(train);
//         System.out.println(TD.displayTrain(train));
        // TD.updateTrain(train);
    }
}
