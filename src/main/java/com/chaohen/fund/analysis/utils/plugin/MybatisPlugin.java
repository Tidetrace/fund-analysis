package com.chaohen.fund.analysis.utils.plugin;


import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.ShellRunner;
import org.mybatis.generator.api.dom.java.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 代码自动生成插件
 */
public class MybatisPlugin extends PluginAdapter {

    public static void main(String[] args) {
        String config = MybatisPlugin.class.getClassLoader()
                .getResource("plugins/generatorConfig.xml")
                .getFile();
        String[] arg = {"-configfile", config, "-overwrite"};
        ShellRunner.main(arg);
    }


    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,
                                   IntrospectedTable introspectedTable) {
        interfaze.addImportedType(new FullyQualifiedJavaType("org.springframework.stereotype.Repository"));
        interfaze.addAnnotation("@Repository");
        return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        generateToString(introspectedTable, topLevelClass);
        return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
    }


    @Override
    public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass,
                                                      IntrospectedTable introspectedTable) {
        generateToString(introspectedTable, topLevelClass);
        return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
    }

    private void generateToString(IntrospectedTable introspectedTable, TopLevelClass topLevelClass) {
        topLevelClass.addImportedType(new FullyQualifiedJavaType("lombok.Data"));
        topLevelClass.addImportedType(new FullyQualifiedJavaType("lombok.NoArgsConstructor"));
        topLevelClass.addImportedType(new FullyQualifiedJavaType("lombok.AllArgsConstructor"));
//        topLevelClass.addImportedType(new FullyQualifiedJavaType("com.common.base.domain.AbstractEntity"));

        //添加注解
        topLevelClass.addAnnotation("@Data");
        topLevelClass.addAnnotation("@NoArgsConstructor");
        topLevelClass.addAnnotation("@AllArgsConstructor");

        // 设置继承类
//        topLevelClass.setSuperClass("AbstractEntity<Long>");


        List<Field> fields = topLevelClass.getFields();
        Map<String, Field> map = new HashMap<String, Field>();
        for (Field field : fields) {
            map.put(field.getName(), field);
        }
        List<IntrospectedColumn> columns = introspectedTable.getAllColumns();
        for (IntrospectedColumn column : columns) {
            Field f = map.get(column.getJavaProperty());
            if (f != null) {
                f.getJavaDocLines().clear();
                if (column.getRemarks() != null) {
                    f.addJavaDocLine("/** " + column.getRemarks() + " */");
                }
            }
        }
    }

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass,
                                              IntrospectedColumn introspectedColumn,
                                              IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        // 去除Setter
        return false;
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass,
                                              IntrospectedColumn introspectedColumn,
                                              IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        // 去除Getter
        return false;
    }


}
