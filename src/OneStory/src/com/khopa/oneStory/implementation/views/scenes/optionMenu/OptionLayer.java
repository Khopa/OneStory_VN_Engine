package com.khopa.oneStory.implementation.views.scenes.optionMenu;

import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.khopa.oneStory.core.views.layers.BackgroundLayer;
import com.khopa.oneStory.implementation.views.scenes.optionMenu.controllers.DebugCheckBoxListener;
import com.khopa.oneStory.implementation.views.scenes.optionMenu.controllers.MusicVolumeSliderListener;
import com.khopa.oneStory.implementation.views.scenes.optionMenu.controllers.OkButtonListener;
import com.khopa.oneStory.implementation.views.scenes.optionMenu.controllers.SoundVolumeSliderListener;
import com.khopa.oneStory.services.configuration.controllers.ConfigurationService;
import com.khopa.oneStory.services.resources.skin.SkinService;
import com.khopa.oneStory.services.resources.string.StringManager;

/**
 * Option menu main layer
 * @author Clément Perreau
 */
public class OptionLayer extends BackgroundLayer{

	/**
	 * Widgets
	 */
	private Table ui;
	
	/**
	 * Validation button
	 */
	private TextButton ok;
	
	/**
	 * SFX volume
	 */
	private Slider sfxVolume;
	
	/**
	 * Music volume
	 */
	private Slider musicVolume;
	
	/**
	 * Debug Checkbox
	 */
	private CheckBox enableDebug;
	
	public OptionLayer(float x, float y, float width, float height,
			String bgName) {
		super(x, y, width, height, bgName);
		init();
		initValues();
		initControls();
		build();
	}
	

	private void init() {
		Skin skin   = SkinService.getSkin();
		ok          = new TextButton("Ok", skin, "choice");
		sfxVolume   = new Slider(0, 1f, 0.1f, false, skin);
		musicVolume = new Slider(0, 1f, 0.1f, false, skin);
		enableDebug = new CheckBox("", skin);
	}
	
	private void build() {
		Skin skin   = SkinService.getSkin();
		ui = new Table(skin);
		ui.defaults().spaceBottom(getHeight()/20f);
		ui.add(StringManager.getString("sfxVolume") + " : ");
		ui.add(sfxVolume).width(getWidth()/3).row();
		ui.add(StringManager.getString("musicVolume") + " : ");
		ui.add(musicVolume).width(getWidth()/3).row();
		ui.add(StringManager.getString("debug") + " : ");
		ui.add(enableDebug).row();
		ui.add(ok).colspan(2).row();
		ui.debug();
		addActor(ui);
		center(ui);
	}

	private void initValues() {
		sfxVolume.setValue(ConfigurationService.getInstance().getFloatValue("sfxVolume"));
		musicVolume.setValue(ConfigurationService.getInstance().getFloatValue("musicVolume"));
		enableDebug.setChecked(ConfigurationService.getInstance().getBooleanValue("debug"));
	}
	
	private void initControls() {
		ok.addListener(new OkButtonListener());
		sfxVolume.addListener(new SoundVolumeSliderListener(sfxVolume));
		musicVolume.addListener(new MusicVolumeSliderListener(musicVolume));
		enableDebug.addListener(new DebugCheckBoxListener());
	}


	
	@Override
	public void act(float delta) {
		super.act(delta);
		
	}

}
