package com.pekall.test.mdmui.phone;

import com.pekall.test.mdmui.galaxyPhone.GalaxyPhone;


public abstract class Phone {
	private static Phone instance;
	public static Phone getInstance(){
		if(instance == null){
			instance = new GalaxyPhone();
		}
		return instance;
	}
	

	public abstract NavigatorManager getNavigatorManager();
	
	public abstract CameraManager getCameraManager();
	
	public abstract NotificationManager getNotificationManager();
	
	public abstract PekallManager getPekallManager();
	
	public abstract PowerManager getPowerManager();
	
	public abstract SettingManager getSettingManager();
	
	public abstract SwipeManager getSwipeManager();
	
}
