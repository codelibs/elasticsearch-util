package org.codelibs.elasticsearch.util;

import org.elasticsearch.action.ActionListener;

public final class ListenerUtils {
    private ListenerUtils() {
    }

    public static <Response> ActionListener<Response> on(
            final OnResponseListener<Response> responseListener,
            final OnFailureListener failureListener) {
        return new ActionListener<Response>() {

            @Override
            public void onResponse(Response response) {
                responseListener.onResponse(response);
            }

            @Override
            public void onFailure(Throwable e) {
                failureListener.onFailure(e);
            }
        };
    }

    public interface OnResponseListener<Response> {
        public void onResponse(Response response);
    }

    public interface OnFailureListener {
        public void onFailure(Throwable t);
    }
}
