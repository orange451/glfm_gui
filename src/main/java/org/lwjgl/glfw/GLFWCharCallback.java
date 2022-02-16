package org.lwjgl.glfw;

public abstract class GLFWCharCallback implements GLFWCharCallbackI {
    public GLFWCharCallback set(long window) {
        return this;
    }

    public static GLFWCharCallback createSafe(GLFWCharCallbackI callback) {
    	return new GLFWCharCallback() {
    		@Override
    		public void invoke(long window, int codepoint) {
    			callback.invoke(window, codepoint);
    		}
    	};
    }
}
