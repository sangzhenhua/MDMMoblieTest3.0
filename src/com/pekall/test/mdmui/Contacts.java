package com.pekall.test.mdmui;

import android.os.RemoteException;

import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.pekall.test.mdmui.pekallManager.PekallApp;
import com.pekall.test.mdmui.pekallManager.PekallContacts;
import com.pekall.test.mdmui.phone.Phone;
import com.pekall.test.mdmui.phone.PowerManager;
import com.pekall.test.mdmui.util.MyAssert;
import com.pekall.test.mdmui.util.PhoneInfo;
import com.pekall.test.mdmui.util.UiANRWatcher;
import com.pekall.test.mdmui.util.UiAction;

public class Contacts extends UiAutomatorTestCase{
	private static MyAssert myAssert = MyAssert.getInstance();
	private static PekallContacts pekallContacts = PekallContacts.getInstance();
	private static PowerManager powerManager = Phone.getInstance().getPowerManager();	
	private static UiAction action = UiAction.getInstance();
	static{
		UiANRWatcher.getInstance().run();
	}
	public void checkUserContactsReceived() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallContacts.gotoContactList();
		myAssert.assert_True("unable receive user contacts",action.waitForExistsByText(PhoneInfo.PekallContacts_userContactsStr));
	}
	public void checkUserGroupContactsReceived() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallContacts.gotoContactList();
		myAssert.assert_True("unable receive user group contacts",action.waitForExistsByText(PhoneInfo.PekallContacts_userGroupContactsStr));
	}
	public void checkDeviceContactsReceived() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallContacts.gotoContactList();
		myAssert.assert_True("unable receive device contacts",action.waitForExistsByText(PhoneInfo.PekallContacts_deviceContactsStr));
	}
	public void checkDeviceGroupContactsReceived() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallContacts.gotoContactList();
		myAssert.assert_True("unable receive device group contacts",action.waitForExistsByText(PhoneInfo.PekallContacts_deviceGroupContactsStr));
	}
	public void checkContacts1Received() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallContacts.gotoContactList();
		myAssert.assert_True("unable receive contacts1",action.waitForExistsByText(PhoneInfo.PekallContacts_contacts1Str));
	}
	public void checkContacts2Received() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallContacts.gotoContactList();
		myAssert.assert_True("unable receive contacts2",action.waitForExistsByText(PhoneInfo.PekallContacts_contacts2Str));
	}
	public void checkUserContactsCancelled() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallContacts.gotoContactList();
		myAssert.assert_True("unable cancel user contacts",action.waitForGone(PhoneInfo.PekallContacts_userContactsStr));
	}
	public void checkUserGroupContactsCancelled() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallContacts.gotoContactList();
		myAssert.assert_True("unable cancel user group contacts",action.waitForGone(PhoneInfo.PekallContacts_userGroupContactsStr));
	}
	public void checkDeviceContactsCancelled() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallContacts.gotoContactList();
		myAssert.assert_True("unable cancel device contacts",action.waitForGone(PhoneInfo.PekallContacts_deviceContactsStr));
	}
	public void checkDeviceGroupContactsCancelled() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallContacts.gotoContactList();
		myAssert.assert_True("unable cancel device group contacts",action.waitForGone(PhoneInfo.PekallContacts_deviceGroupContactsStr));
	}
	public void checkContacts1Cancelled() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallContacts.gotoContactList();
		myAssert.assert_True("unable cancel contacts1",action.waitForGone(PhoneInfo.PekallContacts_contacts1Str));
	}
	public void checkContacts2Updated() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallContacts.gotoContactList();
		myAssert.assert_True("unable update contacts2",action.waitForExistsByText(PhoneInfo.PekallContacts_contacts2UpdateStr));
	}
	public void checkContacts2Deleted() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallContacts.gotoContactList();
		myAssert.assert_True("unable delete contacts2",action.waitForGone(PhoneInfo.PekallContacts_contacts2UpdateStr));
	}
	
}
