package com.xzy.demo;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import java.sql.Types;

/**
 * @author xiazhengyue
 * @since 2020-12-31
 */
public class CustomJavaTypeResolverDefaultImpl extends JavaTypeResolverDefaultImpl {
    public CustomJavaTypeResolverDefaultImpl() {
        super();
        typeMap.put(Types.TINYINT, new JdbcTypeInformation("TINYINT", //$NON-NLS-1$
                new FullyQualifiedJavaType(Integer.class.getName())));
    }


}
