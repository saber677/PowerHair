package com.powerhair.backgroundhair.utils.util;

import com.powerhair.backgroundhair.utils.entity.Result;
import com.powerhair.backgroundhair.utils.enums.ResultCodeEnum;
import com.powerhair.backgroundhair.utils.enums.ResultMsgEnum;
import com.sun.org.glassfish.external.statistics.Statistic;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class ResultUtil {

    /**
     * 成功对象
     * 返回携带data、msg的
     *
     * @param msg
     * @param data
     * @return
     */
    public static Result success(String msg, Object data) {
        return successResult(msg, data);
    }

    /**
     * 成功对象
     * 返回携带data的
     *
     * @param data
     * @return
     */
    public static Result success(Object data) {
        return successResult(null, data);
    }

    /**
     * 成功对象
     * 返回携带msg的
     *
     * @param msg
     * @return
     */
    public static Result success(String msg) {
        return successResult(msg, null);
    }

    /**
     * 成功对象
     * 返回默认的
     *
     * @return
     */
    public static Result success() {
        return successResult(null, null);
    }

    /**
     * 失败对象
     * 返回携带data、msg的
     *
     * @param msg
     * @param data
     * @return
     */
    public static Result error(String msg, Object data) {
        return errorResult(msg, data);
    }


    /**
     * 失败对象
     * 返回携带data的
     *
     * @param data
     * @return
     */
    public static Result error(Object data) {
        return errorResult(null, data);
    }

    /**
     * 失败对象
     * 返回携带msg的
     *
     * @param msg
     * @return
     */
    public static Result error(String msg) {
        return errorResult(msg, null);
    }

    /**
     * 失败对象
     * 返回默认的
     *
     * @return
     */
    public static Result error() {
        return errorResult(null, null);
    }


    private static Result errorResult(String msg, Object data) {
        return StringUtils.isEmpty(msg) ? new Result(ResultCodeEnum.ERROR_CODE.getCode(), msg, data) : new Result(ResultCodeEnum.ERROR_CODE.getCode(), ResultMsgEnum.ERROR_MSG_DEFAULT.getMsg(), data);
    }

    private static Result successResult(String msg, Object data) {
        return StringUtils.isEmpty(msg) ? new Result(ResultCodeEnum.SUCCESS_CODE.getCode(), msg, data) : new Result(ResultCodeEnum.SUCCESS_CODE.getCode(), ResultMsgEnum.SUCCESS_MSG_DEFAULT.getMsg(), data);
    }
}
