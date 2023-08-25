package com.m4ra7h0n.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by xjj on 2023/8/24.
 */
public interface InputStreamSource {
    InputStream getInputStream() throws IOException;
}
