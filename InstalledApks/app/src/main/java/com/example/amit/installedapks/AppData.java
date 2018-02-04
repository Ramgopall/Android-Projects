package com.example.amit.installedapks;

import android.app.Application;
import android.content.pm.PackageInfo;

/**
 * Created by Amit on 9/25/2017.
 */

public class AppData extends Application {
    PackageInfo packageInfo;

    public PackageInfo getPackageInfo() {
        return packageInfo;
    }

    public void setPackageInfo(PackageInfo packageInfo) {
        this.packageInfo = packageInfo;
    }

}
