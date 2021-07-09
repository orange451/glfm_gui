package org.mini.gui;

public interface GApplicationDisplay {
    public void setDisplayChrome(long display, int value);
    
    public void setKeyboardVisible(long display, boolean value);
    
    public void setUserInterfaceOrientation(long display, int value);
}