package com.ac.designpattern.responsiblitychain;


import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * HandlerRegistery
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yangui</a>
 * @since 2019/12/11
 */
public class HandlerRegistry {

    private List<HandlerRegistration> handlerRegistionList = new ArrayList<>();

    public HandlerRegistration addHandler(Handler handler) {
        HandlerRegistration handlerRegistration = new HandlerRegistration(handler);
        handlerRegistionList.add(handlerRegistration);
        return handlerRegistration;
    }

    public void doHandles() {
        List<Handler> handlerList = getHandlerList();
        for (Handler handler : handlerList) {
            handler.handle();
        }
    }

    public List<Handler> getHandlerList() {
        if (CollectionUtils.isEmpty(handlerRegistionList)) {
            return Collections.EMPTY_LIST;
        }
        List<Handler> handlerList = new ArrayList<>(handlerRegistionList.size());
        for (HandlerRegistration handlerRegistration : handlerRegistionList) {
            if (Objects.isNull(handlerRegistration)) {
                continue;
            }
            Handler handler = handlerRegistration.getHandler();
            handlerList.add(handler);
        }
        return handlerList;
    }
}
