package com.conceicaolourenco.tiameirerefeicoes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import SQLite.AcoesDataBase;
import SQLite.DataBaseHelper;
import to.Produto;


public class Novo_Prato extends Activity {

    private Context context;
    private Produto produto = new Produto();
    private EditText editCodigo;
    private EditText descricaoEt;
    private EditText precoEt;
    private Button salvarBt;
    private Button editarBt;
    private Button retornaBt;

    // REFERENCIANDO A BASE DE DADOS
    private DataBaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // remover o titulo - bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // fim
        super.onCreate(savedInstanceState);
        // ira inflar o layout novo prato
        setContentView(R.layout.novo__prato_activity);

        editCodigo = (EditText)findViewById(R.id.editCodigo);
        descricaoEt = (EditText)findViewById(R.id.editDescricao);
        precoEt = (EditText)findViewById(R.id.editPreco);
        salvarBt = (Button)findViewById(R.id.bt_enviar);
       // editarBt = (Button)findViewById(R.id.bt_editar);

        Intent intent = getIntent();
        // se já houver valor no layout
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if(bundle != null){
                produto.setId(bundle.getLong("id"));
                produto.setDescricao(bundle.getString("descricao"));
                produto.setPreco(bundle.getString("preco"));

                editCodigo.setText(produto.getId().toString());
                descricaoEt.setText(produto.getDescricao());
                precoEt.setText(produto.getPreco());

                // se houver valor - deixar editar
                //editarBt.setVisibility(View.VISIBLE);
                //salvarBt.setVisibility(View.INVISIBLE);

            }
            //salvarBt.setVisibility(View.VISIBLE);
            //editarBt.setVisibility(View.INVISIBLE);
        }

        salvarBt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(context, Novo_Prato.class);
                salvarProduto();
            }
        });

    }

    public void salvarProduto() {

        //Toast.makeText(this, "Vamos Inserir um Produto !!", Toast.LENGTH_SHORT).show();

        Long id_prod = produto.getId();
        String descprod = descricaoEt.getText().toString();
        String preco = precoEt.getText().toString();

        produto.setDescricao(descprod);
        produto.setPreco(preco);

        AcoesDataBase bd = new AcoesDataBase(this);
        bd.inserir(produto);

        Toast.makeText(this, "Produto Inserido !!", Toast.LENGTH_SHORT).show();

        //helper.close();
    }
/*
    public void editarProduto(View v) {

        String descprod = descricaoEt.getText().toString();
        String preco = precoEt.getText().toString();

        produto.setDescricao(descprod);
        produto.setPreco(preco);

        AcoesDataBase bd = new AcoesDataBase(this);
        bd.atualizar(produto);

        Toast.makeText(this, "Produto > "+ produto.getDescricao()+" atualizado !!", Toast.LENGTH_SHORT).show();

        //helper.close();
    }
*/
    public void menu_plano(){
        Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Novo_Prato.this,Menu_plano.class);
                startActivity(i);
                finish();
            }
        },1000); // conta 4 seg
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
        menu_plano();
    }


}
