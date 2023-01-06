package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Import {
	
	public static Properties loadConfig() {
		
		String configFilePath = "config.cfg";
		Properties prop = new Properties();
		
		try {
			
			FileInputStream propsInput = new FileInputStream(configFilePath);
			prop.load(propsInput);
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			
		}
		
		return prop;
		
	}
	
	public static List<Record> loadRecords(){
		
		//Load elements/records
		List<Record> records = new ArrayList<Record>();
		  
		    try {
		    	
		      FileInputStream fis = new FileInputStream("tobuy.xlsx");
		      XSSFWorkbook workbook = new XSSFWorkbook(fis);
		      XSSFSheet sheet = workbook.getSheetAt(0);

		   // Get the row iterator
		      Iterator<Row> rowIterator = sheet.iterator();
		      // Iterate over all rows
		      Row row = rowIterator.next();
		      while (rowIterator.hasNext()) {
		        row = rowIterator.next();  // Declare the row variable
		        Record record = new Record();
		        
		        for (int i = 0; i < row.getLastCellNum(); i++) {
		        	  Cell cell = row.getCell(i);
	        	  
		        	  // Skip empty cells
		        	  if (cell == null || cell.getCellTypeEnum() == CellType.BLANK) {
		        	    continue;
		        	  }
		        	  switch (i) {
		        	    case 0:
		        	    	record.setName(cell.getStringCellValue());
		        	    	break;
		        	    case 1:
		        	    	record.setNeed(cell.getNumericCellValue());
		        	    	break;
		        	    case 2:
		        	    	record.setWant(cell.getNumericCellValue());
		        	    	break;
		        	    case 3:
		        	    	record.setPrice(cell.getNumericCellValue());
		        	    	break;
		        	    case 4:
		        	    	record.setBought(cell.getBooleanCellValue());
		        	    	break;
		        	    default:
		        	    	break;
		        	  }
		        
		        

		      }
		        records.add(record);
		      }

		      // Close the workbook and the input stream
		      workbook.close();
		      fis.close();
		    } catch (IOException ex) {
	        	ex.printStackTrace();
	        	System.out.println("Error importing data. Data file might be invalid or corrupted");
	        	records.clear();
		    }
		    
		    return records;
		
	}
	
}
