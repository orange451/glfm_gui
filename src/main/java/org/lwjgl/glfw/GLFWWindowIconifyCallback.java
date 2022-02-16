package org.lwjgl.glfw;

public abstract class GLFWWindowIconifyCallback implements GLFWWindowIconifyCallbackI {
	
    public GLFWWindowIconifyCallback set(long window) {
        return this;
    }

    public static GLFWWindowIconifyCallback createSafe(GLFWWindowIconifyCallbackI callback) {
    	return new GLFWWindowIconifyCallback() {
    		@Override
    		public void invoke(long window, boolean iconified) {
    			callback.invoke(window, iconified);
    		}
    	};
    }
}