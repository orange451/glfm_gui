package org.mini.glfw;

import org.lwjgl.glfw.GLFWMouseButtonCallbackI;

public abstract class GLFWMouseButtonCallback implements GLFWMouseButtonCallbackI {
	
    public GLFWMouseButtonCallback set(long window) {
        return this;
    }

    public static GLFWMouseButtonCallback createSafe(GLFWMouseButtonCallbackI callback) {
    	return new GLFWMouseButtonCallback() {
    		@Override
    		public void invoke(long window, int button, int action, int mods) {
    			callback.invoke(window, button, action, mods);
    		}
    	};
    }
}