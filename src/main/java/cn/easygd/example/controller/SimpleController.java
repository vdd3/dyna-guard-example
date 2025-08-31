package cn.easygd.example.controller;

import cn.easygd.example.Request;
import cn.easygd.example.Response;
import cn.easygd.example.domain.Param;
import cn.easygd.example.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author VD
 * @date 2025/8/16 14:44
 */
@RequestMapping("/simple")
@RestController
public class SimpleController {

    /**
     * 测试服务
     */
    @Autowired
    private SimpleService simpleService;

    /**
     * 单校验节点，使用json
     *
     * @param request 请求参数
     * @return 响应参数
     */
    @PostMapping("/oneNode")
    public Response<Void> oneNode(@RequestBody Request<Param> request) {
        simpleService.oneNode(request.getParam());
        return Response.success(null);
    }

    /**
     * 多校验节点，使用xml
     *
     * @param request 请求参数
     * @return 响应参数
     */
    @PostMapping("/moreNode")
    public Response<Void> moreNode(@RequestBody Request<Param> request) {
        simpleService.moreNode(request.getParam());
        return Response.success(null);
    }

    /**
     * sql校验节点
     *
     * @param request 请求参数
     * @return 响应参数
     */
    @PostMapping("/sqlNode")
    public Response<Void> sqlNode(@RequestBody Request<Param> request) {
        simpleService.sqlNode(request.getParam());
        return Response.success(null);
    }

    /**
     * 熔断
     *
     * @param request 请求参数
     * @return 响应参数
     */
    @PostMapping("/guard")
    public Response<Void> guard(@RequestBody Request<Param> request) {
        simpleService.guard(request.getParam());
        return Response.success(null);
    }

    /**
     * 熔断
     *
     * @param request 请求参数
     * @return 响应参数
     */
    @PostMapping("/security")
    public Response<Void> security(@RequestBody Request<Param> request) {
        simpleService.security(request.getParam());
        return Response.success(null);
    }
}
