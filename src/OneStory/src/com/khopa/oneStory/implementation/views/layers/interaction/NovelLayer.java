package com.khopa.oneStory.implementation.views.layers.interaction;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.khopa.oneStory.core.controllers.animation.transition.FinishableAction;
import com.khopa.oneStory.core.controllers.animation.transition.TextZoneWriting;
import com.khopa.oneStory.core.interfaces.StateMachine;
import com.khopa.oneStory.core.views.layers.UILayer;
import com.khopa.oneStory.core.views.widgets.TextZone;
import com.khopa.oneStory.implementation.models.Sequence;
import com.khopa.oneStory.services.resources.skin.SkinService;

/**
 * 
 * Interaction Layer text zone reading state manager
 * 
 * @author Clément Perreau
 *
 */
public class NovelLayer extends UILayer implements StateMachine {

	/**
	 * Text displayed
	 */
	private TextZone textZone;
	
	/**
	 * Name of the talking character
	 */
	private Label talking;
	
	/**
	 * Next Button
	 */
	private Button next;
	
	/**
	 * Prev Button
	 */
	private Button prev;
	
	/**
	 * State
	 */
	private int state = 0;
	
	/**
	 * Current action
	 */
	private FinishableAction action;
	
	public final static int ACTING = 0;
	public final static int WAITING = 1;
	public final static int READY   = 2;

	/**
	 * Default constructor
	 */
	public NovelLayer(float x, float y, float w, float h) {
		super(x, y, w, h);
		init();
	}

	// Implementation
	
	@Override
	public void init(){
		
		float w = this.getWidth();
		float h = this.getHeight();
		
		System.out.println(w);
		System.out.println(h);
		
		talking = new Label("???", SkinService.getSkin(), "talking");
		talking.setPosition(0, 9f/10f*h);
		
		textZone = new TextZone("", SkinService.getSkin(), new Vector2((6f/10f)*w,h));
		textZone.pack();
		
		next = new ImageButton(SkinService.getSkin(), "next");
		next.setPosition(w-next.getWidth(), h/2-next.getHeight()/2);
		
		prev = new ImageButton(SkinService.getSkin(), "prev");
		prev.setPosition(0, h/2-next.getHeight()/2);
		
		
		next.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				if(state == ACTING){
			      if(action != null){
			    	if(!action.isFinished()){
			    		action.setFinish(true); // Go to the end of the action
			    	} 
			    	else{
			    	  state = READY;
			    	}
			      }
			    }
				else if(state == WAITING){
					state = READY;
				}
				
				// Autorise le script à continuer
				if(state == READY){
					Sequence.getScriptSync().release();
				}
			}
		});
		
	}

	@Override
	public void build() {
		this.clearChildren();
		this.addActor(talking);
		this.addActor(next);
		this.addActor(prev);
		this.addActor(textZone);
		System.out.println(next.getX());
	}

	// Custom methods
	public void changeText(String newText){
		state = ACTING;
		textZone.setText(newText);
		action = new TextZoneWriting(textZone, 0.03f,
		        		   		 new Vector2((2f/10f)*getWidth(), (8.5f/10f)*getHeight()));
		textZone.addAction(action);
	}
	
	public void setTalking(String talker){
		talking.setText(talker);
	}
	
	public TextZone getTextZone() {
		return textZone;
	}

	public Label getTalkingLabel() {
		return talking;
	}

	public Button getNextButton() {
		return next;
	}

	public Button getPrevButton() {
		return prev;
	}

	@Override
	public int getState() {
		return state;
	}
}
