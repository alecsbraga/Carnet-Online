package Servicii;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public interface Audit {
    default void audit(String actiune) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        try{
            FileWriter filewriter = new FileWriter("src\\Fisiere\\Audit.csv",true);
            BufferedWriter buffwriter = new BufferedWriter(filewriter);
            buffwriter.write(actiune+", "+dateFormat.format(cal.getTime())+"\n");
            buffwriter.flush();
            buffwriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
