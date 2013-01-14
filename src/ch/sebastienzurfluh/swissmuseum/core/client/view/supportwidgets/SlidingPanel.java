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

package ch.sebastienzurfluh.swissmuseum.core.client.view.supportwidgets;

import ch.sebastienzurfluh.swissmuseum.core.client.model.Model;
import ch.sebastienzurfluh.swissmuseum.core.client.view.Config;

import com.google.gwt.animation.client.Animation;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;

public class SlidingPanel extends AbsolutePanel {
	private static final int SLOW = 400; //ms
	
	private HorizontalPanel movingPanel = new HorizontalPanel();
	private SlideAnimator slideAnimator;
	
	/**
	 * We will move the length of the panel
	 */
	private int panelWidth = Config.WINDOW_WIDTH;
	
	public SlidingPanel(Model model) {
		add(movingPanel, 0, 0);
		
		slideAnimator = new SlideAnimator(this, movingPanel);
	}
	
	/**
	 * SlidingPanel has to be rendered before calling this function.
	 * @param panel (we need it's offset width).
	 */
	public void addPanel(Panel panel) {
		movingPanel.add(panel);
	}
	
	public void moveToNextPanel() {
		move(-panelWidth);
	}
	

	public void moveToPreviousPanel() {
		move(panelWidth);
	}

	private void move(int delta) {
		System.out.println("SlidingPanel: Move: [initial position: " +
				movingPanel.getAbsoluteLeft() + ", delta" + delta + "]");
		slideAnimator.setPositionBeforeAnimation(
				movingPanel.getElement().getOffsetLeft());
		slideAnimator.setLeftToRightDelta(delta);
		slideAnimator.run(SLOW);
	}
	
	class SlideAnimator extends Animation {
		private int positionBeforeAnimation;
		private int delta;
		private AbsolutePanel fixedPanel;
		private Panel movingPanel;
		
		public SlideAnimator(AbsolutePanel fixedPanel, Panel movingPanel) {
			this.fixedPanel = fixedPanel;
			this.movingPanel = movingPanel;
		}

		@Override
		protected void onUpdate(double progress) {
			 int position = (int) (positionBeforeAnimation + (progress * delta));
		     fixedPanel.setWidgetPosition(movingPanel, position, 0);
		}
		
		@Override
		protected void onComplete() {
			// finish animation
			fixedPanel.setWidgetPosition(movingPanel, positionBeforeAnimation + delta, 0);
		}

		public void setPositionBeforeAnimation(int absoluteLeft) {
			this.positionBeforeAnimation = absoluteLeft;
		}
		
		public void setLeftToRightDelta(int delta) {
			this.delta = delta;
		}
	}
}
