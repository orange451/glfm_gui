package org.mini.glfw;

import org.lwjgl.glfw.GLFWWindowMaximizeCallbackI;

public abstract class GLFWWindowMaximizeCallback implements GLFWWindowMaximizeCallbackI {
	
    public GLFWWindowMaximizeCallback set(long window) {
        return this;
    }

    public static GLFWWindowMaximizeCallback createSafe(GLFWWindowMaximizeCallbackI callback) {
    	return new GLFWWindowMaximizeCallback() {
    		@Override
    		public void invoke(long window, boolean maximized) {
    			callback.invoke(window, maximized);
    		}
    	};
    }
}