package com.example.testunhandledexceptionhandler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Thread.UncaughtExceptionHandler {

    private AppCrasher appCrasher;
    private Thread.UncaughtExceptionHandler originalExceptionHandler;

    /**
     * Determines if the application contains custom crash handling logic. If true, we will set the
     * program's default UncaughtExceptionHandler to the MainActivity.
     */
    private boolean customExceptionLogic = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (customExceptionLogic) {
            originalExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }

        appCrasher = new AppCrasher();

    }

    public void crashApplication(View view) {
        appCrasher.crash();
    }

    @Override
    public void uncaughtException(@NonNull Thread t, @NonNull Throwable e) {
        System.out.println("From handler created in MainActivity.java");
        originalExceptionHandler.uncaughtException(t, e);
    }
}