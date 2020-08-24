package com.example.flutter_bixolon_printer;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {
    int counter;
    int selectedNumber=1;

    private static final String CHANNEL = "ir.ea2.flutter";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new MethodChannel(getFlutterEngine().getDartExecutor().getBinaryMessenger(), CHANNEL).setMethodCallHandler((call, result) -> {


            if (call.method.equals("incrementCounter")) {

                counter = call.argument("counter");

                if (counter != -1) {
                    counter=counter+selectedNumber;
                    result.success(counter);
                    Log.d("JavaCode Result>> ", "counter is : " + counter);

                } else {
                    result.error("UNAVAILABLE", "This Number not available.", null);
                }
            } else {
                result.notImplemented();
            }
        });
    }
}
