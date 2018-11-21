package com.example.alondra.dadm_u3_ejercicio7_alondragonzalezcruz;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo2 extends View {
    Imagen2 bala, game, manita, nave, balita, balita2, balita3, balita4, palma2, palma3, palma4, platino, platino2, platino3, moreno, puntero, puntero2;
    Main2Activity iniciar;
    int numero = 0;

    ///CONSTRUCTOR
    public Lienzo2(Context context) {
        super(context);
        moreno = new Imagen2(R.drawable.moreno, 0, 0, this);
        game = new Imagen2(R.drawable.game, 190, 280, this);
        manita = new Imagen2(R.drawable.manita, 180, 280, this);
        nave = new Imagen2(R.drawable.nave, 280, 880, this);
        bala = new Imagen2(R.drawable.bala, 330, 880, this);
        //primero
        palma2 = new Imagen2(R.drawable.palma, 10, 20, this);
        platino3 = new Imagen2(R.drawable.platino, 90, 10, this);
        balita4 = new Imagen2(R.drawable.balita, 160, 150, this);
        //segundo
        palma4 = new Imagen2(R.drawable.palma, 230, 20, this);
        platino = new Imagen2(R.drawable.platino, 315, 10, this);
        balita2 = new Imagen2(R.drawable.balita, 370, 150, this);
        //tercero
        palma3 = new Imagen2(R.drawable.palma, 480, 20, this);
        platino2 = new Imagen2(R.drawable.platino, 570, 10, this);
        balita3 = new Imagen2(R.drawable.balita, 620, 150, this);


        manita.hacerVisible(false);
        game.hacerVisible(false);
        iniciar = (Main2Activity) context;

        ///ktodo puntero es igual a null
        puntero = null;
        puntero2 = null;

        platino.movimientoTodos(7);
        platino2.movimientoTodos(7);
        platino3.movimientoTodos(7);

        //mover balitas
        balita2.movimientoBala(9);
        balita3.movimientoBala(9);
        balita4.movimientoBala(9);
        //mover palmas
        palma2.movimientoTodos(7);
        palma3.movimientoTodos(7);
        palma4.movimientoTodos(7);


    }

    @Override
    protected void onDraw(Canvas c) {
        Paint p = new Paint();
        moreno.pintar(c, p);
        bala.pintar(c, p);
        game.pintar(c, p);
        manita.pintar(c, p);
        nave.pintar(c, p);
        palma2.pintar(c, p);
        palma3.pintar(c, p);
        palma4.pintar(c, p);
        platino.pintar(c, p);
        platino2.pintar(c, p);
        platino3.pintar(c, p);
        balita2.pintar(c, p);
        balita3.pintar(c, p);
        balita4.pintar(c, p);

        if (balita4.getY() >= getHeight()) {
            balita4.setY(platino3.getY() + 100);
        }
        if (balita3.getY() >= getHeight()) {
            balita3.setY(platino2.getY() + 100);
        }
        if (balita2.getY() >= getHeight()) {
            balita2.setY(platino.getY() + 100);
        }

    }//ondraw

    public boolean onTouchEvent(MotionEvent e) {
        float xp = e.getX();
        float yp = e.getY();
        switch (e.getAction()) {

            case MotionEvent.ACTION_DOWN:
                if (nave.estaEnArea(xp, yp)) {
                    bala = new Imagen2(R.drawable.bala, xp, yp, this);
                    puntero = nave;
                    puntero2 = bala;
                }
                if (game.estaEnArea(xp, yp)) {
                    Intent a = new Intent(iniciar, Main2Activity.class);
                    iniciar.startActivity(a);
                }
                if (manita.estaEnArea(xp, yp)) {
                    Intent a = new Intent(iniciar, Main2Activity.class);
                    iniciar.startActivity(a);
                }
                bala.movimientoTodos(-10);
                break;
            case MotionEvent.ACTION_MOVE:
                if (puntero != null) {
                    puntero.moverNave(xp);
                    if (puntero.colision(platino3) && puntero == nave) {
                        nave.hacerVisible(false);
                        game.hacerVisible(true);
                    }
                    if (puntero.colision(platino) && puntero == nave) {
                        nave.hacerVisible(false);
                        game.hacerVisible(true);
                    }
                    if (puntero.colision(platino2) && puntero == nave) {
                        nave.hacerVisible(false);
                        game.hacerVisible(true);
                    }
                    if (puntero.colision(balita4) && puntero == nave) {
                        nave.hacerVisible(false);
                        game.hacerVisible(true);
                    }
                    if (puntero.colision(balita2) && puntero == nave) {
                        nave.hacerVisible(false);
                        game.hacerVisible(true);
                    }
                    if (puntero.colision(balita3) && puntero == nave) {
                        nave.hacerVisible(false);
                        game.hacerVisible(true);
                    }
                    if (puntero2.colision(platino3) && puntero2 == bala) {
                        platino3 = new Imagen2(R.drawable.platino, 90, 10, this);
                        platino3.movimientoTodos(7);
                        platino3.hacerVisible(true);
                        bala = new Imagen2(R.drawable.bala, xp, yp, this);
                        bala.hacerVisible(false);
                        numero = numero + 1;
                        balita4 = new Imagen2(R.drawable.balita, 160, 150, this);
                        balita4.movimientoBala(9);
                        balita4.hacerVisible(true);
                    }
                    if (puntero2.colision(platino) && puntero2 == bala) {
                        platino = new Imagen2(R.drawable.platino, 315, 10, this);
                        platino.movimientoTodos(7);
                        platino.hacerVisible(true);
                        bala = new Imagen2(R.drawable.bala, xp, yp, this);
                        bala.hacerVisible(false);
                        numero = numero + 1;
                        balita2 = new Imagen2(R.drawable.balita, 370, 150, this);
                        balita2.movimientoBala(9);
                        balita2.hacerVisible(true);
                    }
                    if (puntero2.colision(platino2) && puntero2 == bala) {
                        platino2 = new Imagen2(R.drawable.platino, 570, 10, this);
                        platino2.movimientoTodos(7);
                        platino2.hacerVisible(true);
                        bala = new Imagen2(R.drawable.bala, xp, yp, this);
                        bala.hacerVisible(false);
                        numero = numero + 1;
                        balita3 = new Imagen2(R.drawable.balita, 620, 150, this);
                        balita3.movimientoBala(9);
                        balita3.hacerVisible(true);
                    }
                    if (numero == 5) {
                        manita.hacerVisible(true);
                        nave.hacerVisible(false);
                        bala.hacerVisible(false);
                        palma2.hacerVisible(false);
                        platino3.hacerVisible(false);
                        balita4.hacerVisible(false);
                        palma4.hacerVisible(false);
                        platino.hacerVisible(false);
                        balita2.hacerVisible(false);
                        palma3.hacerVisible(false);
                        platino2.hacerVisible(false);
                        balita3.hacerVisible(false);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                puntero = null;
                break;
        }
        invalidate();
        return true;
    }
}
