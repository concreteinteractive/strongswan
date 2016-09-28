package org.strongswan.android.strongswanlib.support;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;

public class StrongSwanHolder {

    private static Class<?> mConfigurationActivityClass;
    private static final Object mConfigurationActivityClassLock = new Object();

    public static void setConfigurationActivityClass(Class<?> configurationActivityClass) {
        synchronized (mConfigurationActivityClassLock) {
            mConfigurationActivityClass = configurationActivityClass;
        }
    }

    public static Class<?> getConfigurationActivityClass() {
        synchronized (mConfigurationActivityClassLock) {
            if (mConfigurationActivityClass == null) {
                throw new NullPointerException("configurationActivityClass == null - StrongSwanHolder not configured");
            }
            return mConfigurationActivityClass;
        }
    }

    private static Application mMainApplication;
    private static final Object mMainApplicationLock = new Object();

    public static void setMainApplication(Application mainApplication) {
        synchronized (mMainApplicationLock) {
            mMainApplication = mainApplication;
        }
    }

    public static Application getMainApplication() {
        synchronized (mMainApplicationLock) {
            return mMainApplication;
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
