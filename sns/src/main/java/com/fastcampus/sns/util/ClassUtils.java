package com.fastcampus.sns.util;

import java.util.Optional;

public class ClassUtils {

    public static <T> Optional<T> getSafeCastInstance(Object o, Class<T> clazz) {
        return clazz != null && clazz.isInstance(0) ? Optional.of(clazz.cast(o)) : Optional.empty();
    }
}
