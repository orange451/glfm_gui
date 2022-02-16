package org.lwjgl.glfw;

public abstract class GLFWWindowCloseCallback implements GLFWWindowCloseCallbackI {
	
    public GLFWWindowCloseCallback set(long window) {
        return this;
    }

    public static GLFWWindowCloseCallback createSafe(GLFWWindowCloseCallbackI callback) {
    	return new GLFWWindowCloseCallback() {
    		@Override
    		public void invoke(long window) {
    			callback.invoke(window);
    		}
    	};
    }
}