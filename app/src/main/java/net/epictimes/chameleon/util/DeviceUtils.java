package net.epictimes.chameleon.util;

import android.content.Context;
import android.support.annotation.NonNull;

import net.epictimes.chameleon.R;

public class DeviceUtils {

    public static boolean isTablet(@NonNull Context context) {
        return context.getResources().getBoolean(R.bool.isTablet);
    }

}