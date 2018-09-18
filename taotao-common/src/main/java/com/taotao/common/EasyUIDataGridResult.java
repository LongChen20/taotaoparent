package com.taotao.common;

import java.io.Serializable;
import java.util.List;


/**
 * @author LGCN
 * 封装第几页，和每页显示多少条的集合。
 */
public class EasyUIDataGridResult<T> implements Serializable {

    /**
     * 页码
     */
    private Integer total;

    /**
     * 封装集合数据
     */
    private List<T> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
