package com.pekall.test.mdmui.galaxyPhone;

import com.pekall.test.mdmui.phone.CameraManager;

import com.pekall.test.mdmui.phone.NavigatorManager;
import com.pekall.test.mdmui.phone.NotificationManager;
import com.pekall.test.mdmui.phone.PekallManager;
import com.pekall.test.mdmui.phone.Phone;
import com.pekall.test.mdmui.phone.PowerManager;
import com.pekall.test.mdmui.phone.SettingManager;
import com.pekall.test.mdmui.phone.SwipeManager;

public class GalaxyPhone extends Phone{

	@Override
	public NavigatorManager getNavigatorManager() {
		return GalaxyNavigatorManager.getInstance();
	}

	@Override
	public CameraManager getCameraManager() {
		return GalaxyCameraManager.getInstance();
	}

	@Override
	public NotificationManager getNotificationManager() {
		return GalaxyNotificationManager.getInstance();
	}

	@Override
	public PekallManager getPekallManager() {
		return GalaxyPekallManager.getInstance();
	}

	@Override
	public PowerManager getPowerManager() {
		return GalaxyPowerManager.getInstance();
	}

	@Override
	public SettingManager getSettingManager() {
		return GalaxySettingManager.getInstance();
	}

	@Override
	public SwipeManager getSwipeManager() {
		return GalaxySwipeManager.getInstance();
	}
	
}
