/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mini.glfm;

import org.mini.apploader.AppLoader;
import org.mini.apploader.Sync;
import org.mini.gl.GL;
import org.mini.gui.GCallBack;
import org.mini.nanovg.Nanovg;

import static org.mini.nanovg.Nanovg.*;

/**
 * @author Gust
 */
public class GlfmCallBackImpl extends GCallBack {

    long display;
    int winWidth, winHeight;
    int fbWidth, fbHeight;
    float pxRatio;

    public int mouseX, mouseY, lastX, lastY;
    long mouseLastPressed;
    int LONG_TOUCH_TIME = 350;
    int LONG_TOUCH_MAX_DISTANCE = 5;//

    int INERTIA_MIN_DISTANCE = 10;//移动距离超过xx单位时可以产生惯性
    int INERTIA_MAX_MILLS = 200;//在300毫秒内的滑动可以产生惯性

    //
    double moveStartX;
    double moveStartY;
    double longStartX;
    double longStartY;
    long moveStartAt;


    long vg;

    float fps;
    float fpsExpect = 60;
    long startAt, cost;
    long last = System.currentTimeMillis(), now;
    int count = 0;

    static GlfmCallBackImpl instance = new GlfmCallBackImpl();

    /**
     * the glinit method call by native function, glfmapp/main.c
     *
     * @param winContext
     */
    static public void glinit(long winContext) {

        Glfm.glfmSetDisplayConfig(winContext,
                Glfm.GLFMRenderingAPIOpenGLES3,
                Glfm.GLFMColorFormatRGBA8888,
                Glfm.GLFMDepthFormat16,
                Glfm.GLFMStencilFormat8,
                Glfm.GLFMMultisampleNone);

        GCallBack.getInstance().setDisplay(winContext);
        Glfm.glfmSetCallBack(winContext, GCallBack.getInstance());
    }

    public static GlfmCallBackImpl getInstance() {
        return instance;
    }

    private GlfmCallBackImpl() {
    }

    public void setDisplay(long display) {
        this.display = display;
    }


    /**
     * @return the fps
     */
    public float getFps() {
        return fps;
    }

    public void setFps(float fps) {
        fpsExpect = fps;
    }


    public long getDisplay() {
        return display;
    }

    public long getNvContext() {
        return vg;
    }

    public int getDeviceWidth() {
        return (int) winWidth;
    }

    public int getDeviceHeight() {
        return (int) winHeight;
    }

    public int getFrameBufferWidth() {
        return (int) fbWidth;
    }

    public int getFrameBufferHeight() {
        return (int) fbHeight;
    }

    public float getDeviceRatio() {
        return pxRatio;
    }

    public String getResRoot() {
        return Glfm.glfmGetResRoot();
    }

    public void setDisplayTitle(String title) {
        ;
    }

    void init() {
        fbWidth = Glfm.glfmGetDisplayWidth(display);
        fbHeight = Glfm.glfmGetDisplayHeight(display);
        // Calculate pixel ration for hi-dpi devices.
        pxRatio = (float) Glfm.glfmGetDisplayScale(display);
        winWidth = (int) (fbWidth / pxRatio);
        winHeight = (int) (fbHeight / pxRatio);

        vg = Nanovg.nvgCreateGLES3(NVG_ANTIALIAS | NVG_STENCIL_STROKES | NVG_DEBUG);
        if (vg == 0) {
            System.out.println("Could not init nanovg.\n");
        } else {
            System.out.println("nanovg success.");
        }
    }

    @Override
    public void mainLoop(long display, double frameTime) {
    	//
    }

    @Override
    public void onSurfaceCreated(long display, int width, int height) {
        //init();
        AppLoader.boot();
        System.out.println("onSurfaceCreated " + width + "," + height + "," + pxRatio);
    }

    @Override
    public boolean onKey(long display, int keyCode, int action, int modifiers) {
        return true;
    }

    @Override
    public void onCharacter(long window, String str, int modifiers) {
    	//
    }

    @Override
    public boolean onTouch(long display, int touch, int phase, double x, double y) {
    	return true;
    }

    @Override
    public void onSurfaceDestroyed(long window) {

    }

    @Override
    public void onSurfaceResize(long window, int width, int height) {
        fbWidth = Glfm.glfmGetDisplayWidth(display);
        fbHeight = Glfm.glfmGetDisplayHeight(display);
        // Calculate pixel ration for hi-dpi devices.
        pxRatio = (float) Glfm.glfmGetDisplayScale(display);
        winWidth = (int) (fbWidth / pxRatio);
        winHeight = (int) (fbHeight / pxRatio);
    }

    public void onSurfaceError(long display, String description) {
    	//
    }

    @Override
    public void onKeyboardVisible(long display, boolean visible, double x, double y, double w, double h) {
        //System.out.println("keyboardVisableEvent:" + display + "," + visible + "," + x + "," + y + "," + w + "," + h);
        //if (gform == null) {
            //return;
        //}
        x /= Glfm.glfmGetDisplayScale(display);
        y /= Glfm.glfmGetDisplayScale(display);
        w /= Glfm.glfmGetDisplayScale(display);
        h /= Glfm.glfmGetDisplayScale(display);
        //gform.KeyboardPopEvent(visible, (float) x, (float) y, (float) w, (float) h);
    }

    @Override
    public void onPhotoPicked(long display, int uid, String url, byte[] data) {
    	//
    }

    @Override
    public void onAppFocus(long display, boolean focused) {
    	//
    }

    @Override
    public void onNotify(long display, String key, String val) {
    	//
    }


    public String getAppSaveRoot() {
        return Glfm.glfmGetSaveRoot();
    }

    public String getAppResRoot() {
        return Glfm.glfmGetResRoot();
    }

    @Override
    public void init(int w, int h) {
        init();
    }

    @Override
    public void destroy() {
        if (vg != 0) {
            Nanovg.nvgDeleteGLES3(vg);
        }
    }


}
