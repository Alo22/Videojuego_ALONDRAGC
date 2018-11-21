package com.example.alondra.dadm_u3_ejercicio7_alondragonzalezcruz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {
Imagen fondop,play;
MainActivity puntero;
    public Lienzo(Context context) {
        super(context);
        puntero=(MainActivity) context;
        fondop=new Imagen(R.drawable.fondop,1,1,this);
        play=new Imagen(R.drawable.play, 180, 500, this);
    }
    @Override
    protected void onDraw(Canvas c) {
        Paint p = new Paint();
       fondop.pintar(c,p);
       play.pintar(c,p);
    }
    public boolean onTouchEvent(MotionEvent e) {
        float xp = e.getX(); //tipo flotante
        float yp = e.getY();
        //cuando precionas,arrastras y cuando sueltas
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (play.estaEnArea(xp, yp)) {
                    puntero.abrir();
                    break;
                }
        }
        invalidate();
        return true;
    }
}
