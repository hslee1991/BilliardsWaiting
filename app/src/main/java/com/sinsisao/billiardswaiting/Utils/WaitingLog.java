package com.sinsisao.billiardswaiting.Utils;


public class WaitingLog extends Object {
    private static final int DEBUG = 0;
    private static final int RELEASE = 1;

    private static int version = DEBUG;

    public static void d(String log) {
        if (versionDebug()) {
            android.util.Log.d("BilliardsWaiting", log);
        }
    }

    public static void e(String log) {
        android.util.Log.e("BilliardsWaiting", log);
    }

    public static boolean versionDebug() {
        if (version == DEBUG) {
            return true;
        }
        return false;
    }
}
