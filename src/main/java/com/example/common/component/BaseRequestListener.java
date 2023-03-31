package com.example.common.component;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;

public class BaseRequestListener implements ServletRequestListener {

    public void requestDestroyed (ServletRequestEvent sre) {
    }

    public void requestInitialized (ServletRequestEvent sre) {
    }
}
