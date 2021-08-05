package projectzero.budgetar;

import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.logging.Logger;


public class Budgetar {
    public static void main(String[] args) {
        Logger LOG = Logger.getAnonymousLogger();
        LOG.info("Starting Application...");
        LOG.info("Initiating server....");
        File filename = new File("cogsFile.csv");
        new Server().initialize(8080);
        Path filepath = filename.toPath();
        GetData a = new GetData();
        a.myFile();  //check/create file.
        a.FileContent();
        Scanner entry = new Scanner(System.in);
        Double tfa=0.00;
        a.calcBalance();

        int x;
        String option = "";
        do {

            System.out.println("\nCurrent Budget:$" + a.tfa);
            System.out.println("Total Est Cost: $" + a.sumCost);
            System.out.println("Account Balance: $" + (a.tfa - a.sumCost));
            System.out.println("\nSelect an Option"); //working
            System.out.println("1:View List | 2:New List | 3:Edit Budget| 4:Edit Ratings | 0:Exit");


                x = entry.nextInt();
                switch (x) {
                    case 1:
                        option  = "Current list";
                        System.out.println("Retrieving Shopping List.....");
                        a.FileContent().displayData();
                        break;

                    case 2:
                        option = "New List";
                        a.ShoppingList();
                        a.toFile();
                        break;
                    case 3:
                        option = "Edit Budget";
                        a.GetBudget();
                        break;
                    case 4:
                        option = "Index Items";
                        System.out.println(" Retrieving Items List...");
                        a.IndexList();
                        break;
                    case 0:
                        option = "Exit";
                        System.out.println("Exiting... Good Bye!");
                        return;
                    default:
                        option = "Invalid Entry";
                        System.out.println("Invalid Selection..");
                        break;
                }
            } while (true);
        }
}
