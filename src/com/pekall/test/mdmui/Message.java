package com.pekall.test.mdmui;

import android.os.RemoteException;

import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.pekall.test.mdmui.pekallManager.PekallMessage;
import com.pekall.test.mdmui.phone.NavigatorManager;
import com.pekall.test.mdmui.phone.PekallManager;
import com.pekall.test.mdmui.phone.Phone;
import com.pekall.test.mdmui.phone.PowerManager;
import com.pekall.test.mdmui.util.MyAssert;
import com.pekall.test.mdmui.util.PhoneInfo;
import com.pekall.test.mdmui.util.UiANRWatcher;
import com.pekall.test.mdmui.util.UiAction;


public class Message extends  UiAutomatorTestCase{
	private static MyAssert myAssert = MyAssert.getInstance();
	private static PekallMessage pekallMessage = PekallMessage.getInstance();
	private static PowerManager powerManager = Phone.getInstance().getPowerManager();
	private static UiAction action = UiAction.getInstance();
	static{
		UiANRWatcher.getInstance().run();
	}
	public void checkUserMsgReceived() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallMessage.gotoMessage();
		Thread.sleep(2000);
		myAssert.assert_True("unable receive user msg",action.waitForExistsByText(PhoneInfo.PekallMsgCenter_userMsgSubjectStr));
	}
	
	public void checkUserGroupMsgReceived() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallMessage.gotoMessage();
		Thread.sleep(2000);
		myAssert.assert_True("unable receive user group msg",action.waitForExistsByText(PhoneInfo.PekallMsgCenter_userGroupMsgSubjectStr));
	}
	
	public void checkDeviceMsgReceived() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallMessage.gotoMessage();
		Thread.sleep(2000);
		myAssert.assert_True("unable receive device msg",action.waitForExistsByText(PhoneInfo.PekallMsgCenter_deviceMsgSubjectStr));
	}
	public void checkDeviceGroupMsgReceived() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallMessage.gotoMessage();
		Thread.sleep(2000);
		myAssert.assert_True("unable receive device group msg",action.waitForExistsByText(PhoneInfo.PekallMsgCenter_deviceGroupMsgSubjectStr));
	}
}
