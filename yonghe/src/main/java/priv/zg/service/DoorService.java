package priv.zg.service;

import java.util.List;

import priv.zg.pojo.Door;

/**
 * 门店服务
 *
 * @author zg
 * @date 2021/11/04
 */
public interface DoorService {
    /**
     * 1.查询所有门店信息
     *
     * @return List<Door>
     */
    List<Door> findAll();

    /**
     * 2.根据id删除门店信息
     *
     * @param id 门店id
     */
    void deleteById(Integer id);

    /**
     * 3.添加门店信息
     *
     * @param door 门店
     */
    void addDoor(Door door);

    /**
     * 4.根据id查询门店信息
     *
     * @param id 门店id
     * @return {@link Door}
     */
    Door findById(Integer id);

    /**
     * 5.根据id修改门店信息
     *
     * @param door 门店
     */
    void updateById(Door door);
}
