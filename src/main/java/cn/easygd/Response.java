package cn.easygd;

import lombok.Data;

/**
 * @author VD
 * @date 2025/8/16 14:45
 */
@Data
public class Response<T> {

    /**
     * 数据
     */
    private T data;

    /**
     * 错误码
     */
    private String code;

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setData(data);
        return response;
    }

    public static <T> Response<T> error(String code) {
        Response<T> response = new Response<>();
        response.setCode(code);
        return response;
    }
}
