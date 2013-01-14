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

package ch.sebastienzurfluh.swissmuseum.core.client.patterns;

/**
 * Parce que j'emmerde Java.
 *
 * @author Sebastien Zurfluh
 *
 * @param <T>
 */
public class MutablePrimitiveReference<T> {
	public MutablePrimitiveReference(T value) {
		this.value = value;
	}

	private T value;

	public T getValue() {
		return value;	
	}

	public void setValue(T value) {
		this.value = value;	
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MutablePrimitiveReference)
			return super.equals(obj);
		return getValue().equals(obj);
	}
	
	@Override
	public String toString() {
		return getValue().toString();
	}
}