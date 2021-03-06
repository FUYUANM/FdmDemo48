package com.fdm48.fdmdemo48.lect08ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.fdm48.fdmdemo48.R;

import java.util.ArrayList;
import java.util.List;

public class SeniorViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_view);



//        Button dialogBtn = findViewById(R.id.btn_dialog);
//        dialogBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(SeniorViewActivity.this);
//                builder.setIcon(R.mipmap.fdm)
//                        .setTitle("标题")
//                        .setMessage("今天你学习了吗？")
//                        .setPositiveButton("学了", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                Toast.makeText(SeniorViewActivity.this,"你真棒",Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .setNegativeButton("没有", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                Toast.makeText(SeniorViewActivity.this,"继续加油",Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .setNeutralButton("学了一点", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                Toast.makeText(SeniorViewActivity.this,"还不错",Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                AlertDialog dialog = builder.create();
//                dialog.show();
//            }
//        });


        ListView listView = findViewById(R.id.lv);
        List<News> dataList = new ArrayList<>();
        for (int i = 0; i<20; i++){
            News item = new News();
            item.setPicId(R.mipmap.fdm);
            item.setTitle(i +" 同学居然在课堂做这种事情");
            dataList.add(item);
        }

        NewsAdapter adapter = new NewsAdapter(SeniorViewActivity.this,dataList);
        listView.setAdapter(adapter);
    }
}
