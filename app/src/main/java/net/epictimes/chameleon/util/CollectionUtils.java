package net.epictimes.chameleon.util;

import android.support.annotation.Nullable;

import java.util.Collection;

public class CollectionUtils {

    private CollectionUtils() {
    }

    public static boolean isEmpty(@Nullable Collection collection) {
        return collection == null || collection.isEmpty();
    }

}
