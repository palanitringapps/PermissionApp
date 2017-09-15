package com.permissionapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SampleFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        checkPermission(new String[]
                {android.Manifest.permission.READ_CONTACTS}, 222);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onPermissionGrant(String[] permissions, int PERMISSION_REQUEST_CODE) {
        super.onPermissionGrant(permissions, PERMISSION_REQUEST_CODE);
        Log.i("jhgh", "grand");
    }

    @Override
    public void onPermissionDenied(String[] permissions, int PERMISSION_REQUEST_CODE) {
        super.onPermissionDenied(permissions, PERMISSION_REQUEST_CODE);
        Log.i("jhgh", "denied");
    }
}
