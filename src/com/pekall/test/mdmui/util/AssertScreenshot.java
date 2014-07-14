package com.pekall.test.mdmui.util;

import java.io.File;

import com.android.uiautomator.core.UiDevice;

public class AssertScreenshot {
	private static AssertScreenshot instance;
	public static AssertScreenshot getInstance(){
		if(instance == null){
			instance = new AssertScreenshot();
		}
		return instance;
	}
	
	public boolean take(String name){
		UiDevice device = UiDevice.getInstance();
		return device.takeScreenshot(new File("/sdcard/mdm/"+name+".png"));
	}
}
