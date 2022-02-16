package org.lwjgl.glfw;

public abstract class GLFWKeyCallback implements GLFWKeyCallbackI {
	
    public GLFWKeyCallback set(long window) {
        return this;
    }

    public static GLFWKeyCallback createSafe(GLFWKeyCallbackI callback) {
    	return new GLFWKeyCallback() {
    		@Override
    		public void invoke(long window, int key, int scancode, int action, int mods) {
    			callback.invoke(window, key, scancode, action, mods);
    		}
    	};
    }
}