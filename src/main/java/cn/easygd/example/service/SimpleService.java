package cn.easygd.example.service;

import cn.easygd.example.domain.Param;

import java.util.List;

/**
 * @author VD
 * @date 2025/8/16 14:41
 */
public interface SimpleService {

    void oneNode(Param param);

    void moreNode(Param param);

    void sqlNode(Param param);

    void guard(Param param);

    void security(Param param);

    void moreParam(Param param, List<String> workNoList);
}
