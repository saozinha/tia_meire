package com.conceicaolourenco.tiameirerefeicoes;

import android.app.Activity;
import android.app.AlertDialog;
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

    private Produto produto = new Produto();
    private EditText editCodigo;
    private EditText editDescricao;
    private EditText editPreco;
    private Context context;

    private ListView listViewProdutos;
    List<Produto> listaprodutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // remover o titulo - bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // fim
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_prato);

        AcoesDataBase bd = new AcoesDataBase(this);

        //Carrega a lista com todos os produtos
        listaprodutos = bd.ListarProdutos();

        // Adiciona  a lista carregada no adapter
        ProdutoAdapter adapter = new ProdutoAdapter(listaprodutos, this);
        //PROCURA PELA LISTVIEW NO LAYTOU
        listViewProdutos = (ListView) findViewById(R.id.listagem_produtos);
        listViewProdutos.setAdapter(adapter);

        clickLista();

        // -------------------------------------------------------------------------------------
        // ------- se clicar no item da lista ---------------
        //listViewProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        // @Override
        // public void onItemClick(AdapterView<?> list, View view, int position, long id) {

        //String selectedItem = (String) listProd.getAdapter().getItem(position);


                /*
                long posicion = (id + 1);

                String fraccionValues = String.valueOf(posicion);

                Intent intent = new Intent(getApplication(), Editar_Prato.class);

                intent.putExtra("_id", fraccionValues);

                Toast.makeText(getApplicationContext(), fraccionValues + " selected", Toast.LENGTH_LONG).show();

                startActivity(intent);
                */

        //---- CHamar o editar
        //EdicaoDEprato();
        //  }
        // });

        // -------------------------------------------------------------------------------------
    }

    public void EdicaoDEprato() {
        //CHAMAR A TELA INICAL - COM AS OPCAOES
        Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent intent = new Intent(Listagem_Produtos.this, Editar_Prato.class);
                intent.putExtra("descricao", editCodigo.getText().toString());
                startActivity(intent);
                finish();
            }
        }, 1000); // conta 4 seg
    }


    public Produto EntrarNaBusca(String codigo) {
        AcoesDataBase bd = new AcoesDataBase(this);
        Produto produto = bd.buscar(codigo);
        return produto;
    }


    public void clickLista() {
        listViewProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //Produto produto = (Produto) adapterView.getAdapter().getItem(position);
                //Produto produto = (Produto) listViewProdutos.getItemAtPosition(position);
                //position -= listViewProdutos.getHeaderViewsCount();
                //final Produto produto  = (Produto) listViewProdutos.getAdapter().getItem(position);

                final Produto produto = (Produto) listViewProdutos.getAdapter().getItem(position);
                Intent intent = new Intent(Listagem_Produtos.this, Editar_Prato.class);
                // deve serializar o objeto
                intent.putExtra("Produto", produto);
                intent.putExtra("Editar_codigo", "Editar_prato_lista");
                startActivity(intent);
            }
        });
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
