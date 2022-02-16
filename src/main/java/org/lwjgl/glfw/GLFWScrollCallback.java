package org.lwjgl.glfw;

public abstract class GLFWScrollCallback implements GLFWScrollCallbackI {
	
    public GLFWScrollCallback set(long window) {
        return this;
    }

    public static GLFWScrollCallback createSafe(GLFWScrollCallbackI callback) {
    	return new GLFWScrollCallback() {
    		@Override
    		public void invoke(long window, double xoffset, double yoffset) {
    			callback.invoke(window, xoffset, yoffset);
    		}
    	};
    }
}