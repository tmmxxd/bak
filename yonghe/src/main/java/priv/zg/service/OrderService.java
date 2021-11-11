package priv.zg.service;

import java.util.List;

import priv.zg.pojo.Order;

/**
 * 订单服务
 *
 * @author tsz
 * @date 2021/11/04
 */
public interface OrderService {
    /**
     * 1.查询所有订单信息
     *
     * @return {@link List}<{@link Order}>
     */
    List<Order> findAll();

    /**
     * 2.根据id删除订单信息
     *
     * @param id 订单id
     */
    void deleteById(Integer id);

    /**
     * 3.添加订单信息
     *
     * @param order 订单
     */
    void addOrder(Order order);

    /**
     * 4.1.根据id查询订单信息
     *
     * @param id 订单id
     * @return {@link Order}
     */
    Order findById(Integer id);

    /**
     * 4.2.根据id修改订单信息
     *
     * @param order 订单
     */
    void updateById(Order order);


    /**
     * 按门店id删除所有的订单
     *
     * @param id id
     */
    void deleteByDoorId(Integer id);
}
