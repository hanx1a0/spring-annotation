package com.orange.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 2 * @Author: hanx1a0
 * 3 * @Date: 2020/2/26 10:15
 * 4
 */
public class MyImportSelector implements ImportSelector {

    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.orange.bean.Blue", "com.orange.bean.Yellow"};
    }
}
