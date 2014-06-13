package org.codelibs.elasticsearch.util.admin;

import java.util.List;

import org.codelibs.elasticsearch.util.exception.EsUtilSystemException;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.client.Client;

public final class ClusterUtils {
    private ClusterUtils() {
    }

    public static void waitForAvailable(final Client client,
            final String... indices) {
        final ClusterHealthResponse response = client.admin().cluster()
                .prepareHealth(indices).setWaitForYellowStatus().execute()
                .actionGet();
        final List<String> failures = response.getAllValidationFailures();
        if (!failures.isEmpty()) {
            throw new EsUtilSystemException("Cluster is not available: "
                    + failures.toString());
        }
    }
}
