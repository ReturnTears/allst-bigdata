package com.allst.java.cascader;

import lombok.Data;

/**
 * @author YiYa
 * @since 2020/7/24-19:01
 */
@Data
public class Department {

    private Integer id;

    private Integer parentId;

    private String name;

    public Department(Integer id, Integer parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }

    public static TreeItem deptNode(Department dept) {
        TreeItem treeItem = new TreeItem();
        treeItem.setId(dept.getId());
        treeItem.setName(dept.getName());
        treeItem.setParentId(dept.getParentId());
        return treeItem;
    }
}
