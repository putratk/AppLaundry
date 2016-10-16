package id.sch.smktelkom_mlg.tugas01.xiirpl3027.applaundry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama, etAlamat, etNomor;
    Button btOk;
    TextView tvHasil;
    RadioButton rbCB, rbCK, rbCS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);
        etNomor = (EditText) findViewById(R.id.editTextNomor);
        btOk = (Button) findViewById(R.id.buttonOk);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        rbCB = (RadioButton) findViewById(R.id.radioButtonCB);
        rbCK = (RadioButton) findViewById(R.id.radioButtonCK);
        rbCS = (RadioButton) findViewById(R.id.radioButtonCS);

        findViewById(R.id.buttonOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doClick();

            }
        });
    }

    private void doClick() {
        String nama = etNama.getText().toString();
        String alamat = etAlamat.getText().toString();
        String nomor = etNomor.getText().toString();

        String ket = "";
        if (rbCB.isChecked()) {
            ket = rbCB.getText().toString();
        } else if (rbCK.isChecked()) {
            ket = rbCK.getText().toString();
        } else if (rbCS.isChecked()) {
            ket = rbCS.getText().toString();
        } else {
            ket = "Anda belum memilih Jenis Laundry";
        }

        if (isValid()) {
            tvHasil.setText("Nama : " + nama +
                    "\nAlamat : " + alamat +
                    "\nNomor Telepon : " + nomor +
                    "\nJenis Laundry : " + ket);
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String namaa = etNama.getText().toString();
        String alamatt = etAlamat.getText().toString();
        String nomorr = etNomor.getText().toString();

        if (namaa.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (alamatt.isEmpty()) {
            etAlamat.setError("Alamat belum diisi");
            valid = false;
        } else if (nomorr.isEmpty()) {
            etNomor.setError("Nomor telepon belum diisi");
            valid = false;
        } else {
            etNama.setError(null);
            etAlamat.setError(null);
            etNomor.setError(null);
        }

        return valid;

    }
}
