package dialog.readiva.lab.com.readivadialog;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import dialog.readiva.lab.com.mylibrary.ReadivaDialog;

public class MainActivity extends AppCompatActivity {

    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.idBtn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ReadivaDialog.dialog()
                        .setLayout(R.layout.custom_layout).setOkButtonId(R.id.idOkButton)
                        .show(MainActivity.this);

            }
        });



    }
}
