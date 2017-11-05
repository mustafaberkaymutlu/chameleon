package net.epictimes.owl.util;

import android.content.Context;

import net.epictimes.owl.R;

public class ActivityUtils {

    public static boolean isTablet(Context context) {
        return context.getResources().getBoolean(R.bool.isTablet);
    }

}