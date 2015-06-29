package com.conceicaolourenco.tiameirerefeicoes;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import SQLite.AcoesDataBase;
import adapter.EditarProdutoAdapter;
import to.Produto;


public class Menu_plano extends Activity {

    EditText editCodigo;
    EditText editDescricao;
    EditText editPreco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_plano_activity);

        ImageView btn_cardapio = (ImageView) findViewById(R.id.btn_cardapio);
        btn_cardapio.setClickable(true);
        btn_cardapio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MostraCardapio();
            }
        });

        ImageView btn_cad_prato = (ImageView) findViewById(R.id.btn_cad_prato);
        btn_cad_prato.setClickable(true);
        btn_cad_prato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NovoPrato();
            }
        });


        ImageView btn_edit_prato = (ImageView) findViewById(R.id.btn_edit_prato);
        btn_edit_prato.setClickable(true);
        btn_edit_prato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EdicaoDEprato();
            }
        });

        ImageView btn_lista_pedidos = (ImageView) findViewById(R.id.btn_lista_pedidos);
        btn_lista_pedidos.setClickable(true);
        btn_lista_pedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListagemPedidos();
            }
        });
    }

    public void MostraCardapio(){
        Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent i = new Intent(SplahActivity.this,ListaProdutoActivity.class);
                Intent i = new Intent(Menu_plano.this,Listagem_Produtos.class);
                startActivity(i);
                finish();
            }
        },1500); // conta 2 seg
    }

    public void NovoPrato(){
        Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent i = new Intent(SplahActivity.this,ListaProdutoActivity.class);
                Intent i = new Intent(Menu_plano.this,Novo_Prato.class);
                startActivity(i);
                finish();
            }
        },1500); // conta 2 seg

    }

    public void EdicaoDEprato(){

        Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent i = new Intent(SplahActivity.this,ListaProdutoActivity.class);
                //Intent i = new Intent(Menu_plano.this,Editar_Prato.class);
                Intent i = new Intent(Menu_plano.this,Editar_Prato.class);
                i.putExtra("Editar_codigo", "Editar_codigo");
                startActivity(i);
              finish();
            }
        },1500); // conta 2 seg

    }

    public void ListagemPedidos(){
        Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent i = new Intent(SplahActivity.this,ListaProdutoActivity.class);
                Intent i = new Intent(Menu_plano.this,Listagem_Produtos.class);
                startActivity(i);
                finish();
            }
        },1500); // conta 2 seg
    }

    public Produto EntrarNaBusca(String codigo) {
        AcoesDataBase bd = new AcoesDataBase(this);
        Produto produto = new Produto();
        if(codigo!="") {
            produto = bd.buscar(codigo);
        }
        return produto;
    }

    public void TelaEdicao(){
        Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Menu_plano.this, Editar_Prato.class);
                startActivity(i);
                finish();
            }
        },1000); // conta 4 seg
    }

}
