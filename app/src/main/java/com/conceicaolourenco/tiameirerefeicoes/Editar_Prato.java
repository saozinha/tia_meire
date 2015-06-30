package com.conceicaolourenco.tiameirerefeicoes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import SQLite.AcoesDataBase;
import to.Produto;


public class Editar_Prato extends Activity {

    public Produto produto_select = new Produto();
    public EditText editPreco;
    public Button editarBt;
    public Button excluirBt;
    public Produto produto = new Produto();
    public EditText editCodigo;
    public EditText editDescricao;

    // REFERENCIANDO A BASE DE DADOS
    //private DataBaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // remover o titulo - bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // fim
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar__prato_activity);

        editCodigo = (EditText) findViewById(R.id.editCodigo);
        editDescricao = (EditText) findViewById(R.id.editDescricao);
        editPreco = (EditText) findViewById(R.id.editPreco);
        editarBt = (Button) findViewById(R.id.bt_editar);
        excluirBt = (Button) findViewById(R.id.bt_excluir);

        produto = new Produto();

        produto_select = (Produto) getIntent().getSerializableExtra("Produto");

        Intent intent = getIntent();
        // se ja houver valor no layout
        if (intent != null) {
            //Bundle bundle = intent.getExtras();
            // Se houver produto selecionado - no listview - ja carrega a activity com os dados
            produto_select = (Produto) getIntent().getSerializableExtra("Produto");
            if (produto_select != null) {
                editCodigo.setText(produto_select.getId().toString());
                editDescricao.setText(produto_select.getDescricao());
                editPreco.setText(produto_select.getPreco());
                //bundle.clear();
            } else {
                showCustomAlertDialog(this);
            }
        } else {
            showCustomAlertDialog(this);
        }
    }

    public void editarProduto(View v) {


        String descprod = editDescricao.getText().toString();
        String preco = editPreco.getText().toString();

        produto.setId(Long.parseLong(editCodigo.getText().toString()));
        produto.setDescricao(descprod);
        produto.setPreco(preco);

        AcoesDataBase bd = new AcoesDataBase(this);
        bd.atualizar(produto);

        Toast.makeText(this, "Produto : " + produto.getDescricao() + " atualizado !!", Toast.LENGTH_SHORT).show();

        Tela_Menu();
        //helper.close();
    }

    public void excluirProduto(View v) {

        String descprod = editDescricao.getText().toString();
        String preco = editPreco.getText().toString();

        produto.setDescricao(descprod);
        produto.setPreco(preco);

        AcoesDataBase bd = new AcoesDataBase(this);
        bd.deletar(produto);

        Toast.makeText(this, "Produto Excluido !!", Toast.LENGTH_SHORT).show();

        Tela_Menu();
        //helper.close();
    }

    public void Tela_Menu() {
        Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Editar_Prato.this, Menu_plano.class);
                startActivity(i);
                finish();
            }
        }, 1000); // conta 4 seg
    }

    // quando o botao de voltar for pressionado -- volta
    @Override
    public void onBackPressed() {
        //CHAMAR A TELA INICAL - COM AS OPCAOES
        Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Editar_Prato.this, Menu_plano.class);
                startActivity(i);
                finish();
            }
        }, 1000); // conta 4 seg
    }

    //public static void showCustomAlertDialog(Context context, String id, String desc, String preco ) {
    private void showCustomAlertDialog(Context context) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_custom_dialog, null);

        alertDialogBuilder.setView(view);
        alertDialogBuilder.setCancelable(false);

        final AlertDialog dialog = alertDialogBuilder.create();

        dialog.show();

        //instancia os objetos que estao no layout customdialog.xml
        final Button bt_confirmar = (Button) dialog.findViewById(R.id.btn_Confirmar);
        final Button bt_cancelar = (Button) dialog.findViewById(R.id.btn_Cancelar);
        final EditText editValor = (EditText) dialog.findViewById(R.id.etValor);
        final TextView txtMensagem = (TextView) dialog.findViewById(R.id.txtMensagem);

        txtMensagem.setText("Informe o Codigo: ");

        //bt_confirmar.setTypeface(Utils.setBoldTypeface(context));
        //bt_cancelar.setTypeface(Utils.setBoldTypeface(context));

        bt_confirmar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String codigo = editValor.getText().toString();
                if (!codigo.equals("")) {
                    produto = EntrarNaBusca(codigo);
                    if (produto != null) {
                        editCodigo.setText(produto.getId().toString());
                        editDescricao.setText(produto.getDescricao());
                        editPreco.setText(produto.getPreco());
                    }
                }

                dialog.dismiss();

            }
        });

        bt_cancelar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });

    }

    public Produto EntrarNaBusca(String codigo) {
        AcoesDataBase bd = new AcoesDataBase(this);
        produto = bd.buscar(codigo);
        return produto;
    }
}
