package com.khopa.oneStory.implementation.controllers.api.characters;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.TwoArgFunction;

import com.khopa.oneStory.implementation.views.actors.CharacterActor;
import com.khopa.oneStory.implementation.views.layers.VisualLayer;
import com.khopa.oneStory.implementation.views.scenes.NovelScene;

public class Anim extends TwoArgFunction{
	
	private LuaCharacter character;
	
	public Anim(LuaCharacter character){
		this.character = character;
	}

	@Override
	public LuaValue call(LuaValue animation, LuaValue repeat) {
		VisualLayer layer = NovelScene.getInstance().getVisualLayer();
		CharacterActor actor = this.character.getModel().getView();
		actor.setAnimation(character.getModel().getAnimation(animation.tojstring()));
		actor.setRepeat(repeat.toint());
		if(!layer.getChildren().contains(actor, true)){
			System.out.println("DOESN'T CONTAINS");
			layer.addActor(actor);
		}
		return null;
	}


	
	
}
