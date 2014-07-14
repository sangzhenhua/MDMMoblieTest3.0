package com.pekall.test.mdmui.util;

import java.io.File;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiWatcher;

public class UiANRWatcher implements UiWatcher {
	private static UiDevice device = UiDevice.getInstance();
	private static UiANRWatcher instance;
	public static UiANRWatcher getInstance(){
		if(instance == null){
			instance = new UiANRWatcher();
		}
		return instance;
	}
	
	@Override
	public boolean checkForCondition() {
		try {
			device.wakeUp();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         if(UiAction.getInstance().existsByBtnText(PhoneInfo.AndroidPackage, PhoneInfo.MsgboxWaitBtnStr)){
        	 UiAction.getInstance().findByBtnTextAndClickForNewWindow(PhoneInfo.AndroidPackage, PhoneInfo.MsgboxOKBtnStr);
             System.out.println("-----------------------------Found ANR and click okButton!----------------------");
             device.takeScreenshot(new File("/sdcard/mdm/ANR"+RandomString.getInstance().getRandomDigitString(4)+".png"));
             return (true);
         }
         System.out.println("Not found ANR!");
         return false;
     
	}
	
	public void run(){
		device.registerWatcher("ANRWatcher", this);
		device.runWatchers();
	}
}
