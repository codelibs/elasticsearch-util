package org.codelibs.elasticsearch.util.io;

import java.io.Closeable;
import java.io.IOException;

public final class IOUtils {
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
