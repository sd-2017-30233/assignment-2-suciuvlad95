package Model;

import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfReport implements Report {
	
    private static final String FileName = "reportInPdf.pdf";
    
    public void generate(ArrayList<String> titles) {
        Document doc = new Document();
        try {

            PdfWriter.getInstance(doc, new FileOutputStream(new File(FileName)));
            doc.open();

            Paragraph par = new Paragraph();
            par.add("Books out of stock");
           
            doc.add(par);
            
            int len=titles.size();
            for (int i=0;i<len;i++) {
                Paragraph par2 = new Paragraph();
                par2.add(titles.get(i)); 
                doc.add(par2);
            }
            doc.close();
           

        } catch ( DocumentException | FileNotFoundException ee) {
            ee.printStackTrace();
        } 
        
    }

}
