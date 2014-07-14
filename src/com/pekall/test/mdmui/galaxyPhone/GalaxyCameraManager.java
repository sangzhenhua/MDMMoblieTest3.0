package com.pekall.test.mdmui.galaxyPhone;

import android.os.RemoteException;

import com.android.uiautomator.core.UiSelector;
import com.pekall.test.mdmui.phone.CameraManager;
import com.pekall.test.mdmui.phone.NavigatorManager;
import com.pekall.test.mdmui.phone.Phone;
import com.pekall.test.mdmui.util.GoWhere;
import com.pekall.test.mdmui.util.MyAssert;
import com.pekall.test.mdmui.util.PhoneInfo;
import com.pekall.test.mdmui.util.UiAction;

public class GalaxyCameraManager extends CameraManager{
	private static MyAssert myAssert = MyAssert.getInstance();
	private static UiAction action = UiAction.getInstance();
	private static NavigatorManager navigatorManager = Phone.getInstance().getNavigatorManager();
	private static GalaxyCameraManager instance;
	public static GalaxyCameraManager getInstance(){
		if(instance == null){
			instance = new GalaxyCameraManager();
		}
		return instance;
	}
	
	@Override
	public void checkCameraRestrictPloyReceived()
			throws RemoteException, InterruptedException {
		
		myAssert.assert_True("unable receive camera restrict ploy",action.waitForExists(GoWhere.Camera,new UiSelector().text(PhoneInfo.Camera_restrictStr)));
	}
	
	@Override
	public void checkCameraRestrictPloyDeleted() throws RemoteException, InterruptedException {
		
		myAssert.assert_True("unable receive camera restrict ploy",action.waitForGone(GoWhere.Camera,new UiSelector().text(PhoneInfo.Camera_restrictStr)));
	}
		
	
}
