package com.pekall.test.mdmui.pekallManager;

import android.os.RemoteException;

import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.pekall.test.mdmui.phone.NavigatorManager;
import com.pekall.test.mdmui.phone.PekallManager;
import com.pekall.test.mdmui.phone.Phone;
import com.pekall.test.mdmui.util.GoWhere;
import com.pekall.test.mdmui.util.MyAssert;
import com.pekall.test.mdmui.util.PhoneInfo;
import com.pekall.test.mdmui.util.UiAction;

public class PekallContacts extends UiAutomatorTestCase {
	private static PekallManager pekallManager = Phone.getInstance().getPekallManager();
	private static NavigatorManager navigator = Phone.getInstance().getNavigatorManager();
	private static UiAction action = UiAction.getInstance();
	private static MyAssert myAssert = MyAssert.getInstance();

	private static PekallContacts instance;
	public static PekallContacts getInstance(){
		if(instance == null){
			instance = new PekallContacts();
		}
		return instance;
	}
	
	public void gotoContacts() throws RemoteException, InterruptedException{
		pekallManager.gotoPekallHome();
		action.findByTextAndClickForNewWindow(PhoneInfo.PekallContactsStr);	
	}
	
	public void gotoContactList() throws RemoteException, InterruptedException{
		gotoContacts();
		action.findBySelectorAndClick(new UiSelector().resourceId("com.pekall.emdm:id/thrid"));	
	}
	
	
	
	
}
