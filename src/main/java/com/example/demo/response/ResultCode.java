package com.example.demo.response;

/**
 * @author Peter
 */

public enum ResultCode {
    /// <summary>
    /// SUCCESS
    /// </summary>
    SUCCESS(200),
    /// <summary>
    /// FAIL
    /// </summary>
    FAIL(400),
    /// <summary>
    /// UNAUTHORIZED
    /// </summary>
    UNAUTHORIZED(401),
    /// <summary>
    /// NOT_FOUND
    /// </summary>
    NOT_FOUND(404),
    /// <summary>
    /// INTERNAL_SERVER_ERROR
    /// </summary>
    INTERNAL_SERVER_ERROR(500);

    public int code;

    ResultCode(int code) {
        this.code = code;
    }
}
