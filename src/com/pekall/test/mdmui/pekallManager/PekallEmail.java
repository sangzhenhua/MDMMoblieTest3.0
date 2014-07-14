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

public class PekallEmail extends UiAutomatorTestCase{
	private static UiAction action = UiAction.getInstance();
	private static MyAssert myAssert = MyAssert.getInstance();
	private static PekallManager pekallManager = Phone.getInstance().getPekallManager();
	private static NavigatorManager navigator = Phone.getInstance().getNavigatorManager();
	private static PekallEmail instance;
	public static PekallEmail getInstance(){
		if(instance == null){
			instance = new PekallEmail();
		}
		return instance;
	}
	
	public void goEmail() throws RemoteException, InterruptedException{
			navigator.gotoPekall();
			action.findByTextAndClickForNewWindow(PhoneInfo.PekallEmailStr);
		//myAssert.assert_True(device, "unable enter pekall email",(action.existsByText(PhoneInfo.PekallPackage, PhoneInfo.PekallEmail_accountSetupStr, device))||(action.existsByText(PhoneInfo.PekallPackage, PhoneInfo.PekallEmail_emailNotConfigStr, device)));
	}
	
	public void checkEmailConfigReceived() throws RemoteException, InterruptedException{
	//	goEmail();
		//myAssert.assert_True("unable receive email config",action.existsByText(PhoneInfo.PekallPackage, PhoneInfo.PekallEmail_accountSetupStr));
		//myAssert.assert_True("unable receive email config",action.waitForExistsByText(PhoneInfo.PekallPackage, PhoneInfo.PekallEmail_accountSetupStr));
		myAssert.assert_True("unable receive email config",action.waitForExists(GoWhere.PekallEmail,new UiSelector().text(PhoneInfo.PekallEmail_accountSetupStr)));
		
	}
	
	public void setupAccount() throws InterruptedException, RemoteException{
		action.findBySelectorAndSetText(new UiSelector().className("android.widget.EditText").description(PhoneInfo.PekallEmail_addressEditTextDescStr),PhoneInfo.PekallEmail);
		action.findBySelectorAndSetText(new UiSelector().className("android.widget.EditText").description(PhoneInfo.PekallEmail_pwdEditTextDescStr),PhoneInfo.PekallEmailPassword);
		
		action.findByBtnTextAndClickForNewWindow(PhoneInfo.PekallPackage, PhoneInfo.PekallEmail_doneBtnStr);
		Thread.sleep(5000);
		//myAssert.assert_True("unable enter inbox",action.existsByText(PhoneInfo.PekallPackage, PhoneInfo.PekallEmail_inboxStr));
		myAssert.assert_True("unable enter inbox",action.waitForExistsByText(PhoneInfo.PekallPackage, PhoneInfo.PekallEmail_inboxStr));
	}
	
	public void checkEmailConfigUpdated() throws RemoteException, InterruptedException{
		//goEmail();
		//myAssert.assert_True("unable update email config",action.existsBySelector(new UiSelector().className("android.widget.EditText").text(PhoneInfo.PekallEmail_updatedEmailAccount)));
		//myAssert.assert_True("unable update email config",action.waitForExists(new UiSelector().className("android.widget.EditText").text(PhoneInfo.PekallEmail_updatedEmailAccount)));
		myAssert.assert_True("unable update email config",action.waitForExists(GoWhere.PekallEmail,new UiSelector().className("android.widget.EditText").text(PhoneInfo.PekallEmail_updatedEmailAccount)));
		
	}
	
	public void checkEmailConfigDeleted() throws RemoteException, InterruptedException{
		//goEmail();
		//myAssert.assert_True("unable update email config",action.existsByText(PhoneInfo.PekallPackage,PhoneInfo.PekallEmailStr));
		//myAssert.assert_True("unable update email config",action.waitForExistsByText(PhoneInfo.PekallPackage,PhoneInfo.PekallEmailStr));
		myAssert.assert_True("unable update email config",action.waitForExists(GoWhere.PekallEmail,new UiSelector().text(PhoneInfo.PekallEmailStr)));
		
	}

}
