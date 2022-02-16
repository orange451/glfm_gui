package org.mini.gl;

import java.util.HashMap;
import java.util.Map;

import org.mini.glfm.GLFMRenderFuncCallback;
import org.mini.glfm.GLFMTouchCallback;
import org.mini.glfw.GLFWCharCallback;
import org.mini.glfw.GLFWCharModsCallback;
import org.mini.glfw.GLFWCursorEnterCallback;
import org.mini.glfw.GLFWCursorPosCallback;
import org.mini.glfw.GLFWFramebufferSizeCallback;
import org.mini.glfw.GLFWKeyCallback;
import org.mini.glfw.GLFWMouseButtonCallback;
import org.mini.glfw.GLFWScrollCallback;
import org.mini.glfw.GLFWWindowCloseCallback;
import org.mini.glfw.GLFWWindowFocusCallback;
import org.mini.glfw.GLFWWindowIconifyCallback;
import org.mini.glfw.GLFWWindowMaximizeCallback;
import org.mini.glfw.GLFWWindowPosCallback;
import org.mini.glfw.GLFWWindowRefreshCallback;
import org.mini.glfw.GLFWWindowSizeCallback;

public class GLCallbacks {
	public static Map<Long, GLFWCursorPosCallback> cursorPosCallbacks = new HashMap<>();
	public static Map<Long, GLFWCharCallback> charCallbacks = new HashMap<>();
	public static Map<Long, GLFWKeyCallback> keyCallbacks = new HashMap<>();
	public static Map<Long, GLFWMouseButtonCallback> mouseButtonCallbacks = new HashMap<>();
	public static Map<Long, GLFWWindowFocusCallback> windowFocusCallbacks = new HashMap<>();
	public static Map<Long, GLFWWindowCloseCallback> windowCloseCallbacks = new HashMap<>();
	public static Map<Long, GLFWWindowSizeCallback> windowSizeCallbacks = new HashMap<>();
	public static Map<Long, GLFWScrollCallback> scrollCallbacks = new HashMap<>();
	public static Map<Long, GLFWWindowIconifyCallback> windowIconifyCallbacks = new HashMap<>();
	public static Map<Long, GLFWFramebufferSizeCallback> framebufferSizeCallbacks = new HashMap<>();
	public static Map<Long, GLFWCursorEnterCallback> cursorEnterCallbacks = new HashMap<>();
	public static Map<Long, GLFWCharModsCallback> charModsCallbacks = new HashMap<>();
	public static Map<Long, GLFWWindowPosCallback> windowPosCallbacks = new HashMap<>();
	public static Map<Long, GLFWWindowMaximizeCallback> windowMaximizeCallbacks = new HashMap<>();
	public static Map<Long, GLFWWindowRefreshCallback> windowRefreshCallbacks = new HashMap<>();
	public static Map<Long, GLFMRenderFuncCallback> renderFuncCallbacks = new HashMap<>();
	public static Map<Long, GLFMTouchCallback> touchCallbacks = new HashMap<>();
}
