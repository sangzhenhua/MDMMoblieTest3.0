package com.pekall.test.mdmui.galaxyPhone;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiSelector;
import com.pekall.test.mdmui.phone.NavigatorManager;
import com.pekall.test.mdmui.phone.PekallManager;
import com.pekall.test.mdmui.phone.Phone;
import com.pekall.test.mdmui.phone.SwipeManager;
import com.pekall.test.mdmui.util.MyAssert;
import com.pekall.test.mdmui.util.PhoneInfo;
import com.pekall.test.mdmui.util.UiAction;
import com.pekall.test.mdmui.util.Unicode;

public class GalaxyNavigatorManager extends NavigatorManager{
	private static UiAction action = UiAction.getInstance();
	private static PekallManager pekallManager = Phone.getInstance().getPekallManager();
	private static SwipeManager swipeManager = Phone.getInstance().getSwipeManager();
	private static MyAssert myAssert = MyAssert.getInstance();
	private static UiDevice device = UiDevice.getInstance();
	
	private static GalaxyNavigatorManager instance;
	public static GalaxyNavigatorManager getInstance(){
		if(instance == null){
			instance = new GalaxyNavigatorManager();
		}
		return instance;
	}
	
	@Override
	public void goHome() throws RemoteException, InterruptedException {
		System.out.println("go home");
		
		device.pressHome();
	}
	
	@Override
	public void gotoNotificationBar() {
		device.openNotification();
	}
	
	@Override
	public void gotoAppsList() throws RemoteException, InterruptedException {
		System.out.println("go Apps");
		goHome();
		action.findByDescAndClickForNewWindow(PhoneInfo.SecPackage, PhoneInfo.AppsDesc);
		
	}
	
	@Override
	public void gotoSettings() throws RemoteException, InterruptedException {
		System.out.println("go Settings");
		gotoAppsList();
		swipeManager.swipeLiftAndRightAndClick(2, new UiSelector().text(PhoneInfo.SettingsStr));
		myAssert.assert_True("Unable to enter settings",(action.existsByPackage(PhoneInfo.SettingsPackage)));
		
	}
	
	@Override
	public void gotoPekall() throws InterruptedException, RemoteException {
		System.out.println("go Pekall");
		gotoAppsList();
		swipeManager.swipeLiftAndRightAndClick(2, new UiSelector().text(PhoneInfo.PekallStr));
		myAssert.assert_True("Unable to enter pekall",action.existsByPackage(PhoneInfo.PekallPackage));  
	}
	
	@Override
	public void gotoCamera() throws RemoteException, InterruptedException {
		gotoAppsList();
		swipeManager.swipeLiftAndRightAndClick(2, new UiSelector().text(PhoneInfo.CameraStr));
	}
	
	@Override
	public void gotoSettingsItemsWithTab(String tabStr,String itemStr) throws RemoteException, InterruptedException {
		gotoSettings();
		action.findByTextAndClickForNewWindow(PhoneInfo.SettingsPackage, tabStr);
		swipeManager.swipeUpAndDownAndClick(3,new UiSelector().text(itemStr));
	}
	
	@Override
	public void gotoSettingsSecurityItems(String itemStr) throws RemoteException, InterruptedException {
		 gotoSettingsItemsWithoutTab(PhoneInfo.SettingsSecurityStr);
		 swipeManager.swipeUpAndDownAndClick(3,new UiSelector().text(itemStr));
	}
	
	@Override
	public void gotoSettingsItemsWithoutTab(String itemStr) throws RemoteException, InterruptedException {
		gotoSettings();
		swipeManager.swipeUpAndDownAndClick(3,new UiSelector().text(itemStr));
	}
	
	@Override
	public void gotoWIFI() throws RemoteException, InterruptedException {
		gotoSettings();
		System.out.println(PhoneInfo.SettingsWifiStr+"abc");
		swipeManager.swipeUpAndDownAndClick(3,new UiSelector().text(PhoneInfo.SettingsWifiStr));
	}
	
	@Override
	public void gotoAppManagerAppItems(String itemStr) throws RemoteException, InterruptedException {
		gotoSettingsItemsWithoutTab(PhoneInfo.SettingsAppsStr);
		swipeManager.swipeUpAndDownAndClick(3,new UiSelector().text(itemStr));
	}

}
