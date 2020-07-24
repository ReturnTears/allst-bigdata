package com.allst.java.cascader;

import lombok.Data;

/**
 * @author YiYa
 * @since 2020/7/24-19:03
 */
@Data
public class Employee {
    private Integer id;

    private String name;

    private Integer deptId;

    public Employee(Integer id, String name, Integer deptId) {
        this.id = id;
        this.name = name;
        this.deptId = deptId;
    }

    public static TreeItem empNode(Employee emp) {
        TreeItem treeItem = new TreeItem();
        treeItem.setId(emp.getId());
        treeItem.setName(emp.getName());
        treeItem.setParentId(emp.getDeptId());
        return treeItem;
    }
}
