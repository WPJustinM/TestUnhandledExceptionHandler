package com.example.testunhandledexceptionhandler;

import android.os.Handler;
import android.os.Looper;


public class AppCrasher {

    private Handler operationHandler;
    private CustomExceptionHandler exceptionHandler;

    public AppCrasher() {
        operationHandler = new Handler(Looper.getMainLooper());
        exceptionHandler = new CustomExceptionHandler();
    }

    public void crash() {
        this.operationHandler.post(new Runnable() {
            @Override
            public void run() {
                int num = 1;
                int denom = 0;
                int crash = num / denom;
            }
        });
    }
}
