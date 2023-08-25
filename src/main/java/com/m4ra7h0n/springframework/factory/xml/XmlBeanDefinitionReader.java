package com.m4ra7h0n.springframework.factory.xml;

import com.m4ra7h0n.springframework.core.io.Resource;
import com.m4ra7h0n.springframework.core.io.support.EncodedResource;
import com.m4ra7h0n.springframework.factory.support.BeanDefinitionReader;
import com.m4ra7h0n.springframework.factory.support.BeanDefinitionStoreException;
import com.sun.org.apache.xerces.internal.dom.DocumentImpl;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import java.io.InputStream;

/**
 * Created by xjj on 2023/8/25.
 */
public class XmlBeanDefinitionReader implements BeanDefinitionReader {
    @Override
    public int loadBeanDefinitions(Resource resource) throws BeanDefinitionStoreException {
        return loadBeanDefinitions(new EncodedResource(resource));
    }

    @Override
    public int loadBeanDefinitions(EncodedResource encodedResource) throws BeanDefinitionStoreException {
        try {
            InputStream inputStream = encodedResource.getResource().getInputStream();
            InputSource inputSource = new InputSource(inputStream);
            if (encodedResource.getEncoding() != null) {
                inputSource.setEncoding(encodedResource.getEncoding());
            }
            doLoadBeanDefinitions(inputSource, encodedResource.getResource());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * 用xml注册bean的核心逻辑
     * spring 容器实现基础
     * @param inputSource
     * @param resource
     * @return
     * @throws BeanDefinitionStoreException
     * @throws Exception
     */
    protected int doLoadBeanDefinitions(InputSource inputSource, Resource resource)
            throws BeanDefinitionStoreException, Exception {
        try {
            // 1. 加载xml文件，获取对应的Document
            Document doc = doLoadDocument(inputSource, resource);
            // 2. 根据返回的document，注册bean信息
            return registerBeanDefinitions(doc, resource);
        } catch (Exception e) {
            throw new Exception();
        }
    }


    protected Document doLoadDocument(InputSource inputSource, Resource resource) throws Exception {
//        return this.documentLoader.loadDocument(inputSource, getEntityResolver(), this.errorHandler,
//                getValidationModeForResource(resource), isNamespaceAware());
        return new DocumentImpl();
    }

    public int registerBeanDefinitions(Document doc, Resource resource) throws BeanDefinitionStoreException {
//        BeanDefinitionDocumentReader documentReader = createBeanDefinitionDocumentReader();
//        documentReader.setEnvironment(getEnvironment());
//        int countBefore = getRegistry().getBeanDefinitionCount();
//        documentReader.registerBeanDefinitions(doc, createReaderContext(resource));
//        return getRegistry().getBeanDefinitionCount() - countBefore;
        return 1;
    }
}

