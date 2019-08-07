package com.moko.erp.productmanage.domain;


import com.moko.erp.productmanage.common.CollectionUtil;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 生产资料-整体测试
 */
@Setter
@Getter
@Entity
@Table(name = "entirety_test")
public class EntiretyTest extends BaseModel {
    private static final long serialVersionUID = 1L;
    /**
     * 生产资料
     */
    @OneToOne
    @JoinColumn(name = "product_information_id", referencedColumnName = "id")
    private ProductInformation productInformation;

    /**
     * 测试说明
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectId")
    @Where(clause = "(isDel is null or isDel = 0) and object_type='" + ProductFile.ProductFileType.ENTIRETY_TEST_EXPLAIN + "'")
    private List<ProductFile> explain;
    /**
     * 测试说明-历史记录
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectId")
    @Where(clause = "is_del = 1 and object_type='" + ProductFile.ProductFileType.ENTIRETY_TEST_EXPLAIN + "'")
    private List<ProductFile> explainHis;

    /**
     * 测试工具
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectId")
    @Where(clause = "(isDel is null or isDel = 0) and object_type='" + ProductFile.ProductFileType.ENTIRETY_TEST_TOOL + "'")
    private List<ProductFile> tool;
    /**
     * 测试工具-历史记录
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectId")
    @Where(clause = "is_del = 1 and object_type='" + ProductFile.ProductFileType.ENTIRETY_TEST_TOOL + "'")
    private List<ProductFile> toolHis;

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

        CollectionUtil.addToList(rst, getExplain());
        CollectionUtil.addToList(rst, getTool());

        return rst;
    }

}
