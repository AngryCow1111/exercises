package com.ac.designpattern.responsiblitychain;

/**
 * ParamHandler
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yangui</a>
 * @since 2019/12/11
 */
public class ParamHandler implements Handler {
    @Override
    public void handle() {
        System.out.println("ParamHandler");
    }
}
