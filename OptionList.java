package projectzero.budgetar;

import java.util.*;

public class OptionList {





    public static void main(String[] args) {
        HashMap<String, Double> cogs = new HashMap<>();
        ArrayList<String> itemList = new ArrayList<String>();
        ArrayList<Double> itemCost = new ArrayList<Double>();
        Scanner entry = new Scanner(System.in);
        cogs.put("Bread", 5.25);
        cogs.put("Sugar ", 3.25);
        cogs.put("Flour", 2.99);
        cogs.put("Eggs", 4.50);
        cogs.put("Butter", 3.15);
        cogs.put("Milk", 4.25);
        cogs.put("Vanilla", 1.25);
        cogs.put("Coffee", 5.25);
        cogs.put("Water", 1.50);
        cogs.put("Sausage", 6.99);


        Iterator iCogs = cogs.entrySet().stream().iterator();
        while (iCogs.hasNext()) {
            Map.Entry pairs = (Map.Entry) iCogs.next();
            System.out.println(pairs.getKey() + ": $" + pairs.getValue());
            itemList.add(pairs.getKey() + ":$" + pairs.getValue());
        }
        System.out.println(itemList);

        int x=0;
            //while(itemList.stream().iterator().hasNext())


        System.out.println("Indexed List:" + itemList);

    }
}
