package SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ConceicaoLourenco on 25/06/2015.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String banco_dados = "TIAMEIRE";
    public static final int versao_bd = 2;


    public DataBaseHelper (Context ctx) {
        super(ctx, banco_dados, null,versao_bd);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        // salvar imagem :  http://www.guj.com.br/9814-armazenar-imagem-no-sqlite-e-enviar-para-um-webservice
        //bd.execSQL("create table produto (_id integer primary key autoincrement, imagem txt not null , descricao text not null, preco float not null);");
        bd.execSQL("create table produtos (_id integer primary key autoincrement, descricao text not null, preco text not null);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int arg1, int arg2) {
        bd.execSQL("drop table if exists produtos;");
        onCreate(bd);
    }

}
