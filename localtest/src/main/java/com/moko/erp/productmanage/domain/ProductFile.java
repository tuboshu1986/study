package com.moko.erp.productmanage.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 生产资料
 */
@Setter
@Getter
@Entity
@Table(name = "product_file")
@SQLDelete(sql = "update product_file set is_del = 1 where id = ?")
public class ProductFile extends BaseModel {
    private static final long serialVersionUID = 1L;

    /**
     * 文件所属对象id
     */
    @Column(name = "object_id")
    private Integer objectId;

    /**
     * 文件所属对象类型
     */
    @Column(name = "object_type")
    private String objectType;

    /**
     * 原始文件名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 文件存储位置
     */
    @Column(name = "path")
    private String path;

    /**
     * 文件MD5
     */
    @Column(name = "md5")
    private String md5;

    /**
     * 文件所属对象类型
     */
    public static class ProductFileType {
        /**
         * 产品资料
         */
        public static final String PRODUCT_INFORMATION = "000000";

        /**
         * 产品资料-生产概要
         */
        public static final String MANUFACTURE_SAMMARY = "000100";

        /**
         * 产品资料-PCB资料-Gerber单板
         */
        public static final String PCB_INFORMATION_GSINGLE = "000201";
        /**
         * 产品资料-PCB资料-Gerber拼板
         */
        public static final String PCB_INFORMATION_GJOINT = "000202";
        /**
         * 产品资料-PCB资料-工艺要求
         */
        public static final String PCB_INFORMATION_CRAFT = "000203";

        /**
         * 产品资料-PCBA资料-摆位图
         */
        public static final String PCBA_INFORMATION_POSITIONING = "000300";
        /**
         * 产品资料-PCBA资料-坐标
         */
        public static final String PCBA_INFORMATION_COORD = "000301";
        /**
         * 产品资料-PCBA资料-其他
         */
        public static final String PCBA_INFORMATION_OTHER = "000302";
        /**
         * 产品资料-PCBA资料-测试说明
         */
        public static final String PCBA_INFORMATION_TESTEXPLAIN = "000303";
        /**
         * 产品资料-PCBA资料-测试工具
         */
        public static final String PCBA_INFORMATION_TESTTOOL = "000304";

        /**
         * 产品资料-组装资料-组装说明
         */
        public static final String PACKAGE_INFORMATION_EXPLAIN = "000400";
        /**
         * 产品资料-组装资料-组装测试
         */
        public static final String PACKAGE_INFORMATION_TEST = "000401";

        /**
         * 产品资料-组装资料-组装说明
         */
        public static final String ENTIRETY_TEST_EXPLAIN = "000500";
        /**
         * 产品资料-组装资料-组装测试
         */
        public static final String ENTIRETY_TEST_TOOL = "000501";

        /**
         * 产品资料-包装-包装说明
         */
        public static final String PRODUCT_PACK_EXPLAIN = "000600";

        /**
         * 产品资料-其他-包装说明
         */
        public static final String PRODUCT_OTHER_EXPLAIN = "000700";
    }

}
