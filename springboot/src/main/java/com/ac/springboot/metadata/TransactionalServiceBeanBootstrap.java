package com.ac.springboot.metadata;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.SimpleTransactionStatus;

import java.util.Map;

/**
 * TransactionalServiceBeanBootstrap
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/12
 */
@Configuration
@ComponentScan(basePackageClasses = TransactionalServiceBean.class)
@EnableTransactionManagement
public class TransactionalServiceBeanBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(TransactionalServiceBeanBootstrap.class);

        Map<String, TransactionalServiceBean> beansOfType =
                applicationContext.getBeansOfType(TransactionalServiceBean.class);

        // 循环遍历beansOfType
        beansOfType.forEach((name, bean) -> {
            System.out.println(String.format("bean名称:%s,instance:%s", name, bean.toString()));
            bean.save();
        });
        applicationContext.close();
    }

    @Bean("txManager")
    public PlatformTransactionManager txManager() {
        return new PlatformTransactionManager() {
            @Override
            public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
                return new SimpleTransactionStatus();
            }

            @Override
            public void commit(TransactionStatus status) throws TransactionException {
                System.out.println("txManager 提交");
            }

            @Override
            public void rollback(TransactionStatus status) throws TransactionException {

            }
        };
    }

    @Bean("txManager2")
    public PlatformTransactionManager txManager2() {
        return new PlatformTransactionManager() {
            @Override
            public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
                return new SimpleTransactionStatus();
            }

            @Override
            public void commit(TransactionStatus status) throws TransactionException {
                System.out.println("txManager2 提交");
            }

            @Override
            public void rollback(TransactionStatus status) throws TransactionException {

            }
        };
    }
}
