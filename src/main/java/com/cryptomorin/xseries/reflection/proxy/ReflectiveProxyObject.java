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

package com.cryptomorin.xseries.reflection.proxy;

import com.cryptomorin.xseries.reflection.proxy.annotations.Ignore;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * All interfaces used for {@link com.cryptomorin.xseries.reflection.XReflection#proxify(Class)} must
 * extend this interface. Instances of this class can be thought as a dynamic {@link Class} object that
 * contains methods, fields and constructors, whether final or static, but all in forms of public methods.
 * <p>
 * The first instance of this class should be used for only calling constructors, static methods and fields,
 * and {@link #bindTo(Object)} method. However, it's possible to create two separate classes for constructors
 * and static members and one for non-static members without constructors.
 *
 * @see ReflectiveProxy
 * @since 13.0.0
 */
@ApiStatus.Experimental
public interface ReflectiveProxyObject {
    @Nullable
    @Ignore
    Object instance();

    /**
     * Returns a new {@link ReflectiveProxyObject} that's linked to a new {@link ReflectiveProxy} with the given instance.
     *
     * @param instance the instance to bind.
     */
    @NotNull
    @ApiStatus.OverrideOnly
    @Ignore
    ReflectiveProxyObject bindTo(@NotNull Object instance);
}
