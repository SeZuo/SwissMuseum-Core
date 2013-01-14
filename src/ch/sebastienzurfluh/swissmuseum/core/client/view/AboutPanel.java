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

package ch.sebastienzurfluh.swissmuseum.core.client.view;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.FlowPanel;

public class AboutPanel extends FlowPanel {
	public AboutPanel() {
		add(new HTML("<h1>A propos de Mimosa 3.</h1><p>Créé par Sébastien Zurfluh pour le" +
				"Musée des Suisses dans le Monde, Mimosa 3 permet l'édition des Parcours " +
				"de Penthes.</p><p>Utilisez les boutons \"+\" pour ajouter un nouveau groupe," +
				"ou une nouvelle page. Le signet \"ressources\" en haut de la page, vous" +
				"permettra d'ajouter du contenu graphique (vidéos, images, ...) à vos parcours." +
				"</p>"));
		add(new HTML("<h1>A propos des parcours de Penthes.</h1><p>Ce guide virtuel vous " +
				"emporte dans le Musée des Suisses dans le Monde, à la découverte de " +
				"l'exposition permanente et de ses nombreuses curiosités.</p><p>" +
				"Les sources de ce programme sont sous licence libre GPLv3, et vous êtes libres" +
				"de les modifier et de les réutiliser. Le Musée des Suisses dans le Monde" +
				"estime que son travail doit pouvoir servir à l'amélioration d'autres musées." +
				"</p>"));
	}
}
