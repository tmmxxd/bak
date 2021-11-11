package priv.zg.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import priv.zg.pojo.Door;
import priv.zg.pojo.Order;
import priv.zg.service.DoorService;
import priv.zg.service.OrderService;


/**
 * 订单服务
 *
 * @author zg
 * @date 2021/11/04
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private DoorService doorService;

    /**
     * 1.查询所有订单信息
     *
     * @param model 数据传递对象
     * @return {@link String}
     */
    @RequestMapping("/orderList")
    public String orderList(Model model) {
        //1.调用OrderService层的findAll方法查询所有订单
        List<Order> list = orderService.findAll();
        //2.将所有订单的list集合存入Model中(存入request域中)
        model.addAttribute("list", list);
        //3.查询所有门店
        List<Door> doorlist = doorService.findAll();
        //4.将所有订单的list集合存入Model中(存入request域中)
        model.addAttribute("doorList", doorlist);
        //5.转向订单列表页面
        return "order_list";
    }

    /**
     * 2.根据id删除订单信息
     *
     * @param id 订单id
     * @return {@link String}
     */
    @RequestMapping("/orderDelete")
    public String orderDelete(Integer id) {
        //1.调用OrderService的 deleteById方法
        //根据id删除订单信息
        orderService.deleteById(id);
        //2.转向 查询所有订单的方法
        return "redirect:/orderList";
    }

    /**
     * 3.查询所有门店并跳转到订单新增页面
     *
     * @param model 数据传递对象
     * @return {@link String}
     */
    @RequestMapping("/findAllDoorToOrder_add")
    public String toOrder_Add(Model model) {
        //1.调用doorService的findAll方法查询所有门店
        List<Door> list = doorService.findAll();
        //2.将所有门店列表存入Model中(存到了Request域中)
        model.addAttribute("list", list);
        //3.转向订单新增页面
        return "order_add";
    }

    /**
     * 4.新增订单
     *
     * @param order 订单
     * @return {@link String}
     */
    @RequestMapping("/orderAdd")
    public String orderAdd(Order order) {
        //1.调用OrderService的addOrder方法,添加订单信息
        orderService.addOrder(order);
        //转向 查询所有订单的方法
        return "redirect:/orderList";
    }

    /**
     * 4.1.根据id查询订单信息
     *
     * @param id    订单id
     * @param model 数据传递对象
     * @return {@link String}
     */
    @RequestMapping("/orderInfo")
    public String orderInfo(Integer id, Model model) {
        //1.调用OrderService的findById
        //根据id查询订单信息
        Order order = orderService.findById(id);
        //2.将订单信息存入Model中
        model.addAttribute("order", order);
        //3.调用DoorService的findAll方法查询所有门店
        List<Door> list = doorService.findAll();
        //4.将所有门店列表存入Model中
        model.addAttribute("list", list);
        //5.转向 订单修改页面
        return "order_update";
    }

    /**
     * 4.2.根据id修改订单信息
     *
     * @param order 订单
     * @return {@link String}
     */
    @RequestMapping("/orderUpdate")
    public String orderUpdate(Order order) {
        //1.调用OrderService的updateById()
        orderService.updateById(order);
        //剩下的步骤自己完成!!!
        // 转向 查询所有订单的方法
        return "redirect:/orderList";
    }

    /**
     * 自定义日期转换格式
     *
     * @param binder ServletRequestDataBinder对象
     */
    @InitBinder
    public void InitBinder(ServletRequestDataBinder binder) {
        binder.registerCustomEditor(
                java.util.Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}
	





