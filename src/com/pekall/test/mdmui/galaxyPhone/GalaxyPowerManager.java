package com.pekall.test.mdmui.galaxyPhone;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiSelector;
import com.pekall.test.mdmui.phone.PowerManager;
import com.pekall.test.mdmui.util.DevicePWDInput;
import com.pekall.test.mdmui.util.MyAssert;
import com.pekall.test.mdmui.util.MyUiObject;
import com.pekall.test.mdmui.util.PhoneInfo;
import com.pekall.test.mdmui.util.UiAction;

public class GalaxyPowerManager extends PowerManager {
	private static MyAssert myAssert = MyAssert.getInstance();
	private static UiAction action = UiAction.getInstance();
	private static UiDevice device = UiDevice.getInstance();

	private static GalaxyPowerManager instance;

	public static GalaxyPowerManager getInstance() {
		if (instance == null) {
			instance = new GalaxyPowerManager();
		}
		return instance;
	}

	//
	// public void swipeToUnlock(UiDevice device){
	// if(action.existsByText(PhoneInfo.AndroidPackage, PhoneInfo.ScreenLockStr,
	// device)){
	// device.swipe(0, device.getDisplayHeight()/2, device.getDisplayWidth()-50,
	// device.getDisplayHeight()/2, 10);
	// myAssert.assert_False(device,"swipe unlock failed!",action.existsBySelector(new
	// UiSelector().packageName(PhoneInfo.AndroidPackage), device));
	// }
	// }

	@Override
	public void swipeToUnlock() {
		
		if (action.existsByDesc(PhoneInfo.deviceSlideDescStr)) {
			device.swipe(device.getDisplayWidth() / 2,
					device.getDisplayHeight() - 200,
					device.getDisplayWidth() - 50,
					device.getDisplayHeight() - 200, 10);
	
		}
		
	}

	// public void unlock(UiDevice device) throws RemoteException{
	// device.wakeUp();
	// MyUiObject obj = new MyUiObject(new
	// UiSelector().packageName(PhoneInfo.AndroidPackage).className("android.widget.EditText").index(0));
	// if(obj.exists()){
	// System.out.println("need enter device password");
	// obj.setText(GalaxyNotificationManager.getInstance().getCurrentPWD(),device);
	// device.pressEnter();
	// }
	// else{
	// System.out.println("swipe to unlock");
	// }
	// galaxySwipeToUnlock(device);
	// myAssert.assert_False(device,"device password wrong!",action.existsBySelector(new
	// UiSelector().packageName(PhoneInfo.AndroidPackage), device));
	// }

	@Override
	public void unlock() throws RemoteException, InterruptedException {
		device.wakeUp();
		MyUiObject obj = new MyUiObject(new UiSelector()
				.packageName(PhoneInfo.AndroidPackage)
				.className("android.widget.EditText").index(0));
		if (obj.exists()) {
			System.out.println("need enter android password");
			obj.setText(GalaxyNotificationManager.getInstance().getCurrentPWD());
			device.pressEnter();
		} else {
			if (action.existsByDesc(PhoneInfo.AndroidPackage,
					PhoneInfo.DeviceLock_digitInputDescStr)) {
				Thread.sleep(3000);
				DevicePWDInput.getInstance().input(PhoneInfo.DevicePassword);
			} else {
				System.out.println("swipe to unlock");
				swipeToUnlock();
			}

		}
		
		myAssert.assert_False("device password wrong!", action
				.existsBySelector(new UiSelector()
						.packageName(PhoneInfo.AndroidPackage)));
	}

	@Override
	public void checkLocked() throws RemoteException, InterruptedException {
		device.wakeUp();
		
		myAssert.assert_True("unable lock device!", (action
				.waitForExistsByDesc(PhoneInfo.AndroidPackage,
						PhoneInfo.DeviceLock_digitInputDescStr)));
		//unlock();
	}

	@Override
	public void checkAndroidPWDLocked() throws RemoteException, InterruptedException {
		device.wakeUp();
		myAssert.assert_True(
				"unable android password lock device!",
				action.waitForExists(new UiSelector()
						.packageName(PhoneInfo.AndroidPackage)
						.className("android.widget.EditText").index(0)));
		unlock();
	}

	@Override
	public void checkUnlocked() throws RemoteException {
		device.wakeUp();
		myAssert.assert_True(
				"unable unlock device!",
				(action.waitForGone(new UiSelector()
						.packageName(PhoneInfo.AndroidPackage)
						.className("android.widget.EditText").index(0)))
						&& (action.waitForGone(new UiSelector().packageName(
								PhoneInfo.AndroidPackage).description(
								PhoneInfo.DeviceLock_digitInputDescStr))));
		swipeToUnlock();
	}
}
