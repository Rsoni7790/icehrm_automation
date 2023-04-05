package icehrm_automation;
import java.io.FileInputStream;

	import org.apache.poi.hssf.usermodel.HSSFWorkbook;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.CellType;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelUtil {
	 private Workbook workbook;
		   private Sheet sheet;
		 public Object[][] getExcelData(String filePath, String sheetName)
		 { try {
			       	 FileInputStream inputstream=new FileInputStream(filePath);
				    String extension=filePath.substring(filePath.indexOf(".")+1);
				    System.out.println("exetnsion");
				    if(extension.equals("xlsx"))
				     {
					 workbook=new XSSFWorkbook(inputstream);
			     	 }else {
					 workbook=new HSSFWorkbook(inputstream);
				        }
				    sheet= workbook.getSheet(sheetName);
			       int totalRows=sheet.getPhysicalNumberOfRows();
			      int totalCols=sheet.getRow(0).getPhysicalNumberOfCells();
			      System.out.println(totalRows);
			      System.out.println(totalCols);
			      Object[][] object=new Object[totalRows-1][totalCols];
			        for(int i=1;i<totalRows;i++) {
			    	for(int j=0;j<totalCols;j++) {
			    		Cell cell=sheet.getRow(i).getCell(j);
			    		if(cell.getCellType().equals(CellType.STRING)) {
			    			object[i-1][j]=cell.getStringCellValue();
			    		}else if(cell.getCellType().equals(CellType.NUMERIC)) {
			    			object[i-1][j]=sheet.getRow(i).getCell(j);
			    		}else if(cell.getCellType().equals(CellType.BLANK)) {
			    			System.out.println("Blanked Value");
			    			object[i-1][j]=null;
			    		}
			    	}
			        }
			    	workbook.close();
			    	inputstream.close();
			    	return object;
			    	}
			        catch(Exception e)
			    {
			    	throw new RuntimeException(e);
			    }
			        }    	
			    	
	} 
		
		



