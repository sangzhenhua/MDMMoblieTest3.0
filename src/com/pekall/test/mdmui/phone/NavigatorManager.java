package com.pekall.test.mdmui.phone;

import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import android.os.RemoteException;


public abstract class NavigatorManager extends UiAutomatorTestCase{
	
	public abstract void goHome() throws RemoteException, InterruptedException;
	
	public abstract void gotoNotificationBar();
	
	public abstract void gotoAppsList() throws RemoteException, InterruptedException;
	
	public abstract void gotoSettings() throws RemoteException, InterruptedException;
	
	public abstract void gotoPekall() throws InterruptedException, RemoteException;
	
	public abstract void gotoCamera() throws RemoteException, InterruptedException;
	
	public abstract void gotoSettingsItemsWithTab(String tabStr,String itemStr) throws RemoteException, InterruptedException;
	
	public abstract void gotoSettingsSecurityItems(String itemStr) throws RemoteException, InterruptedException;
	 
	public abstract void gotoSettingsItemsWithoutTab(String itemStr) throws RemoteException, InterruptedException;
	
	public abstract void gotoWIFI() throws RemoteException, InterruptedException;
	 
	public abstract void gotoAppManagerAppItems(String itemStr) throws RemoteException, InterruptedException;
	
}
