package org.mini.glfw;

import org.lwjgl.glfw.GLFWWindowFocusCallbackI;

public abstract class GLFWWindowFocusCallback implements GLFWWindowFocusCallbackI {
	
    public GLFWWindowFocusCallback set(long window) {
        return this;
    }

    public static GLFWWindowFocusCallback createSafe(GLFWWindowFocusCallbackI callback) {
    	return new GLFWWindowFocusCallback() {
    		@Override
    		public void invoke(long window, boolean focused) {
    			callback.invoke(window, focused);
    		}
    	};
    }
}