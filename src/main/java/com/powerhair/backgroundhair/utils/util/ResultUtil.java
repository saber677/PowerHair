package com.powerhair.backgroundhair.utils.util;

import com.powerhair.backgroundhair.utils.entity.Result;
import com.powerhair.backgroundhair.utils.enums.ResultEnum;

public class ResultUtil {

    /**
     * 返回响应成功的对象
     *
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static Result success(Integer code, String msg, Object data) {
        return successResult(code, msg, data);
    }


    /**
     * 返回响应失败的对象
     *
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static Result error(Integer code, String msg, Object data) {
        return errorResult(code, msg, data);
    }

    //
    private static Result errorResult(Integer code, String msg) {
        return new Result(code, msg);
    }

    private static Result successResult(Integer code, String msg) {
        return new Result(code, msg);
    }

    private static Result errorResult(Integer code, String msg, Object data) {
        return new Result(code, msg, data);
    }

    private static Result successResult(Integer code, String msg, Object data) {
        return new Result(code, msg, data);
    }
}
