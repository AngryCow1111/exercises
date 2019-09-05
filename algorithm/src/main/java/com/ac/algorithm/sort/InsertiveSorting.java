package com.ac.algorithm.sort;

import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * InsertiveSorting
 * a simple sample for insertive sorting
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019-08-29
 */
public class InsertiveSorting {

    /**
     * @param srcData source data of list
     * @return a list of {@code Integer} for specified order
     * default ASC if no specified,otherwise for specified order {@code ASC} or {@code DESC}
     */
    public List<Integer> insertiveSorting(List<Integer> srcData) {

        if (CollectionUtils.isEmpty(srcData)) {
            return null;
        }

        if (srcData.size() == 1) {
            return srcData;
        }
        return null;

    }

    public static void main(String[] args) {

    }
}
