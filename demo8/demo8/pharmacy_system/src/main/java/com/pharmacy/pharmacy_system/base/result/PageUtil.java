package com.pharmacy.pharmacy_system.base.result;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageUtil {

    public static PageInfo pageResultInfo(List<?> list) {
        return new PageInfo<>(list);
    }

    public static <T> PageVO<T> pageResultVO(List<T> list) {
        return new PageVO<>(list);
    }

}
