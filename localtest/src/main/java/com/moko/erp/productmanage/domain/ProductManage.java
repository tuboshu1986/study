package com.moko.erp.productmanage.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 产品管理
 *
 * @author MOKO
 */
@Entity
@Table(name = "t_product_descs")
@Getter
@Setter
@Data
public class ProductManage extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 产品名称
     */
    @Column(name = "name")
    private String name;

    /**
     * MOKO编码
     */
    @Column(name = "moko_no")
    private String mokoNo;

    /**
     * 产品类别
     */
    @Column(name = "type")
    private String type;

    /**
     * 库存
     */
    @Column(name = "available_qty")
    private String availableQty;

    /**
     * 产品版本
     */
    @Column(name = "p_version")
    private String pversion;

    /**
     * 产品图片（存储路径）
     */
    @Column(name = "p_pic")
    private String ppic;

    /**
     * 产品简介
     */
    @Column(name = "p_introduction")
    private String pintroduction;

    /**
     * 产品描述（存储html）
     */
    @Column(name = "p_describe")
    private String pdescribe;

    /**
     * 产品规格书原始文件名称
     */
    @Column(name = "p_spec_name")
    private String pspecName;

    /**
     * 产品规格书  （存储路径）
     */
    @Column(name = "p_spec")
    private String pspec;

    /**
     * 产品规格书url  （存储url）
     */
    @Column(name = "p_spec_url")
    private String pspecUrl;

    /**
     * 产品彩页原始文件名称
     */
    @Column(name = "p_color_page_name")
    private String pcolorPageName;

    /**
     * 产品彩页（存储路径）
     */
    @Column(name = "p_color_page")
    private String pcolorPage;

    /**
     * 产品彩页url（存储url）
     */
    @Column(name = "p_color_page_url")
    private String pcolorPageUrl;

    /**
     * 其他资料原始文件名称
     */
    @Column(name = "p_other_resource_name")
    private String potherResourceName;

    /**
     * 其他资料（存储路径）
     */
    @Column(name = "p_other_resource")
    private String potherResource;

    /**
     * 其他资料url（存储url）
     */
    @Column(name = "p_other_resource_url")
    private String potherResourceUrl;

    /**
     * 提交时间
     */
    @Column(name = "commit_at")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:SS")
    private Date commitAt;

    /**
     * 产品状态 1未提交 2已提交 3已退回 4待BOM审核 5待研发审核 6待发布 7被驳回 8已发布 9已停售
     */
    @Column(name = "state")
    private Integer state;

    /**
     * 驳回原因
     */
    @Column(name = "reason")
    private String reason;

    /**
     * ecn
     */
    @Column(name = "is_ecn")
    private Integer isEcn;

    @Column(name = "per_sale_manager")
    private String perSaleManager;

    @Column(name = "per_order_sale")
    private String perOrderSale;

    @Column(name = "per_product_manager")
    private String perProductManager;

    @Column(name = "per_rd_engineer")
    private String perRdEngineer;

    public String getProductManagerStr(){
        return fullNames(perProductManager);
    }

    public String getSaleManagerStr(){
        return fullNames(perSaleManager);
    }

    private String fullNames(String info){
        if(StringUtils.isEmpty(info)){
            return "";
        }
        String[] userEntrys = info.split(",");
        List<String> names = new ArrayList<>();
        for(String entry : userEntrys){
            String[] strs = entry.split("#::#");
            names.add(strs[1]);
        }
        final StringBuffer rstBuffer = new StringBuffer();
        names.forEach(item -> {
            rstBuffer.append(item + ",");
        });
        String str = rstBuffer.toString();
        return str.length() == 0 ? "" : (str.endsWith(",") ? str.substring(0, str.length() - 1) : str);
    }

}
