package com.pekall.test.mdmui.phone;

import android.os.RemoteException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public abstract class PekallManager extends UiAutomatorTestCase{
	
	public abstract void start() throws InterruptedException, RemoteException;
	
	public abstract void firstLogin() throws InterruptedException, RemoteException;
	
	public abstract void login() throws InterruptedException, RemoteException;
	
	public abstract void gotoPekallHome() throws RemoteException, InterruptedException;
	
	public abstract void gotoPekallItems(String itemStr) throws RemoteException, InterruptedException;
	
	public abstract void checkCompanyDataCleared() throws RemoteException, InterruptedException;

	public abstract void enterPersonalMode();
}
