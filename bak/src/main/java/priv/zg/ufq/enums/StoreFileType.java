package priv.zg.ufq.enums;

/**
 * 商户文件类型
 *
 * @author tsz
 * @date 2022-01-25 11:25
 */
public enum StoreFileType {
    /**
     * 门店营业执照
     */
    LICENSE(1, "门店营业执照", "business_license_url"),
    STORE_CONTRACT(2, "合作方和门店合同", "store_contract_url"),
    ID_CARD_FRONT(3, "法人身份证正面原件照", "id_card_front_url"),
    ID_CARD_BACK(4, "法人身份证反面原件照", "id_card_back_url"),
    OUTSIDE(5, "门店室外照片", "store_outside_url"),
    INSIDE_FRONT(6, "门店前台照片", "store_inside_url1"),
    INSIDE_REST(7, "治疗休息室", "store_inside_url2"),
    INSIDE_MACHINE(8, "医疗器械室", "store_inside_url3"),
    INSIDE_DIAGNOSIS(9, "医师诊断室", "store_inside_url4"),
    RENT_CONTRACT(10, "经营场所购房（租赁）合同照片", "store_rent_contract_url"),
    PRACTICING_LICENSE_MEDICAL(11, "《医疗机构执业许可证》照", "practicing_license_medical_url"),
    MECHANISM_INNER_NAME_LIST(12, "机构内部名单列表", "mechanism_inner_name_list"),
    OTHER_IMAGE1(13, "其他图片1", "other_image1"),
    OTHER_IMAGE2(14, "其他图片2", "other_image2"),
    OTHER_IMAGE3(15, "其他图片3", "other_image3"),
    OPENING_PERMIT(16, "开户许可证", "opening_permit");

    private final int type;
    private final String desc;
    private final String key;

    StoreFileType(int type, String desc, String key) {
        this.type = type;
        this.desc = desc;
        this.key = key;
    }

    /**
     * 类型
     *
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * 描述
     *
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 对应的参数名
     *
     * @return the key
     */
    public String getKey() {
        return key;
    }

    public static StoreFileType getStoreFileTypeByType(int type) {
        for (StoreFileType fileType : StoreFileType.values()) {
            if (fileType.type == type) {
                return fileType;
            }
        }
        return null;
    }


}
