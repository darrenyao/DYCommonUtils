package com.darrenyao.utils;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by yixuan.yhl on 09/02/2017.
 */
public class CommonUtil {

    public static <T> List<List<T>> getPages(Collection<T> c, Integer pageSize) {
        if (CollectionUtils.isEmpty(c))
            return Collections.emptyList();

        List<T> list = new ArrayList<T>(c);
        if (pageSize == null || pageSize <= 0 || pageSize > list.size())
            pageSize = list.size();

        int numPages = (int) Math.ceil((double)list.size() / (double)pageSize);
        List<List<T>> pages = new ArrayList<List<T>>(numPages);
        for (int pageNum = 0; pageNum < numPages;)
            pages.add(list.subList(pageNum * pageSize, Math.min(++pageNum * pageSize, list.size())));
        return pages;
    }
}
