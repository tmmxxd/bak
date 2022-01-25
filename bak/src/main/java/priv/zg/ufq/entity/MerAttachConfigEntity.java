package priv.zg.ufq.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 附件配置实体
 *
 * @author wbj
 * @date 2020-03-04
 */
@Data
@TableName("mer_attach_config")
public class MerAttachConfigEntity {

    /**
     * 主键
     */
    @TableId(type = IdType.UUID)
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
     * 附件类型(file:文件 ,text:文本，radio:单选，checkbox:多选)
     */
    private String configType;

    /**
     * 附件值(config_type为radio或者checkbox,必填，key:value 形式)
     */
    private String configValue;

    /**
     * 是否必传(1,是，0：否)
     */
    private Integer configRequire;

    /**
     * 排序码
     */
    private Integer configSort;

    /**
     * 附件状态（0：禁用，1：启用）
     */
    private Integer configStatus;

    /**
     * 是否删除（1：是，0：否）
     */
    private Integer isDelete;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
