package com.pekall.test.mdmui;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.pekall.test.mdmui.pekallManager.PekallApp;
import com.pekall.test.mdmui.phone.Phone;
import com.pekall.test.mdmui.phone.PowerManager;
import com.pekall.test.mdmui.util.MyAssert;
import com.pekall.test.mdmui.util.PhoneInfo;
import com.pekall.test.mdmui.util.UiANRWatcher;
import com.pekall.test.mdmui.util.UiAction;

public class App extends UiAutomatorTestCase{
	private static MyAssert myAssert = MyAssert.getInstance();
	private static PekallApp pekallApp = PekallApp.getInstance();
	private static PowerManager powerManager = Phone.getInstance().getPowerManager();	
	private static UiAction action = UiAction.getInstance();
	private static UiDevice device = UiDevice.getInstance();
	
	static{
		UiANRWatcher.getInstance().run();
	}
	public void checkUserAppReceived() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallApp.gotoEnterpriseApp();
		myAssert.assert_True("unable receive user app",action.waitForExistsByText(PhoneInfo.PekallApp_userAppStr));
	
	}
	
	public void checkUserAppDownloadAndInstall()throws RemoteException, InterruptedException{
		action.findByBtnTextAndClick(PhoneInfo.PekallDownloadBtnStr);
		myAssert.assert_True("unable display downloading", action.waitForExistsByText(PhoneInfo.PekallDownloadingStr));
		myAssert.assert_True("unable display pause button", action.waitForExistsByText(PhoneInfo.PekallPauseBtnStr));
		
		action.findByBtnTextAndClick(PhoneInfo.PekallPauseBtnStr);
		action.findByBtnTextAndClickForNewWindow(PhoneInfo.PekallResumeBtnStr);
		myAssert.assert_True("unable download user app", action.waitForExistsByText(PhoneInfo.PekallInstallBtnStr,120000));	
		action.findByBtnTextAndClickForNewWindow(PhoneInfo.PekallInstallBtnStr);
		while(action.existsByBtnText(PhoneInfo.SystemInstallNextStepBtnStr)){
			action.findByBtnTextAndClickForNewWindow(PhoneInfo.SystemInstallNextStepBtnStr);
		}
		action.findByBtnTextAndClickForNewWindow(PhoneInfo.PekallInstallBtnStr);
		action.waitForExistsByText(PhoneInfo.SystemInstallFilishBtnStr,60000);
		action.findByBtnTextAndClickForNewWindow(PhoneInfo.SystemInstallFilishBtnStr);
		myAssert.assert_True("unable install user app", action.waitForExistsByText(PhoneInfo.PekallInstalledBtnStr));	
	
	}
	
	
	public void checkUserGroupAppReceived() throws RemoteException, InterruptedException{
		powerManager.unlock();
		device.openNotification();
		Thread.sleep(1000);
		Phone.getInstance().getSwipeManager().swipeUpAndDownAndClick(2, new UiSelector().textContains(PhoneInfo.PekallApp_userGroupAppStr));
		myAssert.assert_True("unable receive user group app",action.waitForExistsByText(PhoneInfo.PekallApp_userGroupAppStr));
	}
	
	public void checkUserGroupAppDownloadAndInstallInDetail() throws RemoteException, InterruptedException{
		action.findByTextAndClickForNewWindow(PhoneInfo.PekallApp_userGroupAppStr);
		myAssert.assert_True("unable display user group app instroduce", action.existsByText(PhoneInfo.PekallApp_userGroupAppIntroduceStr));
		action.findByBtnTextAndClick(PhoneInfo.PekallDownloadBtnStr);
		myAssert.assert_True("unable download user app", action.waitForExistsByText(PhoneInfo.PekallInstallBtnStr,120000));	
		action.findByBtnTextAndClickForNewWindow(PhoneInfo.PekallInstallBtnStr);
		while(action.existsByBtnText(PhoneInfo.SystemInstallNextStepBtnStr)){
			action.findByBtnTextAndClickForNewWindow(PhoneInfo.SystemInstallNextStepBtnStr);
		}
		action.findByBtnTextAndClickForNewWindow(PhoneInfo.PekallInstallBtnStr);
		action.waitForExistsByText(PhoneInfo.SystemInstallFilishBtnStr,60000);
		action.findByBtnTextAndClickForNewWindow(PhoneInfo.SystemInstallFilishBtnStr);
		myAssert.assert_True("unable install user app", action.waitForExistsByText(PhoneInfo.PekallInstalledBtnStr));	
	
	}
	
	public void checkUserGroupAppUpdate() throws RemoteException, InterruptedException{
		action.findByBtnTextAndClickForNewWindow(PhoneInfo.PekallInstalledBtnStr);
		action.findByBtnTextAndClickForNewWindow(PhoneInfo.PekallInstallBtnStr);
		action.waitForExistsByText(PhoneInfo.SystemInstallFilishBtnStr,60000);
		action.findByBtnTextAndClickForNewWindow(PhoneInfo.SystemInstallFilishBtnStr);
		myAssert.assert_True("unable update user group app", action.existsByBtnText(PhoneInfo.PekallInstalledBtnStr));
	}
	
	public void checkDeviceAppReceived() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallApp.gotoMarketApp();
		myAssert.assert_True("unable receive device app",action.waitForExistsByText(PhoneInfo.PekallApp_deviceAppStr));
	}
	
	public void checkDeviceAppDownloadAndInstall() throws RemoteException, InterruptedException{
		action.findByBtnTextAndClick(PhoneInfo.PekallDownloadBtnStr);
		action.findByTextAndClick(PhoneInfo.PekallApp_marketAppDownloadContainer);
		action.findByBtnTextAndClickForNewWindow(PhoneInfo.PekallApp_marketAppDownlaodContainerSelectStr);
		action.findByTextAndClick(PhoneInfo.PekallInstallBtnStr);
		action.waitForExistsByText(PhoneInfo.PekallOpenBtnStr, 120000);
		while(action.existsByPackage(PhoneInfo.QihooAppStorePackage)){
			device.pressBack();
		}
		myAssert.assert_True("unable display already installed", action.waitForExistsByText(PhoneInfo.PekallInstalledBtnStr));
	}
	
	public void checkDeviceGroupAppReceived() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallApp.gotoEnterpriseApp();
		myAssert.assert_True("unable receive device group app",action.waitForExistsByText(PhoneInfo.PekallApp_deviceGroupAppStr));
	}
	public void checkApp1Received() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallApp.gotoEnterpriseApp();
		myAssert.assert_True("unable receive app1",action.waitForExistsByText(PhoneInfo.PekallApp_app1Str));
	}
	public void checkApp2Received() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallApp.gotoEnterpriseApp();
		myAssert.assert_True("unable receive app2",action.waitForExistsByText(PhoneInfo.PekallApp_app2Str));
	}
	
	public void checkUserAppCancelledAndUninstall() throws RemoteException, InterruptedException{
		powerManager.unlock();
		myAssert.assert_True("unable display uninstal notification", action.waitForExistsByText(PhoneInfo.PekallApp_unintallNotificationStr));
		action.findByBtnTextAndClickForNewWindow(PhoneInfo.MsgboxConfirmBtnStr);
		pekallApp.gotoEnterpriseApp();
		myAssert.assert_True("unable cancel user app",action.waitForGone(PhoneInfo.PekallApp_userAppStr));
	}
	
	public void checkUserGroupAppCancelledAndUninstall() throws RemoteException, InterruptedException{
		powerManager.unlock();
		myAssert.assert_True("unable display uninstal notification", action.waitForExistsByText(PhoneInfo.PekallApp_unintallNotificationStr));
		action.findByBtnTextAndClickForNewWindow(PhoneInfo.MsgboxConfirmBtnStr);
		pekallApp.gotoEnterpriseApp();
		myAssert.assert_True("unable cancel user group app",action.waitForGone(PhoneInfo.PekallApp_userGroupAppStr));
	}
	public void checkDeviceAppCancelledAndUninstall() throws RemoteException, InterruptedException{
		powerManager.unlock();
		myAssert.assert_True("unable display uninstal notification", action.waitForExistsByText(PhoneInfo.PekallApp_unintallNotificationStr));
		action.findByBtnTextAndClickForNewWindow(PhoneInfo.MsgboxConfirmBtnStr);
		pekallApp.gotoMarketApp();
		myAssert.assert_True("unable cancel device app",action.waitForGone(PhoneInfo.PekallApp_userGroupAppStr));
	}
	            
	public void checkDeviceGroupAppCancelled() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallApp.gotoEnterpriseApp();
		myAssert.assert_True("unable cancel device group app",action.waitForGone(PhoneInfo.PekallApp_deviceGroupAppStr));
	}
	public void checkApp1Cancelled() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallApp.gotoEnterpriseApp();
		myAssert.assert_True("unable cancel app1",action.waitForGone(PhoneInfo.PekallApp_app1Str));
	}
	public void checkApp2Deleted() throws RemoteException, InterruptedException{
		powerManager.unlock();
		pekallApp.gotoEnterpriseApp();
		myAssert.assert_True("unable delete app2",action.waitForGone(PhoneInfo.PekallApp_app2Str));
	}
	
}
