package com.demo.imports.selector;

import com.demo.imports.annotation.EnableSelectService;
import com.demo.imports.service.BizServiceV1;
import com.demo.imports.service.BizServiceV2;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description
 * @Author wuyupeng
 * @Date 2019/10/11 15:49
 **/
public class BizImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata metadata) {

        EnableSelectService.ServiceVersion version = this.getVersionFromAnnotation(metadata);
        String serviceName;
        switch (version){
            case V1:
                serviceName = BizServiceV1.class.getName();
                break;
            case V2:
                serviceName = BizServiceV2.class.getName();
                break;
            default:
                serviceName = null;

        }
        return new String[]{serviceName};

    }

    /**
     * 从EnableSelectService注解中获取对应方法version中的值
     * @param metadata
     * @return
     */
    private EnableSelectService.ServiceVersion getVersionFromAnnotation(AnnotationMetadata metadata){
        Class<?> annType = EnableSelectService.class;

        AnnotationAttributes attributes = AnnotationAttributes.fromMap(metadata.getAnnotationAttributes(annType.getName(), false));

        EnableSelectService.ServiceVersion version = attributes.getEnum("version");
        return version;
    }
}
