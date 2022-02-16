package org.lwjgl.glfw;

public abstract class GLFWWindowPosCallback implements GLFWWindowPosCallbackI {
	
    public GLFWWindowPosCallback set(long window) {
        return this;
    }

    public static GLFWWindowPosCallback createSafe(GLFWWindowPosCallbackI callback) {
    	return new GLFWWindowPosCallback() {
    		@Override
    		public void invoke(long window, int xpos, int ypos) {
    			callback.invoke(window, xpos, ypos);
    		}
    	};
    }
}