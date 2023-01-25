import java.time.Duration;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class parameters {

	public WebDriver driver;

	String URlname = "https://www.demoblaze.com/";

	SoftAssert MySoftAssert = new SoftAssert();

	@BeforeTest

	public void pre_test() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(URlname);
	}

	@Test
	public void Check_The_Contact_Information() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		String nameofEmail[] = { "a1@gamil.com", "a9gmail", "uu887@gamil", "king@gmail.com" };

		Random Email_Index = new Random();
		int Index = Email_Index.nextInt(4);

		driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a")).click();

		driver.findElement(By.xpath("//*[@id=\"recipient-email\"]")).sendKeys(nameofEmail[Index]);
		// driver.findElement(By.xpath("//*[@id=\\\"recipient-email\\\"]")).clear();

		// .sleep(5000);
		// driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]")).click();

		String MyValue = driver.findElement(By.xpath(URlname)).getAttribute("value");

		System.out.println(MyValue);

		String Regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(Regex);

		Matcher matcher = pattern.matcher(nameofEmail[Index]);

		System.out.println(nameofEmail[Index] + " is vaild email:" + matcher.matches());

	}
}
