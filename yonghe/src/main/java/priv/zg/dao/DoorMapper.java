package priv.zg.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import priv.zg.pojo.Door;

/**
 * 门店查询
 *
 * @author zg
 * @date 2021/11/04
 */
@Mapper
public interface DoorMapper extends BaseMapper<Door> {
}
