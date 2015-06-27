package com.conceicaolourenco.tiameirerefeicoes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import SQLite.AcoesDataBase;
import adapter.ProdutoAdapter;
import to.Produto;

/**
 * Created by ConceicaoLourenco on 26/06/2015.
 */
public class Listagem_Produtos extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // remover o titulo - bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // fim
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_prato);

        AcoesDataBase bd = new AcoesDataBase(this);

        //List<Produto> list = bd.buscar();
        //setListAdapter(new AdapterProduto(list, this));

        List<Produto> lista = bd.buscar();

        ProdutoAdapter adapter = new ProdutoAdapter(lista, this);

        //PROCURA PELA LISTVIEW NO LAYTOU
        final ListView listprod = (ListView) findViewById(R.id.listagem_produtos);
        listprod.setAdapter(adapter);

   // -------------------------------------------------------------------------------------
        // ------- se clicar no item da lista ---------------
        listprod.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String  itemValue = (String) listprod.getItemAtPosition(position);

                //---- CHamar o editar
                EdicaoDEprato();
                // Show Alert
                //Toast.makeText(getApplicationContext(), "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG).show();

            }
        });

        // -------------------------------------------------------------------------------------
    }

    public void EdicaoDEprato(){
        Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent i = new Intent(SplahActivity.this,ListaProdutoActivity.class);
                Intent i = new Intent(Listagem_Produtos.this,Editar_Prato.class);
                startActivity(i);
                finish();
            }
        },1500); // conta 2 seg

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Id correspondente ao botão Up/Home da actionbar
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // quando o botao de voltar for pressionado -- volta
    @Override
    public void onBackPressed()
    {
        //CHAMAR A TELA INICAL - COM AS OPCAOES
        Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Listagem_Produtos.this,Menu_plano.class);
                startActivity(i);
                finish();
            }
        },1000); // conta 4 seg
    }

}
