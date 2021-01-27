package com.ac.java8.domain.model;

import lombok.Data;

import java.util.Date;

/**
 * Student
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yangui</a>
 * @since 2019/12/11
 */
@Data
public class Student {
    private Long id;
    private String name;
    private Date birthday;
}
