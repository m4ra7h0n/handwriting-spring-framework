package com.m4ra7h0n.springframework.core.util;


/**
 * Created by xjj on 2023/8/24.
 */
public abstract class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Exception e) {

        }
        if (cl == null) {
            cl = ClassUtils.class.getClassLoader();
            if (cl == null) {
                try {
                    cl = ClassLoader.getSystemClassLoader();
                } catch (Exception e) {

                }
            }
        }
        return cl;
    }
}
