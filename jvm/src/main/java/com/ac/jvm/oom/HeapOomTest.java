package com.ac.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * HeapOomTest
 * a sample of oom happend on  heap with out of creation num for limit
 *
 * @author <a href="mailto:yanghui@pingtiao.com">yanghui</a>
 * @since 2019-08-26
 */
public class HeapOomTest {

    static class OomObject {

    }

    public static void main(String[] args) {
        List list = new ArrayList();
        while (true) {
            list.add(new OomObject());
        }
    }

}
