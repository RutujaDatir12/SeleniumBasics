package demowebshop;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelLogIn {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
        File file = new File("C:\\Users\\USER\\OneDrive\\Documents");
        FileInputStream fileInput = new FileInputStream(file);
        XSSFWorkbook wb= new XSSFWorkbook(fileInput);
        fileInput.close();
        
        XSSFSheet st= wb.getSheet("LogInInfo");
        XSSFRow ro=st.getRow(1);
        XSSFCell ce=ro.getCell(1);
        String url=ce.getStringCellValue();
        System.out.println("URL+ "+ url);
        
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        
        
        
	}

}
