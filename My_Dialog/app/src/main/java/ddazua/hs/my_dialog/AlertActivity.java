package ddazua.hs.my_dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class AlertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
    }

    @Override
    public void onBackPressed() {
        //AlertDialog 생성
        AlertDialog.Builder dialog = new AlertDialog.Builder(AlertActivity.this);

        dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        dialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertActivity.this, "no click", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setNeutralButton("neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertActivity.this, "neutral click", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setTitle("app name");
        dialog.setMessage("are you want exit application?");

        dialog.show();
    }//onBackPressed();
}