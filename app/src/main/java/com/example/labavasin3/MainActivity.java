package com.example.labavasin3;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
    }

    public void btnFunc_1(View view) {
        Toast myToast = Toast.makeText(getApplicationContext(),"кнопка номер 1 нажата",Toast.LENGTH_SHORT);
        myToast.show();
    }

    public void btnFunc_2(View view) {
        Toast myToast = Toast.makeText(getApplicationContext(),"кнопка номер 2 нажата",Toast.LENGTH_LONG);
        myToast.setGravity(Gravity.TOP,0,-30);
        myToast.show();
    }

    public void btnFunc_3(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("кнопка 3")
                .setIcon(R.drawable.test_icon)
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        btn1.setTextColor(Color.RED);
                        btn2.setTextColor(Color.RED);
                        btn3.setTextColor(Color.RED);
                        btn4.setTextColor(Color.RED);
                    }
                })
                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        Toast.makeText(getApplicationContext(),"Вы отменили",Toast.LENGTH_SHORT).show();
                    }
                });;
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void btnFunc_4(View view) {
        String[] pers = {"1 уровень","2 уровень","3 уровень"};
        boolean[] pers_c = {false,false,false};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Выберите уровень")
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(pers_c[2] && !pers_c[0] && !pers_c[1]){
                            Toast myToast = Toast.makeText(getApplicationContext(),"все верно",Toast.LENGTH_LONG);
                            myToast.setGravity(Gravity.CENTER,0,0);
                            myToast.show();
                        }
                        else {
                            btn1.setVisibility(View.INVISIBLE);
                            btn2.setVisibility(View.INVISIBLE);
                            btn3.setVisibility(View.INVISIBLE);
                            btn4.setVisibility(View.INVISIBLE);
                        }
                    }
                })
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .setMultiChoiceItems(pers, pers_c, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        pers_c[i]=b;
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}