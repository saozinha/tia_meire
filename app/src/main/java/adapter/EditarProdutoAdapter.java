package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import com.conceicaolourenco.tiameirerefeicoes.R;

import java.util.List;

import to.Produto;

/**
 * Created by ConceicaoLourenco on 28/06/2015.
 */
public class EditarProdutoAdapter extends BaseAdapter {
    private Produto produto;
    private List<Produto> lista;
    private Context context;

    public EditarProdutoAdapter(List<Produto> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    public EditarProdutoAdapter(Produto produto, Context context) {
        this.produto = produto;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lista.size(); // informa quantos elementos tem na lista
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Produto prod = lista.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.editar_prato_activity, null);

        EditText editCodigo = (EditText) v.findViewById(R.id.editCodigo);
        EditText descricaoEt = (EditText) v.findViewById(R.id.editDescricao);
        EditText precoEt = (EditText) v.findViewById(R.id.editPreco);


        return v;
    }
}
