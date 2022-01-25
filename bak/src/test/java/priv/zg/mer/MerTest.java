package priv.zg.mer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import priv.zg.ufq.dao.OdBizFileDao;
import priv.zg.ufq.entity.MerAttachConfigEntity;
import priv.zg.ufq.entity.OdBizFileEntity;
import priv.zg.ufq.handler.MerReturnHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 商户文件数据迁移
 *
 * @author tsz
 * @date 2022-01-25 14:25
 */
@Slf4j
@SpringBootTest
public class MerTest {

    @Autowired
    private MerReturnHandler handler;
    @Autowired
    private OdBizFileDao bizFileDao;

    @Test
    public void test1() {
        //获取需要数据迁移的biz_is集合
        final List<String> needIds = bizFileDao.findIds();
        //转为set集合
        final HashSet<String> idsSet = new HashSet<>(needIds);
        //获取 mer_attach_config 表所有数据
        final List<MerAttachConfigEntity> config = handler.getAttachConfig();
        //文fileType 1-16 遍历
        for (int i = 1; i <= 16; i++) {
            // isDelete 0-1 遍历
            for (int j = 0; j <= 1; j++) {
                //获取 该fileType和isDelete 下的所有商户
                Set<String> ids = handler.getOdBizIdList(i, j);
                for (String id : ids) {
                    //判断该商户是否属于未同步商户
                    if (!idsSet.contains(id)) {
                        continue;
                    }
                    log.info(id);
                    //根据 biz_id,file_type,is_delete 获取该商户 此类型文件
                    List<OdBizFileEntity> list = handler.getOdBizFileList(id, i, j);
                    //根据获取的第一个文件创建 mer_attach 表,并返回 主键
                    String attachId = handler.createAttach(config, list.get(0));
                    if (attachId == null) {
                        continue;
                    }
                    //遍历list,将生成的 attachId 传入关联生成 mer_attach_value 数据
                    for (OdBizFileEntity bizFile : list) {
                        handler.createAttachValue(attachId, bizFile);
                    }
                }//merAttach and merAttachValue
            }//isDelete
        }//fileType
    }//method


}//class
