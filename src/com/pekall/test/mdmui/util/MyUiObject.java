package com.pekall.test.mdmui.util;

import java.io.File;

import android.os.RemoteException;
import android.os.SystemClock;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.pekall.test.mdmui.phone.Phone;
import com.pekall.test.mdmui.phone.PowerManager;

public class MyUiObject extends UiObject {
	private UiDevice device = UiDevice.getInstance();
	private PowerManager powerManager = Phone.getInstance().getPowerManager();
	public MyUiObject(UiSelector selector) {
		super(selector);
	}
	
	
	
	public boolean myWaitForExists() throws RemoteException{
		return myWaitForExists(PhoneInfo.Timeout);
	}
	
	public boolean myWaitForExists(long timeout) throws RemoteException{
		System.out.println("my Wait for exists");
		long startMills = SystemClock.uptimeMillis();
        long currentMills = 0;
      
        while (currentMills <= timeout) {
        	try {
				powerManager.unlock();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	System.out.println("currentMills:"+currentMills);
        
        	
        	if(this.exists()){
        		System.out.println("exists!!");
        		return true;
        	}
            currentMills = SystemClock.uptimeMillis() - startMills;
           
        }
		return false;
	}
	
	public boolean myWaitForGone() throws RemoteException{
		return myWaitForGone(PhoneInfo.Timeout);
	}
	
	public boolean myWaitForGone(long timeout) throws RemoteException{
		System.out.println("my Wait for exists");
		long startMills = SystemClock.uptimeMillis();
        long currentMills = 0;
      
        while (currentMills <= timeout) {
        	try {
				powerManager.unlock();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	System.out.println("currentMills:"+currentMills);
        	
        	if(!this.exists()){
        		System.out.println("not exists!!");
        		return true;
        	}
            currentMills = SystemClock.uptimeMillis() - startMills;
           
        }
		return false;
	}
	
	public void clearTextField(){
		try{
		super.clearTextField();
		}catch(UiObjectNotFoundException e){
			device.takeScreenshot(new File("/sdcard/mdm/"+this.getSelector()+".png"));
			e.printStackTrace();
		}
	}
	
	public boolean click() {
	
		boolean result=false;
		try{
		 result= super.click();
		}catch(UiObjectNotFoundException e){
			e.printStackTrace();
		   	device.takeScreenshot(new File("/sdcard/mdm/"+this.getSelector()+".png"));	
		}
		return result;
	}

	
	public boolean clickAndWaitForNewWindow()  {
		boolean result = false;
		try{
		result = super.clickAndWaitForNewWindow();
		}catch(UiObjectNotFoundException e){
			e.printStackTrace();
			device.takeScreenshot(new File("/sdcard/mdm/"+this.getSelector()+".png"));
		}
		return result;
	}

	public boolean setText(String text) {
		boolean result = false;
		try{
		result = super.setText(text);
		}catch(UiObjectNotFoundException e){
			device.takeScreenshot(new File("/sdcard/mdm/"+this.getSelector()+".png"));	
			e.printStackTrace();
		}
		return result;
	}
	
}
