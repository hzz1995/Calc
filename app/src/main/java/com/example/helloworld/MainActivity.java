package com.example.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    private EditText et_basic;
    private EditText  et_11;
    private EditText  et_12;
    private EditText  et_13;
    private EditText  et_14;
    private EditText  et_21;
    private EditText  et_22;
    private EditText  et_23;
    private EditText  et_24;
    private EditText  et_31;
    private EditText  et_32;
    private EditText  et_33;
    private EditText  et_34;
    private EditText  et_41;
    private EditText  et_42;
    private EditText  et_43;
    private EditText  et_44;
    private Button b_clear;
    private  Button b_count;
    private Button b_exits;
    private List<EditText> et_list = new ArrayList<EditText>();
    String[][] Item = new String[4][4];
    int[][] Items = new int[4][4];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init();

    //获取文本框的内容
        /*EditText edit11 = (EditText)findViewById(R.id.et_11);
        String str11=edit11.getText().toString();*/

        //清除设置好的文本框。
         b_clear.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 et_basic.setText("0");
                    for (int i =0;i<et_list.size();i++){
                        et_list.get(i).setText("0");
                    }
             }
         });

        //退出程序
        b_exits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });

        //计算按钮
        b_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetValues();
                String str=et_basic.getText().toString();
                float str1=Float.parseFloat(str);
                float tn1=0,tn2=0,tn3=0,tn4=0,hn1=0,hn2=0,hn3=0,hn4=0;
                //A的拖鸟
                    for(int j = 1;j<4;j++) {
                        if (Items[2][0] > Items[2][j]) {
                            tn1 += Items[1][0] + Items[1][j];
                        } else {
                            tn1 += -(Items[1][0] + Items[1][j]);
                        }
                    }
                //B的拖鸟
                if (Items[2][1] > Items[2][0]) {
                    tn2 += Items[1][1] + Items[1][0];
                } else {
                    tn2 += -(Items[1][1] + Items[1][0]);
                }
                for(int j = 2;j<4;j++) {
                    if (Items[2][1] > Items[2][j]) {
                        tn2 += Items[1][1] + Items[1][j];
                    } else {
                        tn2 += -(Items[1][1] + Items[1][j]);
                    }
                }
                //C的拖鸟

                    if (Items[2][2] > Items[2][3]) {
                        tn3 += Items[1][2] + Items[1][3];
                    } else {
                        tn3 += -(Items[1][2] + Items[1][3]);
                    }

                for(int j = 1;j>=0;j--) {
                    if (Items[2][2] > Items[2][j]) {
                        tn3 += Items[1][2] + Items[1][j];
                    } else {
                        tn3 += -(Items[1][2] + Items[1][j]);
                    }
                }

                //D的拖鸟。
                for(int j = 2;j>=0;j--) {
                    if (Items[2][3] > Items[2][j]) {
                        tn4 += Items[1][3] + Items[1][j];
                    } else {
                        tn4 += -(Items[1][3] + Items[1][j]);
                    }
                }

                //计算火鸟。
                //A的活鸟
                for(int j=1;j<4;j++){
                    hn1 += (Items[2][0]-Items[2][j])*str1*(Items[0][0]+1)*(Items[0][j]+1);
                }

                //B的活鸟
                hn2 += (Items[2][1]-Items[2][0])*str1*(Items[0][1]+1)*(Items[0][0]+1);
                for(int j=2;j<4;j++){
                    hn2 += (Items[2][1]-Items[2][j])*str1*(Items[0][1]+1)*(Items[0][j]+1);
                }


                //C的活鸟
                hn3 += (Items[2][2]-Items[2][3])*str1*(Items[0][2]+1)*(Items[0][3]+1);
                for(int j=1;j>=0;j--){
                    hn3 += (Items[2][2]-Items[2][j])*str1*(Items[0][2]+1)*(Items[0][j]+1);
                }
                //D的活鸟
                for(int j=2;j>=0;j--){
                    hn4 += (Items[2][3]-Items[2][j])*str1*(Items[0][3]+1)*(Items[0][j]+1);
                }
                String A = String.valueOf(hn1+tn1);
                String B = String.valueOf(hn2+tn2);
                String C = String.valueOf(hn3+tn3);
                String D = String.valueOf(hn4+tn4);
                et_list.get(12).setText(A);
                et_list.get(13).setText(B);
                et_list.get(14).setText(C);
                et_list.get(15).setText(D);
            }
        });






    }
    public void Init(){
        et_basic=(EditText)findViewById(R.id.et_per);
        et_11 = (EditText)findViewById(R.id.et_11);
        et_list.add(et_11);
        et_12 = (EditText)findViewById(R.id.et_12);
        et_list.add(et_12);
        et_13 = (EditText)findViewById(R.id.et_13);
        et_list.add(et_13);
        et_14 = (EditText)findViewById(R.id.et_14);
        et_list.add(et_14);
        et_21 = (EditText)findViewById(R.id.et_21);
        et_list.add(et_21);
        et_22 = (EditText)findViewById(R.id.et_22);
        et_list.add(et_22);
        et_23 = (EditText)findViewById(R.id.et_23);
        et_list.add(et_23);
        et_24= (EditText)findViewById(R.id.et_24);
        et_list.add(et_24);
        et_31 = (EditText)findViewById(R.id.et_31);
        et_list.add(et_31);
        et_32 = (EditText)findViewById(R.id.et_32);
        et_list.add(et_32);
        et_33 = (EditText)findViewById(R.id.et_33);
        et_list.add(et_33);
        et_34 = (EditText)findViewById(R.id.et_34);
        et_list.add(et_34);
        et_41 = (EditText)findViewById(R.id.et_41);
        et_list.add(et_41);
        et_42 = (EditText)findViewById(R.id.et_42);
        et_list.add(et_42);
        et_43 = (EditText)findViewById(R.id.et_43);
        et_list.add(et_43);
        et_44 = (EditText)findViewById(R.id.et_44);
        et_list.add(et_44);
        b_clear =(Button)findViewById(R.id.b_clear);
        b_count = (Button)findViewById(R.id.b_count);
        b_exits=(Button)findViewById(R.id.b_exits);
    }
    //获取文本框中的值
    public void GetValues(){
        for (int i = 0;i<et_list.size();i++){
            if (i <= 3) {
                Item[0][i]=et_list.get(i).getText().toString();
                Items[0][i]=Integer.parseInt(Item[0][i]);

            }
            if (i>3 && i <= 7) {

                Item[1][i-4]=et_list.get(i).getText().toString();
                Items[1][i-4]=Integer.parseInt(Item[1][i-4]);

            }
            int[] Int = new int[4];
            if (i>7 && i <= 11) {

                Item[2][i-8]=et_list.get(i).getText().toString();
                Int[i-8]=Integer.parseInt(Item[2][i-8]);
                if(Int[i-8]%10!=0 &&Math.abs(Int[i-8]%10)>=5){
                    if(Int[i-8]>0)
                     Items[2][i-8]=Int[i-8]/10*10+10;
                    else{
                        Items[2][i-8]=Int[i-8]/10*10-10;
                    }
                }
                else{
                    Items[2][i-8]=Int[i-8]/10*10;
                }

            }


            }


    }
}
