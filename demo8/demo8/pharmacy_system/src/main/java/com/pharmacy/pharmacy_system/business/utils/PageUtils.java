package com.pharmacy.pharmacy_system.business.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageUtils {

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 每页显示记录条数
     */
    private int pageSizes;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 总条数
     */
    private int total;

    /**
     * 每页显示的数据
     */
    private List<?> dataList;

    /**
     * 开始数据
     */
    private int star;
    public PageUtils paging() {

        try {
            //查询出的list数据
            List<?> showdata = this.dataList;
            //刚开始的页面为第一页
            if (this.currentPage == null) {
                this.currentPage = 1;
            }
            //每页的开始数
            this.star = ((this.currentPage - 1) * this.pageSizes);
            //list的大小
            int count = showdata.size();
            //设置总页数
            this.totalPage = (count % this.pageSizes == 0 ? count / this.pageSizes : count / this.pageSizes + 1);
            //对list进行截取
            this.dataList = (showdata.subList(this.star, count - this.star > this.pageSizes ? this.star + this.pageSizes : count));
            PageUtils pages = new PageUtils();
            pages.setCurrentPage(this.currentPage);
            pages.setPageSizes(this.pageSizes);
            pages.setTotal(count);
            pages.setTotalPage(this.totalPage);
            pages.setDataList(this.dataList);
            return pages;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
