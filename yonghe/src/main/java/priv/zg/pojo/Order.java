package priv.zg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 订单信息类, 用于封装订单信息
 *
 * @author zg
 * @date 2021/11/04
 */
@Data
@TableName("tb_order")
public class Order {
    /**
     * 订单id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 门店id
     */
    private Integer doorId;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 订单类型
     */
    private String orderType;
    /**
     * 数量
     */
    private Integer pnum;
    /**
     * 收银员
     */
    private String cashier;
    /**
     * 订单时间
     */
    private Date orderTime;
    /**
     * 支付时间
     */
    private Date payTime;
    /**
     * 支付类型
     */
    private String payType;
    /**
     * 价格
     */
    private Double price;

    /**
     * 重写toString
     *
     * @return {@link String}
     */
    @Override
    public String toString() {
        return "Order [id=" + id + ", doorId=" + doorId + ", orderNo=" + orderNo + ", orderType=" + orderType
                + ", pnum=" + pnum + ", cashier=" + cashier + ", orderTime=" + orderTime + ", payTime=" + payTime
                + ", payType=" + payType + ", price=" + price + "]";
    }
}
