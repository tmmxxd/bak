package priv.zg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import priv.zg.pojo.Door;
import priv.zg.service.DoorService;
import priv.zg.service.OrderService;


/**
 * 门店服务
 *
 * @author zg
 * @date 2021/11/04
 */
@Controller
public class DoorController {
    @Autowired
    private DoorService doorService;
    @Autowired
    private OrderService orderService;

    /**
     * 1.查询所有门店信息
     *
     * @param model 模型
     * @return {@link String}
     */
    @RequestMapping("/doorList")
    public String doorList(Model model) {
        //调用findAll方法查询所有门店信息
        List<Door> list = doorService.findAll();
        //往model中添加一个属性(添加到request域中)
        model.addAttribute("list", list);
        return "door_list";
    }

    /**
     * 2.根据id删除门店信息
     *
     * @param id id
     * @return {@link String}
     */
    @RequestMapping("/doorDelete")
    public String doorDelete(Integer id) {
        //删除此门店下的所有订单
        orderService.deleteByDoorId(id);
        //调用deleteById方法, 根据id删除门店
        doorService.deleteById(id);
        return "redirect:/doorList";
    }

    /**
     * 3.添加门店信息
     *
     * @param door 门
     * @return {@link String}
     */
    @RequestMapping("/doorAdd")
    public String doorAdd(Door door) {
        //1.调用DoorService层的addDoor方法, 添加门店信息
        doorService.addDoor(door);
        return "redirect:/doorList";
    }

    /**
     * 4.根据id修改门店信息
     * 4.1.先根据id查询当前门店的信息
     *
     * @param id    id
     * @param model 模型
     * @return {@link String}
     */
    @RequestMapping("/doorInfo")
    public String doorInfo(Integer id, Model model) {
        //1.根据id查询门店信息
        Door door = doorService.findById(id);
        System.out.println(door);
        //2.将门店信息存入model中(存入request域中)
        model.addAttribute("door", door);
        //3.转向door_update.jsp
        return "door_update";
    }

    /**
     * 4.根据id修改门店信息
     * 4.1.先根据id查询当前门店的信息
     * 4.2.再根据id修改当前门店的信息
     *
     * @param door 门
     * @return {@link String}
     */
    @RequestMapping("/doorUpdate")
    public String doorUpdate(Door door) {
        //1.调用doorService的updateById方法修改门店信息
        doorService.updateById(door);
        //2.转向查询所有门店的方法
        return "redirect:/doorList";
    }

}






