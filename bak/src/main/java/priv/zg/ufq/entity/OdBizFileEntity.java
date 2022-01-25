package priv.zg.ufq.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 商户文件表
 *
 * @author tsz
 * @date 2022-01-25
 */
@Data
@TableName("od_biz_file")
public class OdBizFileEntity {

    /**
     * 主键
     */
    @TableId(type = IdType.UUID)
    private String fileId;

    /**
     * 商户id
     */
    private String bizId;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 文件类型（见枚举StoreFileType）
     */
    private Integer fileType;

    /**
     * 是否删除（0:未删除，1:已删除）
     */
    private Integer isDelete;


    /**
     * 添加时间
     */
    private Date enteringtime;

    /**
     * 更新时间
     */
    private Date upertime;


}
