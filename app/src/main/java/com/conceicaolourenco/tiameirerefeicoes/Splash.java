package com.conceicaolourenco.tiameirerefeicoes;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;


public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // remover o titulo - bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // fim
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        abre_Plano();
    }

    public void abre_Plano(){
        Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent i = new Intent(SplahActivity.this,ListaProdutoActivity.class);
                Intent i = new Intent(Splash.this,Menu_plano.class);
                startActivity(i);
                finish();
            }
        },3000); // conta 4 seg
    }
}
