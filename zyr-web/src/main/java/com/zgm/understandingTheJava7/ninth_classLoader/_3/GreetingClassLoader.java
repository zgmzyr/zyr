/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.ninth_classLoader._3;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: GreetingClassLoader.java $Date: 2013-3-18 下午9:42:40 -0400 2013
 * @since 1.0
 * 
 */
public class GreetingClassLoader extends ClassLoader implements Opcodes {
private String message;
    
    public GreetingClassLoader(String message) {
        this.message = message;
    }
    
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = generateClassData(name);
        return defineClass(name, classData, 0, classData.length);
    }

    private byte[] generateClassData(String className) {
        className = className.replaceAll("\\.", "/");
        ClassWriter writer = new ClassWriter(0);
        writer.visit(V1_7, ACC_PUBLIC + ACC_SUPER, className, null, "java/lang/Object", null);
        MethodVisitor mv = writer.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitCode();
        mv.visitVarInsn(ALOAD, 0);
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn(message);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
        mv.visitInsn(RETURN);
        mv.visitMaxs(2, 1);
        mv.visitEnd();
        writer.visitEnd();
        return writer.toByteArray();
    }
}
