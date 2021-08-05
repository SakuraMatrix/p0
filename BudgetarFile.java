package projectzero.budgetar;

import java.io.*;
import java.util.HashMap;

public class BudgetarFile extends GetData {
    File cogFile = new File("FileCogs.csv");
    String filepath;


    String CreateDataFile(String filepath){
        try {
            if (!(cogFile.exists())) {
                cogFile.createNewFile();
                filepath = cogFile.getName();
                System.out.println(" New File Created: " + filepath);
            }
            else if(cogFile.exists()) System.out.println("File: " + filepath + " Already Exists");
        }catch (FileNotFoundException e){
            System.out.println("File Not Found Error");
        }catch ( IOException e){
            System.out.println(" Error encountered creating new File");
        }finally {
            System.out.println("Will output the current values to File");
        }
        return filepath;
    }


    String[] ReadDataFile(String filepath){
        String xFile=filepath;
        String line;
        int x = 0;
        System.out.println("Retrieving Shopping List:");
        try{
            BufferedReader brRead = new BufferedReader(new FileReader(cogFile));
            while ((line = brRead.readLine()) != null) {
                System.out.println(x + ". " + line);
                dataList = line.split(",");  //Stores a list of Items to String Array.
                //System.out.println(x + ". Item: " + dataList[0]);
                x++;
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return dataList;
    }

}
