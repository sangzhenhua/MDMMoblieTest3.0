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


public class PekallMessage extends UiAutomatorTestCase {
	private static PekallMessage instance;
	private static UiAction action = UiAction.getInstance();
	private static MyAssert myAssert = MyAssert.getInstance();
	private static PekallManager pekallManager = Phone.getInstance().getPekallManager();
	private static NavigatorManager navigator = Phone.getInstance().getNavigatorManager();
	
	public static PekallMessage getInstance(){
		if(instance == null){
			instance = new PekallMessage();
		}
	return instance;
	}
	
	public void gotoMessage() throws RemoteException, InterruptedException{
		if(!(action.existsByText(PhoneInfo.PekallMsgCenterStr) && !action.existsByText(PhoneInfo.PekallDocCenterStr))){
			System.out.println("go to pekall message center");
			pekallManager.gotoPekallHome();
			action.findByTextAndClickForNewWindow(PhoneInfo.PekallMsgCenterStr);
		}
	}
	
	
}
