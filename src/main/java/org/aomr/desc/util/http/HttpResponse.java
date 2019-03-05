package org.aomr.desc.util.http;

import org.apache.http.*;

import java.io.UnsupportedEncodingException;

public class HttpResponse {

    /**
     * 返回中的Header信息
     */
    private Header[] responseHeaders;

    /**
     * String类型的result
     */
    private String stringResult;

    /**
     * btye类型的result
     */
    private byte[] byteResult;

    public Header[] getResponseHeaders() {
        return responseHeaders;
    }

    public void setResponseHeaders(Header[] responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    public byte[] getByteResult() {
        if (byteResult != null) {
            return byteResult;
        }
        if (stringResult != null) {
            return stringResult.getBytes();
        }
        return null;
    }

    public void setByteResult(byte[] byteResult) {
        this.byteResult = byteResult;
    }

    public String getStringResult() {
        String result = null;
        if (stringResult != null) {
            result = stringResult;
        }
        if (byteResult != null) {
            try {
                result = new String(byteResult, "utf8");
            } catch (UnsupportedEncodingException e) {
                result = null;
            }
        }
        return result;
    }

    public void setStringResult(String stringResult) {
        this.stringResult = stringResult;
    }
}
