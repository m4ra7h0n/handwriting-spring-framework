package com.m4ra7h0n.springframework.core.io;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by xjj on 2023/8/24.
 */
public interface Resource extends InputStreamSource {
    // 资源是否存在
    boolean exists();

    // Return a URL handle for this resource.
    URL getURL() throws IOException;

    // Return a File handler for this resource.
    File getFile() throws IOException;

    String getDescription() ;
}

