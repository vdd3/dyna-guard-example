package cn.easygd.example;

import cn.easygd.dynaguard.core.chain.ChainExecutorHelper;
import cn.easygd.dynaguard.core.chain.ValidationChain;
import cn.easygd.dynaguard.domain.SpringValidationContext;
import cn.easygd.dynaguard.domain.ValidationResult;
import cn.easygd.dynaguard.domain.context.ChainOptions;
import cn.easygd.dynaguard.domain.context.ValidationContext;
import cn.easygd.dynaguard.domain.exception.ValidationFailedException;
import cn.easygd.example.domain.Param;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author VD
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CoreTest {

    @Test
    public void QLExpress4_TEST() {
        String group = "xml";

        ValidationResult validationResult;

        Param param = new Param();

        ValidationContext context = new SpringValidationContext();
        context.put("param", param);

        // name为null
        ValidationChain qlExpress4_test_1 = ChainExecutorHelper.getChain(group, "QLExpress4_TEST_1");
        context.setChainOptions(ChainOptions.builder().enableGuard(false).build());
        validationResult = qlExpress4_test_1.executeResult(context);
        Assert.assertFalse(validationResult.getSuccess());
        Assert.assertEquals("校验失败", validationResult.getMessage());

        // name不为null
        param.setName("name");
        validationResult = qlExpress4_test_1.executeResult(context);
        Assert.assertTrue(validationResult.getSuccess());

        // 安全策略开启，list无法添加内容
        ValidationChain qlExpress4_test_2 = ChainExecutorHelper.getChain(group, "QLExpress4_TEST_2");
        context.setChainOptions(ChainOptions.builder().enableGuard(false).build());
        context.put("test2List", Lists.newArrayList("2"));
        Assert.assertThrows("脚本执行错误", ValidationFailedException.class, () -> qlExpress4_test_2.execute(context));

        // 安全策略开启，map无法添加内容
        ValidationChain qlExpress4_test_3 = ChainExecutorHelper.getChain(group, "QLExpress4_TEST_3");
        context.setChainOptions(ChainOptions.builder().enableGuard(false).build());
        context.put("test3Map", Maps.newHashMap());
        Assert.assertThrows("脚本执行错误", ValidationFailedException.class, () -> qlExpress4_test_3.execute(context));

        // 安全策略开启，set无法添加内容
        ValidationChain qlExpress4_test_4 = ChainExecutorHelper.getChain(group, "QLExpress4_TEST_4");
        context.setChainOptions(ChainOptions.builder().enableGuard(false).build());
        context.put("test4Set", Sets.newHashSet("1"));
        Assert.assertThrows("脚本执行错误", ValidationFailedException.class, () -> qlExpress4_test_4.execute(context));

        // 安全策略开启，param无法改变内容
        ValidationChain qlExpress4_test_5 = ChainExecutorHelper.getChain(group, "QLExpress4_TEST_5");
        context.setChainOptions(ChainOptions.builder().enableGuard(false).build());
        Assert.assertThrows("脚本执行错误", ValidationFailedException.class, () -> qlExpress4_test_5.execute(context));
    }
}
