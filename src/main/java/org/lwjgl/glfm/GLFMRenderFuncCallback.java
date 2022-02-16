package org.lwjgl.glfm;

public abstract class GLFMRenderFuncCallback implements GLFMRenderFuncCallbackI {
	
    public GLFMRenderFuncCallback set(long window) {
        return this;
    }

    public static GLFMRenderFuncCallback createSafe(GLFMRenderFuncCallbackI callback) {
    	return new GLFMRenderFuncCallback() {
    		@Override
    		public void invoke(long window, double frameTime) {
    			callback.invoke(window, frameTime);
    		}
    	};
    }
}