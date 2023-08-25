package com.m4ra7h0n.springframework.core.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by xjj on 2023/8/24.
 */
public abstract class AbstractResource implements Resource {
    @Override
    public boolean exists() {
        try {
            return getFile().exists();
        } catch (IOException e) {
            try {
                InputStream is = getInputStream();
                is.close();
                return true;
            } catch (IOException ex) {
                return false;
            }
        }
    }

    @Override
    public URL getURL() throws IOException {
        throw new FileNotFoundException(getDescription() + " cannot be resolved to URL");
    }

    @Override
    public File getFile() throws IOException {
        throw new FileNotFoundException(getDescription() + " cannot be resolved to absolute file path");
    }
}
