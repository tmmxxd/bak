package priv.zg.ufq.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

/**
 * 商户附件信息实体
 *
 * @author wbj
 * @date 2020-03-04
 */
@Data
@TableName("mer_attach")
public class MerAttachEntity {

    /**
     * 主键
     */
    @TableId(type = IdType.UUID)
    private String attachId;

    /**
     * 所属商户
     */
    private String merId;

    /**
     * 附件配置关联
     */
    private String configId;

    /**
     * 附件名称
     */
    private String configName;

    /**
     * 附件编码
     */
    private String configCode;

    /**
     * 附件配置值
     */
    private String configValue;

    /**
     * 生效时间
     */
    private Date effectStart;

    /**
     * 失效时间
     */
    private Date effectEnd;

    /**
     * 是否删除(0未删除  1已删除)
     */
    private Integer isDelete;

    /**
     * 附件审核结果
     */
    private String attachResult;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
