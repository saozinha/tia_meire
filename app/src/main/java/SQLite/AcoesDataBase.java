package SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import to.Produto;

/**
 * Created by ConceicaoLourenco on 25/06/2015.
 */
public class AcoesDataBase {
    private SQLiteDatabase bd;

    public AcoesDataBase(Context cont) {
        DataBaseHelper auxBD = new DataBaseHelper(cont);
        this.bd = auxBD.getWritableDatabase();
    }

    public void inserir(Produto produto) {
        ContentValues valores = new ContentValues();
        valores.put("descricao", produto.getDescricao());
        valores.put("preco", produto.getPreco());
        //valores.put("imagem", produto.getImagem());
        bd.insert("produtos", null, valores);

    }

    public void atualizar(Produto produto) {
        ContentValues valores = new ContentValues();
        valores.put("descricao", produto.getDescricao());
        valores.put("preco", produto.getPreco());
        //valores.put("imagem", produto.getImagem());
        bd.update("produtos", valores, "_id = ?", new String[]{"" + produto.getId()});
    }

    public void deletar(Produto produto) {
        bd.delete("produtos", "_id = " + produto.getId(), null);
    }

    public Produto buscar(String codigo) {
        List<Produto> lista = new ArrayList<Produto>();
        String[] colunas = new String[]{"_id", "descricao", "preco"};
        Cursor cursor = bd.query("produtos", colunas, null, null, null, null, "descricao ASC");
        Produto prod = new Produto();

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Long cod = cursor.getLong(0);
                if (cursor.getLong(0) == Long.parseLong(codigo)) {
                    prod.setId(cursor.getLong(0));
                    prod.setDescricao(cursor.getString(1));
                    prod.setPreco(cursor.getString(2));
                    break;
                }
            } while (cursor.moveToNext());
        }
        return prod;
    }

    public List<Produto> ListarProdutos() {
        List<Produto> lista = new ArrayList<Produto>();
        String[] colunas = new String[]{"_id", "descricao", "preco"};
        Cursor cursor = bd.query("produtos", colunas, null, null, null, null, "descricao ASC");

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Produto prod = new Produto();
                prod.setId(cursor.getLong(0));
                prod.setDescricao(cursor.getString(1));
                prod.setPreco(cursor.getString(2));
                lista.add(prod);
            } while (cursor.moveToNext());
        }
        return lista;
    }
}
