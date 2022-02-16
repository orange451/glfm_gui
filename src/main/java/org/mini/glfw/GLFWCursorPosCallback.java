package org.mini.glfw;

import org.lwjgl.glfw.GLFWCursorPosCallbackI;

public abstract class GLFWCursorPosCallback implements GLFWCursorPosCallbackI {
	
    public GLFWCursorPosCallback set(long window) {
        return this;
    }

    public static GLFWCursorPosCallback createSafe(GLFWCursorPosCallbackI callback) {
    	return new GLFWCursorPosCallback() {
    		@Override
    		public void invoke(long window, double xpos, double ypos) {
    			callback.invoke(window, xpos, ypos);
    		}
    	};
    }
}