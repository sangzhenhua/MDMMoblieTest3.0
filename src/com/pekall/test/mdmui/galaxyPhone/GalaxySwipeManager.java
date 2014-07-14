package com.pekall.test.mdmui.galaxyPhone;

import java.io.File;


import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.pekall.test.mdmui.phone.SwipeManager;
import com.pekall.test.mdmui.util.MyUiObject;


public class GalaxySwipeManager extends SwipeManager {
	private static UiDevice device = UiDevice.getInstance();
	private static GalaxySwipeManager instance;
	public static GalaxySwipeManager getInstance(){
		if(instance == null){
			instance = new GalaxySwipeManager();
		}
		return instance;
	}
	
	@Override
	public UiObject swipeLeft(int maxSwipes,
			UiSelector selector) {
//		System.out.println("swipe left");
//		UiScrollable scrollable = new UiScrollable(new UiSelector().scrollable(true));
//		scrollable.setAsHorizontalList();
//		try {
//			return scrollable.getChild(selector);
//		} catch (UiObjectNotFoundException e) {
//			e.printStackTrace();
//			device.takeScreenshot(new File("/sdcard/mdm/"+selector+".png"));
//		}
//		return null;
		
		System.out.println("maxSwipes:"+maxSwipes);
		UiObject obj = new UiObject(selector);
		if(!obj.exists()){
			for(int i=0;i<maxSwipes;i++){
				device.swipe(0+50, device.getDisplayHeight()/2, device.getDisplayWidth(), device.getDisplayHeight()/2, 10);
				if(obj.exists()){
					break;
				}
			}
		}
		return obj;
	}
	
	@Override
	public void swipeLeftAndClick(int maxSwipes,
			UiSelector selector) {
//		UiScrollable scrollable = new UiScrollable(new UiSelector().scrollable(true));
//		scrollable.setAsHorizontalList();
//		try {
//			scrollable.getChild(selector).clickAndWaitForNewWindow();
//		} catch (UiObjectNotFoundException e) {
//			e.printStackTrace();
//			device.takeScreenshot(new File("/sdcard/mdm/"+selector+".png"));
//		}
		
		System.out.println("maxSwipes:"+maxSwipes);
		UiObject obj = new UiObject(selector);
		if(!obj.exists()){
			for(int i=0;i<maxSwipes;i++){
				device.swipe(0+50, device.getDisplayHeight()/2, device.getDisplayWidth(), device.getDisplayHeight()/2, 10);
				if(obj.exists()){
					break;
				}
			}
		}
		try {
			obj.clickAndWaitForNewWindow();
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
			device.takeScreenshot(new File("/sdcard/mdm/"+selector+".png"));
		}
	}

	@Override
	public UiObject swipeRight(int maxSwipes,
			UiSelector selector) {
		System.out.println("swipe...");
		UiObject obj = new UiObject(selector);
		if(!obj.exists()){
			for(int i=0;i<maxSwipes;i++){
				System.out.println("swipte i:"+i);
				System.out.println("width:"+device.getDisplayWidth());
				System.out.println("height:"+device.getDisplayHeight());
				System.out.println(device);
				device.swipe(device.getDisplayWidth()-50, device.getDisplayHeight()/2, 0+50, device.getDisplayHeight()/2, 10);
				if(obj.exists()){
					return obj;
				}
			}
		}
		return obj;
	}
	
	@Override
	public void swipeRightAndClick(int maxSwipes,
			UiSelector selector) {
		System.out.println("swipe...");
		MyUiObject obj = new MyUiObject(selector);
		if(!obj.exists()){
			for(int i=0;i<maxSwipes;i++){
				System.out.println("swipte i:"+i);
				System.out.println("width:"+device.getDisplayWidth());
				System.out.println("height:"+device.getDisplayHeight());
				System.out.println(device);
				device.swipe(device.getDisplayWidth()-50, device.getDisplayHeight()/2, 0+50, device.getDisplayHeight()/2, 10);
				if(obj.exists()){
					obj.clickAndWaitForNewWindow();
				}
			}
		}
		else{
			obj.clickAndWaitForNewWindow();
		}
	}

	@Override
	public UiObject swipeLiftAndRight(int maxSwipes,
			UiSelector selector) {

		System.out.println("maxSwipes:"+maxSwipes);
		MyUiObject obj = new MyUiObject(selector);
		if(obj.exists()){
			return obj;
		}
		else{
			for(int i=0;i<maxSwipes;i++){
				device.swipe(0+50, device.getDisplayHeight()/2, device.getDisplayWidth(), device.getDisplayHeight()/2, 10);
				if(obj.exists()){
					return obj;
				}
				else{
					System.out.println("continue to swipe");
				}
			}
			for(int i=0;i<maxSwipes;i++){
				device.swipe(device.getDisplayWidth()-50, device.getDisplayHeight()/2, 0+50, device.getDisplayHeight()/2, 10);
				if(obj.exists()){
					return obj;
				}
				else{
					System.out.println("continue to swipe");
				}
			}
		}
		return obj;
	
	}

	@Override
	public void swipeLiftAndRightAndClick(int maxSwipes,
			UiSelector selector) {

		System.out.println("maxSwipes:"+maxSwipes);
		MyUiObject obj = new MyUiObject(selector);
		boolean isContinue = true;
		if(obj.exists()){
			obj.clickAndWaitForNewWindow();
		}
		else{
			for(int i=0;i<maxSwipes;i++){
				device.swipe(0+50, device.getDisplayHeight()/2, device.getDisplayWidth(), device.getDisplayHeight()/2, 10);
				if(obj.exists()){
					isContinue = false;
				
					break;
				}
				else{
					System.out.println("continue to swipe");
				}
			}
			if(isContinue){
				for(int i=0;i<maxSwipes;i++){
					device.swipe(device.getDisplayWidth()-50, device.getDisplayHeight()/2, 0+50, device.getDisplayHeight()/2, 10);
					if(obj.exists()){
						
						break;
					}
					else{
						System.out.println("continue to swipe");
					}
				}
			}
			
			obj.clickAndWaitForNewWindow();
			
		}
	}
	
	@Override
	public UiObject swipeUpAndDown(int maxSwipes,UiSelector selector) {
		System.out.println("maxSwipes:"+maxSwipes);
		UiObject obj = new UiObject(selector);
		if(!obj.exists()){
			for(int i=0;i<maxSwipes;i++){
				device.swipe(device.getDisplayWidth()/2, 200, device.getDisplayWidth()/2, device.getDisplayHeight()-200, 10);
				if(obj.exists()){
					return obj;
				}
				else{
					System.out.println("continue to swipe");
				}
			}
			for(int i=0;i<maxSwipes;i++){
				device.swipe(device.getDisplayWidth()/2, device.getDisplayHeight()-200, device.getDisplayWidth()/2, 200, 10);
				if(obj.exists()){
					return obj;
				}
				else{
					System.out.println("continue to swipe");
				}
			}
		}
		return obj;
		
	}
	
	@Override
	public void swipeUpAndDownAndClick(int maxSwipes, UiSelector selector) {
		System.out.println("maxSwipes:"+maxSwipes);
		MyUiObject obj = new MyUiObject(selector);
		if(!obj.exists()){
			for(int i=0;i<maxSwipes;i++){
				device.swipe(device.getDisplayWidth()/2, 200, device.getDisplayWidth()/2, device.getDisplayHeight()-200, 10);
				if(obj.exists()){
					obj.clickAndWaitForNewWindow();
					break;
				}
				else{
					System.out.println("continue to swipe");
				}
			}
			for(int i=0;i<maxSwipes;i++){
				device.swipe(device.getDisplayWidth()/2, device.getDisplayHeight()-200, device.getDisplayWidth()/2, 200, 10);
				if(obj.exists()){
					obj.clickAndWaitForNewWindow();
					break;
				}
				else{
					System.out.println("continue to swipe");
				}
			}
		}
		else{
			obj.clickAndWaitForNewWindow();
		}
	}
}
