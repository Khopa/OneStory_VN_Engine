package com.khopa.oneStory.core.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * Primitives pour le dessin de formes
 * @author Clément Perreau
 */
public class Primitives {
	
	/**
	 * Shape renderer
	 */
	private static ShapeRenderer renderer;
	
	public static void init(){
		renderer = new ShapeRenderer();
	}
	
	/**
	 * Prépare le rendu en effectuant les projections sur les bonnes matrices Gl
	 */
	public static void prepareRenderer(SpriteBatch batch){
		renderer.setProjectionMatrix(batch.getProjectionMatrix());
		renderer.setTransformMatrix(batch.getTransformMatrix());
	}
	
	/**
	 * Active l'alpha blending openGl
	 */
	public static void enableAlphaBlending(){
		Gdx.gl.glEnable(GL10.GL_BLEND);
	    Gdx.gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
	}
	
	/**
	 * Désactive l'alpha blending
	 */
	public static void disableAlphaBlending(){
		Gdx.gl.glDisable(GL10.GL_BLEND);
	}
	
	/**
	 * Choisit la taille des lignes
	 */
	public static void lineWidth(int width){
		Gdx.gl10.glLineWidth(width);
	}

	/**
	 * Dessin d'un rectangle
	 */
	public static void rect(int x, int y, int w, int h,Color color){
		renderer.setColor(color);
		Primitives.rect(x,y,w,h);
	}
	
	public static void rect(int x, int y, int w, int h){
		renderer.begin(ShapeType.Line);
		renderer.rect(x, y, w, h);
		renderer.end();
	}
	
	/**
	 * Dessin d'un rectangle rempli
	 */
	public static void filledRect(int x, int y, int w, int h, Color color){
		renderer.begin(ShapeType.Filled);
		renderer.setColor(color);
		renderer.rect(x, y, w, h);
		renderer.end();
	}
	
	/**
	 * Dessin d'une ligne
	 */
	public static void line(int x1, int y1, int x2, int y2, int width, Color color){
		renderer.begin(ShapeType.Line);
		renderer.setColor(color);
		Gdx.gl10.glLineWidth(width);
		renderer.line(x1, y1, x2, y2);
		renderer.end();
	}
	
	/**
	 * Termine le rendu de formes
	 * @param batch
	 */
	public static void endRendering(SpriteBatch batch){
		batch.begin();
	}
	
	
	
	
	/**
	 * Dessin d'une jauge
	 * @param x Coordonnée X
	 * @param y Coordonnée Y
	 * @param w Largeur de la jauge
	 * @param h Hauteur de la jauge
	 * @param borderSize Largeur des bordures
	 * @param percent Pourcentage de remplissage
	 * @param colorInside Couleur intérieure
	 * @param borderColor Couleur des bordures
	 */
	public static void gauge(int x, int y, int w, int h, int borderSize, float percent, Color colorInside, Color borderColor){
		
		// Dessin du rectangle de bordure
		Primitives.filledRect(x,y,w,h,borderColor);
		
		/*
		 * Largeur en px pour le pourcentage donné
		 */
		int wg = (int) (percent*(w-2*borderSize));
		
		// Contenu de la jauge
		Primitives.filledRect(x+borderSize, y+borderSize, wg, h-2*borderSize, colorInside);
		
	}
	
	
	
}
