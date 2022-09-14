package Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Base.BaseClass;
import utilities.ReadXL;


public class TestRunner extends BaseClass{
	@Test
	private void tc1() {
		
		//search testcase
		driver.get("https://adactinhotelapp.com/SearchHotel.php");
		WebElement location=driver.findElement(By.id("location"));
		Select a=new Select(location);
		a.selectByValue("London");
		WebElement hotel=driver.findElement(By.id("hotels"));
		Select b=new Select(hotel);
		b.selectByValue("Hotel Sunshine");
		WebElement room=driver.findElement(By.xpath("//*[@id=\"room_type\"]"));
		Select c=new Select(room);
		c.selectByIndex(1);
		
		
		driver.findElement(By.id("Submit")).click();
		
		
	}
	@Test
	private void tc2() {
		//select hotel
		driver.get("https://adactinhotelapp.com/SelectHotel.php");
		
		driver.findElement(By.xpath("//input[@id='radiobutton_0']")).click();
		driver.findElement(By.id("continue")).click();
		
		
	}
	@Test
	private void tc3() {
		//Book A Hotel
		//validation booking option
		driver.findElement(By.id("first_name")).sendKeys("kavya");
		driver.findElement(By.name("last_name")).sendKeys("G");
		driver.findElement(By.xpath(".//textarea[@rows='4']")).sendKeys("hyd");
		driver.findElement(By.xpath(".//input[@id='cc_num']")).sendKeys("9999999999999999");
		Select s3=new Select(driver.findElement(By.id("cc_type")));
		s3.selectByIndex(4);
		Select s4=new Select(driver.findElement(By.xpath(".//select[@id='cc_exp_month']")));
		s4.selectByVisibleText("December");
		Select s5=new Select(driver.findElement(By.xpath(".//select[@id='cc_exp_year']")));
		s5.selectByVisibleText("2022");
		driver.findElement(By.id("cc_cvv")).sendKeys("4321");
		driver.findElement(By.id("book_now")).click();
	}
    @Test
    private void tc4() {
    	//
    	driver.get("https://adactinhotelapp.com/BookingConfirm.php");
    	System.out.println("The Order No :0IZI39381H");
    }

}
