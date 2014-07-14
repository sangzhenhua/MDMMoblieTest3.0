package com.pekall.test.mdmui;

import java.io.IOException;

import android.os.RemoteException;

import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.pekall.test.mdmui.pekallManager.PekallSetting;
import com.pekall.test.mdmui.phone.CameraManager;
import com.pekall.test.mdmui.phone.NotificationManager;
import com.pekall.test.mdmui.phone.Phone;
import com.pekall.test.mdmui.phone.PowerManager;
import com.pekall.test.mdmui.phone.SettingManager;
import com.pekall.test.mdmui.util.MyAssert;
import com.pekall.test.mdmui.util.PhoneInfo;
import com.pekall.test.mdmui.util.UiANRWatcher;
import com.pekall.test.mdmui.util.UiAction;

public class PloyAndConfig extends UiAutomatorTestCase{
	static{
		UiANRWatcher.getInstance().run();
	}
	private static PowerManager powerManager = Phone.getInstance().getPowerManager();
	private static NotificationManager notificationManager = Phone.getInstance().getNotificationManager();
	private static SettingManager settingManager = Phone.getInstance().getSettingManager();
	private static CameraManager cameraManager = Phone.getInstance().getCameraManager();
	private static PekallSetting pekallSetting = PekallSetting.getInstance();
	private static UiAction action = UiAction.getInstance();
	private static MyAssert myAssert = MyAssert.getInstance();
	
	public void checkUserPloyChanged() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallSetting.gotoMydevice();
		myAssert.assert_True("unable change user ploy",action.waitForExists(new UiSelector().textContains(PhoneInfo.PekallSetting_userPloyStr)));
	}
	public void checkUserGroupPloyChanged() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallSetting.gotoMydevice();
		myAssert.assert_True("unable change user group ploy",action.waitForExists(new UiSelector().textContains(PhoneInfo.PekallSetting_userGroupPloyStr)));
	}
	public void checkDevicePloyChanged() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallSetting.gotoMydevice();
		myAssert.assert_True("unable change device ploy",action.waitForExists(new UiSelector().textContains(PhoneInfo.PekallSetting_devicePloyStr)));
	}
	public void checkDeviceGroupPloyChanged() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallSetting.gotoMydevice();
		myAssert.assert_True("unable change device group ploy",action.waitForExists(new UiSelector().textContains(PhoneInfo.PekallSetting_deviceGroupPloyStr)));
	}
	public void checkAndroidPWDPloyReceived() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallSetting.gotoMydevice();
		myAssert.assert_True("unable receive android pwd ploy",action.waitForExists(new UiSelector().textContains(PhoneInfo.PekallSetting_androidPWDPloyStr)));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
