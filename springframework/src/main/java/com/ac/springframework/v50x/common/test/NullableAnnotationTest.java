package com.ac.springframework.v50x.common.test;

import com.ac.springframework.v50x.common.annotation.DefaultNullableAnnotationTarget;

/**
 * NullableAnnotationTest
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yanghui</a>
 * @since 2020/5/26
 */
public class NullableAnnotationTest {

    public static void main(String[] args) {
        DefaultNullableAnnotationTarget defaultNullableAnnotationTarget = new DefaultNullableAnnotationTarget();
        defaultNullableAnnotationTarget.check(null);
    }
}
