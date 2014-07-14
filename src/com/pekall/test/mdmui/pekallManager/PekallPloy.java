package com.pekall.test.mdmui.pekallManager;

public class PekallPloy {
	private static PekallPloy instance;
	public static PekallPloy getInstance(){
		if(instance == null){
			instance = new PekallPloy();
		}
		return instance;
	}
	
	
}
