package org.strongswan.android.strongswanlib.support;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;

public class StrongSwanHolder {

    private static Class<?> configurationActivityClass;
    private static final Object configurationActivityClassLock = new Object();

    public static void setConfigurationActivityClass(Class<?> configurationActivityClass) {
        synchronized (configurationActivityClassLock) {
            configurationActivityClass = configurationActivityClass;
        }
    }

    public static Class<?> getConfigurationActivityClass() {
        synchronized (configurationActivityClassLock) {
            if (configurationActivityClass == null) {
                throw new NullPointerException("configurationActivityClass == null - StrongSwanHolder not configured");
            }
            return configurationActivityClass;
        }
    }

    private static Application mainApplication;
    private static final Object mainApplicationLock = new Object();

    public static void setMainApplication(Application mainApplication) {
        synchronized (mainApplicationLock) {
            StrongSwanHolder.mainApplication = mainApplication;
        }
    }

    public static Application getMainApplication() {
        synchronized (mainApplicationLock) {
            return mainApplication;
        }
    }

    public static Context getContext() {
        Application app = getMainApplication();
        if (app == null) {
            throw new NullPointerException("Main application is null - StrongSwanHolder not configured");
        }
        return app.getApplicationContext();
    }
}
