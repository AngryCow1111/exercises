package com.ac.springboot.metadata;

/**
 * TransactionalServiceBean
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/12
 */
@TransactionalService
public class TransactionalServiceBean {
    public void save() {
        System.out.println("保存.......");
    }
}
