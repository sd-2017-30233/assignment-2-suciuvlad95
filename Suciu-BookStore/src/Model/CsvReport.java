package Model;
import java.util.ArrayList;
import java.io.*;

public class CsvReport implements Report {
    public void generate(ArrayList<String> titles) throws FileNotFoundException{
       
    	PrintWriter printer = new PrintWriter(new File("reportInCsv.csv"));
        
        StringBuilder bookGenerate = new StringBuilder();
        for (int i=0;i<titles.size();i++)
        {
            bookGenerate.append("Title ,");
            bookGenerate.append(titles.get(i));
            bookGenerate.append('\n');
        }
        
        printer.write(bookGenerate.toString());
        printer.close();
      
    }
}
