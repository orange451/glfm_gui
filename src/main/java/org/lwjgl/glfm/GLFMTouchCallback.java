package org.lwjgl.glfm;

public abstract class GLFMTouchCallback implements GLFMTouchCallbackI {
	
    public GLFMTouchCallback set(long window) {
        return this;
    }

    public static GLFMTouchCallback createSafe(GLFMTouchCallbackI callback) {
    	return new GLFMTouchCallback() {
    		@Override
    		public void invoke(long window, int action, int phase, double x, double y) {
    			callback.invoke(window, action, phase, x, y);
    		}
    	};
    }
}