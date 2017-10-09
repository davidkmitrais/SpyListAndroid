package com.davidk.oneStopClick;

import android.app.Application;
import android.util.Log;

import com.davidk.oneStopClick.Dependencies.DependencyRegistry;
import com.davidk.oneStopClick.ModelLayer.Network.MockWebServer;
import java.io.IOException;
import io.realm.Realm;

public class OneStopClickApplication extends Application {

    private static final String TAG = "OneStopClickApplication";

    MockWebServer server;
    private DependencyRegistry registry;

    @Override
    public void onCreate() {
        super.onCreate();

        //Realm.init must be called before assigning the DependencyRegistry
        Realm.init(this);

        //Forces initialization of DependencyRegistry
        registry = DependencyRegistry.shared;

        try {
            server = new MockWebServer();
            Log.d(TAG, "Web Server Initialized");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, "Failed to create Web Server");
        }
    }
}
