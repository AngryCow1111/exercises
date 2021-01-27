package com.ac.designpattern.responsiblitychain;

/**
 * Test
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yangui</a>
 * @since 2019/12/11
 */
public class Test {
    public static void main(String[] args) {
        HandlerRegistry handlerRegistry = new HandlerRegistry();
        handlerRegistry.addHandler(new ParamHandler());
        handlerRegistry.addHandler(new AccessHandler());
        handlerRegistry.doHandles();
    }
}
