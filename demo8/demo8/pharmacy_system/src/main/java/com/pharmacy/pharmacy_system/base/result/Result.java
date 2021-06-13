package com.pharmacy.pharmacy_system.base.result;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回值
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    /**
     * 返回值
     * 返回成功的情况
     * 适用于查询
     * @param data
     * @return
     */
    public static Result result(Object data) {
        return new Result(ResultCode.SUCCESS.code, MessageConstant.MESSAGE_ALERT_SUCCESS.msg, data);
    }

    /**
     * 返回值
     * 适用于增删改
     * @param operate 增删改的操作结果，大于0时，返回成功，小于0时，返回失败
     * @param data    结果集
     * @return
     */
    public static Result result(int operate, Object data) {
        Result result = new Result(ResultCode.SUCCESS.code, MessageConstant.MESSAGE_ALERT_SUCCESS.msg, data);
        if (operate <= 0) {
            result.setCode(ResultCode.FAIL.code);
            result.setMsg(MessageConstant.MESSAGE_ALERT_ERROR.msg);
        }
        return result;
    }

    /**
     * 返回值
     * 适用于增删改
     * @param operate 增删改的操作结果，大于0时，返回成功，小于0时，返回失败
     * @param success 成功的提示信息
     * @param error   失败的提示信息
     * @return
     */
    public static Result result(int operate, String success, String error) {
        Result result = new Result(ResultCode.SUCCESS.code, success, null);
        if (operate <= 0) {
            result.setCode(ResultCode.FAIL.code);
            result.setMsg(error);
        }
        return result;
    }

    /**
     * 返回值
     * 适用于增删改
     * @param operate 增删改的操作结果，大于0时，返回成功，小于0时，返回失败
     * @param success 成功的提示信息
     * @param error   失败的提示信息
     * @param data    结果集
     * @return
     */
    public static Result result(int operate, String success, String error, Object data) {
        Result result = new Result(ResultCode.SUCCESS.code, success, data);
        if (operate <= 0) {
            result.setCode(ResultCode.FAIL.code);
            result.setMsg(error);
        }
        return result;
    }

    /**
     * 自定义返回内容
     * @param code 返回值代码
     * @param msg  返回值提示信息
     * @param data 返回值内容
     * @return
     */
    public static Result result(ResultCode code, String msg, Object data) {
        return new Result(code.code, msg, data);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
