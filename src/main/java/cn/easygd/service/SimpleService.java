package cn.easygd.service;

import cn.easygd.domain.Param;

/**
 * @author VD
 * @date 2025/8/16 14:41
 */
public interface SimpleService {


    void oneNode(Param param);

    void moreNode(Param param);

    void sqlNode(Param param);

    void guard(Param param);
}
