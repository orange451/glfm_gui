package org.lwjgl.glfw;

public abstract class GLFWCharModsCallback implements GLFWCharModsCallbackI {
	
    public GLFWCharModsCallback set(long window) {
        return this;
    }

    public static GLFWCharModsCallback createSafe(GLFWCharModsCallbackI callback) {
    	return new GLFWCharModsCallback() {
    		@Override
    		public void invoke(long window, int codepoint, int mods) {
    			callback.invoke(window, codepoint, mods);
    		}
    	};
    }
}