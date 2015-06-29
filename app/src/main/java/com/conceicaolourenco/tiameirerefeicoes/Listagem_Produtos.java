package com.conceicaolourenco.tiameirerefeicoes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import SQLite.AcoesDataBase;
import adapter.EditarProdutoAdapter;
import adapter.ProdutoAdapter;
import to.Produto;

/**
 * Created by ConceicaoLourenco on 26/06/2015.
 */
public class Listagem_Produtos extends Activity {

    List<Produto> listaprodutos;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // remover o titulo - bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // fim
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_prato);

        AcoesDataBase bd = new AcoesDataBase(this);

        listaprodutos = bd.ListarProdutos();
        ProdutoAdapter adapter = new ProdutoAdapter(listaprodutos, this);

        //PROCURA PELA LISTVIEW NO LAYTOU
        final ListView listViewProd = (ListView) findViewById(R.id.listagem_produtos);
        listViewProd.setAdapter(adapter);

   // -------------------------------------------------------------------------------------
        // ------- se clicar no item da lista ---------------
        listViewProd.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> list, View view, int position, long id) {


                //---- CHamar o editar
                EdicaoDePrato();


            }
        });

        // -------------------------------------------------------------------------------------
    }

    public void EdicaoDePrato(){

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.editar_prato_activity, null);

        EditText editCodigo = (EditText)v.findViewById(R.id.editCodigo);
        EditText descricaoEt = (EditText)v.findViewById(R.id.editDescricao);
        EditText precoEt = (EditText)v.findViewById(R.id.editPreco);

        Toast.makeText(getApplicationContext(), "selecionado >  "
                + descricaoEt.getText() + "Preco > "
                + precoEt.getText() , Toast.LENGTH_LONG).show();

    }


    public void Editarprato(){
       //TODO
        /*
        *
        Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent i = new Intent(SplahActivity.this,ListaProdutoActivity.class);
                Intent i = new Intent(Listagem_Produtos.this,CustomDialogActivity.class);
                startActivity(i);
                finish();
            }
        },1500); // conta 2 seg

        */
    }

    public Produto EntrarNaBusca(String codigo) {
        AcoesDataBase bd = new AcoesDataBase(this);
        Produto produto = bd.buscar(codigo);
        return produto;
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
