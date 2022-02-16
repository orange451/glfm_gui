package org.lwjgl.glfw;

public abstract class GLFWWindowSizeCallback implements GLFWWindowSizeCallbackI {
	
    public GLFWWindowSizeCallback set(long window) {
        return this;
    }

    public static GLFWWindowSizeCallback createSafe(GLFWWindowSizeCallbackI callback) {
    	return new GLFWWindowSizeCallback() {
    		@Override
    		public void invoke(long window, int width, int height) {
    			callback.invoke(window, width, height);
    		}
    	};
    }
}