package com.khopa.oneStory.implementation.controllers.api.characters;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.ThreeArgFunction;

import com.khopa.oneStory.core.controllers.animation.transition.Transitions;
import com.khopa.oneStory.implementation.views.actors.CharacterActor;
import com.khopa.oneStory.implementation.views.layers.VisualLayer;
import com.khopa.oneStory.implementation.views.scenes.NovelScene;

public class Appear extends ThreeArgFunction{
	
	private LuaCharacter character;
	
	public Appear(LuaCharacter character){
		this.character = character;
	}

	@Override
	public LuaValue call(LuaValue animation, LuaValue x, LuaValue y) {
		VisualLayer layer = NovelScene.getInstance().getVisualLayer();
		CharacterActor actor = this.character.getModel().getView();
		System.out.println(actor);
		actor.setAnimation(character.getModel().getAnimation(animation.tojstring()));
		actor.setPosition(x.tofloat()*layer.getWidth(), y.tofloat()*layer.getHeight());
		actor.addAction(Transitions.fadeIn(.5f));
		layer.addActor(actor);
		return null;
	}

	
	
}
