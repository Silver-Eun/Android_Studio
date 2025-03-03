package kr.ac.hs.petview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView Text1, Text2, Text3, Text4, Text5;
    CheckBox ChkAgree;
    RadioGroup Rgroup1;
    RadioButton RdoDog, RdoCat, RdoRabbit;
    Button BtnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Text1 = (TextView) findViewById(R.id.Text1);
        ChkAgree = (CheckBox) findViewById(R.id.ChkAgree);

        Text2 = (TextView) findViewById(R.id.Text2);
        Text3 = (TextView) findViewById(R.id.Text3);
        Rgroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        RdoDog = (RadioButton) findViewById(R.id.RdoDog);
        RdoCat = (RadioButton) findViewById(R.id.RdoCat);
        RdoRabbit = (RadioButton) findViewById(R.id.RdoRabbit);
        Text4 = (TextView) findViewById(R.id.Text4);
        Text5 = (TextView) findViewById(R.id.Text5);

        BtnOk = (Button) findViewById(R.id.BtnOk);

        ChkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ChkAgree.isChecked() == true){
                    Text2.setVisibility(View.VISIBLE);
                    Rgroup1.setVisibility(View.VISIBLE);
                    BtnOk.setVisibility(View.VISIBLE);
                }
                else{
                    Text2.setVisibility(View.INVISIBLE);
                    Rgroup1.setVisibility(View.INVISIBLE);
                    BtnOk.setVisibility(View.INVISIBLE);
                }
            }
        });

        BtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(Rgroup1.getCheckedRadioButtonId()){
                    case R.id.RdoDog:
                        Text3.setVisibility(View.VISIBLE);
                        Text4.setVisibility(View.INVISIBLE);
                        Text5.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.RdoCat:
                        Text3.setVisibility(View.INVISIBLE);
                        Text4.setVisibility(View.VISIBLE);
                        Text5.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.RdoRabbit:
                        Text3.setVisibility(View.INVISIBLE);
                        Text4.setVisibility(View.INVISIBLE);
                        Text5.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
    }
}