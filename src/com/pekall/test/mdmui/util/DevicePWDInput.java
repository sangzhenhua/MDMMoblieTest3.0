package com.pekall.test.mdmui.util;

import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;



public class DevicePWDInput extends UiAutomatorTestCase{
	private static UiAction action = UiAction.getInstance();
	private static DevicePWDInput instance;
	public static DevicePWDInput getInstance(){
		if(instance == null){
			instance = new DevicePWDInput();
		}
		return instance;
	}
	
	public void input(String digits){
		for(char digit : digits.toCharArray()){
			if(digit=='0'){
				action.findByBtnTextAndClick(PhoneInfo.AndroidPackage, "0");
			}
			if(digit=='1'){
				action.findByBtnTextAndClick(PhoneInfo.AndroidPackage, "1");
			}
			if(digit=='2'){
				action.findByBtnTextAndClick(PhoneInfo.AndroidPackage, "2 ABC");
			}
			if(digit=='3'){
				action.findByBtnTextAndClick(PhoneInfo.AndroidPackage, "3 DEF");
			}
			if(digit=='4'){
				action.findByBtnTextAndClick(PhoneInfo.AndroidPackage, "4 GHI");
			}
			if(digit=='5'){
				action.findByBtnTextAndClick(PhoneInfo.AndroidPackage, "5 JKL");
			}
			if(digit=='6'){
				action.findByBtnTextAndClick(PhoneInfo.AndroidPackage, "6 MNO");
			}
			if(digit=='7'){
				action.findByBtnTextAndClick(PhoneInfo.AndroidPackage, "7 PQRS");
			}
			if(digit=='8'){
				action.findByBtnTextAndClick(PhoneInfo.AndroidPackage, "8 TUV");
			}
			if(digit=='9'){
				action.findByBtnTextAndClick(PhoneInfo.AndroidPackage, "9 WXYZ");
			}
		}
		action.findBySelectorAndClickForNewWindow(new UiSelector().description(PhoneInfo.DeviceLock_digitInputEnterDescStr));
	}
}
