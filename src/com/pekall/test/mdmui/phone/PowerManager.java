package com.pekall.test.mdmui.phone;

import android.os.RemoteException;

import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public abstract class PowerManager extends UiAutomatorTestCase{
	
	public abstract void swipeToUnlock();
	
	public abstract void unlock() throws RemoteException, InterruptedException;
	
	public abstract void checkLocked() throws RemoteException, InterruptedException;
	
	public abstract void checkUnlocked() throws RemoteException;

	public abstract void checkAndroidPWDLocked() throws RemoteException, InterruptedException;
}
