package com.conceicaolourenco.tiameirerefeicoes;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import SQLite.AcoesDataBase;
import adapter.EditarProdutoAdapter;
import to.Produto;


public class CustomDialogActivity extends Dialog implements
        android.view.View.OnClickListener {

    public Activity c;
    public Dialog d;
    //d.setContentView(R.layout.activity_custom_dialog);
    public EditText editValor;
    public TextView txtMensagem;
    public Button confirma, cancela;

    EditText editCodigo;


    public CustomDialogActivity(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_custom_dialog);

        confirma = (Button) findViewById(R.id.btn_Confirmar);
        cancela = (Button) findViewById(R.id.btn_Cancelar);
        txtMensagem = (TextView) findViewById(R.id.txtMensagem);
        editValor = (EditText) findViewById(R.id.etValor);
        confirma.setOnClickListener(this);
        cancela.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Confirmar:
                c.finish();
                break;
            case R.id.btn_Cancelar:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}

    /*
        extends Activity {
    EditText editCodigo;
    EditText editDescricao;
    EditText editPreco;


    /** Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_prato_activity);

        editCodigo = (EditText) findViewById(R.id.editCodigo);
        editDescricao = (EditText) findViewById(R.id.editDescricao);
        editPreco = (EditText) findViewById(R.id.editPreco);

        AcoesDataBase bd = new AcoesDataBase(this);

        ExibeDialog();
    }

    //M�todo executado quando usu�rio clicar no bot�o
    //Chamar Dialog
    public void ChamarDialog_click(View v){
        ExibeDialog();
    }

    private void ExibeDialog(){
        final Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.activity_custom_dialog);

        //define o t�tulo do Dialog
        dialog.setTitle("Editar Prato:");

        //instancia os objetos que est�o no layout customdialog.xml
        final Button confirmar = (Button) dialog.findViewById(R.id.btn_Confirmar);
        final Button cancelar = (Button) dialog.findViewById(R.id.btn_Cancelar);
        final EditText editValor = (EditText) dialog.findViewById(R.id.etValor);
        final TextView txtMensagem = (TextView) dialog.findViewById(R.id.txtMensagem);

        //txtMensagem.setText("Informe o Codigo: ");

        confirmar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Produto produto = EntrarNaBusca(editValor.getText().toString());

                // CHAMAR A EDICAO DE PRATO PASSANDO O PRODUTO

                if(produto != null) {
                    editCodigo.setText(produto.getId().toString());
                    editDescricao.setText(produto.getDescricao());
                    editPreco.setText(produto.getPreco());
                }
                //finaliza o dialog

                dialog.dismiss();
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //finaliza o dialog
                dialog.dismiss();
            }
        });

        //exibe na tela o dialog
        dialog.show();

    }

    public Produto EntrarNaBusca(String codigo) {
        AcoesDataBase bd = new AcoesDataBase(this);
        Produto produto = bd.buscar(codigo);
        return produto;
    }

    public void TelaEdicao(){
        Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(CustomDialogActivity.this, Editar_Prato.class);
                startActivity(i);
                finish();
            }
        },1000); // conta 4 seg
    }
}
*/