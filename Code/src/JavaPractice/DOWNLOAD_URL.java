package JavaPractice;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DOWNLOAD_URL {
    private static void PrototypeDownload(String URLInput, String fileInput) throws Exception{
        URL url = new URL(URLInput);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();                   //Create a http connection using the URL just made.
        double fileSize = (double)http.getContentLengthLong();                              //Create a double that represents the file's size in bytes.
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fos = new FileOutputStream(fileInput);
        byte[] buffer = new byte[1024];

        int count = 0;                  //Where the data goes through
        double download = 0.00;         //How much has been downloaded.
        int read = 0;                   //How much there is to read.
        double percentDone = 0.00;      //What percentage of the file has been downloaded already.
        while ((count = bis.read(buffer,0,1024)) != -1){
            fos.write(buffer,0,count);
            download += count;
            percentDone = (download*100) / fileSize;                //Show's how much of the file has been downloaded.

            String stringPercent = String.format("%.2f", percentDone);              //Get a string that states the current percentage.
            System.out.println("Current Percent: " + stringPercent +"/100");      //Print out that string.
            //System.out.println("Current amount: " + download + "/" + fileSize);
        }
        fos.close();
        bis.close();
    }

    public static void DownloadFileFromURL(String URLInput, String fileInput){
        try {
            DOWNLOAD_URL.PrototypeDownload(URLInput,fileInput);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        String webURL1 = "https://coronavirus.data.gov.uk/api/v2/data?areaType=overview&metric=newCasesBySpecimenDate&metric=newCasesByPublishDate&format=csv";
        String webURL2 = "https://cdn.cloudflare.steamstatic.com/client/installer/SteamSetup.exe";
        String webURL3 = "http://neilcic.com/mouthdreams/Neil%20Cicierega%20-%20Mouth%20Dreams%20-%20MP3.zip";
        String fileType = "csv";
        String filePath = "C:\\Users\\Mark\\Documents\\¬University\\Year 2, 2020-2021\\New Year Modules\\CE291 - Team Project, New Year\\newcode\\src\\CSVFiles\\exampleFile1." + fileType;
        // Remember, you'll need to write the name of what you want the file to be at the end, and give it the appropriate file type.

        try {
            DOWNLOAD_URL.PrototypeDownload(webURL1,filePath);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
