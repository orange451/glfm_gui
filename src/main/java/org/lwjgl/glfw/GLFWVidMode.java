package org.lwjgl.glfw;

public class GLFWVidMode {
	
	private final int width;
	
	private final int height;

	public GLFWVidMode(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int width() {
		return this.width;
	}

	public int height() {
		return this.height;
	}

	public int refreshRate() {
		return 60;
	}
}
