package com.coinceres.uflodemo.holder;

import javax.servlet.http.HttpServletRequest;

/**
 * threadLocal保存request
 */
public class RequestHolder {

    private static final ThreadLocal<HttpServletRequest> threadLocal = new ThreadLocal<>();

    public static void setRequest(HttpServletRequest req) {
        threadLocal.set(req);
    }

    public static HttpServletRequest getRequest() {
        return threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }
}
