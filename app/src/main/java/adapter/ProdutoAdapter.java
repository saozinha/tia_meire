package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.conceicaolourenco.tiameirerefeicoes.Novo_Prato;
import com.conceicaolourenco.tiameirerefeicoes.R;

import java.util.List;

import to.Produto;

/**
 * Created by ConceicaoLourenco on 25/06/2015.
 */
public class ProdutoAdapter extends BaseAdapter {

    private List<Produto> listaProdutos;
    private Context context;


    public ProdutoAdapter(List<Produto> list, Context context) {
        this.listaProdutos = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaProdutos.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return listaProdutos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Produto produto = listaProdutos.get(position);
        final int auxPos = position;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // De onde , qual layout a inflar o conteudo
        View view = inflater.inflate(R.layout.item_prato,null);

        ((EditText) view.findViewById(R.id.editCodigo)).setText(produto.getId().toString());

        ((EditText) view.findViewById(R.id.editDescricao)).setText(produto.getDescricao());

        ((EditText) view.findViewById(R.id.editPreco)).setText(produto.getPreco());

        Button bt_enviar = (Button) view.findViewById(R.id.bt_enviar);
        bt_enviar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Novo_Prato.class);
            }
        });

        Button bt_editar = (Button) view.findViewById(R.id.bt_editar);
        bt_editar.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Novo_Prato.class);
                intent.putExtra("_id",listaProdutos.get(auxPos).getId());
                intent.putExtra("descricao",listaProdutos.get(auxPos).getDescricao());
                intent.putExtra("preco",listaProdutos.get(auxPos).getPreco());
                context.startActivity(intent);
            }
        });


        return view;
    }
}
