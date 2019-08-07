package com.moko.erp.productmanage.domain;

import com.moko.erp.productmanage.common.CollectionUtil;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 生产资料-生产概要
 */
@Setter
@Getter
@Entity
@Table(name = "manufacture_sammary")
public class ManufactureSammary extends BaseModel {

    private static final long serialVersionUID = 1L;
    /**
     * 生产资料
     */
    @OneToOne
    @JoinColumn(name = "product_information_id", referencedColumnName = "id")
    private ProductInformation productInformation;

    /**
     * 生产说明
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectId")
    @Where(clause = "(is_del is null or is_del = 0) and object_type='" + ProductFile.ProductFileType.MANUFACTURE_SAMMARY + "'")
    private List<ProductFile> manufactureExplain;

    /**
     * 生产说明-历史版本
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectId")
    @Where(clause = "is_del = 1 and object_type='" + ProductFile.ProductFileType.MANUFACTURE_SAMMARY + "'")
    private List<ProductFile> manufactureExplainHis;

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
        CollectionUtil.addToList(rst, getManufactureExplain());
        return rst;
    }

}
