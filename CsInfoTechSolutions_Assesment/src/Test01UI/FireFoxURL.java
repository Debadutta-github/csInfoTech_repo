package Test01UI;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class FireFoxURL {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        String[] urls = {
            "https://www.getcalley.com/",
            "https://www.getcalley.com/calley-lifetime-offer/",
            "https://www.getcalley.com/see-a-demo/",
            "https://www.getcalley.com/calley-teams-features/",
            "https://www.getcalley.com/calley-pro-features/"
        };

        String[] fileNames = {
            "FirstURLPage.png",
            "SecondURLPage.png",
            "ThirdURLPage.png",
            "FourthURLPage.png",
            "FifthURLPage.png"
        };
       String deviceName="ASUS";
       String resolution="1920X1080";

        for (int i = 0; i < urls.length; i++) {
            driver.get("https://www.getcalley.com/page-sitemap.xml");
            driver.findElement(By.linkText(urls[i])).click();

            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File firefoxFile = screenshot.getScreenshotAs(OutputType.FILE);
            String timestamp = LocalDateTime.now().toString().replace(":", "-");
            File destFile = new File("./AllFireFoxURL/" +deviceName+"_"+resolution+"_"+timestamp+"_"+ fileNames[i]);
            FileHandler.copy(firefoxFile, destFile);

            Thread.sleep(2000);
            driver.navigate().back();
        }
        driver.quit();
	}

}
