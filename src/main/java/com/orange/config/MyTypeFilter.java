package com.orange.config;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 2 * @Author: hanx1a0
 * 3 * @Date: 2020/2/25 14:49
 * 4
 * 自定义TypeFilter，实现TypeFilter接口的match
 */
public class MyTypeFilter implements TypeFilter {
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        if(metadataReader.getClassMetadata().getClassName().endsWith("Dao")){
            return true;
        }
        return false;
    }
}

