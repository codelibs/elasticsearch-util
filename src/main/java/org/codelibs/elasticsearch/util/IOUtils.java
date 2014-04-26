package org.codelibs.elasticsearch.util;

import java.io.Closeable;
import java.io.IOException;

public class IOUtils {
    private IOUtils() {
    }

    public static void closeQuietly(final Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (final IOException e) {
            }
        }
    }
}
