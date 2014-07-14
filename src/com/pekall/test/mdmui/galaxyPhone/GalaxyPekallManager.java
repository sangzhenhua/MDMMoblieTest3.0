package com.pekall.test.mdmui.galaxyPhone;



import android.os.RemoteException;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiSelector;
import com.pekall.test.mdmui.phone.NavigatorManager;
import com.pekall.test.mdmui.phone.PekallManager;
import com.pekall.test.mdmui.phone.Phone;
import com.pekall.test.mdmui.phone.SwipeManager;
import com.pekall.test.mdmui.util.MyAssert;
import com.pekall.test.mdmui.util.PhoneInfo;
import com.pekall.test.mdmui.util.UiAction;

public class GalaxyPekallManager extends PekallManager{
	private static  UiAction action = UiAction.getInstance();
	private static NavigatorManager navigatorManager = Phone.getInstance().getNavigatorManager();
	private static SwipeManager swipeManager = Phone.getInstance().getSwipeManager();
	private static MyAssert myAssert = MyAssert.getInstance();
	private static UiDevice device = UiDevice.getInstance();
	
	private static GalaxyPekallManager instance;
	public static GalaxyPekallManager getInstance(){
		if(instance == null){
			instance = new GalaxyPekallManager();
		}
		return instance;
	}
	
	@Override
	public void start() throws InterruptedException, RemoteException {
		navigatorManager.gotoPekall();
		if(action.waitForExists(new UiSelector().resourceId("com.pekall.emdm.launcher:id/circle_indicator"),10000)){
			swipeManager.swipeRight(5, new UiSelector().text(PhoneInfo.pekallStartBtnStr));
		}
		
		if(action.existsByBtnText(PhoneInfo.pekallStartBtnStr)){
			action.findByBtnTextAndClickForNewWindow(PhoneInfo.pekallStartBtnStr);
		}
		if(action.existsByBtnText(PhoneInfo.SettingsDeviceAdminActiveBtnStr)){
			action.findByBtnTextAndClickForNewWindow(PhoneInfo.SettingsDeviceAdminActiveBtnStr);
		}
		if(action.existsByBtnText(PhoneInfo.SettingsDeviceAdminActivateBtnStr)){
			action.findByBtnTextAndClickForNewWindow(PhoneInfo.SettingsDeviceAdminActivateBtnStr);
		}
		
		if(action.existsByText(PhoneInfo.SecEsdkPackage, PhoneInfo.SecPrivacyPolicyStr)){
			action.findByTextAndClickForNewWindow(PhoneInfo.SecEsdkPackage, PhoneInfo.MsgboxCancelBtnStr);	
		}
	}
	
	@Override
	public void firstLogin() throws InterruptedException, RemoteException{   
		Thread.sleep(3000); 
		if(action.existsBySelector(new UiSelector().text(PhoneInfo.PekallLoginServerEditTextHiteStr).enabled(true))){
			action.findBySelectorAndSetText(new UiSelector().text(PhoneInfo.PekallLoginServerEditTextHiteStr), PhoneInfo.PekallURL);	
		}
		if(action.existsBySelector(new UiSelector().text(PhoneInfo.PekallLoginEmailAddressEditTextHiteStr).enabled(true))){
			action.findBySelectorAndSetText(new UiSelector().text(PhoneInfo.PekallLoginEmailAddressEditTextHiteStr), PhoneInfo.PekallEmail);	
		}
	   if(action.existsBySelector(new UiSelector().className("android.widget.EditText").instance(2).enabled(true))){
		   action.findBySelectorAndSetText(new UiSelector().className("android.widget.EditText").instance(2), PhoneInfo.PekallPassword);
	   }
	   else{
		   action.findBySelectorAndSetText(new UiSelector().className("android.widget.EditText").enabled(true),  PhoneInfo.PekallPassword);
	   }
	   device.pressEnter();
		//device.pressBack();
	    action.findByBtnTextAndClickForNewWindow(PhoneInfo.PekallLoginBtnStr);
	    if(action.existsByText(PhoneInfo.PekallPackage, PhoneInfo.PekallSetDefaultDialerStr)){
	    	action.findByTextAndClick(PhoneInfo.AndroidPackage,PhoneInfo.PekallStr);
	    	action.findByBtnTextAndClickForNewWindow(PhoneInfo.MsgboxWaitAlwaysStr);
	    	action.findByTextAndClickForNewWindow(PhoneInfo.PekallPackage, PhoneInfo.PekallStartCloudBaseOfficeStr);
	    	
	    }
	    action.waitForExists(new UiSelector().text(PhoneInfo.PekallPersonalModeStr));
		
	}
	
	@Override
	public void login() throws InterruptedException, RemoteException{
		if(action.existsByBtnText(PhoneInfo.PekallLoginBtnStr)){
			if(action.existsBySelector(new UiSelector().text(PhoneInfo.PekallEmail))){
				System.out.println("login after clear company data");
				action.findBySelectorAndSetText(new UiSelector().className("android.widget.EditText").enabled(true), PhoneInfo.PekallPassword);
				action.findByBtnTextAndClickForNewWindow(PhoneInfo.PekallLoginBtnStr);
				action.waitForExists(new UiSelector().text(PhoneInfo.PekallPersonalModeStr));
				
			}
			else{
				System.out.println("login normaly");
				action.findBySelectorAndSetText(new UiSelector().className("android.widget.EditText"), PhoneInfo.PekallPassword);
				action.findByBtnTextAndClickForNewWindow(PhoneInfo.PekallLoginBtnStr);
				action.waitForExists(new UiSelector().text(PhoneInfo.PekallPersonalModeStr));
				
			}
		}
		else{
			System.out.println("not need login ");
		}
	}
	
	@Override
	public void enterPersonalMode(){
		action.findByTextAndClickForNewWindow(PhoneInfo.PekallPackage,PhoneInfo.PekallPersonalModeStr);
		myAssert.assert_True("unable enter Personal Mode",action.existsBySelector(new UiSelector().packageName("com.sec.android.app.launcher")));
	}
	
	@Override
	public void gotoPekallHome() throws RemoteException, InterruptedException{
		navigatorManager.gotoPekall();
		while(!(action.existsByText(PhoneInfo.PekallAppStr)&&action.existsByText(PhoneInfo.PekallDocCenterStr))){
			device.pressBack();
		}
	}
	
	@Override
	public void gotoPekallItems(String itemStr) throws RemoteException, InterruptedException{
		if(!action.existsByPackage(PhoneInfo.PekallPackage)){
			System.out.println("not in pekall");
			gotoPekallHome();
			if(!action.existsByText(PhoneInfo.PekallPackage, itemStr)){
				System.out.println(itemStr+" not in pekall home");
				action.findBySelectorAndClick(new UiSelector().className("android.widget.ImageView").index(1).clickable(true));
			}
			else{
				System.out.println(itemStr+" in pekall home");
			}
		}
		else{
			System.out.println("in pekall");
			
			if(!action.existsByText(PhoneInfo.PekallPackage, itemStr)){
				System.out.println( itemStr +"  not in pekall list");
				gotoPekallHome();
				if(!action.existsByText(PhoneInfo.PekallPackage, itemStr)){
					System.out.println("not in pekall home");
					action.findBySelectorAndClick(new UiSelector().className("android.widget.ImageView").index(1).clickable(true));
				}else{
					System.out.println("in pekall home");
				}
			}
			else{
				System.out.println(itemStr +" in pekall list or home");
			}
		}
		myAssert.assert_True("unable access pekall "+itemStr,action.existsByText(PhoneInfo.PekallPackage, itemStr));
	}
	
	@Override
	public void checkCompanyDataCleared() throws RemoteException, InterruptedException{
		if(!action.existsByPackage(PhoneInfo.PekallPackage)){
			navigatorManager.gotoPekall();
		}
		else{
			System.out.println("in pekall");
		}
		myAssert.assert_True("unable clear company data",action.waitForExists(new UiSelector().className("android.widget.EditText").text(PhoneInfo.PekallEmail)));
	}
}
