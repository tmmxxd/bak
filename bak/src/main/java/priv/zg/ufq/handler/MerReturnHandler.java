package priv.zg.ufq.handler;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import priv.zg.ufq.dao.MerAttachConfigDao;
import priv.zg.ufq.dao.MerAttachDao;
import priv.zg.ufq.dao.MerAttachValueDao;
import priv.zg.ufq.dao.OdBizFileDao;
import priv.zg.ufq.entity.MerAttachConfigEntity;
import priv.zg.ufq.entity.MerAttachEntity;
import priv.zg.ufq.entity.MerAttachValueEntity;
import priv.zg.ufq.entity.OdBizFileEntity;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 商户数据转移操作类
 *
 * @author tsz
 * @date 2022-01-25 14:47
 */
@Component
public class MerReturnHandler {

    @Autowired
    private MerAttachDao attachDao;
    @Autowired
    private OdBizFileDao bizFileDao;
    @Autowired
    private MerAttachValueDao valueDao;
    @Autowired
    private MerAttachConfigDao configDao;


    public static final Map<Integer, String> configCode2fileType = new HashMap<>();

    static {
        //已存在
        configCode2fileType.put(5, "merchant_outdoor");
        configCode2fileType.put(6, "merchant_front");
        configCode2fileType.put(7, "treatment_lounge");
        configCode2fileType.put(8, "medical_instrument_room");
        configCode2fileType.put(9, "doctor_office");
        configCode2fileType.put(10, "venue_contract");
        configCode2fileType.put(13, "other_image");
        //需要新增的
        configCode2fileType.put(1, "license");
        configCode2fileType.put(2, "store_contract");
        configCode2fileType.put(3, "id_card_front");
        configCode2fileType.put(4, "id_card_back");
        configCode2fileType.put(11, "practicing_license_medical");
        configCode2fileType.put(12, "mechanism_inner_name_list");
        configCode2fileType.put(14, "other_image2");
        configCode2fileType.put(15, "other_image3");
        configCode2fileType.put(16, "opening_permit");
    }

    /**
     * 获取 mer_attach_config 所有数据
     *
     * @return {@link List}<{@link MerAttachConfigEntity}>
     */
    public List<MerAttachConfigEntity> getAttachConfig() {
        return configDao.selectList(new QueryWrapper<>(new MerAttachConfigEntity()));
    }


    /**
     * 获取该文件类型和是否删除下的所有商户id集合
     *
     * @param fileType 文件类型
     * @param isDelete 是否删除
     * @return {@link Set}<{@link String}>
     */
    public Set<String> getOdBizIdList(int fileType, int isDelete) {
        OdBizFileEntity queryArgs = new OdBizFileEntity();
        queryArgs.setFileType(fileType);
        queryArgs.setIsDelete(isDelete);
        List<OdBizFileEntity> list = bizFileDao.selectList(new QueryWrapper<>(queryArgs));
        return list.stream().map(OdBizFileEntity::getBizId).collect(Collectors.toSet());
    }


    /**
     * 根据商户id,文件类型,是否删除获取所有此类型文件
     *
     * @param bizId    商户id
     * @param fileType 文件类型
     * @param isDelete 是否删除
     * @return {@link List}<{@link OdBizFileEntity}>
     */
    public List<OdBizFileEntity> getOdBizFileList(String bizId, int fileType, int isDelete) {
        OdBizFileEntity queryArgs = new OdBizFileEntity();
        queryArgs.setFileType(fileType);
        queryArgs.setIsDelete(isDelete);
        queryArgs.setBizId(bizId);
        return bizFileDao.selectList(new QueryWrapper<>(queryArgs));
    }


    /**
     * 创建 mer_attach 表数据
     *
     * @param config  mer_attach_config 所有数据
     * @param bizFile 商户文件表数据
     * @return {@link String}
     */
    public String createAttach(List<MerAttachConfigEntity> config, OdBizFileEntity bizFile) {
        String bizId = bizFile.getBizId();
        Integer isDelete = bizFile.getIsDelete();
        Integer fileType = bizFile.getFileType();
        String configCode = configCode2fileType.get(fileType);
        MerAttachConfigEntity configEntity = getConfigByConfigCode(config, configCode);
        if (configEntity == null) {
            return null;
        }
        MerAttachEntity merAttach = new MerAttachEntity();
        merAttach.setMerId(bizId);
        merAttach.setConfigId(configEntity.getConfigId());
        merAttach.setConfigName(configEntity.getConfigName());
        merAttach.setConfigCode(configEntity.getConfigCode());
        merAttach.setConfigValue(configEntity.getConfigValue());
        merAttach.setEffectStart(null);
        merAttach.setEffectEnd(null);
        merAttach.setAttachResult("合格");
        merAttach.setIsDelete(isDelete);
        merAttach.setAddTime(bizFile.getEnteringtime());
        merAttach.setUpdateTime(bizFile.getUpertime());
        attachDao.insert(merAttach);
        return merAttach.getAttachId();
    }


    /**
     * 根据configCode值和 mer_attach_config 所有数据对比,返回对应 config
     *
     * @param config     配置
     * @param configCode 配置代码
     * @return {@link MerAttachConfigEntity}
     */
    private MerAttachConfigEntity getConfigByConfigCode(List<MerAttachConfigEntity> config, String configCode) {
        for (MerAttachConfigEntity entity : config) {
            if (entity.getConfigCode() != null && entity.getConfigCode().equals(configCode)) {
                return entity;
            }
        }
        return null;
    }

    /**
     * 创建 mer_attach_value 表数据
     *
     * @param attachId 关联 mer_attach 表数据
     * @param bizFile  商户文件表数据
     */
    public void createAttachValue(String attachId, OdBizFileEntity bizFile) {
        MerAttachValueEntity entity = new MerAttachValueEntity();
        entity.setAttachId(attachId);
        entity.setValValue(bizFile.getFilePath());
        entity.setValStatus(bizFile.getIsDelete());
        entity.setAddTime(bizFile.getEnteringtime());
        entity.setUpdateTime(bizFile.getUpertime());
        entity.setValName(null);
        entity.setValType(null);
        entity.setAddUserName("系统管理员");
        entity.setAddUserId("1");
        entity.setUpdateUserName("系统管理员");
        entity.setUpdateUserId("1");
        valueDao.insert(entity);
    }

}
