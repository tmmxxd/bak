package priv.zg.ufq.enums;

/**
 * 商户存储文件类型
 *
 * @author tsz
 * @date 2022-01-25 11:13
 */
public enum MerchantFileType {

    /**
     * mer_attach_config表config_code字段
     */
    merchant_front("门店前台"),
    other_image("其他"),
    //未使用
    cooperative_info("合作商户信息登记表"),
    //未使用
    merchant_logo("商户logo"),
    venue_contract("房屋租赁/产权证明"),
    medical_instrument_room("医疗器械室/手术室"),
    treatment_lounge("治疗休息室"),
    doctor_office("医师诊断室/咨询室"),
    merchant_outdoor("门店室外照片(含门头照)"),
    //未使用
    bd_group_photo("BD合照"),
    run_project_sheet("经营性项目报价单"),
    //未使用
    doctor_certificate("医师执业证书"),
    //未使用
    other_explain("其他说明性材料"),


    //新增的
    license("门店营业执照"),
    store_contract("合作方和门店合同"),
    id_card_front("法人身份证正面原件照"),
    id_card_back("法人身份证反面原件照"),

    practicing_license_medical("《医疗机构执业许可证》照"),
    mechanism_inner_name_list("机构内部名单列表"),
    other_image2("其他图片2"),
    other_image3("其他图片3"),
    opening_permit("开户许可证")





    ;

    private final String value;

    MerchantFileType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}





















