package com.moko.erp.productmanage.common;

import com.moko.erp.productmanage.domain.ProductFile;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

public class CollectionUtil {

    public static void addToList(List<ProductFile> to, List<ProductFile> from){
        if(CollectionUtils.isNotEmpty(from)){
            to.addAll(from);
        }
    }

}
