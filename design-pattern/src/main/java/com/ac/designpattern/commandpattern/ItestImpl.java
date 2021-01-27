package com.ac.designpattern.commandpattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ItestImpl
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yangui</a>
 * @since 2019/11/23
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItestImpl implements Itest {
    Integer code;
    String name;
}
