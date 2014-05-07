package com.khopa.oneStory.implementation.views.scenes.mainMenu;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.khopa.oneStory.core.views.layers.BackgroundLayer;
import com.khopa.oneStory.implementation.views.scenes.mainMenu.controllers.AboutButtonListener;
import com.khopa.oneStory.implementation.views.scenes.mainMenu.controllers.OptionButtonListener;
import com.khopa.oneStory.implementation.views.scenes.mainMenu.controllers.PlayButtonListener;
import com.khopa.oneStory.implementation.views.scenes.mainMenu.controllers.QuitButtonListener;
import com.khopa.oneStory.services.resources.skin.SkinService;
import com.khopa.oneStory.services.resources.string.StringManager;

/**
 * 
 * The main menu layer
 * 
 * @author Clément Perreau
 *
 */
public class MainMenuLayer extends BackgroundLayer {

	private Table buttons;
	private TextButton play;
	private TextButton options;
	private TextButton about;
	private TextButton quit;
	
	public MainMenuLayer(float x, float y, float width, float height,
			String bgName) {
		super(x, y, width, height, bgName);
		init();
	}

	private void init() {
		
		Skin skin = SkinService.getSkin();
		play    = new TextButton(StringManager.getString("play"), skin, "choice");
		options = new TextButton(StringManager.getString("options"), skin, "choice");
		about   = new TextButton(StringManager.getString("about"), skin, "choice");
		quit    = new TextButton(StringManager.getString("quit"), skin, "choice");
		buttons = new Table(skin);
		
		buttons.defaults().space(getHeight()/20f);
		buttons.add(play);
		buttons.row();
		buttons.add(options);
		buttons.row();
		buttons.add(about);
		buttons.row();
		buttons.add(quit);
		buttons.row();
		buttons.debug();
		
		this.addActor(buttons);
		this.center(buttons);
		
		play.addListener(new PlayButtonListener());
		about.addListener(new AboutButtonListener());
		options.addListener(new OptionButtonListener());
		quit.addListener(new QuitButtonListener());
		
	}

}
