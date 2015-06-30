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

import java.util.List;

import SQLite.AcoesDataBase;
import adapter.ProdutoAdapter;
import to.Produto;


public class Listagem_Produtos extends Activity {

    //private Produto produto = new Produto();
    //private EditText editCodigo;
    //private EditText editDescricao;
    //private EditText editPreco;
    //private Context context;

    List<Produto> listaprodutos;
    private ListView listViewProdutos;

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
    }

    public void clickLista() {
        listViewProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                final Produto produto = (Produto) listViewProdutos.getAdapter().getItem(position);
                Intent intent = new Intent(Listagem_Produtos.this, Editar_Prato.class);
                // deve serializar o objeto
                intent.putExtra("Produto", produto);
                //intent.putExtra("Editar_codigo", "Editar_prato_lista");
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
