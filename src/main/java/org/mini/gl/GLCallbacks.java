package org.mini.gl;

import java.util.HashMap;
import java.util.Map;

import org.lwjgl.glfm.GLFMRenderFuncCallback;
import org.lwjgl.glfm.GLFMTouchCallback;
import org.lwjgl.glfw.GLFWCharCallback;
import org.lwjgl.glfw.GLFWCharModsCallback;
import org.lwjgl.glfw.GLFWCursorEnterCallback;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWFramebufferSizeCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWScrollCallback;
import org.lwjgl.glfw.GLFWWindowCloseCallback;
import org.lwjgl.glfw.GLFWWindowFocusCallback;
import org.lwjgl.glfw.GLFWWindowIconifyCallback;
import org.lwjgl.glfw.GLFWWindowMaximizeCallback;
import org.lwjgl.glfw.GLFWWindowPosCallback;
import org.lwjgl.glfw.GLFWWindowRefreshCallback;
import org.lwjgl.glfw.GLFWWindowSizeCallback;

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
