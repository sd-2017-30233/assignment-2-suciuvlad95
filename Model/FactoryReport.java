package Model;

public class FactoryReport {
	 public Report getReport(String reportTypeSelection) {
		 
	        if (reportTypeSelection == null) {
	            return null;
	        }
	        
	        if (reportTypeSelection.equals("PDF")) {
	            return new PdfReport();

	        }
	        else if (reportTypeSelection.equals("CSV")) {
	            return new CsvReport();
	        }
	        
	        return null;
	}

}
