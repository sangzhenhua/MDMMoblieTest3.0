package com.pekall.test.mdmui;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.pekall.test.mdmui.pekallManager.PekallEmail;
import com.pekall.test.mdmui.phone.Phone;
import com.pekall.test.mdmui.util.UiANRWatcher;


public class Email extends UiAutomatorTestCase{
	static{
		UiANRWatcher.getInstance().run();
	}
	public void checkEmailConfigReceived() throws RemoteException, InterruptedException, UiObjectNotFoundException{
		Phone.getInstance().getPowerManager().unlock();
		PekallEmail.getInstance().checkEmailConfigReceived();
		PekallEmail.getInstance().setupAccount();
	}
	
	public void checkEmailConfigUpdated() throws RemoteException, InterruptedException, UiObjectNotFoundException{
		Phone.getInstance().getPowerManager().unlock();
		PekallEmail.getInstance().checkEmailConfigUpdated();
	}
	
	public void checkEmailConfigDeleted() throws RemoteException, InterruptedException, UiObjectNotFoundException{
		Phone.getInstance().getPowerManager().unlock();
		PekallEmail.getInstance().checkEmailConfigDeleted();
	}
}
