/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
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
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.command.parameters.specification.factories;

import org.spongepowered.api.command.parameters.CommandExecutionContext;
import org.spongepowered.api.command.parameters.specification.ValueParameter;
import org.spongepowered.api.command.parameters.specification.ValueParameterModifier;

import java.util.function.Supplier;

/**
 * Provides {@link ValueParameterModifier}s that cannot be cataloged.
 */
public interface ValueParameterModifierFactory {

    /**
     * Requires the parameter to be provided a certain number of times.
     *
     * <p>Command values will be stored under their provided keys in the
     * {@link CommandExecutionContext}.</p>
     *
     * @param times The number of times to repeat the element.
     * @return The {@link ValueParameterModifier}
     */
    ValueParameterModifier repeated(int times);

    /**
     * If after a {@link ValueParameter}'s execution there is no value stored
     * in the associated key, this modifier will put the supplied default into
     * the context.
     *
     * @param defaultValue The default value.
     * @return The {@link ValueParameterModifier}
     */
    ValueParameterModifier defaultValue(Object defaultValue);

    /**
     * If after a {@link ValueParameter}'s execution there is no value stored
     * in the associated key, this modifier will put the default obtained from
     * the supplied {@link Supplier} into the context, if the default is
     * non-null.
     *
     * @param defaultValueSupplier The default value {@link Supplier}.
     * @return The {@link ValueParameterModifier}
     */
    ValueParameterModifier defaultValueSupplier(Supplier<Object> defaultValueSupplier);

}
