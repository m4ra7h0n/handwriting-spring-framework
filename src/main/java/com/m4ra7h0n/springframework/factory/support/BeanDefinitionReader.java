package com.m4ra7h0n.springframework.factory.support;

import com.m4ra7h0n.springframework.core.io.Resource;
import com.m4ra7h0n.springframework.core.io.support.EncodedResource;


/**
 * Created by xjj on 2023/8/25.
 */
public interface BeanDefinitionReader {

    int loadBeanDefinitions(Resource resource) throws BeanDefinitionStoreException;

    int loadBeanDefinitions(EncodedResource resource) throws BeanDefinitionStoreException;
}
