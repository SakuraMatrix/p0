import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class getData {

        Scanner entry = new Scanner(System.in);
        HashMap<String, Double> cogs = new HashMap<String, Double>();
        HashMap<String, Double> nv = new HashMap<String, Double>();
        int x = 0;
        double tfa = 100.00;   // start value to prove action performed


        double GetBudget(double tfa) {   //get the Total Budget Size
            Scanner entry = new Scanner(System.in);
            System.out.println(" Enter Total fund Available: $");
            tfa = entry.nextDouble();
            System.out.println("My Budget: $" + tfa);
            return tfa;
        }

        HashMap GetShoppingList() {
            Scanner entry = new Scanner(System.in);
            HashMap cogs = new HashMap<String, Double>();
            int x = 0;
            System.out.println("Create a Shopping List");
            do {
            String[] itemX = entry.nextLine().split("\\s+");
            //double costX = entry.nextDouble();
            x++;
            try {
                if (itemX.equals("")) {    //if the scanner entry is NOT empty, continue, else catch exception
                    break;
                } else {
                    cogs.put(itemX[0], itemX[1]); //, costX);
                }
            } catch (Exception e) {
                System.out.println(" Shopping List" + cogs);
                break;
            } finally {
                System.out.println(cogs);
            }
            } while (cogs.size() < 5 || entry.nextLine().equals(""));    //Limits the item list to 10 Items
            // Items
            System.out.println("Shopping List: " + cogs);
            //String itemXlist[] = cogs.keySet();
            return cogs;
         }


         String[] IndexShoppingList() {
            String[] itemZ = cogs.keySet().toArray(new String[0]);
             HashMap<String, Double> nv =  new HashMap<String, Double>();
            System.out.println("Shopping List Items : " + itemZ);
            return itemZ;
         }

}


