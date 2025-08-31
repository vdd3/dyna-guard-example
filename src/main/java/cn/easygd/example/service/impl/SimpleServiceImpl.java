package cn.easygd.example.service.impl;

import cn.easygd.example.domain.Param;
import cn.easygd.dynaguard.core.annotation.DynamicGuard;
import cn.easygd.dynaguard.core.chain.ChainExecutorHelper;
import cn.easygd.dynaguard.core.chain.ValidationChain;
import cn.easygd.dynaguard.domain.SpringValidationContext;
import cn.easygd.dynaguard.domain.ValidationResult;
import cn.easygd.dynaguard.domain.context.ChainOptions;
import cn.easygd.dynaguard.domain.context.ValidationContext;
import cn.easygd.dynaguard.domain.enums.GuardMode;
import cn.easygd.dynaguard.domain.guard.InterceptRateThreshold;
import cn.easygd.example.service.SimpleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author VD
 * @date 2025/8/16 12:10
 */
@Service("simpleService")
public class SimpleServiceImpl implements SimpleService {

    /**
     * 单个脚本为校验链
     *
     * @param param 请求参数
     */
    @DynamicGuard(group = "json", chainId = "user.create")
    @Override
    public void oneNode(Param param) {
        System.out.println("校验通过");
    }

    /**
     * 多脚本组合为校验链
     *
     * @param param 请求参数
     */
    @DynamicGuard(group = "xml", chainId = "user.update", enableGuard = true, guardMode = GuardMode.RATE)
    @Override
    public void moreNode(Param param) {
        System.out.println("校验通过");
    }

    /**
     * 按照优先级匹配校验链分组
     *
     * @param param 请求参数
     */
    @DynamicGuard(chainId = "user.create")
    @Override
    public void sqlNode(Param param) {
        System.out.println("校验通过");
    }

    /**
     * 测试熔断
     *
     * @param param 请求参数
     */
    @Override
    @DynamicGuard(chainId = "user.create",
            enableGuard = true,
            guardMode = GuardMode.COUNTER,
            guardThreshold = "{\"threshold\":100,\"period\":10,\"fail\":true}")
    public void guard(Param param) {
        System.out.println("校验通过");
    }

    @Override
    @DynamicGuard(chainId = "user.security")
    public void security(Param param) {
        System.out.println("校验通过");
    }

    @Override
    public void moreParam(Param param, List<String> workNoList) {

    }


    public void guardInBiz(Param param) {
        // 构建您的验证流程上下文
        ValidationContext context = new SpringValidationContext();
        InterceptRateThreshold guardThreshold1 = new InterceptRateThreshold();
        ChainOptions chainOptions = ChainOptions.builder()
                // 启用熔断
                .enableGuard(true)
                // 熔断模式
                .guardMode(GuardMode.RATE)
                // 熔断阈值
                .guardThreshold(guardThreshold1)
                .build();
        context.setChainOptions(chainOptions);

        // 获取流程，然后自己执行
        ValidationChain chain = null;
        chain = ChainExecutorHelper.getChain("您的验证链ID");
        chain = ChainExecutorHelper.getChain("您想使用的存储流程的分组", "您的验证链ID");

        // 直接抛出异常的执行
        chain.execute(context);

        // 带返回值的执行
        ValidationResult result = chain.executeResult(context);


        // 您可以根据返回值中的信息处理


        // 工具类帮您执行
        ChainExecutorHelper.validateHere("您的验证链ID", context);
        ChainExecutorHelper.validateHere("您想使用的存储流程的分组", "您的验证链ID", context);

    }
}
