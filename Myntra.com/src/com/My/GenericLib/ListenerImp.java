package com.My.GenericLib;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImp implements ITestListener
{
@Override
public void onTestFailure(ITestResult result) {
	Date date=new Date();
	
	int day=date.getDate();
	
	
	String [] dateArr=date.toString().split(" ");
	
	String month=dateArr[1];
	String year=dateArr[5];
	String time=dateArr[3].replace(":", "_");
	
	String methodName=result.getMethod().getMethodName();
	
	EventFiringWebDriver fire=new EventFiringWebDriver(Base.scrndriver);

	File src=fire.getScreenshotAs(OutputType.FILE);
	
	File dest=new File("./screenShot/"+methodName+"_"+day+"_"+month+"_"+time+"_"+year+".png");
	
	try
	{
		FileUtils.copyFile(src, dest);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

}
