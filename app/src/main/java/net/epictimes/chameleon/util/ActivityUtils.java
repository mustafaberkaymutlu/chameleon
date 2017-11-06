package net.epictimes.chameleon.util;

import android.content.Context;

import net.epictimes.chameleon.R;

public class ActivityUtils {

    public static boolean isTablet(Context context) {
        return context.getResources().getBoolean(R.bool.isTablet);
    }

}