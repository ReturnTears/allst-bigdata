package com.allst.java.cascader;

import lombok.Data;

import java.util.List;

/**
 * @author YiYa
 * @since 2020/7/24-19:02
 */
@Data
public class TreeItem {
    private Integer id;

    private Integer parentId;

    private String name;

    private List<TreeItem> children;
}
