package newton.com.comprasdaroca.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import newton.com.comprasdaroca.R;

public class sobreActivity extends AppCompatActivity {

    private TextView textoApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        textoApp = findViewById(R.id.text_app);
    }
}
