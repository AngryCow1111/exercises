package com.ac.springboot.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;
import org.springframework.util.ReflectionUtils;

/**
 * GenericEvent
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/13
 */
// ResolvableType 为了便于通过反射获得泛型
public class GenericEvent<T> extends ApplicationEvent implements ResolvableTypeProvider {
    public GenericEvent(T source) {
        super(source);
    }

    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(getClass(),
                ResolvableType.forInstance(getSource()));
    }

    @Override
    public T getSource() {
//        ReflectionUtils.rethrowRuntimeException();
        return (T) super.getSource();
    }
}
