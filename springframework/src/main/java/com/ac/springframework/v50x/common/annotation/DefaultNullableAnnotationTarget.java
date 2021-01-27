package com.ac.springframework.v50x.common.annotation;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * DefaultNullableAnnotationTarget
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yanghui</a>
 * @since 2020/5/26
 */
public class DefaultNullableAnnotationTarget implements NullableAnnotationTarget {
    @NonNull
    public int check(@NonNull Integer param) {
        return 1;
    }
}
