package com.xzy.demo;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

/**
 *
 * @author xiazhengyue
 * @since 2021-01-04
 */
@Deprecated
public class RenameJavaMapperPlugin extends PluginAdapter {

    private String replaceString;
    private Pattern pattern;

    public RenameJavaMapperPlugin() {
    }

    @Override
    public boolean validate(List<String> warnings) {

        String searchString = properties.getProperty("searchString");
        replaceString = properties.getProperty("replaceString"); //$NON-NLS-1$

        boolean valid = stringHasValue(searchString);

        if (valid) {
            pattern = Pattern.compile(searchString);
        } else {
            warnings.add(getString("ValidationError.18", //$NON-NLS-1$
                    "RenameExampleClassPlugin", //$NON-NLS-1$
                    "searchString")); //$NON-NLS-1$
        }

        return valid;
    }

    @Override
    public void initialized(IntrospectedTable introspectedTable) {
        String oldType = introspectedTable.getMyBatis3JavaMapperType();
        Matcher matcher = pattern.matcher(oldType);
        oldType = matcher.replaceAll(replaceString);

        introspectedTable.setMyBatis3JavaMapperType(oldType);
    }
}
