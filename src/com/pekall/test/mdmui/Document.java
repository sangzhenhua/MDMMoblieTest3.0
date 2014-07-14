package com.pekall.test.mdmui;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.pekall.test.mdmui.pekallManager.PekallApp;
import com.pekall.test.mdmui.pekallManager.PekallDocument;
import com.pekall.test.mdmui.phone.Phone;
import com.pekall.test.mdmui.phone.PowerManager;
import com.pekall.test.mdmui.util.GoWhere;
import com.pekall.test.mdmui.util.MyAssert;
import com.pekall.test.mdmui.util.PhoneInfo;
import com.pekall.test.mdmui.util.UiANRWatcher;
import com.pekall.test.mdmui.util.UiAction;


public class Document extends UiAutomatorTestCase {
	private static MyAssert myAssert = MyAssert.getInstance();
	private static PekallDocument pekallDoc = PekallDocument.getInstance();
	private static PowerManager powerManager = Phone.getInstance().getPowerManager();
	private static UiAction action = UiAction.getInstance();
	static{
		UiANRWatcher.getInstance().run();
	}
	public void checkUserDocReceived() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallDoc.gotoEnterpriseDocument();
		myAssert.assert_True("unable receive user document",action.waitForExistsByText(PhoneInfo.PekallDocManager_userDocStr));
	}
	public void checkUserGroupDocReceived() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallDoc.gotoEnterpriseDocument();
		myAssert.assert_True("unable receive user group document",action.waitForExistsByText(PhoneInfo.PekallDocManager_userGroupDocStr));
	}
	public void checkDeviceDocReceived() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallDoc.gotoEnterpriseDocument();
		myAssert.assert_True("unable receive device document",action.waitForExistsByText(PhoneInfo.PekallDocManager_deviceDocStr));
	}
	public void checkDeviceGroupDocReceived() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallDoc.gotoEnterpriseDocument();
		myAssert.assert_True("unable receive device group document",action.waitForExistsByText(PhoneInfo.PekallDocManager_deviceGroupDocStr));
	}
	public void checkDoc1Received() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallDoc.gotoEnterpriseDocument();
		myAssert.assert_True("unable receive document1",action.waitForExistsByText(PhoneInfo.PekallDocManager_doc1Str));
	}
	public void checkDoc2Received() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallDoc.gotoEnterpriseDocument();
		myAssert.assert_True("unable receive document2",action.waitForExistsByText(PhoneInfo.PekallDocManager_doc2Str));
	}
	
	public void checkUserDocCancelled() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallDoc.gotoEnterpriseDocument();
		myAssert.assert_True("unable cancel user document",action.waitForGone(PhoneInfo.PekallDocManager_userDocStr));
	}
	public void checkUserGroupDocCancelled() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallDoc.gotoEnterpriseDocument();
		myAssert.assert_True("unable cancel user group document",action.waitForGone(PhoneInfo.PekallDocManager_userGroupDocStr));
	}
	public void checkDeviceDocCancelled() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallDoc.gotoEnterpriseDocument();
		myAssert.assert_True("unable cancel device document",action.waitForGone(PhoneInfo.PekallDocManager_deviceDocStr));
	}
	public void checkDeviceGroupDocCancelled() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallDoc.gotoEnterpriseDocument();
		myAssert.assert_True("unable cancel device group document",action.waitForGone(PhoneInfo.PekallDocManager_deviceGroupDocStr));
	}
	public void checkDoc1Cancelled() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallDoc.gotoEnterpriseDocument();
		myAssert.assert_True("unable cancel document1",action.waitForGone(PhoneInfo.PekallDocManager_doc1Str));
	}
	
	public void checkDoc2Deleted() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallDoc.gotoEnterpriseDocument();
		myAssert.assert_True("unable delete document2",action.waitForGone(PhoneInfo.PekallDocManager_doc2Str));
	}
}
