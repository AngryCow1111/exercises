package com.ac.designpattern.responsiblitychain;

import lombok.Data;

/**
 * HandlerRegistion
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yangui</a>
 * @since 2019/12/11
 */
@Data
public class HandlerRegistration {

    private Handler handler;

    public HandlerRegistration(Handler handler) {
        this.handler = handler;
    }
}
