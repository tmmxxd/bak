package priv.zg.ufq.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import priv.zg.ufq.entity.OdBizFileEntity;

import java.util.List;

/**
 * @author tsz
 * @date 2022-01-25 14:35
 */
@Mapper
public interface OdBizFileDao extends BaseMapper<OdBizFileEntity> {


    /**
     * 查询 未同步 mer_merchant 的数据
     *
     * @return {@link List}<{@link String}>
     */
    @Select("SELECT ob.biz_id FROM od_biz ob LEFT JOIN mer_merchant mer on ob.biz_id = mer.biz_id WHERE mer.biz_id IS NULL")
    List<String> findIds();
}
