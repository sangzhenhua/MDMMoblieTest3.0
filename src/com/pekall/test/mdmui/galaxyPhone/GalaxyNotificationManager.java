package com.pekall.test.mdmui.galaxyPhone;

import android.os.RemoteException;




import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.pekall.test.mdmui.phone.NavigatorManager;
import com.pekall.test.mdmui.phone.NotificationManager;
import com.pekall.test.mdmui.phone.Phone;
import com.pekall.test.mdmui.phone.PowerManager;
import com.pekall.test.mdmui.util.GoWhere;
import com.pekall.test.mdmui.util.MyAssert;
import com.pekall.test.mdmui.util.PhoneInfo;
import com.pekall.test.mdmui.util.RandomString;
import com.pekall.test.mdmui.util.UiAction;

public class GalaxyNotificationManager extends NotificationManager{
	private static UiAction action = UiAction.getInstance();
	private static NavigatorManager navigatorManager = Phone.getInstance().getNavigatorManager();
	private static PowerManager powerManager = Phone.getInstance().getPowerManager();
	private static MyAssert myAssert = MyAssert.getInstance();
	private static UiDevice device = UiDevice.getInstance();
	
	
	private static GalaxyNotificationManager instance;
	private static String currentPWD =PhoneInfo.DevicePassword;
	private String newPWD =null;
	public static GalaxyNotificationManager getInstance(){
		if(instance == null){
			instance = new GalaxyNotificationManager();
		}
		return instance;
	}
	
	@Override
	public void close() throws RemoteException, UiObjectNotFoundException, InterruptedException{
		powerManager.unlock();
		device.pressBack();
	}
	
	@Override
	public void checkAndroidPWDPloyReceived() throws RemoteException, InterruptedException{
		//navigatorManager.gotoNotificationBar();
		//myAssert.assert_True("unable receive android password ploy",action.waitForExists(GoWhere.Notification,new UiSelector().text(PhoneInfo.PekallAndroidPWDNotificationStr)));
		myAssert.assert_True("unable receive android password ploy",action.waitForExists(GoWhere.Notification,new UiSelector().text(PhoneInfo.PekallAndroidPWDNotificationStr)));
		
		setAndroidPWD(true);
	}
	
	@Override
	public void checkAndroidPWDPloyUpdated() throws RemoteException, InterruptedException{
		//navigatorManager.gotoNotificationBar();
		myAssert.assert_True("unable update android password ploy",action.waitForExists(GoWhere.Notification,new UiSelector().packageName(PhoneInfo.PekallPackage).text(PhoneInfo.PekallAndroidPWDNotificationStr)));
		setAndroidPWD(false);
	}
	
	@Override
	public void setAndroidPWD(boolean isFirst) throws RemoteException, InterruptedException{
		if(isFirst){
			System.out.println("isFirst:"+isFirst);
			newPWD = RandomString.getInstance().getRandomDigitString(5)+RandomString.getInstance().getRandomAlphabetString(1);
			System.out.println("newPWD:"+newPWD);
		}
		else{
			System.out.println("isFirst:"+isFirst);
			newPWD = RandomString.getInstance().getRandomDigitString(9)+RandomString.getInstance().getRandomAlphabetString(2)+RandomString.getInstance().getRandomSpecialString(1);
			System.out.println("newPWD:"+newPWD);
		}
		
		if(action.existsByText(PhoneInfo.PekallPackage, PhoneInfo.PekallAndroidPWDNotificationStr)){
			action.findByTextAndClickForNewWindow(PhoneInfo.PekallPackage, PhoneInfo.PekallAndroidPWDNotificationStr);
			if(action.existsByText(PhoneInfo.SettingsConfirmYouPinStr)){
				action.findBySelectorAndSetText(new UiSelector().className("android.widget.EditText"), PhoneInfo.DevicePassword);
				action.findByBtnTextAndClickForNewWindow(PhoneInfo.SettingsPinConfirmNextBtnStr);
			}
			action.findByTextAndClickForNewWindow(PhoneInfo.SettingsPackage, PhoneInfo.SettingsUnlockPasswordStr);
			
			action.findBySelectorAndSetText(new UiSelector().className("android.widget.EditText").index(2), newPWD);
			if(action.isEnabledByBtnText( PhoneInfo.SettingsUnlockContinueBtnStr)){
				action.findByBtnTextAndClickForNewWindow(PhoneInfo.SettingsPackage, PhoneInfo.SettingsUnlockContinueBtnStr);
				action.findBySelectorAndSetText(new UiSelector().className("android.widget.EditText").index(2),newPWD);
				action.findByBtnTextAndClickForNewWindow(PhoneInfo.SettingsPackage, PhoneInfo.MsgboxOKBtnStr);
				currentPWD = newPWD;
				device.sleep();
				powerManager.checkAndroidPWDLocked();
			}
			else{
				System.out.println("password not meet requirement");
			}	
		}
	}
	
	@Override
	public String getCurrentPWD(){
		System.out.println("get currentPWD:"+currentPWD);
		return currentPWD;
	}

}
