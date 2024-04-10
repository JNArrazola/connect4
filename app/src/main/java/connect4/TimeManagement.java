package connect4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Class to manage best times of connect 4 game
  */
public class TimeManagement {
    private static ArrayList<Register> timesPvP = FileManagement.deserializePvP();
    private static ArrayList<Register> timesPvPc = FileManagement.deserializePvsPc();

    public static void addTimePvP(Register time){
        timesPvP.add(time);
        FileManagement.serializePvP(timesPvP);
    }

    public static void addTimePvPc(Register time){
        timesPvPc.add(time);
        FileManagement.serializePlayerVsPc(timesPvPc);
    }

    public static void printLearderboardPvP(){
        if(timesPvP.isEmpty())
            System.out.println("No hay tiempos registrados");

        Collections.sort(timesPvP, new Comparator<Register>() {
            @Override
            public int compare(Register r1, Register r2) {
                return r1.getTime().compareTo(r2.getTime());
            }
        });
        
        short ctr = 1;
        for(Register s : timesPvP){
            if(ctr<5)
                System.out.println("=== #" + (ctr++) + ": \n" + s.toString());
            else 
                System.out.println(s.toString());
        }
    }


}
