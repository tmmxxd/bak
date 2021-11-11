package priv.zg.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import priv.zg.dao.DoorMapper;
import priv.zg.pojo.Door;
import priv.zg.service.DoorService;


/**
 * 门店服务
 * spring会扫描service包下的所有类
 * 将类上带有@Service注解的类, 自动注册到
 * spring容器中, 即由spring创建该类的实例
 *
 * @author tsz
 * @date 2021/11/04
 */
@Service
public class DoorServiceImpl implements DoorService {

    /**
     * 由spring自动为属性赋值
     */
    @Autowired
    private DoorMapper doorMapper;

    @Override
    public List<Door> findAll() {
        //调用findAll方法查询所有门店信息
        return doorMapper.selectList(new QueryWrapper<>(new Door()));
    }

    @Override
    public void deleteById(Integer id) {
        //根据id删除门店信息
        doorMapper.deleteById(id);
    }

    @Override
    public void addDoor(Door door) {
        doorMapper.insert(door);
    }

    @Override
    public Door findById(Integer id) {
        return doorMapper.selectById(id);
    }

    @Override
    public void updateById(Door door) {
        doorMapper.updateById(door);
    }
}




