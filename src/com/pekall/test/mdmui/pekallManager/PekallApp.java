package com.pekall.test.mdmui.pekallManager;

import android.os.RemoteException;

import com.pekall.test.mdmui.phone.NavigatorManager;
import com.pekall.test.mdmui.phone.PekallManager;
import com.pekall.test.mdmui.phone.Phone;
import com.pekall.test.mdmui.util.MyAssert;
import com.pekall.test.mdmui.util.PhoneInfo;
import com.pekall.test.mdmui.util.UiAction;

public class PekallApp {
	private static UiAction action = UiAction.getInstance();
	private static MyAssert myAssert = MyAssert.getInstance();
	private static PekallManager pekallManager = Phone.getInstance().getPekallManager();
	private static NavigatorManager navigator = Phone.getInstance().getNavigatorManager();
	
	private static PekallApp instance;
	public static PekallApp getInstance(){
		if(instance == null){
			instance = new PekallApp();
		}
		return instance;
	}
	
	public void gotoApp() throws RemoteException, InterruptedException{
		if(!action.existsByText(PhoneInfo.PekallApp_EnterpriseAppStr)){
			pekallManager.gotoPekallHome();
			action.findByTextAndClickForNewWindow(PhoneInfo.PekallAppStr);
		}
	}
	
	public void gotoEnterpriseApp() throws RemoteException, InterruptedException{
		gotoApp();
		action.findByTextAndClickForNewWindow(PhoneInfo.PekallApp_EnterpriseAppStr);
	}
	public void gotoMarketApp() throws RemoteException, InterruptedException{
		gotoApp();
		action.findByTextAndClickForNewWindow(PhoneInfo.PekallApp_MarketAppStr);
	}
}
