package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.devtools.v85.media.model.Timestamp;

import BaseLayer.TestBase;

public class SnapShot extends TestBase{
	
	
	public String captureScreenPrint()
	{
		
		TakesScreenshot ts=(TakesScreenshot) d;
		
		File f1=ts.getScreenshotAs(OutputType.FILE);
		
		
			try {
				FileUtils.copyFile(f1, new File("./ScreenProofs/GaneshTest.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
								
			}
			
		String s=System.getProperty("user.dir")+"/ScreenProofs/GaneshTest.png";
		return s;// Returning the string of path where screen print is being stored
	}
	

}
