package priv.zg.ufq.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

/**
 * 商户附件值实体
 *
 * @author wbj
 * @date 2020-03-04
 */
@Data
@TableName("mer_attach_value")
public class MerAttachValueEntity {

    /**
     * 主键
     */
    @TableId(type = IdType.UUID)
    private String valId;

    /**
     * 所属附件
     */
    private String attachId;

    /**
     * 附件值
     */
    private String valValue;

    /**
     * 附件类型
     */
    private String valType;

    /**
     * 状态(0:未删除 1:已删除)
     */
    private Integer valStatus;

    /**
     * 附件名称
     */
    private String valName;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 附件类型
     */
    private String addUserName;

    /**
     * 附件类型
     */
    private String addUserId;

    /**
     * 附件类型
     */
    private String updateUserName;

    /**
     * 附件类型
     */
    private String updateUserId;

}
