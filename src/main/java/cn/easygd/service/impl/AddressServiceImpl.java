package cn.easygd.service.impl;

import cn.easygd.service.AddressService;
import org.springframework.stereotype.Service;

/**
 * @author VD
 * @date 2025/8/16 17:22
 */
@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Override
    public String getAddress() {
        return "郑州";
    }
}
