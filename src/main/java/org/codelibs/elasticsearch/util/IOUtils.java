package org.codelibs.elasticsearch.util;

import java.io.IOException;
import java.io.InputStream;

public class IOUtils {
    private IOUtils() {
    }

    public static void closeQuietly(final InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (final IOException e) {
            }
        }
    }
}
