package com.khopa.oneStory;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;
import com.khopa.oneStory.core.interfaces.Loader;
import com.khopa.oneStory.implementation.models.characters.Character;
import com.khopa.oneStory.services.configuration.impl.OneStoryConfigurationService;
import com.khopa.oneStory.services.event.impl.EventManager;
import com.khopa.oneStory.services.logger.Logger;
import com.khopa.oneStory.services.resources.graphic.controllers.SpriteSheetService;
import com.khopa.oneStory.services.resources.graphic.impl.DefinitionDeterminer;
import com.khopa.oneStory.services.resources.graphic.impl.SpriteSheetLoader;
import com.khopa.oneStory.services.resources.skin.SkinService;
import com.khopa.oneStory.services.resources.sound.MusicService;
import com.khopa.oneStory.services.resources.sound.SoundService;
import com.khopa.oneStory.services.resources.string.StringManager;

public class OneStoryLoader extends Loader{

	@Override
	public void initializeServices() {
		new EventManager();
		new Logger();
		new DefinitionDeterminer();
		new SpriteSheetLoader();
		new OneStoryConfigurationService();
		StringManager.init();
		Character.loadCharacters();
		SkinService.init();
		SoundService.init();
		MusicService.init();
	}

	@Override
	public void loadResources() {
		XmlReader reader = new XmlReader();
		FileHandle sheetsFile = Gdx.files.internal("data/resources/sheets.xml");
		SpriteSheetService loader = SpriteSheetService.getInstance();
		Element sheets;
		try {
			sheets = reader.parse(sheetsFile);
			for(Element sheet:sheets.getChildrenByName("sheet")){
				loader.loadSpriteSheet(sheet.getText());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		
}
