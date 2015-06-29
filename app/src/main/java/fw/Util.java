package fw;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.conceicaolourenco.tiameirerefeicoes.R;

/**
 * Created by ConceicaoLourenco on 29/06/2015.
 */
public class Util {

    public static void showCustomAlertDialog(Context context, String name,
                                             String id, String desc, String fromDate, String toDate,
                                             String resions) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_custom_dialog, null);

        alertDialogBuilder.setView(view);
        alertDialogBuilder.setCancelable(false);

        final AlertDialog dialog = alertDialogBuilder.create();

        dialog.show();

        //instancia os objetos que estão no layout customdialog.xml
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
                // TODO Auto-generated method stub
                dialog.dismiss();

            }
        });

        bt_cancelar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dialog.dismiss();

            }
        });

    }

}
