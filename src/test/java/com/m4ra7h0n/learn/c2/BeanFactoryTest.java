package com.m4ra7h0n.learn.c2;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import static org.junit.Assert.assertEquals;

/**
 * Created by xjj on 2023/8/24.
 */
@SuppressWarnings("deprecation")
public class BeanFactoryTest {
    @Test
    public void testSimpleLoad() {

        ClassPathResource resource = new ClassPathResource("c2/beanFactoryTest.xml");
        XmlBeanFactory factory = new XmlBeanFactory(resource);

        MyTestBean bean = (MyTestBean) factory.getBean("myTestBean");
        assertEquals("testStr", bean.getTestStr());
    }
}
