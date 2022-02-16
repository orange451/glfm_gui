package org.lwjgl.glfw;

public abstract class GLFWCursorEnterCallback implements GLFWCursorEnterCallbackI {
	
    public GLFWCursorEnterCallback set(long window) {
        return this;
    }

    public static GLFWCursorEnterCallback createSafe(GLFWCursorEnterCallbackI callback) {
    	return new GLFWCursorEnterCallback() {
    		@Override
    		public void invoke(long window, boolean entered) {
    			callback.invoke(window, entered);
    		}
    	};
    }
}