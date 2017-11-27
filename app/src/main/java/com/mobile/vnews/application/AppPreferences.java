package com.mobile.vnews.application;

import android.content.SharedPreferences;

public class AppPreferences {

    private static final String KEY_APP_VERSION = "app_version";
    private static final String KEY_APP_LAUNCH_FIRST = "app_launch_first";

    public static void saveVersion(String version) {
        saveString(KEY_APP_VERSION, version);
    }

    public static String getVersion() {
        return getString(KEY_APP_VERSION);
    }

    public static void saveLaunchInfo(boolean value) {
        saveBoolean(KEY_APP_LAUNCH_FIRST, value);
    }

    public static boolean getLaunchInfo() {
        return getBoolean(KEY_APP_LAUNCH_FIRST);
    }

    private static void saveBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
    private static boolean getBoolean(String key) {
        return getSharedPreferences().getBoolean(key, true);
    }
    private static void saveString(String key, String value) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(key, value);
        editor.apply();
    }

    private static String getString(String key) {
        return getSharedPreferences().getString(key, "0");
    }

    private static SharedPreferences getSharedPreferences() {
        return AppCache.getContext().getSharedPreferences("App", 0);
    }

}