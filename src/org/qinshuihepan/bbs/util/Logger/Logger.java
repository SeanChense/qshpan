package org.qinshuihepan.bbs.util.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import android.util.Log;

public final class Logger {
    static String MODULE_NAME="WESHARE";

    //当前文件名 行号 函数名
    public static String getFileLineMethod() {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
        StringBuffer toStringBuffer = new StringBuffer("[").append(
                traceElement.getFileName()).append(" | ").append(
                traceElement.getLineNumber()).append(" | ").append(
                traceElement.getMethodName()).append("()").append("]");
        return toStringBuffer.toString();
    }
    // 当前文件名
    public static String _FILE_() {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
        return traceElement.getFileName();
    }

    // 当前方法名
    public static String _FUNC_() {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
        return traceElement.getMethodName();
    }

    // 当前行号
    public static int _LINE_() {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
        return traceElement.getLineNumber();
    }

    // 当前时间
    public static String _TIME_() {
        Date now = new Date(0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return sdf.format(now);

    }

    public static String makeTag(String tag) {
        tag = MODULE_NAME;

        // get current file name: "Logger.java"
        StackTraceElement selfTrace = ((new Exception()).getStackTrace())[0];
        String selfFilename = selfTrace.getFileName();

        // trace down to the module other than Logger class itself
        int i=1;
        StackTraceElement traceElement;
        do {
            traceElement = ((new Exception()).getStackTrace())[i++];
        }
        while (traceElement.getFileName().equalsIgnoreCase(selfFilename));

        StringBuffer toStringBuffer = new StringBuffer("").append(
                tag).append("[").append(
                traceElement.getFileName()).append("#").append(
                traceElement.getLineNumber()).append("@").append(
                traceElement.getMethodName()).append("()]");
        return toStringBuffer.toString();
    }

    public static void v(String msg) {
        Logger.v(MODULE_NAME,msg);
    }
    public static void v(String tag, String msg) {
        String TAG = Logger.makeTag(tag);
        Log.v(TAG, msg);
    }
    public static void d(String msg) {
        Logger.d(MODULE_NAME,msg);
    }
    public static  void d(String tag, String msg) {
        String TAG = Logger.makeTag(tag);
        Log.d("\033[0;34m" + TAG , msg + "\033[0m");
    }
    public static void i(String msg) {
        Logger.i(MODULE_NAME,msg);
    }

    public static void i(String tag, String msg) {
        String TAG = Logger.makeTag(tag);
        Log.i("\033[0;32m" + TAG,msg + "\033[0m");
    }
    public static void w(String msg) {
        Logger.w(MODULE_NAME,msg);
    }

    public static void w(String tag, String msg) {
        String TAG = Logger.makeTag(tag);
        Log.w("\033[0;33m" + TAG,msg + "\033[0m");
    }
    public static void e(String msg) {
        Logger.e(MODULE_NAME,msg);
    }

    public static void e(String tag, String msg) {
        String TAG = Logger.makeTag(tag);
        Log.e("\033[0;31m" + TAG,msg + "\033[0m");
    }

    public static void ENTER() {
        v("Entering...");
    }

    public static void LEAVE() {
        v("Leaving...");
    }

    public static void FOOTPRINT() { Logger.v(">>>>>>>>>> footprint <<<<<<<<<<"); }
    public static void SEPARATOR() { Logger.v("------------------------------------------------------------------------"); }
}
