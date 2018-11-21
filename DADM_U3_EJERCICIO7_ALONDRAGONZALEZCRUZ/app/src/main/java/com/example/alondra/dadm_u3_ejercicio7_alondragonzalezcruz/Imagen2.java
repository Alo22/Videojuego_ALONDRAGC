package com.example.alondra.dadm_u3_ejercicio7_alondragonzalezcruz;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.CountDownTimer;

public class Imagen2 {
    private Bitmap icono;
    private float x, y;
    private boolean visible;
    int desplazamientoy, desplazamientoY;
    CountDownTimer timer;

    public Imagen2(int resource, float _x, float _y, final Lienzo2 l) { //se recibre un 4 parametro de lienzo
        icono = BitmapFactory.decodeResource(l.getResources(), resource);

        x = _x;
        y = _y;
        visible = true;
        timer = new CountDownTimer(1000, 64) {
            @Override
            public void onTick(long millisUntilFinished) {
                y += desplazamientoy;
                if (y >= l.getHeight()) {
                    y = -150;
                }
                y += desplazamientoY;
                l.invalidate();
            }

            @Override
            public void onFinish() {
                start();

            }
        };
    } //imagen

    public void movimientoTodos(int movimiento) {
        desplazamientoy = movimiento;
        timer.start();
    }

    public void movimientoBala(int mov) {
        desplazamientoY = mov;
        timer.start();
    }


    public void pintar(Canvas c, Paint p) {
        if (visible)
            c.drawBitmap(icono, x, y, p);
    }//metodo pintar

    public void hacerVisible(boolean v) {
        visible = v;
    }

    public boolean estaEnArea(float xp, float yp) {
        if (!visible) return false;
        float x2, y2;
        x2 = x + icono.getWidth();
        y2 = y + icono.getHeight();
        if (xp >= x && xp <= x2) {
            if (yp >= y && yp <= y2) {
                return true;
            }
            // validando el valor de las x

        } //del toquen
        return false; //retornara verdadero si ambos if son SI
    }

    public boolean colision(Imagen2 objetoB) {
        float x2 = x + icono.getWidth();
        float y2 = y + icono.getHeight();
        if (objetoB.estaEnArea(x2, y)) return true;
        if (objetoB.estaEnArea(x, y)) return true;
        if (objetoB.estaEnArea(x, y2)) return true;
        if (objetoB.estaEnArea(x2, y2)) return true;
        return false;
    } //metodo de colision

    public void moverNave(float xp) {
        x = xp - (icono.getWidth() / 2);
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

}
