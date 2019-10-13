package com.ac.springboot.metadata;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

/**
 * TransactionService
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/11
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Transactional
@Service(value = "transactionalService")
//@Service
@Inherited
@Documented
public @interface TransactionalService {
    String value() default "";

//    String transactionManager() default "txManager";

    @AliasFor(value = "transactionManager", annotation = Transactional.class)
    String manager() default "txManager2";
}
