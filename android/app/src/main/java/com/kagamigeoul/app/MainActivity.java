package com.kagamigeoul.app;

import android.os.Bundle;

import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Plugins do próprio app precisam ser registrados antes do super.onCreate.
        registerPlugin(VozPlugin.class);
        super.onCreate(savedInstanceState);
    }
}
