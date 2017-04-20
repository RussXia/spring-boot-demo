package com.xzy.demo.result;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by RuzzZZ on 2017/4/20.
 */
@Setter
@NoArgsConstructor
public class DubboResult<T> implements Serializable {


    /**
     * 成功标识
     */
    private boolean success = false;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 返回结果code
     */
    private String code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 含参构造器
     *
     * @param success
     * @param data
     * @param code
     * @param message
     */
    public DubboResult(boolean success, T data, String code, String message) {
        this.success = success;
        this.data = data;
        this.code = code;
        this.message = message;
    }

    /**
     * @return DubboResult<T>
     */
    public static <T> DubboResult<T> create() {
        return new DubboResult<T>();
    }

    /**
     * 快速创建Result的方法 -create DubboResult<T> Object for successful cases.
     *
     * @param data result data
     * @return DubboResult<T>
     */
    public static <T> DubboResult<T> create(T data) {
        DubboResult<T> result = DubboResult.create();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    /**
     * 接口调用成功时也需要code和message的场景
     *
     * @param data
     * @param code
     * @param message
     * @return
     */
    public static <T> DubboResult<T> create(T data, String code, String message) {
        DubboResult<T> result = DubboResult.create();
        result.setSuccess(true);
        result.setData(data);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * 任意场景
     *
     * @param isSuccess
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static <T> DubboResult<T> create(boolean isSuccess, String code, String message, T data) {
        DubboResult<T> result = DubboResult.create();
        result.setSuccess(isSuccess);
        result.setData(data);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * create DubboResult<T> Object for unsuccessful cases.
     *
     * @param code    result code
     * @param message result code
     * @return DubboResult<T>
     */
    public static <T> DubboResult<T> create(String code, String message) {
        DubboResult<T> result = DubboResult.create();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * @param errorCodeEnum
     * @param <T>
     * @return
     */
    public static <T> DubboResult<T> create(ErrorCodeEnum errorCodeEnum) {
        DubboResult<T> result = DubboResult.create();
        result.setSuccess(false);
        result.setCode(errorCodeEnum.getErrCode());
        result.setMessage(errorCodeEnum.getErrMsg());
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
