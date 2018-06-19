package com.yuanli.latte.compiler;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Modifier;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor7;

/**
 * ElectronicCommerce
 *
 * @author liyuanli
 * @data 2018/6/13
 */

public final class EntryVisiter extends SimpleAnnotationValueVisitor7<Void, Void> {

    private Filer mFiler = null;
    private String mPackageName = null;

    public void setFiler(Filer filer) {
        this.mFiler = filer;
    }

    @Override
    public Void visitString(String s, Void p) {
        mPackageName = s;
        return p;
    }

    @Override
    public Void visitType(TypeMirror t, Void aVoid) {
        generateJavaCode(t);
        return aVoid;
    }

    private void generateJavaCode(TypeMirror typeMirror) {
        final TypeSpec targetActivity=
                TypeSpec.classBuilder("WXEntryActivity")
                .addModifiers(Modifier.PUBLIC)
                .addModifiers(Modifier.FINAL)//没有办法继承
                .superclass(TypeName.get(typeMirror))//继承那个类？从注解中拿出来的类类型
                .build();

        //注解中写入的packagename+
        final JavaFile javaFile=JavaFile.builder(mPackageName+".wxapi",targetActivity)
                .addFileComment("微信入口文件")//注释
                .build();
        try {
            javaFile.writeTo(mFiler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
