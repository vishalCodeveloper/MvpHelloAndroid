package com.example.mvp_hello_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SayHelloContract.View, View.OnClickListener {

    private TextView mTvHeading;
    private EditText mEtFirst, mEtlast;
    private SayHelloPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        mTvHeading = findViewById(R.id.tv_heading);
        mEtFirst = findViewById(R.id.et_first_name);
        mEtlast = findViewById(R.id.et_last_name);

        presenter = new SayHelloPresenter(this);
        findViewById(R.id.btn_show).setOnClickListener(this);
        findViewById(R.id.btn_update).setOnClickListener(this);
    }

    @Override
    public void ShowMessage(String msg) {
      mTvHeading.setText(msg);
    }

    @Override
    public void ShowError(String Error) {
        Toast.makeText(this, Error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_update:
                presenter.saveName(mEtFirst.getText().toString(), mEtlast.getText().toString());
                break;

            case R.id.btn_show:
                presenter.loadMessage();
                break;
        }
    }
}
