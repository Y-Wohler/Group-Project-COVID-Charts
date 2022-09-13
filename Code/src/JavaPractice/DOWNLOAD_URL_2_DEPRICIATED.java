package JavaPractice;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class DOWNLOAD_URL_2_DEPRICIATED implements Runnable{
    String link;
    File out;

    public DOWNLOAD_URL_2_DEPRICIATED(String linkInp, File outInp){
        this.link = linkInp;
        this.out = outInp;
    }

    @Override
    public void run() {
        try{
            URL url = new URL(link);                                                            //Create an instance of URL using the link String.
            HttpURLConnection http = (HttpURLConnection)url.openConnection();                   //Create a http connection using the URL just made.
            double fileSize = (double)http.getContentLengthLong();                              //Create a double that represents the file's size in bytes.
            BufferedInputStream input = new BufferedInputStream(http.getInputStream());         //Create an input stream. This one finds the http website and streams the information in it.
            FileOutputStream output = new FileOutputStream(this.out);                           //Create an output stream. This takes information streamed, and stores it inside a file location.
            BufferedOutputStream buffered = new BufferedOutputStream(output, 1024);             //Create a buffered output stream. This allows us to chose both the location AND the size.

            byte[] data = new byte[1024];
            double download = 0.00;         //How much has been downloaded.
            int read = 0;                   //How much there is to read.
            double percentDone = 0.00;      //What percentage of the file has been downloaded already.

            while ((read = input.read(data,0, 1024))  >= 0 ){   //When the end of the stream is reached, it will return 0, so while 0 hasn't been returned...
                buffered.write(data, 0, read);                      //Write the data to the location with 0 offset.
                download += read;                                       //Update the amount of data downloaded.
                percentDone = (download*100) / fileSize;                //Show's how much of the file has been downloaded.

                String stringPercent = String.format("%.2f", percentDone);      //Get a string that states the current percentage.
                //System.out.println("Current Percent: " + stringPercent +"/100");        //Print out that string.
                System.out.println("Current amount: " + download + "/" + fileSize);
            }
            buffered.close();
            input.close();
            System.out.println("Download Complete!");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        String webURL1 = "https://coronavirus.data.gov.uk/api/v1/data?filters=areaType=overview&structure=%7B%22areaType%22:%22areaType%22,%22areaName%22:%22areaName%22,%22areaCode%22:%22areaCode%22,%22date%22:%22date%22,%22newCasesBySpecimenDate%22:%22newCasesBySpecimenDate%22,%22cumCasesBySpecimenDate%22:%22cumCasesBySpecimenDate%22%7D&format=csv";
        String webURL2 = "https://cdn.cloudflare.steamstatic.com/client/installer/SteamSetup.exe";

        String fileType = "csv";
        String address = "C:\\Users\\Mark\\Documents\\¬University\\Year 2, 2020-2021\\New Year Modules\\CE291 - Team Project, New Year\\newcode\\src\\CSVFiles\\exampleFile." + fileType;
        File filePath = new File(address);
        // Remember, you'll need to write the name of what you want the file to be at the end

        new Thread(new DOWNLOAD_URL_2_DEPRICIATED(webURL1, filePath)).start();    // Create a thread and start it using our code as a parameter.
    }
}
