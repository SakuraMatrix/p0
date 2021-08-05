package projectzero.budgetar;

import io.javalin.Javalin;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;
import io.javalin.Javalin;
//import io.netty.buffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class GetData {
    //public ArrayList httpList;
    File filename = new File("cogsFile.csv");
    Path filepath = filename.toPath();
    Scanner entry = new Scanner(System.in);
    HashMap cogs = new HashMap<String, ArrayList<Object>>();
    int x = 0;
    double tfa = 0.00;   // Total Funds Available
    double sumCost=0.00;  //Total Cost of Goods
    double cashBalance =0.00;
    String[] dataList =  new String[0];
    ArrayList<String> itemList= new ArrayList<>();  //contains a list of all Items osn shopping List.
    ArrayList<String> httpList= new ArrayList<>();  //contains a list of all Items osn shopping List.

    //update the budget value
    public void  GetBudget() {   //get the Total Budget Size
        System.out.println(" Enter Total funds Available: $");
        this.tfa = entry.nextDouble();
        System.out.println(" TFA Wallet Updated:... $" + this.tfa );
        return this;
    }

    //Crete anew Shopping list and discard the old one.
    public void ShoppingList() {
        StringBuilder sbWrite = new StringBuilder();
        int x = 0;
        System.out.println("Create a Shopping List");
        ArrayList<String> itemList = this.itemList;
        do {
            String[] itemX = entry.nextLine().split("\\s+");
            try {
                if (!(itemX.equals(""))) {    //if the scanner entry is NOT empty, continue, else catch exception
                    cogs.put(itemX[0], itemX[1]); // costX);  //Store the data in a hashmap
                }
                x++;
            } catch (Exception e) {
                break;
            }
        } while (cogs.size() < 5 || entry.nextLine().equals(""));    //Limits the item list to 10 ItemsSystem.out.println(br);
        MapToArray(); //Convert Hashmap to Array List
        System.out.println("Rate by Necessity Index (i.e Must have): 1-5 : ");
        nvIndex(); //index the items
        return this;
    }

    //will edit the items in the File.
    public void IndexList() {
        String line;
        String tempList="";
        System.out.println("Rate by Necessity Index (Must have): 1-5 : ");
        try {
            BufferedReader brRead = new BufferedReader(new FileReader(this.filename)); //opens up the read from File Function
            while ((line = brRead.readLine()) != null) {
                System.out.println(line.split(",")[0]);
                int nvIndex = entry.nextInt();
                itemList.add(line.split(",")[0] + "," + line.split(",")[1] + "," + nvIndex);
                x++;
            }

        }catch (FileNotFoundException e){
                e.printStackTrace();
        }catch (IOException e){

                e.printStackTrace();
        }
        //System.out.println(itemList);
        System.out.println("Update Values? Y/N");
        String y = entry.nextLine();
        if (y.toUpperCase(Locale.ROOT).equals("Y")) {
            toFile();
        }else {
            System.out.println("Discarding New List....");
        }
        return this;
    }

    //Edits the Items on the itemList Array
    public void nvIndex(){
       for (int x=itemList.size()-1; x >= 0; x--) {
           System.out.println(itemList.get(x));
           itemList.add( itemList.get(x) + ","  + entry.nextInt());
       }
    }

    //Verifies True if file Exists, or will create a new file
    public void myFile(){
        filename = this.filename;
        try {
            if (!(filename.exists())) {
                filename.createNewFile();
                //filepath = filepath.getName();
                System.out.println(" Error:... " + filename);
            }
            else if(filename.exists()) System.out.println("Success: " + filename);
        }catch (FileNotFoundException e){
            System.out.println("File Not Found Error:..." + filename);
        }catch ( IOException e){
            System.out.println(" Error encountered creating new File:...." + filename);
        }finally {
            System.out.println("");
        }
        return this;
    }

    //Writes Data to File
    public GetData toFile() {
        System.out.println("Save current List ?: (Y/N)");
        final String y = entry.nextLine().toString();
        String line ="";
        HashMap data = this.cogs;
        int x = 0;
        try {
            System.out.println("Writing to File");
            BufferedWriter brWrite = new BufferedWriter(new FileWriter(filename)); //Opens up the Write to File function
            for (String t : itemList) {
                brWrite.write(t + "\n");  //Write the String to the File
                x++;
            }
            brWrite.close();                //close the File after writing **/
        } catch (FileNotFoundException e) {
            //Error message out
        } catch (IOException e) {
            //Error Message out:  use logger
        }
        return this;
    }

    //display the content of the .csv file
    public GetData FileContent(){
        //Iterator<String> iter = itemList.iterator();
        try(Stream<String> lines = Files.lines(this.filepath)){
           lines.forEach(s -> itemList.add(s));
        }catch (IOException e){
            System.err.println("Failed to stream File");
        }
        return this;
    }

    //Data Display Method
    public GetData displayData(){
       itemList.forEach(s -> System.out.println((s.split(",")[0] + ", $" + s.split(",")[1])));
    return this;
    }

    //calculate trx Balance.
    public void calcBalance(){
        try {
            sumCost = this.itemList.stream().mapToDouble(s ->  Double.parseDouble(s.split(",")[1])).sum();
        }catch (Exception e){
            e.printStackTrace();
        }
        //System.out.println("Total Est Cost: $" + sumCost);
        //System.out.println("Account Balance: $" + (cashBalance = this.tfa - sumCost));
    }

    //convert hashmap to arrayList
    public void MapToArray() {  // fucntion will convert current Hashmap to Array List
        Iterator iCogs = cogs.entrySet().stream().iterator();;
        this.itemList.clear();
        while (iCogs.hasNext()) {
            Map.Entry pairs = (Map.Entry)iCogs.next();
            this. itemList.add(pairs.getKey() + "," + pairs.getValue() + ",");
        }
        this.itemList = itemList;
        System.out.println(itemList);
    }

    //add to the List
    public void addItemToList(){
        System.out.println("Add: (Item,Cost,nvValue)");
        String item = entry.nextLine();
        this.itemList.add(item.split("")[0] + "," + item.split("")[1] + "," + item.split("")[2] + "\n");
        System.out.println("Update File: Y/N");
        if(entry.nextLine().toUpperCase(Locale.ROOT) == "Y"){
            this.toFile();
        }
    }

    //Remove from list
    public void rmItemFromlist(){
        System.out.println("Select Item to be Deleted");
        String xItem = entry.nextLine();
        this.itemList.remove(xItem);
    }




}

