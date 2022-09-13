package JavaCode;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;
//import
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1CFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;


import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.*;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CreatePDF {
    public static void main(String[] args) throws IOException {
        generatePDF();
    }

    public String fileLocation;
//    private UCharacterIterator PdfWriter;

    public CreatePDF(String fileLocation){
        this.fileLocation = fileLocation;
    }

    public static void generatePDF() throws IOException {
        PDDocument document = new PDDocument();
        PDPage pdfPage = new PDPage();
        document.addPage(pdfPage);

        Path path = Paths.get("src/AllFiles/graphimage.png");
        PDPageContentStream contentStream = new PDPageContentStream(document,pdfPage);
        contentStream.beginText();
        contentStream.setFont(PDType1Font.COURIER_BOLD, 20);
        contentStream.newLineAtOffset(50,700);
        contentStream.showText("Graph Analysis");
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont(PDType1Font.COURIER, 14);
        contentStream.newLineAtOffset(50,650);
        contentStream.showText("Infection Rate Cumulative");
        contentStream.endText();
        PDImageXObject image = PDImageXObject.createFromFile(path.toAbsolutePath().toString(), document);
        contentStream.drawImage(image,50,230);
        contentStream.beginText();
        contentStream.setFont(PDType1Font.COURIER, 10);
        contentStream.setLeading(11.5f);
        contentStream.newLineAtOffset(50,200);
        contentStream.showText("This graph shows the amount of currently infected on that day. The graph shows that");
        contentStream.newLine();
        contentStream.showText("at the start of the pandemic, there was a sharp increase in the number of infected");
        contentStream.newLine();
        contentStream.showText("until around day 50 of the pandemic where the numbers of infected started to decrease");
        contentStream.newLine();
        contentStream.showText("drastically and this could be due to the government intercepting the peoples activity");
        contentStream.newLine();
        contentStream.showText("like a national lockdown to decrease the chances of people meeting each other so");
        contentStream.newLine();
        contentStream.showText("there would be less people being infected everyday.");
        contentStream.newLine();
        contentStream.showText("There was one little 'bump' where there was an increase in the amount of infected");
        contentStream.newLine();
        contentStream.showText("which then did take some time to start declining on the number of infected which");
        contentStream.newLine();
        contentStream.showText("stayed below 10,000 for quite some time.");
        contentStream.endText();
        contentStream.close();
        document.save("src/AllFiles/PDF.pdf");
        System.out.println("PDF Created");
        document.close();

    }
}
