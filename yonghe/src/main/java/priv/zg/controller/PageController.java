package priv.zg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * 页面跳转 控制器(RESTful 风格)
 *
 * @author zg
 * @date 2021/11/04
 */
@Controller
public class PageController {


    @Autowired
    InternalResourceViewResolver viewResolver;

    @RequestMapping(value = "/error/{errorCode}")
    public String error(@PathVariable String errorCode) {
        return "error/" + errorCode;
    }


    /**
     * 通用的页面跳转方法
     * 如果通过浏览器访问 /hello 斜杠后的hello会被 /{page}中的 page 变量接收
     * {@code @PathVariable}会将方法上声明的 page变量的值 赋值给 page参数 最后 return page
     *
     * @param page 页面名称
     * @return {@link String}
     */
    @RequestMapping("/{page}")
    public String page(@PathVariable String page) {
        System.out.println(viewResolver);
        return page;
    }
}
