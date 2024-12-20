/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2024 Crypto Morin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.cryptomorin.xseries.reflection.jvm.objects;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

final class ReflectedObjectMethod implements ReflectedObject {
    private final Method delegate;

    ReflectedObjectMethod(Method delegate) {this.delegate = delegate;}

    @Override
    public Type type() {
        return Type.METHOD;
    }

    @Override
    public Object unreflect() {
        return delegate;
    }

    @Override
    public String name() {
        return delegate.getName();
    }

    @Override
    public Class<?> getDeclaringClass() {
        return delegate.getDeclaringClass();
    }

    @Override
    public int getModifiers() {
        return delegate.getModifiers();
    }

    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationClass) {
        return delegate.getAnnotation(annotationClass);
    }

    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
        return delegate.isAnnotationPresent(annotationClass);
    }

    @Override
    public <A extends Annotation> A[] getAnnotationsByType(Class<A> annotationClass) {
        return delegate.getAnnotationsByType(annotationClass);
    }

    @Override
    public Annotation[] getAnnotations() {
        return delegate.getAnnotations();
    }

    @Override
    public <A extends Annotation> A getDeclaredAnnotation(Class<A> annotationClass) {
        return delegate.getDeclaredAnnotation(annotationClass);
    }

    @Override
    public <A extends Annotation> A[] getDeclaredAnnotationsByType(Class<A> annotationClass) {
        return delegate.getDeclaredAnnotationsByType(annotationClass);
    }

    @Override
    public Annotation[] getDeclaredAnnotations() {
        return delegate.getDeclaredAnnotations();
    }
}