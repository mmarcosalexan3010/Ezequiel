package com.example.ezequiel; // Certifique-se que o package é o correto

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout; // Importe FrameLayout
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat; // Para ContextCompat.getColor

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText editEmail;
    private TextInputEditText textInputLayoutSenha;
    private Button botaoLogin;
    private FrameLayout headerContainer; // Declare o FrameLayout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Certifique-se que o nome do seu layout XML está correto

        // Inicializar as Views
        editEmail = findViewById(R.id.editEmail);
        textInputLayoutSenha = findViewById(R.id.editSenha);
        botaoLogin = findViewById(R.id.botaoLogin);
        headerContainer = findViewById(R.id.headerContainer); // Obtenha a referência do FrameLayout

        // Configurar o fundo arredondado para o headerContainer
        if (headerContainer != null) {
            setBottomLeftRoundedCorner(headerContainer, R.color.white, 20); // 20dp de raio
        }

        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString().trim();
                String senha = textInputLayoutSenha.getText().toString().trim();

                if (email.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                } else {
                    String mensagemLogin = "Email: " + email + "\nSenha: " + senha;
                    Toast.makeText(MainActivity.this, mensagemLogin, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /**
     * Define um fundo para a View com apenas o canto inferior esquerdo arredondado.
     * @param view A View à qual o fundo será aplicado.
     * @param backgroundColorResId O ID do recurso da cor de fundo (ex: R.color.white).
     * @param cornerRadiusDp O raio do canto em DP.
     */
    private void setBottomLeftRoundedCorner(View view, int backgroundColorResId, float cornerRadiusDp) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);

        // Define a cor de fundo
        gradientDrawable.setColor(ContextCompat.getColor(this, backgroundColorResId));

        // Converte o raio de DP para pixels
        float cornerRadiusPx = cornerRadiusDp * getResources().getDisplayMetrics().density;

        // Define os raios para cada canto:
        // {topLeftX, topLeftY, topRightX, topRightY, bottomRightX, bottomRightY, bottomLeftX, bottomLeftY}
        // Cada par (X, Y) define o raio para aquele canto.
        // Para um canto reto, o raio é 0.
        float[] radii = new float[]{
                0, 0, // Canto superior esquerdo
                0, 0, // Canto superior direito
                0, 0, // Canto inferior direito
                cornerRadiusPx, cornerRadiusPx  // Canto inferior esquerdo
        };
        gradientDrawable.setCornerRadii(radii);

        view.setBackground(gradientDrawable);
    }
}
