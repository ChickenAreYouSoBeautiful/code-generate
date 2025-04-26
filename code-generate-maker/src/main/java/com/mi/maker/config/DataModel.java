package com.mi.maker.config;

import lombok.Data;

/**
 * @author mi
 * @data 2025/4/10 22:05
 * @version 1.0
 */
@Data
public class DataModel {

    /**
     * 是否循环
     */
    private boolean loop;

    /**
     * 作者信息
     */
    private String author = "睿智";

    /**
     * 输出语句
     */
    private String outputText = "sum =";
}
