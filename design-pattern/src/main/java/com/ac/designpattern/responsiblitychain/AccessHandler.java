package com.ac.designpattern.responsiblitychain;

/**
 * AccessHandler
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yangui</a>
 * @since 2019/12/11
 */
public class AccessHandler implements Handler {
    @Override
    public void handle() {
        System.out.println("AccessHandler");
    }
}
