/*
 * Copyright 2014-2015 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kotcrab.vis.runtime.component.proto;

import com.kotcrab.vis.runtime.component.VisSpriter;
import com.kotcrab.vis.runtime.properties.FlipOwner;
import com.kotcrab.vis.runtime.properties.PositionOwner;
import com.kotcrab.vis.runtime.properties.RotationOwner;

/** @author Kotcrab */
public class ProtoVisSpriter extends ProtoComponent<VisSpriter> implements PositionOwner, RotationOwner, FlipOwner {
	public float x, y;
	public float rotation;
	public float scale;
	public boolean flipX, flipY;

	public boolean playOnStart;
	public int defaultAnimation;

	public ProtoVisSpriter () {
	}

	public ProtoVisSpriter (VisSpriter comp) {
		x = comp.getX();
		y = comp.getY();

		scale = comp.player.getScale();

		rotation = comp.getRotation();

		flipX = comp.isFlipX();
		flipY = comp.isFlipY();

		playOnStart = comp.playOnStart;
		defaultAnimation = comp.defaultAnimation;
	}

	@Override
	public void fill (VisSpriter comp) {
		comp.setPosition(x, y);
		comp.player.setScale(scale);
		comp.setRotation(rotation);
		comp.setFlip(flipX, flipY);
		comp.onDeserialize(playOnStart, defaultAnimation);
	}

	@Override
	public float getX () {
		return x;
	}

	@Override
	public void setX (float x) {
		this.x = x;
	}

	@Override
	public float getY () {
		return y;
	}

	@Override
	public void setY (float y) {
		this.y = y;
	}

	@Override
	public void setPosition (float x, float y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public float getRotation () {
		return rotation;
	}

	@Override
	public void setRotation (float rotation) {
		this.rotation = rotation;
	}

	@Override
	public boolean isFlipX () {
		return flipX;
	}

	@Override
	public boolean isFlipY () {
		return flipY;
	}

	@Override
	public void setFlip (boolean x, boolean y) {
		this.flipX = x;
		this.flipY = y;
	}
}