package com.pekall.test.mdmui.util;

import android.os.RemoteException;
import android.os.SystemClock;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.pekall.test.mdmui.pekallManager.PekallContacts;
import com.pekall.test.mdmui.pekallManager.PekallDocument;
import com.pekall.test.mdmui.pekallManager.PekallEmail;
import com.pekall.test.mdmui.pekallManager.PekallMessage;
import com.pekall.test.mdmui.phone.NavigatorManager;
import com.pekall.test.mdmui.phone.Phone;


public class UiAction  {
	private static NavigatorManager navigatorManager = Phone.getInstance().getNavigatorManager();
	private static UiAction action = UiAction.getInstance();
	private static UiDevice device = UiDevice.getInstance();
	private static UiAction instance;
	public static UiAction getInstance(){
		if(instance == null){
			instance = new UiAction();
		}
		return instance;
	}
	
	public void findByTextAndClick(String pkgName,String txt){
		MyUiObject obj = new MyUiObject(new UiSelector().packageName(pkgName).className("android.widget.TextView").text(txt));
		obj.click();
	}
	public void findByTextAndClick(String txt){
		MyUiObject obj = new MyUiObject(new UiSelector().className("android.widget.TextView").text(txt));
		obj.click();
	}
	
	public void findByTextAndClickForNewWindow(String txt){
		MyUiObject obj = new MyUiObject(new UiSelector().className("android.widget.TextView").text(txt));
		obj.clickAndWaitForNewWindow();
	}
	
	public void findByTextAndClickForNewWindow(String pkgName,String txt) {
		MyUiObject obj = new MyUiObject(new UiSelector().packageName(pkgName).className("android.widget.TextView").text(txt));
		try {
			System.out.println(obj.getText());
			System.out.println(obj.getBounds());
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}
		obj.clickAndWaitForNewWindow();
	}
	public void findByDescAndClickForNewWindow(String pkgName,String txt){
		MyUiObject obj = new MyUiObject(new UiSelector().packageName(pkgName).description(txt));
		obj.clickAndWaitForNewWindow();
	}
	public void findByBtnTextAndClick(String pkgName,String txt){
		MyUiObject obj = new MyUiObject(new UiSelector().packageName(pkgName).className("android.widget.Button").text(txt));
		obj.click();
	}
	public void findByBtnTextAndClick(String txt){
		MyUiObject obj = new MyUiObject(new UiSelector().className("android.widget.Button").text(txt));
		obj.click();
	}
	public void findByBtnTextAndClickForNewWindow(String pkgName,String txt){
		MyUiObject obj = new MyUiObject(new UiSelector().packageName(pkgName).className("android.widget.Button").text(txt));
		obj.clickAndWaitForNewWindow();
	}
	public void findByBtnTextAndClickForNewWindow(String txt){
		MyUiObject obj = new MyUiObject(new UiSelector().className("android.widget.Button").text(txt));
		obj.clickAndWaitForNewWindow();
	}
	public void findBySelectorAndClick(UiSelector selector){
		MyUiObject obj = new MyUiObject(selector);
		try {
			System.out.println(obj.getVisibleBounds());
		} catch (UiObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		obj.click();
	}
	public void findBySelectorAndClickForNewWindow(UiSelector selector){
		MyUiObject obj = new MyUiObject(selector);
		obj.clickAndWaitForNewWindow();
	}
	
	public void findBySelectorAndSetText(UiSelector selector,String txt){
		MyUiObject obj = new MyUiObject(selector);
		obj.clearTextField();
		obj.setText(txt);
	}
	
	public boolean existsByText(String pkgName,String txt){
		boolean isExists = false;
		MyUiObject obj = new MyUiObject(new UiSelector().packageName(pkgName).className("android.widget.TextView").text(txt));
		isExists = obj.exists();
		return isExists;
	}
	
	public boolean existsByText(String txt){
		boolean isExists = false;
		MyUiObject obj = new MyUiObject(new UiSelector().className("android.widget.TextView").text(txt));
		isExists = obj.exists();
		return isExists;
	}
	
	public boolean existsByDesc(String pkgName,String txt){
		boolean isExists = false;
		MyUiObject obj = new MyUiObject(new UiSelector().packageName(pkgName).description(txt));
		isExists = obj.exists();
		return isExists;
	}
	
	public boolean existsByDesc(String txt){
		boolean isExists = false;
		MyUiObject obj = new MyUiObject(new UiSelector().description(txt));
		isExists = obj.exists();
		return isExists;
	}
	
	public boolean existsByBtnText(String pkgName,String txt){
		boolean isExists = false;
		MyUiObject obj = new MyUiObject(new UiSelector().packageName(pkgName).className("android.widget.Button").text(txt));
		isExists = obj.exists();
		return isExists;
	}
	public boolean existsByBtnText(String txt){
		boolean isExists = false;
		MyUiObject obj = new MyUiObject(new UiSelector().className("android.widget.Button").text(txt));
		isExists = obj.exists();
		return isExists;
	}
	
	public boolean existsBySelector(UiSelector selector){
		boolean isExists = false;
		MyUiObject obj = new MyUiObject(selector);
		isExists = obj.exists();
		return isExists;
	}
	
	public boolean existsByPackage(String pkgName){
		boolean isExists = false;
		MyUiObject obj = new MyUiObject(new UiSelector().packageName(pkgName));
		isExists = obj.exists();
		return isExists;
	}
	
	public boolean isEnabledByBtnText(String txt) {
		boolean isEnabled = false;
		MyUiObject obj = new MyUiObject(new UiSelector().className("android.widget.Button").text(txt));
		try {
			isEnabled = obj.isEnabled();
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}
		return isEnabled;
	}
	
	public boolean waitForExists(UiSelector selector,long timeout) throws RemoteException{
		MyUiObject obj = new MyUiObject(selector);
		return obj.myWaitForExists(timeout);
	}
	
	public boolean waitForGone(UiSelector selector,long timeout) throws RemoteException{
		MyUiObject obj = new MyUiObject(selector);
		return obj.myWaitForGone(timeout);
	}
	
	public boolean waitForGone(UiSelector selector) throws RemoteException{
		MyUiObject obj = new MyUiObject(selector);
		return obj.myWaitForGone();
	}
	
	public boolean waitForGone(String text) throws RemoteException{
		MyUiObject obj = new MyUiObject(new UiSelector().text(text));
		return obj.myWaitForGone();
	}
	
	public boolean waitForExists(UiSelector selector) throws RemoteException{
		MyUiObject obj = new MyUiObject(selector);
		return obj.myWaitForExists();
	}
	
	public boolean waitForExistsByText(String text,long timeout) throws RemoteException{
		MyUiObject obj = new MyUiObject(new UiSelector().text(text));
		return obj.myWaitForExists(timeout);
	}
	
	public boolean waitForExistsByText(String text) throws RemoteException{
		MyUiObject obj = new MyUiObject(new UiSelector().text(text));
		return obj.myWaitForExists();
	}
	
	public boolean waitForExistsByText(String packageName,String text,long timeout) throws RemoteException{
		MyUiObject obj = new MyUiObject(new UiSelector().packageName(packageName).text(text));
		return obj.myWaitForExists(timeout);
	}
	
	public boolean waitForExistsByText(String packageName,String text) throws RemoteException{
		MyUiObject obj = new MyUiObject(new UiSelector().packageName(packageName).text(text));
		return obj.myWaitForExists();
	}
	
	
	public boolean waitForExistsByDesc(String desc,long timeout) throws RemoteException{
		MyUiObject obj = new MyUiObject(new UiSelector().description(desc));
		return obj.myWaitForExists(timeout);
	}
	
	public boolean waitForExistsByDesc(String desc) throws RemoteException{
		MyUiObject obj = new MyUiObject(new UiSelector().description(desc));
		return obj.myWaitForExists();
	}
	
	public boolean waitForExistsByDesc(String packageName,String desc,long timeout) throws RemoteException{
		MyUiObject obj = new MyUiObject(new UiSelector().packageName(packageName).description(desc));
		return obj.myWaitForExists(timeout);
	}
	
	public boolean waitForExistsByDesc(String packageName,String desc) throws RemoteException{
		MyUiObject obj = new MyUiObject(new UiSelector().packageName(packageName).description(desc));
		return obj.myWaitForExists();
	}
	
	
	public boolean waitForExists(GoWhere go,UiSelector selector) throws RemoteException, InterruptedException{
		return waitForExists(go,selector,PhoneInfo.Timeout);
	}
	
	
	
	public boolean waitForExists(GoWhere go,UiSelector selector,long timeout) throws RemoteException, InterruptedException{
		MyUiObject obj = new MyUiObject(selector);
		
		long startMills = SystemClock.uptimeMillis();
        long currentMills = 0;
        long checkMills = SystemClock.uptimeMillis();
      
        Phone.getInstance().getPowerManager().unlock();
     
        switch(go){
        case Camera:
        	navigatorManager.gotoCamera();
        	break;
        case WIFI:
        	navigatorManager.gotoWIFI();
        	break;
        case Notification:
        	device.openNotification();
        	break;
       
        case PekallEmail:
        	PekallEmail.getInstance().goEmail();
        	break;
        }
      
        if(action.existsBySelector(selector)){
        	return true;
        }
        while (currentMills <= timeout) {
        	if(SystemClock.uptimeMillis()-checkMills>5000){
        		checkMills = SystemClock.uptimeMillis();
        		 Phone.getInstance().getPowerManager().unlock();
                switch(go){
                case Camera:
                	navigatorManager.gotoCamera();
                	break;
                case WIFI:
                	navigatorManager.gotoWIFI();
                	break;
                case Notification:
                	device.openNotification();
                	break;
             
                
                case PekallEmail:
                	PekallEmail.getInstance().goEmail();
                	break;
                }
        		
                if(action.existsBySelector(selector)){
                	return true;
                }
                if(timeout - currentMills<5000){
                	break;
                }
        	}
        
            currentMills = SystemClock.uptimeMillis() - startMills;
           
        }
		return false;
	}
	
	public boolean waitForGone(GoWhere go,UiSelector selector,long timeout) throws RemoteException, InterruptedException{
		MyUiObject obj = new MyUiObject(selector);
		
		long startMills = SystemClock.uptimeMillis();
        long currentMills = 0;
        long checkMills = SystemClock.uptimeMillis();
        Phone.getInstance().getPowerManager().unlock();
     
        switch(go){
        case Camera:
        	navigatorManager.gotoCamera();
        	break;
        case WIFI:
        	navigatorManager.gotoWIFI();
        	break;
        case Notification:
        	device.openNotification();
        	break;
      
        case PekallEmail:
        	PekallEmail.getInstance().goEmail();
        	break;
        }
      
        if(!action.existsBySelector(selector)){
        	return true;
        }
        while (currentMills <= timeout) {
        	if(SystemClock.uptimeMillis()-checkMills>10000){
        		checkMills = SystemClock.uptimeMillis();
        		Phone.getInstance().getPowerManager().unlock();

                switch(go){
                case Camera:
                	navigatorManager.gotoCamera();
                	break;
                case WIFI:
                	navigatorManager.gotoWIFI();
                	break;
                case Notification:
                	device.openNotification();
                	break;
           
              
                case PekallEmail:
                	PekallEmail.getInstance().goEmail();
                	break;
                }
        		
                if(!action.existsBySelector(selector)){
                	return true;
                }
        	}
        
            currentMills = SystemClock.uptimeMillis() - startMills;
           
        }
		return false;
	}
	
	public boolean waitForGone(GoWhere go,UiSelector selector) throws RemoteException, InterruptedException{
		return waitForGone(go,selector,PhoneInfo.Timeout);
	}
}
