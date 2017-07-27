package com.permissionapp;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission(new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION}, 121);
    }

    @Override
    public void onPermissionDenied(String[] permissions, int PERMISSION_REQUEST_CODE) {
        super.onPermissionDenied(permissions, PERMISSION_REQUEST_CODE);
        Log.i("JHfhgsdgjf", "jhgsdsj");
    }

    @Override
    public void onPermissionGrant(String[] permissions, int PERMISSION_REQUEST_CODE) {
        super.onPermissionGrant(permissions, PERMISSION_REQUEST_CODE);
        Log.i("JHfhgsdgjf", "jhgsdsj");
    }
}
