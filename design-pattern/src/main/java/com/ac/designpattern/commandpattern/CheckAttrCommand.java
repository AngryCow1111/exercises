package com.ac.designpattern.commandpattern;

import java.util.List;

/**
 * CheckAttrCommand
 *
 * @author <a href="mailto:yanghui@pingtiao.com">yanghui</a>
 * @since 2019-08-15
 */
public class CheckAttrCommand implements Command {

    private List<String> results;

    public CheckAttrCommand(List<String> results) {
        this.results = results;
    }

    @Override
    public void execute() {
        System.out.println("check properties");
        results.stream()
                .map(s -> s.startsWith("s"))
                .forEach(System.out::println);

    }
}
