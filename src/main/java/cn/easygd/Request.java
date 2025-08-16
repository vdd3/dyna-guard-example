package cn.easygd;

import lombok.Data;

/**
 * @author VD
 * @date 2025/8/16 14:42
 */
@Data
public class Request<T> {

    /**
     * 请求参数
     */
    private T param;
}
