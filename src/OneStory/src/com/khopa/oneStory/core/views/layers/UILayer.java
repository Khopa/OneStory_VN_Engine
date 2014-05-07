package com.khopa.oneStory.core.views.layers;


/**
 * Manage a layer widgets' positionning
 * @author Clément Perreau
 */
public abstract class UILayer extends SizedLayer {

	public UILayer(float x, float y, float w, float h){
		super(x,y,w,h);
	}
	
	// ----------- Methods ----------------- \\
	
	/**
	 * Called on construction
	 * Override ME !
	 */
	public void init(){
		// Override ME !
	}
	
	/**
	 * Apply the layout to the layer
	 */
	public abstract void build();
	
}
