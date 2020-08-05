package com.allst.java.cascader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author YiYa
 * @since 2020/7/24-19:04
 */
public class CascaderApp {
    public static void main(String[] args) {
        //创建部门
        List<Department> deptList = Arrays.asList(
            new Department(1, 0, "星宇"),
            new Department(2, 1, "金3"),
            new Department(3, 2, "金3/1"),
            new Department(4, 2, "金3/2"),
            new Department(5, 1, "总1"),
            new Department(6, 5, "总1/2")
        );
        //创建员工
        List<Employee> empList = Arrays.asList(
            new Employee(1, "张三", 5),
            new Employee(2, "李四", 6),
            new Employee(3, "王五", 2),
            new Employee(4, "赵六", 2),
            new Employee(5, "田七", 3),
            new Employee(6, "牛八", 4)
        );
        //转换成结点
        List<TreeItem> allDept = deptList.stream().map(Department::deptNode).collect(Collectors.toList());
        //按照上级部门分组
        Map<Integer, List<TreeItem>> deptMap = allDept.stream().collect(Collectors.groupingBy(TreeItem::getParentId));
        //给每个部门绑定子部门
        allDept.forEach(node -> node.setChildren(deptMap.get(node.getId())));

        List<TreeItem> treeItem = deptMap.get(0);

        Map<Integer, List<TreeItem>> empMap = empList.stream().filter(emp -> emp.getDeptId() != null).map(Employee::empNode)
                .collect(Collectors.groupingBy(TreeItem::getParentId));
        //BFS辅助队列
        List<TreeItem> queue = new ArrayList<>(treeItem);
        for (int i = 0; i < queue.size(); i++) {
            TreeItem node = queue.get(i);
            //遍历时先将子部门放入队列中
            if (node.getChildren() != null) {
                queue.addAll(node.getChildren());
            } else {
                node.setChildren(new ArrayList<>());
            }
            //再将部门成员放入子结点中
            List<TreeItem> children = empMap.get(node.getId());
            if (children != null) {
                node.getChildren().addAll(children);
            }
        }
        treeItem.forEach(System.out::println);
    }
}
