package com.pekall.test.mdmui.phone;

import android.os.RemoteException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public abstract class SettingManager extends UiAutomatorTestCase{
	
	public abstract void deactivePekall() throws RemoteException, InterruptedException;
	
	public abstract void clearData() throws RemoteException;
	
	public abstract void clearPekallData() throws RemoteException, InterruptedException;
	
	public abstract void checkWIFIConfigReceived() throws RemoteException, InterruptedException;
		 
}
