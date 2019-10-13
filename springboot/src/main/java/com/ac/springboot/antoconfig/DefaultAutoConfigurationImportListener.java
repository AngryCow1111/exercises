//package com.ac.springboot.antoconfig;
//
//import org.springframework.boot.autoconfigure.AutoConfigurationImportEvent;
//import org.springframework.boot.autoconfigure.AutoConfigurationImportListener;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.core.io.support.SpringFactoriesLoader;
//
//import java.util.List;
//import java.util.Set;
//
///**
// * DefaultAutoConfigurationImportListener
// *
// * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
// * @since 2019/10/13
// */
//public class DefaultAutoConfigurationImportListener implements AutoConfigurationImportListener {
//    @Override
//    public void onAutoConfigurationImportEvent(AutoConfigurationImportEvent event) {
//        ClassLoader classLoader = event.getClass().getClassLoader();
//        // 获得所以候选配置class名单
//        List<String> candidates = SpringFactoriesLoader.loadFactoryNames(EnableAutoConfiguration.class, classLoader);
//        // 实际装配的class名单
//        List<String> candidateConfigurations = event.getCandidateConfigurations();
//        // 要排除的class名单
//        Set<String> exclusions = event.getExclusions();
//        System.out.println(String.format("自动装配class名单：候选数量：%s，排除数量：%s,实际装配数量:%s",
//                candidates.size(), exclusions.size(), candidateConfigurations.size()));
//        System.out.println("------------实际装配名单--------------");
//        candidateConfigurations.forEach(System.out::println);
//        System.out.println("------------排除名单--------------");
//        exclusions.forEach(System.out::println);
//
//    }
//}
