package net.epictimes.chameleon.util;

import android.support.annotation.Nullable;

import java.util.Collection;

public class CollectionUtils {

    private CollectionUtils() {
    }

    public static boolean isEmpty(@Nullable Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static int size(@Nullable Collection collection) {
        return (collection == null) ? 0 : collection.size();
    }

    public static int size(@Nullable Object[] objects) {
        return (objects == null) ? 0 : objects.length;
    }
}
