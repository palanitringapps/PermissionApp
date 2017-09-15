package com.permissionapp;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tringapps-admin on 15/9/17.
 */

public class BaseFragment extends Fragment {
    private int PERMISSION_REQUEST_CODE;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        List<String> deniedPermission = new ArrayList<>(), grantPermission = new ArrayList<>();
        for (String permission : permissions) {
            if (getActivity().checkCallingOrSelfPermission(permission) == PackageManager.PERMISSION_GRANTED) {
                grantPermission.add(permission);
            } else {
                deniedPermission.add(permission);
            }
        }
        if (deniedPermission.size() > 0) {
            onPermissionDenied(deniedPermission.toArray(new String[deniedPermission.size()]), PERMISSION_REQUEST_CODE);
        } else {
            onPermissionGrant(grantPermission.toArray(new String[grantPermission.size()]), PERMISSION_REQUEST_CODE);
        }
    }

    public void onPermissionGrant(String[] permissions, int PERMISSION_REQUEST_CODE) {
    }

    public void onPermissionDenied(String[] permissions, int PERMISSION_REQUEST_CODE) {
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean checkPermission(String[] permissions, int requestCode) {
        PERMISSION_REQUEST_CODE = requestCode;
        if (hasPermission(permissions)) {
            onPermissionGrant(permissions, PERMISSION_REQUEST_CODE);
            return true;
        } else {
            this.requestPermissions(permissions, requestCode);
        }

        return false;
    }

    public boolean hasPermission(String... permissions) {
        for (String permission : permissions) {
            if (getActivity().checkCallingOrSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }
}
