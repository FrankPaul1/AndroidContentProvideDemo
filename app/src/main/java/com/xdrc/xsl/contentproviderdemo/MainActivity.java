package com.xdrc.xsl.contentproviderdemo;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_read_contact)
    public void readContract() {
        Cursor c = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        while (c.moveToNext()) {
            String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            Log.i(TAG, "--contactname: " + name);
        }
    }
}
