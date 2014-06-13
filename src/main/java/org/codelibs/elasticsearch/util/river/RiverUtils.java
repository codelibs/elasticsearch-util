package org.codelibs.elasticsearch.util.river;

import org.codelibs.elasticsearch.util.exception.EsUtilSystemException;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.admin.indices.mapping.delete.DeleteMappingResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.river.RiverName;

public final class RiverUtils {

    private RiverUtils() {
    }

    public static void deleteQuietly(final Client client,
            final RiverName riverName) {
        try {
            delete(client, riverName);
        } catch (final EsUtilSystemException e) {
            // ignore
        }
    }

    public static void delete(final Client client, final RiverName riverName) {
        DeleteMappingResponse deleteMappingResponse;
        try {
            deleteMappingResponse = client.admin().indices()
                    .prepareDeleteMapping("_river").setType(riverName.name())
                    .execute().actionGet();
        } catch (final ElasticsearchException e) {
            throw new EsUtilSystemException("Failed to delete "
                    + riverName.name(), e);
        }
        if (!deleteMappingResponse.isAcknowledged()) {
            throw new EsUtilSystemException("Failed to delete "
                    + riverName.name() + ". "
                    + deleteMappingResponse.toString());
        }
    }

}
