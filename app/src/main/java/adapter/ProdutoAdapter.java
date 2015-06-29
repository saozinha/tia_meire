package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        //return listaProdutos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaProdutos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Produto produto = listaProdutos.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // De onde , qual layout a inflar o conteudo
        View view = inflater.inflate(R.layout.itens_listagem,null);

        ((TextView) view.findViewById(R.id.editCodigo)).setText(produto.getId().toString());

        ((TextView) view.findViewById(R.id.editDescricao)).setText(produto.getDescricao());

        ((TextView) view.findViewById(R.id.editPreco)).setText(produto.getPreco());

        return view;
    }
}
