package JavaCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CSVReader {

    private ArrayList<String[]> storedStringArray;
    private String fileLocation;

    // Constructor.
    public CSVReader(){
        System.out.println("CSVReader Instance Created!");
        storedStringArray = new ArrayList<String[]>();
        fileLocation = "";
    }

    // This is just what i like to use in order to make debugging WAY easier.
    private void functionTemplate(){                                                                                            //Template for functions.
        System.out.println("\nThe \"functionTemplate\" function has started.");
        //
        System.out.println("The \"functionTemplate\" function has ended.");
    }

    // Set the stored file location (it'll be an address).
    public void setFileLocation(String input) {
        System.out.println("\nThe \"setFileLocation\" function has started.");
        fileLocation = input;
        System.out.println("The location has now been set to the following: \t\"" + fileLocation + "\"");
        System.out.println("The \"setFileLocation\" function has ended.");
    }

    // Return the address stored.
    public String getFileLocation() {
        System.out.println("\nThe \"getFileLocation\" function has started.");
        System.out.println("The \"getFileLocation\" function has ended.");
        return fileLocation;
    }

    // This reads the .csv file and puts it into a
    public void loadFile(){
        System.out.println("\nThe \"loadFile\" function has started.");
        BufferedReader reader = null;
        String line = "";                                                                                               // This is the variable that is made to hold the line currently being read.
        int count = 0;
        try{
            reader = new BufferedReader(new FileReader(fileLocation));
            while((line=reader.readLine()) != null ) {                                                                  // A variable "line" is made to be equal to the current line being scanned. End the loops if its empty.
                String[] row = line.split(",");                                                                   // Splits the line into an array of strings.
                storedStringArray.add(row);                                                                                 // Adds the array of strings to the ArrayList.
                count++;
            }
            reader.close();
        } catch (Exception e) {                                                                                          // If an error occurs...
            e.printStackTrace();                                                                                        // Prints any errors.
        }
        System.out.println(count + " rows added.");
        System.out.println("The \"loadFile\" function has ended.");
    }

    public void printStringArray(){
        System.out.println("\nThe \"displayFile\" function has started.");


        if (storedStringArray.isEmpty()){
            System.out.println("The arrayList \"fileVariables\" is currently empty!");
        } else {
            System.out.println("The size of fileVariables is: " + storedStringArray.size() + "\n");
            for (int i=0; i < storedStringArray.size(); i++){
                for (String j: storedStringArray.get(i)) {
                    System.out.printf(j + ", ");

                }
                System.out.println("");
            }

        }
        System.out.println("The \"displayFile\" function has ended.");
    }

    public ArrayList<String[]>  returnStoredStringArray(){
        System.out.println("\nThe \"returnStoredStringArray\" function has started.");
        System.out.println("The \"returnStoredStringArray\" function has ended.");
        return storedStringArray;
    }
}
