package com.moko.erp.productmanage.domain;


import com.moko.erp.productmanage.common.CollectionUtil;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 生产资料-PCBA资料
 */
@Setter
@Getter
@Entity
@Table(name = "pcba_information")
public class PCBAInformation extends BaseModel {

    private static final long serialVersionUID = 1L;
    /**
     * 生产资料
     */
    @OneToOne
    @JoinColumn(name = "product_information_id", referencedColumnName = "id")
    private ProductInformation productInformation;

    /**
     * 摆位图
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectId")
    @Where(clause = "(isDel is null or isDel = 0) and object_type='" + ProductFile.ProductFileType.PCBA_INFORMATION_POSITIONING + "'")
    private List<ProductFile> positioning;
    /**
     * 摆位图-历史记录
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectId")
    @Where(clause = "is_del = 1 and object_type='" + ProductFile.ProductFileType.PCBA_INFORMATION_POSITIONING + "'")
    private List<ProductFile> positioningHis;

    /**
     * 坐标
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectId")
    @Where(clause = "(isDel is null or isDel = 0) and object_type='" + ProductFile.ProductFileType.PCBA_INFORMATION_COORD + "'")
    private List<ProductFile> coord;
    /**
     * 坐标-历史记录
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectId")
    @Where(clause = "is_del = 1 and object_type='" + ProductFile.ProductFileType.PCBA_INFORMATION_COORD + "'")
    private List<ProductFile> coordHis;

    /**
     * 烧录置具
     */
    @Column(name = "burn_tool_from")
    private String burnToolFrom;
    /**
     * 烧录置具-名称
     */
    @Column(name = "burn_tool_from_name")
    private String burnToolFromName;

    /**
     * 烧录方式
     */
    @Column(name = "burn_method")
    private String burnMethod;
    /**
     * 烧录方式-名称
     */
    @Column(name = "burn_method_name")
    private String burnMethodName;

    /**
     * 烧录说明
     */
    @Column(name = "burn_remarks")
    private String burnRemarks;

    /**
     * 其他
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectId")
    @Where(clause = "(isDel is null or isDel = 0) and object_type='" + ProductFile.ProductFileType.PCBA_INFORMATION_OTHER + "'")
    private List<ProductFile> other;
    /**
     * 其他-历史记录
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectId")
    @Where(clause = "is_del = 1 and object_type='" + ProductFile.ProductFileType.PCBA_INFORMATION_OTHER + "'")
    private List<ProductFile> otherHis;

    /**
     * 测试置具：不需要置具：1；需要，工程制作：2；需要，客户提供：3
     */
    @Column(name = "test_tool_from")
    private String testToolFrom;
    /**
     * 测试置具-名称
     */
    @Column(name = "test_tool_from_name")
    private String testToolFromName;

    /**
     * 测试说明
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectId")
    @Where(clause = "(isDel is null or isDel = 0) and object_type='" + ProductFile.ProductFileType.PCBA_INFORMATION_TESTEXPLAIN + "'")
    private List<ProductFile> testExplain;
    /**
     * 测试说明-历史记录
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectId")
    @Where(clause = "is_del = 1 and object_type='" + ProductFile.ProductFileType.PCBA_INFORMATION_TESTEXPLAIN + "'")
    private List<ProductFile> testExplainHis;

    /**
     * 测试工具
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectId")
    @Where(clause = "(isDel is null or isDel = 0) and object_type='" + ProductFile.ProductFileType.PCBA_INFORMATION_TESTTOOL + "'")
    private List<ProductFile> testTool;
    /**
     * 测试工具-历史记录
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectId")
    @Where(clause = "is_del = 1 and object_type='" + ProductFile.ProductFileType.PCBA_INFORMATION_TESTTOOL + "'")
    private List<ProductFile> testToolHis;

    /**
     * 将objectId设置到对应的文件信息
     * @return
     */
    public void setValidFileObjectId(){
        allValidFileInfo().forEach(f -> {
            f.setObjectId(this.getId());
        });
    }

    /**
     * 获取该产品资料中的所有文件信息
     * @return
     */
    public List<ProductFile> allValidFileInfo(){
        List<ProductFile> rst = new ArrayList<>();

        CollectionUtil.addToList(rst, getPositioning());
        CollectionUtil.addToList(rst, getCoord());
        CollectionUtil.addToList(rst, getOther());
        CollectionUtil.addToList(rst, getTestExplain());
        CollectionUtil.addToList(rst, getTestTool());

        return rst;
    }

}
