package com.pekall.test.mdmui.phone;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;



public abstract class SwipeManager extends UiAutomatorTestCase{
	
	public abstract UiObject swipeLeft(int maxSwipes, UiSelector selector);
	 
	public abstract UiObject swipeRight(int maxSwipes, UiSelector selector);
	 
	public abstract UiObject swipeLiftAndRight(int maxSwipes, UiSelector selector);
	 
	public abstract UiObject swipeUpAndDown(int maxSwipes,UiSelector selector);

	public abstract void swipeLeftAndClick(int maxSwipes,UiSelector selector);

	public abstract void swipeRightAndClick(int maxSwipes,UiSelector selector);

	public abstract void swipeLiftAndRightAndClick(int maxSwipes,UiSelector selector);

	public abstract void swipeUpAndDownAndClick(int maxSwipes, UiSelector selector);
}
