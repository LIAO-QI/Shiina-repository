package com.pharmacy.pharmacy_system.base.result;

/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS(200),

    /**
     * 失败
     */
    FAIL(400),

    /**
     * 未认证（签名错误）
     */
    UNAUTHORIZED(401),

    /**
     * 权限不足
     */
    NOPERMISSION(403),

    /**
     * 接口不存在
     */
    NOT_FOUND(404),

    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(500);

    public int code;
    ResultCode(int code) {
        this.code = code;
    }
}
