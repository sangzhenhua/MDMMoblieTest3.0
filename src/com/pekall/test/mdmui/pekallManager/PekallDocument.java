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

public class PekallDocument extends UiAutomatorTestCase{
	private static UiAction action = UiAction.getInstance();
	private static MyAssert myAssert = MyAssert.getInstance();
	private static PekallManager pekallManager = Phone.getInstance().getPekallManager();
	private static NavigatorManager navigator = Phone.getInstance().getNavigatorManager();
	
	private static PekallDocument instance;
	public static PekallDocument getInstance(){
		if(instance == null){
			instance = new PekallDocument();
		}
		return instance;
	}
	
	public void gotoDocument() throws RemoteException, InterruptedException{
		pekallManager.gotoPekallHome();
		action.findByTextAndClickForNewWindow(PhoneInfo.PekallDocCenterStr);
		
	}
	
	public void gotoEnterpriseDocument()throws RemoteException, InterruptedException{
		if(!(action.existsByText(PhoneInfo.PekallDocCenterEnterpriseDoc) && !(action.existsByText(PhoneInfo.PekallDocCenterLocalDoc)))){
			gotoDocument();
			action.findByTextAndClickForNewWindow(PhoneInfo.PekallDocCenterEnterpriseDoc);
		}
		
	}
	
	
	
}
