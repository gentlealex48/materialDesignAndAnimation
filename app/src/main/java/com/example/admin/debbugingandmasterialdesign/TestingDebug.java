package com.example.admin.debbugingandmasterialdesign;

import android.util.Log;

import java.util.ArrayList;

public class TestingDebug {

    public static String memoryKiller(String passedString) {
        ArrayList<String> list = new ArrayList<>();
        Log.d("_TAG", "MemoryKiller" + passedString);
        list.add(memoryKiller(passedString));
        return "jajajajaja";
    }
}
