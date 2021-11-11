package priv.zg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * POJO(实体类)
 * 用于封装所有的门店信息
 *
 * @author zg
 * @date 2021/11/04
 */
@Data
@TableName("tb_door")
public class Door {
    /**
     * 门店id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 门店名称
     */
    private String name;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 门店地址
     */
    private String addr;

    /**
     * 重写toString方法
     *
     * @return {@link String}
     */
    @Override
    public String toString() {
        return "Door [id=" + id + ", name="
                + name + ", tel=" + tel
                + ", addr=" + addr + "]";
    }

}
