package org.mini.glfw;

import org.lwjgl.glfw.GLFWWindowRefreshCallbackI;

public abstract class GLFWWindowRefreshCallback implements GLFWWindowRefreshCallbackI {
	
    public GLFWWindowRefreshCallback set(long window) {
        return this;
    }

    public static GLFWWindowRefreshCallback createSafe(GLFWWindowRefreshCallbackI callback) {
    	return new GLFWWindowRefreshCallback() {
    		@Override
    		public void invoke(long window) {
    			callback.invoke(window);
    		}
    	};
    }
}