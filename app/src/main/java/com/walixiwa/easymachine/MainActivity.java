package com.walixiwa.easymachine;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.walixiwa.easy.machine.Parser;
import com.walixiwa.easy.machine.Searcher;
import com.walixiwa.easy.machine.model.BaseDetailModel;
import com.walixiwa.easy.machine.model.BaseResultModel;
import com.walixiwa.easy.machine.model.BaseRuleModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static BaseRuleModel baseRuleModel;
    private EditText mEtKeyWords;
    private EditText mEtLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEtKeyWords = findViewById(R.id.et_keywords);
        mEtLink = findViewById(R.id.et_link);
        findViewById(R.id.btn_create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBuilderDialog();
            }
        });
        findViewById(R.id.btn_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (baseRuleModel == null) {
                    Toast.makeText(MainActivity.this, "引擎未载入", Toast.LENGTH_SHORT).show();
                } else {
                    search(mEtKeyWords.getText().toString(), 1);
                }
            }
        });

        findViewById(R.id.btn_parse).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (baseRuleModel == null) {
                    Toast.makeText(MainActivity.this, "引擎未载入", Toast.LENGTH_SHORT).show();
                } else {
                    parse(mEtLink.getText().toString());
                }
            }
        });
    }

    private void showBuilderDialog() {
        final BaseRuleModel ruleModel = ModelBuilder.buildWaiJuWangModel();
        new AlertDialog.Builder(this)
                .setTitle("载入引擎")
                .setMessage(ruleModel.toBase64Linker())
                .setCancelable(false)
                .setPositiveButton("确认载入", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        baseRuleModel = ruleModel;
                        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        assert clipboardManager != null;
                        clipboardManager.setPrimaryClip(ClipData.newPlainText(null, ruleModel.toBase64Linker()));
                        Toast.makeText(MainActivity.this, "已复制Linker", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }

    private void search(String key, int page) {
        new Searcher(baseRuleModel).with(key, page).setCallback(new Searcher.Callback() {
            @Override
            public void onStart() {

            }

            @Override
            public void onResult(List<BaseResultModel> results) {
                Log.e("result", "size:"+results.size());
                for (int i = 0; i < results.size(); i++) {
                    Log.e("result", results.get(i).toJson());
                }
            }

            @Override
            public void onFail(String message) {
                Log.e("result", message);
            }

            @Override
            public void onEnd() {

            }
        }).start();
    }

    private void parse(String link) {
        new Parser(baseRuleModel).with(link).setCallBack(new Parser.CallBack() {
            @Override
            public void onSuccess(BaseDetailModel resultModel) {
                Log.e("result", resultModel.toJson());
            }

            @Override
            public void onFail(String msg) {

            }

        }).start();
    }
}
