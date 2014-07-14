package com.pekall.test.mdmui.pekallManager;

import android.os.RemoteException;

import com.pekall.test.mdmui.phone.Phone;
import com.pekall.test.mdmui.util.PhoneInfo;
import com.pekall.test.mdmui.util.UiAction;

public class PekallSetting {
	private static PekallSetting instance;
	public static PekallSetting getInstance(){
		if(instance == null){
			instance = new PekallSetting();
		}
		return instance;
	}
	
	public void gotoSetting() throws RemoteException, InterruptedException{
		Phone.getInstance().getPekallManager().gotoPekallHome();
		UiAction.getInstance().findByTextAndClickForNewWindow(PhoneInfo.SettingsStr);
	}
	
	public void gotoMydevice()throws RemoteException, InterruptedException{
		gotoSetting();
		UiAction.getInstance().findByTextAndClickForNewWindow(PhoneInfo.PekallSetting_mydeviceStr);
	}
}
