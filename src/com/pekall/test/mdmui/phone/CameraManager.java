package com.pekall.test.mdmui.phone;

import android.os.RemoteException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public abstract class CameraManager extends UiAutomatorTestCase{
	
	public abstract void checkCameraRestrictPloyReceived() throws RemoteException, InterruptedException;
	
	public abstract void checkCameraRestrictPloyDeleted() throws RemoteException, InterruptedException;
	
}
