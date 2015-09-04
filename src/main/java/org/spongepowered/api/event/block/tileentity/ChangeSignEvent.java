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
package org.spongepowered.api.event.block.tileentity;

import org.spongepowered.api.block.tileentity.Sign;
import org.spongepowered.api.data.manipulator.immutable.tileentity.ImmutableSignData;
import org.spongepowered.api.data.manipulator.mutable.tileentity.SignData;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.command.CommandSourceEvent;
import org.spongepowered.api.event.entity.EntityEvent;
import org.spongepowered.api.event.entity.living.LivingEvent;
import org.spongepowered.api.event.entity.living.human.HumanEvent;
import org.spongepowered.api.event.entity.living.player.PlayerEvent;

public interface ChangeSignEvent extends TargetTileEntityEvent, Cancellable {

    /**
     * Gets the target {@link Sign} being changed.
     *
     * @return The Sign
     */
    @Override
    Sign getTargetTile();

    /**
     * Gets the original {@link ImmutableSignData} before event changes.
     * @return The immutable SignData
     */
    ImmutableSignData getOriginalText();

    /**
     * Gets the {@link SignData} to be applied to the {@link Sign} after event resolution.
     * @return The SignData
     */
    SignData getText();

    /**
     * An event where an {@link CommandSource} is the source.
     */
    interface SourceCommandSource extends ChangeSignEvent, CommandSourceEvent { }

    /**
     * An event where an {@link Entity} is the source.
     */
    interface SourceEntity extends ChangeSignEvent, EntityEvent { }

    /**
     * An event where an {@link Living} is the source.
     */
    interface SourceLiving extends SourceEntity, LivingEvent { }

    /**
     * An event where an {@link Human} is the source.
     */
    interface SourceHuman extends SourceLiving, HumanEvent { }

    /**
     * An event where a {@link Player} is the source.
     */
    interface SourcePlayer extends SourceHuman, PlayerEvent { }

}