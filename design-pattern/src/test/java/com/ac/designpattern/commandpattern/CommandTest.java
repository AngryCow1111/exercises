package com.ac.designpattern.commandpattern;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * CommandTest
 *
 * @author <a href="mailto:yanghui@pingtiao.com">yanghui</a>
 * @since 2019-08-15
 */
public class CommandTest {

    private Command command;
    private Receiver receiver;

    @Before
    public void init() {
        receiver = new Receiver();
        command = new ConcreteCommand(receiver);
    }

    @Test
    public void execute() {
        Invoker invoker = new Invoker(command);
        invoker.invoke();
    }

    @Test
    public void checkProperties() {
        List<String> origins = new ArrayList<>();
        origins.add("s");
        origins.add("12");

        command = new CheckAttrCommand(origins);
        Invoker invoker = new Invoker(command);
        invoker.invoke();
    }
}