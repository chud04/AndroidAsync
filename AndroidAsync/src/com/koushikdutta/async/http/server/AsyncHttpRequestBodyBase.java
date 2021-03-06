package com.koushikdutta.async.http.server;

import junit.framework.Assert;

import com.koushikdutta.async.FilteredDataCallback;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.AsyncHttpRequestBody;
import com.koushikdutta.async.http.AsyncHttpResponse;

public class AsyncHttpRequestBodyBase extends FilteredDataCallback implements AsyncHttpRequestBody {
    public AsyncHttpRequestBodyBase(String contentType) {
        mContentType = contentType;
    }

    @Override
    public void write(AsyncHttpRequest request, AsyncHttpResponse sink) {
        Assert.fail();
    }

    private String mContentType;
    @Override
    public String getContentType() {
        return mContentType;
    }

    @Override
    public void onCompleted(Exception ex) {
        CompletedCallback callback = getEndCallback();
        if (callback != null)
            callback.onCompleted(ex);
    }

    @Override
    public boolean readFullyOnRequest() {
        return false;
    }

    @Override
    public int length() {
        return -1;
    }
}
