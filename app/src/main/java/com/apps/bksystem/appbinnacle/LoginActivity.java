package com.apps.bksystem.appbinnacle;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.DataBase.DB_Helper;
import com.apps.bksystem.appbinnacle.SyncPackage.SyncManager;

public class LoginActivity extends AppCompatActivity {

    Activity context;

    //private Button btn_ingresar;
    //private DB_Helper db_helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);





        /*db_helper = new DB_Helper(this);
        SQLiteDatabase db = db_helper.getWritableDatabase();
        db.getVersion();




        btn_ingresar = (Button)findViewById(R.id.login_btn_ingresar);

        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SyncManager syncManager = new SyncManager(context);
                syncManager.execute();
            }
        });*/

    }
}
