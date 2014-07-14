package com.pekall.test.mdmui;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.pekall.test.mdmui.pekallManager.PekallDocument;
import com.pekall.test.mdmui.phone.Phone;
import com.pekall.test.mdmui.phone.PowerManager;
import com.pekall.test.mdmui.util.MyAssert;
import com.pekall.test.mdmui.util.PhoneInfo;
import com.pekall.test.mdmui.util.UiANRWatcher;
import com.pekall.test.mdmui.util.UiAction;


public class Device extends UiAutomatorTestCase{
	private static MyAssert myAssert = MyAssert.getInstance();
	private static PowerManager powerManager = Phone.getInstance().getPowerManager();
	private static UiAction action = UiAction.getInstance();
	static{
		UiANRWatcher.getInstance().run();
	}
	public void checkLocked() throws RemoteException, InterruptedException{
		UiDevice device = this.getUiDevice();
		Thread.sleep(3000);
		device.wakeUp();
		myAssert.assert_True("lock failed", action.existsByDesc(PhoneInfo.DeviceLock_digitInputDescStr));
	}
	
	public void lock() throws RemoteException{
		UiDevice device = this.getUiDevice();
		device.sleep();
	}
	
	public void checkLockedScreen()throws RemoteException, InterruptedException{
		UiDevice device = this.getUiDevice();
		Thread.sleep(3000);
		device.wakeUp();
		myAssert.assert_True("lockScreen failed", action.existsByDesc(PhoneInfo.deviceSlideDescStr));
	}
	
	
	public void checkUnlocked() throws RemoteException, InterruptedException{
		UiDevice device = this.getUiDevice();
		device.wakeUp();
		myAssert.assert_True("unlock failed", action.waitForGone(PhoneInfo.DeviceLock_digitInputDescStr));
	}
		
	
	public void checkCompanyDataCleared() throws RemoteException, InterruptedException{
		Phone.getInstance().getPowerManager().unlock();
		Phone.getInstance().getPekallManager().checkCompanyDataCleared();
	}
	
	
}
