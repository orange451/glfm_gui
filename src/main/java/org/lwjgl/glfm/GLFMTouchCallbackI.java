package org.lwjgl.glfm;

public interface GLFMTouchCallbackI {
	public void invoke(long window, int action, int phase, double x, double y);
}