package com.fdm48.fdmdemo48.lect07intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.widget.Toast;

import com.fdm48.fdmdemo48.R;

public class IntentActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        findViewById(R.id.btn_web).setOnClickListener(this);
        findViewById(R.id.btn_flag).setOnClickListener(this);
        findViewById(R.id.btn_dial).setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_dial: {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0376557738"));
                startActivity(intent);
            }break;
            case R.id.btn_flag:{
                Intent intent=new Intent(IntentActivity.this, FlagActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
            break;
            case R.id.btn_web: {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                Intent chooser=Intent.createChooser(intent,"选浏览器！");
                if(intent.resolveActivity(getPackageManager()) !=null){
//                    startActivity(chooser);
                    startActivity(intent);
                }else{
                    Toast.makeText(this,"手机没有app支持打开该链接",Toast.LENGTH_SHORT).show();
                }
//                startActivity(intent);
            }
            break;
            default:
                break;
        }
    }
}

