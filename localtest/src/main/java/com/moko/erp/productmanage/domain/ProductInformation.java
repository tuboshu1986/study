package com.moko.erp.productmanage.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections.CollectionUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 生产资料
 */
@Setter
@Getter
@Entity
@Table(name = "product_information")
public class ProductInformation extends BaseModel {
    private static final long serialVersionUID = 1L;
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductManage product;

    /**
     * 产品组成代码
     */
    private String elementCode;

    /**
     * 产品组成名称
     */
    private String elementName;

    /**
     * 产品组成备注
     */
    private String elementRemarks;

    /**
     * 产品有效列
     */
    private String elementIngredient;

    /**
     * 包装方法，普通气泡装：1，防静电袋：2
     */
    private Integer packType;

    /**
     * 是否是拼板，是：1，否：2
     */
    private Integer panelType;

    /**
     * 是否使用三防漆，是：1，否：2
     */
    private Integer paintType;

    /**
     * 其他要求
     */
    private String otherDemand;

    /**
     * 生产概要
     */
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "productInformation", fetch = FetchType.LAZY)
    private ManufactureSammary manufactureSammary;

    /**
     * pcb资料
     */
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "productInformation", fetch = FetchType.LAZY)
    private PCBInformation pcbInformation;

    /**
     * pcba资料
     */
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "productInformation", fetch = FetchType.LAZY)
    private PCBAInformation pcbaInformation;

    /**
     * 组装资料
     */
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "productInformation", fetch = FetchType.LAZY)
    private PackageInformation packageInformation;

    /**
     * 整机测试
     */
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "productInformation", fetch = FetchType.LAZY)
    private EntiretyTest entiretyTest;

    /**
     * 包装
     */
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "productInformation", fetch = FetchType.LAZY)
    private ProductPack productPack;

    /**
     * 其他
     */
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "productInformation", fetch = FetchType.LAZY)
    private ProductOther productOther;

    /**
     * 将objectId设置到对应的文件信息
     * @return
     */
    public Integer[] objectIds(){
        List<Integer> ids = new ArrayList<>();
        if(manufactureSammary != null) {
            ids.add(manufactureSammary.getId());
        }
        if(pcbInformation != null) {
            ids.add(pcbInformation.getId());
        }
        if(pcbaInformation != null) {
            ids.add(pcbaInformation.getId());
        }
        if(packageInformation != null) {
            ids.add(packageInformation.getId());
        }
        if(entiretyTest != null) {
            ids.add(entiretyTest.getId());
        }
        if(productPack != null) {
            ids.add(productPack.getId());
        }
        if(productOther != null) {
            ids.add(productOther.getId());
        }
        return ids.toArray(new Integer[ids.size()]);
    }

    /**
     * 将objectId设置到对应的文件信息
     * @return
     */
    public void setValidFileObjectId(){
        List<ProductFile> rst = new ArrayList<>();
        if(manufactureSammary != null) {
            manufactureSammary.setValidFileObjectId();
        }
        if(pcbInformation != null) {
            pcbInformation.setValidFileObjectId();
        }
        if(pcbaInformation != null) {
            pcbaInformation.setValidFileObjectId();
        }
        if(packageInformation != null) {
            packageInformation.setValidFileObjectId();
        }
        if(entiretyTest != null) {
            entiretyTest.setValidFileObjectId();
        }
        if(productPack != null) {
            productPack.setValidFileObjectId();
        }
        if(productOther != null) {
            productOther.setValidFileObjectId();
        }
    }

    /**
     * 获取该产品资料中的所有文件信息
     * @return
     */
    public List<ProductFile> allValidFileInfo(){
        List<ProductFile> rst = new ArrayList<>();
        if(manufactureSammary != null) {
            addToList(rst, manufactureSammary.allValidFileInfo());
        }
        if(pcbInformation != null) {
            addToList(rst, pcbInformation.allValidFileInfo());
        }
        if(pcbaInformation != null) {
            addToList(rst, pcbaInformation.allValidFileInfo());
        }
        if(packageInformation != null) {
            addToList(rst, packageInformation.allValidFileInfo());
        }
        if(entiretyTest != null) {
            addToList(rst, entiretyTest.allValidFileInfo());
        }
        if(productPack != null) {
            addToList(rst, productPack.allValidFileInfo());
        }
        if(productOther != null) {
            addToList(rst, productOther.allValidFileInfo());
        }
        return rst;
    }

    private void addToList(List<ProductFile> to, List<ProductFile> from){
        if(CollectionUtils.isNotEmpty(from)){
            to.addAll(from);
        }
    }

}
