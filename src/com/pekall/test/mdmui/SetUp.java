package com.pekall.test.mdmui;

import android.os.RemoteException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.pekall.test.mdmui.phone.NavigatorManager;
import com.pekall.test.mdmui.phone.PekallManager;
import com.pekall.test.mdmui.phone.Phone;
import com.pekall.test.mdmui.phone.PowerManager;
import com.pekall.test.mdmui.phone.SettingManager;
import com.pekall.test.mdmui.util.UiANRWatcher;

public class SetUp extends UiAutomatorTestCase{
		
	static{
		UiANRWatcher.getInstance().run();
	}
	private static PowerManager powerManager = Phone.getInstance().getPowerManager();
	private static SettingManager settingManager = Phone.getInstance().getSettingManager();
	private static PekallManager pekallManager = Phone.getInstance().getPekallManager();
	private static NavigatorManager navigatorManager = Phone.getInstance().getNavigatorManager();
	
	public void setup() throws RemoteException, InterruptedException{
		powerManager.unlock();
		settingManager.deactivePekall();
		settingManager.clearPekallData();
		
		pekallManager.start();
		pekallManager.firstLogin();
		pekallManager.gotoPekallHome();
	}
	
	public void loginPekall() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallManager.gotoPekallHome();	
	}
	
	public void goHome()throws RemoteException, InterruptedException{
		powerManager.unlock();
		navigatorManager.goHome();
	}
}
