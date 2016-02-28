package thinkmobile.com.homework4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    TextView text_view_a;
    TextView text_view_b;
    Button button_calc;
    EditText edit_text_operation;
    TextView text_result;

    double dNumber_a = 0;
    double dNumber_b = 0;
    double dNumber_c = 0;

    Switch switchTheme;

    static final private int CHOOSE_A = 1;
    static final private int CHOOSE_B = 2;
    private static int mCurTheme =1;
    public  final static String RESTORED_A ="sNum_A";
    public  final static String RESTORED_B ="sNum_B";
    public  final static String RESTORED_RESULT ="sNum_RESTORED_RESULT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Theme_Changer.onActivityCreateSetTheme(MainActivity.this);
        setContentView(R.layout.activity_main);

        text_view_a = (TextView) findViewById(R.id.text_view_a);
        text_view_a.setOnClickListener(numA);
        text_view_b = (TextView) findViewById(R.id.text_view_b);
        text_view_b.setOnClickListener(numB);
        text_result = (TextView) findViewById(R.id.text_result);
        button_calc = (Button) findViewById(R.id.button_calc);
        button_calc.setOnClickListener(btnL);
        edit_text_operation = (EditText) findViewById(R.id.edit_text_operation);
        edit_text_operation.setOnClickListener(operatorL);

        switchTheme = (Switch) findViewById(R.id.theme_switch);
        switchTheme.setChecked(Theme_Changer.themeIsDark);
        switchTheme.setOnCheckedChangeListener(sw);


    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.theme_switch:
                if (isChecked) {
                    Theme_Changer.changeTheme(this, Theme_Changer.THEME_BLUE);
                } else {
                    Theme_Changer.changeTheme(this, Theme_Changer.THEME_LIGHT);
                }
                break;
        }
    }

/*    @Override
    protected void onSaveInstanceState(Bundle outState) {
     super.onSaveInstanceState(outState);

         outState.putString(RESTORED_A, text_view_a.getText().toString());
         outState.putString(RESTORED_B, text_view_b.getText().toString());
         outState.putString(RESTORED_RESULT, text_result.getText().toString());


    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) throws NullPointerException{
        super.onRestoreInstanceState(savedInstanceState);

        text_view_a.setText(savedInstanceState.getString(RESTORED_A));
        text_view_b.setText(savedInstanceState.getString(RESTORED_B));
        text_result.setText(savedInstanceState.getString(RESTORED_RESULT));
    }
*/

    CompoundButton.OnCheckedChangeListener sw = new CompoundButton.OnCheckedChangeListener() {
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.theme_switch:
                if (isChecked) {
                    Theme_Changer.changeTheme(MainActivity.this, Theme_Changer.THEME_BLUE);
                } else {
                    Theme_Changer.changeTheme(MainActivity.this, Theme_Changer.THEME_LIGHT);
                }
                break;
        }
    }
    };

    OnClickListener btnL = new OnClickListener() {
        @Override
        public void onClick(View v) {
            String sNumber_a = text_view_a.getText().toString();
            String sNumber_b = text_view_b.getText().toString();
            String operator = edit_text_operation.getText().toString();
    try {
        dNumber_a = Double.parseDouble(sNumber_a);
        dNumber_b = Double.parseDouble(sNumber_b);
    } catch (NumberFormatException ex){
        if (sNumber_a.isEmpty() && sNumber_b.isEmpty()) {
            Toast.makeText(MainActivity.this, "Fields a, b are empty", Toast.LENGTH_SHORT).show();
        } else if (sNumber_a.isEmpty()) {
            sNumber_a = "0";
            Toast.makeText(MainActivity.this, "Field A is empty", Toast.LENGTH_SHORT).show();
        } else if (sNumber_b.isEmpty()) {
            sNumber_b = "0";
            Toast.makeText(MainActivity.this, "Field B is empty", Toast.LENGTH_SHORT).show();
        }
    }

            ArrayList<String> operators = new ArrayList<String>();
            operators.add(0, " ");
            operators.add(1, "+");
            operators.add(2, "-");
            operators.add(3, "/");
            operators.add(4, "*");



            if (operator.equals(operators.get(0))) {
                text_result.setText(R.string.choose);
            }
            if (operator.equals(operators.get(1))) {
                dNumber_c = dNumber_a + dNumber_b;
                text_result.setText(String.valueOf(dNumber_c));
            }
            if (operator.equals(operators.get(2))) {
                dNumber_c = dNumber_a - dNumber_b;
                text_result.setText(String.valueOf(dNumber_c));
            }
            if (operator.equals(operators.get(3))) {
                dNumber_c = dNumber_a / dNumber_b;
                text_result.setText(String.valueOf(dNumber_c));
            }
            if (operator.equals(operators.get(4))) {
                dNumber_c = dNumber_a * dNumber_b;
                text_result.setText(String.valueOf(dNumber_c));
            }

        }

    };
    OnClickListener operatorL = new OnClickListener() {
        @Override
        public void onClick(View v) {
            edit_text_operation.setText("");
        }
    };
    OnClickListener numA = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivityForResult(intent, 1);
        }
    };
    OnClickListener numB = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivityForResult(intent, 2);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }
        if (requestCode == CHOOSE_A) {
            String A = data.getStringExtra("A");
            text_view_a.setText(A);
        }
        if (requestCode == CHOOSE_B) {
            String A = data.getStringExtra("A");
            text_view_b.setText(A);
        }
    }


}
