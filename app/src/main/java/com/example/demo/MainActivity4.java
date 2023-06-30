package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity4 extends AppCompatActivity {

    private EditText edt1,edt2,edt3,edt4;
    private TextView rb1;

  private boolean resendenabled=false;
  private int resendtimer = 60;

  private int selectposition =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        edt1 = this.findViewById(R.id.edt1);
        edt2 = this.findViewById(R.id.edt2);
        edt3 = this.findViewById(R.id.edt3);
        edt4 = this.findViewById(R.id.edt4);

        rb1 = this.findViewById(R.id.rb1);

        final Button b3 = this.findViewById(R.id.b3);
        final TextView t1 = this.findViewById(R.id.t1);
        final TextView t2 = this.findViewById(R.id.t2);

        final String getEmail = getIntent().getStringExtra("refermobile");
        final String getmobile = getIntent().getStringExtra("Refermobile");

        t1.setText(getEmail);
        t2.setText(getmobile);

        edt1.addTextChangedListener(textWatcher);
        edt2.addTextChangedListener(textWatcher);
        edt3.addTextChangedListener(textWatcher);
        edt4.addTextChangedListener(textWatcher);

        showkeyboard(edt1);
        startcountdowntimer();
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(resendenabled){
                    startcountdowntimer();
                }

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            final String generateotp = edt1.getText().toString()+edt2.getText().toString()+edt3.getText().toString()+edt4.getText().toString();
            if(generateotp.length()==4){

            }
            }
        });
    }

    private void showkeyboard(EditText optet){
        optet.requestFocus();

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(optet,InputMethodManager.SHOW_IMPLICIT);
    }

    private void startcountdowntimer(){
        resendenabled=false;
        rb1.setTextColor(Color.parseColor("#99000000"));
        new CountDownTimer(resendtimer=60,100){
            @Override
            public void onTick(long millisUntilFinished) {
                rb1.setText("Resend Code ("+(millisUntilFinished / 1000)+")");
            }

            @Override
            public void onFinish() {
                resendenabled=true;
                rb1.setText("Resend code");
                rb1.setTextColor(getResources().getColor(R.color.purple_200));

            }
        }.start();
    }
        private final TextWatcher textWatcher=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            if (s.length() > 0){
                 if (selectposition==0){
                     selectposition=1;
                     showkeyboard(edt2);
                 } else if (selectposition==1) {
                     selectposition=2;
                     showkeyboard(edt3);

                 } else if (selectposition == 2) {
                     selectposition=3;
                     showkeyboard(edt4);
                 }
            }
            }
        };

    public boolean onKeyUp(int keycode, KeyEvent event){
        if(keycode==KeyEvent.KEYCODE_DEL){
            if(selectposition==3){
                selectposition=2;
                showkeyboard(edt3);
            } else if (selectposition==2) {
                selectposition=1;
                showkeyboard(edt2);

            } else if (selectposition==1) {
                selectposition=0;
                showkeyboard(edt1);

            }
            return true;
        }
        else {
            return super.onKeyUp(keycode,event);
        }


    }
}



