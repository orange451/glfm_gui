package org.lwjgl.glfm;

import java.util.HashMap;
import java.util.Map;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCharCallback;
import org.lwjgl.glfw.GLFWCharCallbackI;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWKeyCallbackI;
import org.mini.gl.GLCallbacks;
import org.mini.glfm.Glfm;
import org.mini.glfm.GlfmCallBack;

public class GLFM extends Glfm {

    public static void glfmSetDisplayConfig(long display,
            int preferredAPI,
            int colorFormat,
            int depthFormat,
            int stencilFormat,
            int multisample) {
		Glfm.glfmSetDisplayConfig(display, preferredAPI, colorFormat, depthFormat, stencilFormat, multisample);
		setupCallbacks(display);
	}
    
	public static GLFWCharCallback glfmSetCharCallback(long window, GLFWCharCallbackI callback) {
		return GLCallbacks.charCallbacks.put(window, GLFWCharCallback.createSafe(callback));
	}
	
	public static GLFWKeyCallback glfmSetKeyCallback(long window, GLFWKeyCallbackI callback) {
		return GLCallbacks.keyCallbacks.put(window, GLFWKeyCallback.createSafe(callback));
	}
	
	public static GLFMRenderFuncCallback glfmSetRenderFuncCallback(long window, GLFMRenderFuncCallbackI callback) {
		return GLCallbacks.renderFuncCallbacks.put(window, GLFMRenderFuncCallback.createSafe(callback));
	}
	
	public static GLFMTouchCallback glfmSetTouchCallback(long window, GLFMTouchCallbackI callback) {
		return GLCallbacks.touchCallbacks.put(window, GLFMTouchCallback.createSafe(callback));
	}
	
	private static Map<Long, GlfmCallBack> callbacks = new HashMap<>();
	private static void setupCallbacks(long window) {
		if ( callbacks.containsKey(window) ) 
			return;
		
		if ( "org.mini.glfm.GlfwCallBackImpl".equals(System.getProperty("gui.driver")) )
			return;
		
		callbacks.put(window, new GlfmCallBack() {
			
			{
				Glfm.glfmSetCallBack(window, this);
			}

			@Override
			public void mainLoop(long display, double frameTime) {
				if ( GLCallbacks.renderFuncCallbacks.containsKey(display) )
					GLCallbacks.renderFuncCallbacks.get(display).invoke(display, frameTime);
			}

			@Override
			public boolean onTouch(long display, int touch, int phase, double x, double y) {
				x /= GLFM.glfmGetDisplayScale(display);
				y /= GLFM.glfmGetDisplayScale(display);
				
				// Update mouse position
				if ( phase != GLFM.GLFMTouchPhaseEnded )
					if ( GLCallbacks.cursorPosCallbacks.containsKey(display) )
						GLCallbacks.cursorPosCallbacks.get(display).invoke(display, x, y);
				
				// Port clicking
				if ( GLCallbacks.mouseButtonCallbacks.containsKey(display) && (phase == GLFM.GLFMTouchPhaseBegan || phase == GLFM.GLFMTouchPhaseEnded) )
					GLCallbacks.mouseButtonCallbacks.get(display).invoke(display, GLFW.GLFW_MOUSE_BUTTON_LEFT, phase == GLFM.GLFMTouchPhaseBegan ? GLFW.GLFW_PRESS : GLFW.GLFW_RELEASE, phase);
				
				// Touch event
				if ( GLCallbacks.touchCallbacks.containsKey(display) )
					GLCallbacks.touchCallbacks.get(display).invoke(display, touch, phase, x, y);
				
				// Unset mouse position
				if ( phase == GLFM.GLFMTouchPhaseEnded )
					if ( GLCallbacks.cursorPosCallbacks.containsKey(display) )
						GLCallbacks.cursorPosCallbacks.get(display).invoke(display, Double.MIN_VALUE, Double.MIN_VALUE);
				
				return false;
			}

			@Override
			public boolean onKey(long display, int keyCode, int action, int modifiers) {
				if ( GLCallbacks.keyCallbacks.containsKey(display) )
					GLCallbacks.keyCallbacks.get(display).invoke(display, keyCode, keyCode, action, modifiers);
				return false;
			}

			@Override
			public void onCharacter(long display, String str, int modifiers) {
				if (GLCallbacks.charCallbacks.containsKey(display)) {
					for (int i = 0; i < str.length(); i++) {
						GLCallbacks.charCallbacks.get(display).invoke(display, str.charAt(i));
					}
				}
			}

			@Override
			public void onKeyboardVisible(long display, boolean visible, double x, double y, double w, double h) {
				//
			}

			@Override
			public void onSurfaceError(long display, String description) {
				//
			}

			@Override
			public void onSurfaceCreated(long display, int width, int height) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSurfaceResize(long display, int width, int height) {
				if ( GLCallbacks.framebufferSizeCallbacks.containsKey(display) )
					GLCallbacks.framebufferSizeCallbacks.get(display).invoke(display, width, height);
				
				double pixelRatio = Glfm.glfmGetDisplayScale(display);
				
				if ( GLCallbacks.windowSizeCallbacks.containsKey(display) )
					GLCallbacks.windowSizeCallbacks.get(display).invoke(display, (int)(width/pixelRatio), (int)(height/pixelRatio));
			}

			@Override
			public void onSurfaceDestroyed(long display) {
				//
			}

			@Override
			public void onMemWarning(long display) {
				//
			}

			@Override
			public void onAppFocus(long display, boolean focused) {
				//
			}

			@Override
			public void onPhotoPicked(long display, int uid, String url, byte[] data) {
				//
			}

			@Override
			public void onNotify(long display, String key, String val) {
				//
			}

			@Override
			public void onOrientationChanged(long display, int orientation) {
				//
			}
		});
	}
}
