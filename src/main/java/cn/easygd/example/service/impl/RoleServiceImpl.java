package cn.easygd.example.service.impl;

import cn.easygd.example.service.RoleService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author VD
 * @date 2025/8/16 16:39
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Override
    public List<String> getRoleList(String workNo) {
        return Lists.newArrayList("admin", "user");
    }

    @Override
    public List<String> getDataRoleList(String workNo) {
        if ("1234".equals(workNo)) {
            return Lists.newArrayList("update");
        }
        return Lists.newArrayList();
    }
}
