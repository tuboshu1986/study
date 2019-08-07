package com.moko.erp.productmanage.domain;

import com.moko.erp.productmanage.common.CollectionUtil;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 生产资料-PCB资料
 */
@Setter
@Getter
@Entity
@Table(name = "pcb_Information")
public class PCBInformation extends BaseModel {
    private static final long serialVersionUID = 1L;
    /**
     * 生产资料
     */
    @OneToOne
    @JoinColumn(name = "product_information_id", referencedColumnName = "id")
    private ProductInformation productInformation;

    /**
     * Gerber-单板文件
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectId")
    @Where(clause = "(isDel is null or isDel = 0) and object_type='" + ProductFile.ProductFileType.PCB_INFORMATION_GSINGLE + "'")
    private List<ProductFile> gerberSinglePanel;
    /**
     * Gerber-单板文件-历史版本
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectId")
    @Where(clause = "is_del = 1 and object_type='" + ProductFile.ProductFileType.PCB_INFORMATION_GSINGLE + "'")
    private List<ProductFile> gerberSinglePanelHis;

    /**
     * Gerber-拼板文件
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectId")
    @Where(clause = "(is_del is null or is_del = 0) and object_type='" + ProductFile.ProductFileType.PCB_INFORMATION_GJOINT + "'")
    private List<ProductFile> gerberJointPanel;
    /**
     * Gerber-拼板文件-历史版本
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectId")
    @Where(clause = "is_del and object_type='" + ProductFile.ProductFileType.PCB_INFORMATION_GJOINT + "'")
    private List<ProductFile> gerberJointPanelHis;

    /**
     * 工艺要求
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectId")
    @Where(clause = "(is_del is null or is_del = 0) and object_type='" + ProductFile.ProductFileType.PCB_INFORMATION_CRAFT + "'")
    private List<ProductFile> craftDemand;
    /**
     * 工艺要求-历史版本
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectId")
    @Where(clause = "is_del = 1 and object_type='" + ProductFile.ProductFileType.PCB_INFORMATION_CRAFT + "'")
    private List<ProductFile> craftDemandHis;

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

        CollectionUtil.addToList(rst, getGerberSinglePanel());
        CollectionUtil.addToList(rst, getGerberJointPanel());
        CollectionUtil.addToList(rst, getCraftDemand());

        return rst;
    }

}
