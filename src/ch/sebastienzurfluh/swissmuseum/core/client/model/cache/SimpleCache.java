/*
 * Copyright 2012-2013 Sebastien Zurfluh
 * 
 * This file is part of "Parcours".
 * 
 * "Parcours" is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * "Parcours" is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with "Parcours".  If not, see <http://www.gnu.org/licenses/>.
 */

package ch.sebastienzurfluh.swissmuseum.core.client.model.cache;

/**
 * This is the simplest implementation possible with only one cached value, therefore no eviction policy.
 *
 *
 * @author Sebastien Zurfluh
 *
 * @param <Key>
 * @param <Value>
 */
public class SimpleCache<Key, Value> implements Cache<Key, Value> {
	Key key;
	Value value;

	@Override
	public Value get(Key key) {
		return this.key == key ? value : null;
	}

	@Override
	public void put(Key key, Value value) {
		this.key = key;
		this.value = value;
	}
}
