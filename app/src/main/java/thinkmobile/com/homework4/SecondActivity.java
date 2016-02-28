package thinkmobile.com.homework4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Andrii on 23.02.2016.
 */

public class SecondActivity extends Activity {
    EditText edit_number;
    Button button_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Theme_Changer.onActivityCreateSetTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        edit_number = (EditText) findViewById(R.id.edit_number);
        button_ok = (Button) findViewById(R.id.button_ok);
    }
        public void okClick(View v) {
            Intent intent = new Intent();
            intent.putExtra("A", edit_number.getText().toString());;
            setResult(RESULT_OK, intent);
            finish();
        }
}
