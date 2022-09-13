package JavaPractice;

import java.security.PublicKey;
import java.util.ArrayList;

public class FINDBIGNUMBER {
    public ArrayList<String[]> array;

    public FINDBIGNUMBER(){
        array = new ArrayList<String[]>();
    }

    public int findLargestNumber(ArrayList<String[]> array, int whatColumnToLookAt){
        System.out.println("\nThe \"findLargestNumber\" function has started.");
        int bigNumber = 0;
        for (int i = 0; i < array.size(); i++) {
            System.out.println("New number: " + array.get(i)[whatColumnToLookAt]);
            int currentItem = Integer.parseInt(array.get(i)[whatColumnToLookAt]);
            try {
                if ( currentItem > bigNumber){                                   // Using the supplied ArrayList<String[]>, we see if it's the biggest one yet.
                    System.out.println(bigNumber + " is smaller than " + currentItem + ", bigNumber changed!");
                    bigNumber = currentItem;
                } else{
                    System.out.println(bigNumber + " isn't bigger than " + currentItem + ", bigNumber remains.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nThe \"findLargestNumber\" function has ended.");
        if (bigNumber == 0) {
            return 20000;
        }
        return bigNumber;
    }

    public static void main(String[] args) {
        FINDBIGNUMBER big = new FINDBIGNUMBER();
        big.array.add(new String[]{"unitedkingdom", "overview", "100",});
        big.array.add(new String[]{"unitedkingdom", "overview", "200",});
        big.array.add(new String[]{"unitedkingdom", "overview", "300",});
        big.array.add(new String[]{"unitedkingdom", "overview", "400",});
        big.array.add(new String[]{"unitedkingdom", "overview", "500",});
        big.array.add(new String[]{"unitedkingdom", "overview", "400",});
        big.array.add(new String[]{"unitedkingdom", "overview", "500",});
        System.out.println(big.findLargestNumber(big.array, 2));
    }
}
