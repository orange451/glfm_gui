package org.lwjgl.glfw;

public abstract class GLFWFramebufferSizeCallback implements GLFWFramebufferSizeCallbackI {
	
    public GLFWFramebufferSizeCallback set(long window) {
        return this;
    }

    public static GLFWFramebufferSizeCallback createSafe(GLFWFramebufferSizeCallbackI callback) {
    	return new GLFWFramebufferSizeCallback() {
    		@Override
    		public void invoke(long window, int width, int height) {
    			callback.invoke(window, width, height);
    		}
    	};
    }
}