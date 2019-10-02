package com.ac.test;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * RecursionDeom
 *
 * @author <a href="mailto:yanghui@pingtiao.com">yanghui</a>
 * @since 2019-08-23
 */
@Data
public class RecursionDemo {
    boolean flag = true;
    static int count = 0;

    public static void recurse() {
        count++;
        if (count < 10) {
            recurse();
        }
        System.out.println("rescure over count: " + count);
    }

    public static void main(String[] args) {
        recurse();
    }
}
