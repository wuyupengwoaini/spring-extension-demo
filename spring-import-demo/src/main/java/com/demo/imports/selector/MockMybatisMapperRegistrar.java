package com.demo.imports.selector;

import com.demo.imports.annotation.EnableMybatisMapperScan;
import com.demo.imports.annotation.Mapper;
import com.demo.imports.annotation.Select;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author wuyupeng
 * @Date 2019/10/11 16:46
 **/
public class MockMybatisMapperRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes mapperScanAttrs = AnnotationAttributes
                .fromMap(importingClassMetadata.getAnnotationAttributes(EnableMybatisMapperScan.class.getName()));
        List<String> basePackages = Arrays.stream(mapperScanAttrs.getStringArray("basePackages"))
                .filter(StringUtils::hasText)
                .collect(Collectors.toList());
        ClassPathScanningCandidateComponentProvider scanner = getScanner();
        for (String basePackage:basePackages){
            Set<BeanDefinition> candidateComponents = scanner.findCandidateComponents(basePackage);
            for (BeanDefinition bd:candidateComponents){
                BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(MybatisFactoryBean.class);
                beanDefinitionBuilder.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
                Class beanClz = null;
                try {
                    beanClz = Class.forName(bd.getBeanClassName());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                beanDefinitionBuilder.addPropertyValue("clazz", beanClz);

                registry.registerBeanDefinition(bd.getBeanClassName(), beanDefinitionBuilder.getBeanDefinition());
            }

        }

    }

    /**
     * Gets scanner.
     *
     * @return the scanner
     */
    protected ClassPathScanningCandidateComponentProvider getScanner() {
        ClassPathScanningCandidateComponentProvider scan = new CustomClassPathScanningCandidateComponentProvider(false);
        scan.addIncludeFilter((metadataReader, metadataReaderFactory) -> metadataReader.getClassMetadata().isInterface()
                && metadataReader.getAnnotationMetadata().hasAnnotation(Mapper.class.getName())
        );
        return scan;
    }

    private static class MybatisFactoryBean implements FactoryBean<Object>{
        private Class clazz;
        public void setClazz(Class clazz) {
            this.clazz = clazz;
        }

        @Override
        public Class<?> getObjectType() {
            return clazz;
        }

        @Override
        public Object getObject() {
            return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    Select select = method.getAnnotation(Select.class);
                    String sql = select.value();
                    // 模拟发送sql到db中
                    System.out.println("send sql:"+sql);
                    System.out.println("fetch result from db");
                    return "result";
                }
            });
        }
    }

    private static class CustomClassPathScanningCandidateComponentProvider extends ClassPathScanningCandidateComponentProvider {
        CustomClassPathScanningCandidateComponentProvider(boolean useDefaultFilters) {
            super(useDefaultFilters);
        }

        @Override
        protected boolean isCandidateComponent(
                AnnotatedBeanDefinition beanDefinition) {
            return beanDefinition.getMetadata().isInterface() && beanDefinition.getMetadata().isIndependent();
        }
    }

}
