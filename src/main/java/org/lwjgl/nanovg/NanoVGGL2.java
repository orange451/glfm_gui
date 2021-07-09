package org.lwjgl.nanovg;

import org.mini.nanovg.Nanovg;

public class NanoVGGL2 {

	public static final int NVG_STENCIL_STROKES = Nanovg.NVG_STENCIL_STROKES;
	public static final int NVG_ANTIALIAS = Nanovg.NVG_ANTIALIAS;

	public static int nvglCreateImageFromHandle(long nvg, int texId, int width, int height, int nvgImageFlipy) {
		if ( "org.mini.glfm.GlfmCallBackImpl".equals(System.getProperty("gui.driver")) ) {
			return Nanovg.nvglCreateImageFromHandleGLES3(nvg, texId, width, height, nvgImageFlipy);
		} else {
			return Nanovg.nvglCreateImageFromHandleGL3(nvg, texId, width, height, nvgImageFlipy);
		}
	}

	public static long nvgCreate(int flags) {
		if ( "org.mini.glfm.GlfmCallBackImpl".equals(System.getProperty("gui.driver")) ) {
			return Nanovg.nvgCreateGLES3(flags);
		} else {
			return Nanovg.nvgCreateGL3(flags);
		}
	}

	public static void nvgDelete(long nvgContext) {
		if ( "org.mini.glfm.GlfmCallBackImpl".equals(System.getProperty("gui.driver")) ) {
			Nanovg.nvgDeleteGLES3(nvgContext);
		} else {
			Nanovg.nvgDeleteGL3(nvgContext);
		}
	}
}
