package com.hb.ztree;

import java.util.List;

public interface TreeDataSource {
    TreeModel findOne(Integer id);
    TreeModel save(TreeModel obj);
    List<Item> getData();
}
