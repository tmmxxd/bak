package priv.zg.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import priv.zg.pojo.Order;

/**
 * 订单查询
 *
 * @author tsz
 * @date 2021/11/04
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}




