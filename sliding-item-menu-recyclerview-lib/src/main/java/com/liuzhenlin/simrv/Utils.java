/*
 * Created on 11/6/18 5:48 PM.
 * Copyright © 2018 刘振林. All rights reserved.
 */

package com.liuzhenlin.simrv;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.view.View;

public class Utils {
    public static boolean isLayoutRtl(@NonNull View view) {
        return ViewCompat.getLayoutDirection(view) == ViewCompat.LAYOUT_DIRECTION_RTL;
    }
}
