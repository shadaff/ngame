package org.game.view;

import org.rogotulka.ngame.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView {
    /**Загружаемая картинка*/
    private Bitmap bmp;
    
    /**Наше поле рисования*/
    private SurfaceHolder holder;
    
	public GameView(Context context) {
		super(context);
        holder = getHolder();
        holder.addCallback(new SurfaceHolder.Callback() 
        {
               public void surfaceDestroyed(SurfaceHolder holder) 
               {
               }

               @SuppressLint("WrongCall") @Override
               public void surfaceCreated(SurfaceHolder holder) 
               {
                      Canvas c = holder.lockCanvas(null);
                      onDraw(c);
                      holder.unlockCanvasAndPost(c);
               }

               @Override
               public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) 
               {
               }
        });
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.hero_mage_01);
  }

  //Рисуем нашу картинку на черном фоне
  protected void onDraw(Canvas canvas) 
  {
	  //Display display = ).getDefaultDisplay();  
	  canvas.drawColor(Color.GRAY);
        canvas.drawBitmap(bmp, 10, canvas.getHeight()-bmp.getHeight()-10, null);
  }

}
