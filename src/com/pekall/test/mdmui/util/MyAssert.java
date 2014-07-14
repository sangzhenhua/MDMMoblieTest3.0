package com.pekall.test.mdmui.util;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;


public class MyAssert extends UiAutomatorTestCase{
	private static UiDevice device = UiDevice.getInstance();
	private static MyAssert instance;
	public static MyAssert getInstance(){
		if(instance == null){
			instance = new MyAssert();
		}
		return instance;
	}
	
	public void assert_True(String failStr,boolean condition ){
		if(!condition){
			try {
				device.wakeUp();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AssertScreenshot.getInstance().take(failStr);
		}
		assertTrue(failStr,condition);
	}
	
	public void assert_False(String failStr,boolean condition ){
		if(condition){
			try {
				device.wakeUp();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AssertScreenshot.getInstance().take(failStr);
		}
		assertFalse(failStr,condition);
	}
}
