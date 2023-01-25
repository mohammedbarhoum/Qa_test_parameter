import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestFualProject extends parameters {

	@Test()
	public void Check_Image_Drawer() {

		List<WebElement> myimages = driver.findElements(By.className(""));

	Boolean MyImageCkech1 = myimages.get(0).getAttribute("src") == myimages.get(1).getAttribute("src");
	Boolean MyImageCkech2 = myimages.get(1).getAttribute("src") == myimages.get(2).getAttribute("src");
	Boolean MyImageCkech3 = myimages.get(2).getAttribute("src") == myimages.get(0).getAttribute("src");
	
	MySoftAssert.assertEquals(MyImageCkech1, false," Image one with  image two");
	MySoftAssert.assertEquals(MyImageCkech2, false);
	MySoftAssert.assertEquals(MyImageCkech1, false);
	
		MySoftAssert.assertAll();
	}

}
