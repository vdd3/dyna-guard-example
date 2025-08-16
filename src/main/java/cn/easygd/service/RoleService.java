package cn.easygd.service;

import java.util.List;

/**
 * @author VD
 * @date 2025/8/16 16:39
 */
public interface RoleService {

    List<String> getRoleList(String workNo);

    List<String> getDataRoleList(String workNo);
}
