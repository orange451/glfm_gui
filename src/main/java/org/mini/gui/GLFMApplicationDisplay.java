package org.mini.gui;

import org.mini.glfm.Glfm;

public class GLFMApplicationDisplay implements GApplicationDisplay {
	@Override
	public void setDisplayChrome(long display, int value) {
		Glfm.glfmSetDisplayChrome(display, value);
	}

	@Override
	public void setKeyboardVisible(long display, boolean value) {
		Glfm.glfmSetKeyboardVisible(display, value);
	}

	@Override
	public void setUserInterfaceOrientation(long display, int value) {
		Glfm.glfmSetUserInterfaceOrientation(display, value);
	}
}
