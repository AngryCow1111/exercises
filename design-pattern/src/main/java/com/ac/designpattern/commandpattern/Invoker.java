package com.ac.designpattern.commandpattern;

/**
 * Invoker
 *
 * @author <a href="mailto:yanghui@pingtiao.com">yanghui</a>
 * @since 2019-08-15
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    void invoke() {
        System.out.println(command.getClass().getSimpleName() + "开始执行命令");
        command.execute();
        System.out.println("命令执行结束");
    }
}
