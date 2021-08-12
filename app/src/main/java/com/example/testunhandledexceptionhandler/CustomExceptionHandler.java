package com.example.testunhandledexceptionhandler;

import android.os.Looper;

import androidx.annotation.NonNull;

public class CustomExceptionHandler implements Thread.UncaughtExceptionHandler {

    private Thread.UncaughtExceptionHandler originalExceptionHandler;

    public CustomExceptionHandler() {
        originalExceptionHandler = Looper.getMainLooper().getThread().getUncaughtExceptionHandler();
        Looper.getMainLooper().getThread().setUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(@NonNull Thread t, @NonNull Throwable e) {
        System.out.println("Handling Exception");
        originalExceptionHandler.uncaughtException(t, e);
    }
}
