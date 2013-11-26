package org.codelibs.elasticsearch.util;

import java.lang.reflect.Field;

import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.common.logging.Loggers;
import org.elasticsearch.common.netty.channel.Channel;
import org.elasticsearch.rest.RestChannel;

public class NettyUtils {
    private static final String CHANNEL_FIELD_NAME = "channel";

    private static final ESLogger logger = Loggers.getLogger(NettyUtils.class);

    private static Field channelField;

    private NettyUtils() {
    }

    public static Channel getChannel(final RestChannel channel) {
        try {
            if (channelField == null) {
                channelField = channel.getClass().getDeclaredField(CHANNEL_FIELD_NAME);
                channelField.setAccessible(true);
            }
            return (Channel) channelField.get(channel);
        } catch (final Exception e) {
            logger.error("Could not load Netty's channel.", e);
        }
        return null;
    }
}
