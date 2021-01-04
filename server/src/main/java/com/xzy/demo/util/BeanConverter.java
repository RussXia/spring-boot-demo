package com.xzy.demo.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xiazhengyue
 * @since 2021-01-04
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanConverter {

    public static <T> T copyProperties(Object source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }
        T t = null;
        try {
            t = targetClass.newInstance();
            BeanUtils.copyProperties(source, t);
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(String.format("Create new instance of %s failed: %s", targetClass, e.getMessage()));
        }
        return t;
    }

    public static <T> List<T> copyPropertiesOfList(List sourceList, Class<T> targetClass) {
        if (sourceList == null || sourceList.isEmpty()) {
            return Collections.emptyList();
        }
        List<T> resultList = new ArrayList<>(sourceList.size());
        for (Object source : sourceList) {
            T t = BeanConverter.copyProperties(source, targetClass);
            resultList.add(t);
        }
        return resultList;
    }
}
