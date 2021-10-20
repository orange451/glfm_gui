package org.mini.gl;

import java.util.HashMap;
import java.util.Map;

import org.lwjgl.glfm.GLFMRenderFuncCallbackI;
import org.lwjgl.glfm.GLFMTouchCallbackI;
import org.lwjgl.glfw.GLFWCharCallbackI;
import org.lwjgl.glfw.GLFWCharModsCallbackI;
import org.lwjgl.glfw.GLFWCursorEnterCallbackI;
import org.lwjgl.glfw.GLFWCursorPosCallbackI;
import org.lwjgl.glfw.GLFWFramebufferSizeCallbackI;
import org.lwjgl.glfw.GLFWKeyCallbackI;
import org.lwjgl.glfw.GLFWMouseButtonCallbackI;
import org.lwjgl.glfw.GLFWScrollCallbackI;
import org.lwjgl.glfw.GLFWWindowCloseCallbackI;
import org.lwjgl.glfw.GLFWWindowFocusCallbackI;
import org.lwjgl.glfw.GLFWWindowIconifyCallbackI;
import org.lwjgl.glfw.GLFWWindowMaximizeCallbackI;
import org.lwjgl.glfw.GLFWWindowPosCallbackI;
import org.lwjgl.glfw.GLFWWindowRefreshCallbackI;
import org.lwjgl.glfw.GLFWWindowSizeCallbackI;

public class GLCallbacks {

	public static Map<Long, GLFWCursorPosCallbackI> cursorPosCallbacks = new HashMap<>();
	public static Map<Long, GLFWCharCallbackI> charCallbacks = new HashMap<>();
	public static Map<Long, GLFWKeyCallbackI> keyCallbacks = new HashMap<>();
	public static Map<Long, GLFWMouseButtonCallbackI> mouseButtonCallbacks = new HashMap<>();
	public static Map<Long, GLFWWindowFocusCallbackI> windowFocusCallbacks = new HashMap<>();
	public static Map<Long, GLFWWindowCloseCallbackI> windowCloseCallbacks = new HashMap<>();
	public static Map<Long, GLFWWindowSizeCallbackI> windowSizeCallbacks = new HashMap<>();
	public static Map<Long, GLFWScrollCallbackI> scrollCallbacks = new HashMap<>();
	public static Map<Long, GLFWWindowIconifyCallbackI> windowIconifyCallbacks = new HashMap<>();
	public static Map<Long, GLFWFramebufferSizeCallbackI> framebufferSizeCallbacks = new HashMap<>();
	public static Map<Long, GLFWCursorEnterCallbackI> cursorEnterCallbacks = new HashMap<>();
	public static Map<Long, GLFWCharModsCallbackI> charModsCallbacks = new HashMap<>();
	public static Map<Long, GLFWWindowPosCallbackI> windowPosCallbacks = new HashMap<>();
	public static Map<Long, GLFWWindowMaximizeCallbackI> windowMaximizeCallbacks = new HashMap<>();
	public static Map<Long, GLFWWindowRefreshCallbackI> windowRefreshCallbacks = new HashMap<>();
	public static Map<Long, GLFMRenderFuncCallbackI> renderFuncCallbacks = new HashMap<>();
	public static Map<Long, GLFMTouchCallbackI> touchCallbacks = new HashMap<>();
}
