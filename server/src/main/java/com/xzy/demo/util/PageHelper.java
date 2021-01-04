package com.xzy.demo.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

/**
 * @author xiazhengyue
 * @since 2021-01-04
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PageHelper {

    public static int offset(int pageNum, int pageSize) {
        Assert.isTrue(pageNum > 0, "传入的页码非法");
        Assert.isTrue(pageSize > 0, "传入的分页大小非法");
        return (pageNum - 1) * pageSize;
    }
}
