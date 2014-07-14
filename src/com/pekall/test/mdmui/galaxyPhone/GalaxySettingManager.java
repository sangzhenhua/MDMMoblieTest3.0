package com.pekall.test.mdmui.galaxyPhone;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiSelector;
import com.pekall.test.mdmui.phone.NavigatorManager;
import com.pekall.test.mdmui.phone.Phone;
import com.pekall.test.mdmui.phone.SettingManager;
import com.pekall.test.mdmui.util.MyAssert;
import com.pekall.test.mdmui.util.PhoneInfo;
import com.pekall.test.mdmui.util.UiAction;

public class GalaxySettingManager extends SettingManager {
	private static UiAction action = UiAction.getInstance();
	private static NavigatorManager navigatorManager = Phone.getInstance().getNavigatorManager();
	private static MyAssert myAssert = MyAssert.getInstance();
	private static UiDevice device = UiDevice.getInstance();
	
	private static GalaxySettingManager instance;
	public static GalaxySettingManager getInstance(){
		if(instance == null){
			instance = new GalaxySettingManager();
		}
		return instance;
	}
	
	@Override
	public void deactivePekall() throws RemoteException, InterruptedException {
		navigatorManager.gotoSettingsSecurityItems(PhoneInfo.SettingsDeviceAdminStr);
		if(action.existsByText(PhoneInfo.SettingsPackage,PhoneInfo.SettingsPekallEMMPStr)){
			action.findByTextAndClickForNewWindow(PhoneInfo.SettingsPackage,PhoneInfo.SettingsPekallEMMPStr);
			if(action.existsByBtnText(PhoneInfo.SettingsDeviceAdminDeactivateBtnStr)){
				action.findByBtnTextAndClickForNewWindow(PhoneInfo.SettingsDeviceAdminDeactivateBtnStr);
				myAssert.assert_True("unable to deactive pekall",action.existsByBtnText(PhoneInfo.SettingsDeviceAdminActiveBtnStr));
				device.pressBack();
			}
			else{
				System.out.println("Pekall has been deactived");
			}
		}
		else{
			System.out.println("Pekall has not been installed");
		}
	}

	@Override
	public void clearData() throws RemoteException {
		if(action.waitForExists(new UiSelector().text(PhoneInfo.SettingsClearDataBtnStr).enabled(true),5000)){
			action.findByBtnTextAndClickForNewWindow(PhoneInfo.SettingsClearDataBtnStr);
			action.findByBtnTextAndClickForNewWindow(PhoneInfo.MsgboxOKBtnStr);
			myAssert.assert_False("clear data failed", action.isEnabledByBtnText(PhoneInfo.SettingsClearDataBtnStr));
		}
		else{
			System.out.println("clear data is unable");
		}
	}

	@Override
	public void clearPekallData() throws RemoteException, InterruptedException {
		navigatorManager.gotoAppManagerAppItems(PhoneInfo.PekallStr);
		clearData();
	}

	@Override
	public void checkWIFIConfigReceived() throws RemoteException, InterruptedException {
		navigatorManager.gotoWIFI();
	}

}
