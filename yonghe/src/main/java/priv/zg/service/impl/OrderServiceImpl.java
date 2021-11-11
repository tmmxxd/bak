package priv.zg.service.impl;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.zg.dao.OrderMapper;
import priv.zg.pojo.Order;
import priv.zg.service.OrderService;


/**
 * 订单服务impl
 *
 * @author zg
 * @date 2021/11/04
 */
@Service
public class OrderServiceImpl implements OrderService {
    /**
     * 由spring创建对象并为变量赋值
     */
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> findAll() {
        //查询所有订单
        List<Order> orders = orderMapper.selectList(new QueryWrapper<>(new Order()));
        System.out.println(orders);
        return orders;
    }

    @Override
    public void deleteById(Integer id) {
        //1.调用OrderMapper的deleteById方法
        //根据id删除订单信息
        orderMapper.deleteById(id);
    }

    @Override
    public void addOrder(Order order) {
        order.setOrderTime(new Date());
        order.setPayTime(new Date());
        //1.调用OrderMapper的addOrder方法
        orderMapper.insert(order);
    }

    @Override
    public Order findById(Integer id) {
        //1.调用OrderMapper的findById方法
        return orderMapper.selectById(id);
    }

    @Override
    public void updateById(Order order) {
        //1.调用OrderMapper中的updateById方法
        orderMapper.updateById(order);
    }

    @Override
    public void deleteByDoorId(Integer id) {
        Order order = new Order();
        order.setDoorId(id);
        orderMapper.delete(new UpdateWrapper<>(order));
    }
}







