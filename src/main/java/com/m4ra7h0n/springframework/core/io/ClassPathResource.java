package com.m4ra7h0n.springframework.core.io;



import com.m4ra7h0n.springframework.core.util.ClassUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by xjj on 2023/8/24.
 */
public class ClassPathResource extends AbstractResource {

    private final String path;

    private ClassLoader classLoader;

    private Class<?> clazz;

    @Override
    public boolean exists() {
        return super.exists();
    }

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path  = path;
        this.classLoader = classLoader == null ? ClassUtils.getDefaultClassLoader() : classLoader;
    }

    @Override
    public URL getURL() throws IOException {
        return super.getURL();
    }

    @Override
    public File getFile() throws IOException {
        return super.getFile();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is;
        if (this.clazz != null) {
            is = clazz.getResourceAsStream(this.path);
        } else if (this.classLoader != null) {
            is = classLoader.getResourceAsStream(this.path);
        } else {
            is = ClassLoader.getSystemResourceAsStream(this.path);
        }
        if (is == null) {
            throw new FileNotFoundException(getDescription() + " cannot be opened because it does not exist");
        }
        return is;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
