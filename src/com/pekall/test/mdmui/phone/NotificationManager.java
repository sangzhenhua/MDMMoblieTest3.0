package com.pekall.test.mdmui.phone;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;


public abstract class NotificationManager extends UiAutomatorTestCase{
	
	public abstract void close() throws RemoteException, UiObjectNotFoundException, InterruptedException;
	
	public abstract void checkAndroidPWDPloyReceived() throws RemoteException, InterruptedException;
	
	public abstract void checkAndroidPWDPloyUpdated() throws RemoteException, InterruptedException;
	
	public abstract void setAndroidPWD(boolean isFirst) throws RemoteException, InterruptedException;
	
	public abstract String getCurrentPWD();
}
