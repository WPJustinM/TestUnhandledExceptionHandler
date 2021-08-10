package com.example.testunhandledexceptionhandler;

import android.os.Looper;

import androidx.annotation.NonNull;

public class CustomExceptionHandler implements Thread.UncaughtExceptionHandler {

    private Thread.UncaughtExceptionHandler originalExceptionHandler;
    private String onExceptionMessage;

    public CustomExceptionHandler(String message) {
        originalExceptionHandler = Looper.getMainLooper().getThread().getUncaughtExceptionHandler();
        Looper.getMainLooper().getThread().setUncaughtExceptionHandler(this);
        onExceptionMessage = message;
    }

    @Override
    public void uncaughtException(@NonNull Thread t, @NonNull Throwable e) {
        System.out.println(onExceptionMessage);
        originalExceptionHandler.uncaughtException(t, e);
    }
}
