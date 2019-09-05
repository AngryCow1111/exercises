package com.ac.java8.stream;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * StreamDemo
 *
 * @author <a href="mailto:yanghui@pingtiao.com">yanghui</a>
 * @since 2019-08-10
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<PersonPO> persons = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            PersonPO personPO = new PersonPO();
            personPO.setId(i);
            personPO.setName("hello" + i);
            persons.add(personPO);
        }
        persons.stream()
                .map(personPO -> {
                    PersonDO personDO = new PersonDO();
                    BeanUtils.copyProperties(personPO, personDO);
                    return personDO;
                })
                .toArray();

    }
}
