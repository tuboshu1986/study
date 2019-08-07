package com.moko.erp.productmanage.domain;

import com.moko.core.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 产品修改记录表
 * @author MOKO
 *
 */
@Entity
@Table(name = "t_product_alters")
@Getter
@Setter
public class ProductRecord implements Serializable {
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "p_id")
    private ProductManage pid;
	
	//创建人
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "p_create")
    private User pcreater;
	
	//创建时间
	@Column(name = "created_at ")
    private Date createdAt;
    
	//修改人
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "p_alter")
    private User palter;
	
	//修改时间
	@Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "reason")
    private String reason;
}
