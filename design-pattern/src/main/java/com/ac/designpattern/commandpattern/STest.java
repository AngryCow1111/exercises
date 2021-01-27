package com.ac.designpattern.commandpattern;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.beans.BeanUtils;

import java.util.Map;

/**
 * STest
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yangui</a>
 * @since 2019/11/23
 */
public class STest {
    public static void main(String[] args) {
        Itest itest = new ItestImpl(1, "2");
        ItestImpl itest1 = new ItestImpl();
        BeanUtils.copyProperties(itest, itest1);
        Map<String, Object> stringObjectMap = BeanUtil.beanToMap(itest);
    }
}
