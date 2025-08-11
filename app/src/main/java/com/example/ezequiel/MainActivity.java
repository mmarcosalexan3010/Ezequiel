package com.example.ezequiel; // Certifique-se que o package é o correto para o seu projeto

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText; // Para o EditText de email
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText; // Para o TextInputEditText de senha

public class MainActivity extends AppCompatActivity {

    // Declarar as Views
    private EditText editEmail;
    private TextInputEditText textInputLayoutSenha; // Se estiver usando TextInputEditText para senha
    // Se o campo de senha for um EditText normal, use: private EditText editTextSenha;
    private Button botaoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // EdgeToEdge.enable(this); // Você pode manter ou remover isso dependendo se está usando EdgeToEdge
        setContentView(R.layout.activity_main); // Certifique-se que o nome do seu layout XML está correto

        // Inicializar as Views (conectar com os IDs do XML)
        editEmail = findViewById(R.id.editEmail);
        textInputLayoutSenha = findViewById(R.id.editSenha);
        // Se o campo de senha for um EditText normal, use: editTextSenha = findViewById(R.id.editSenha);
        botaoLogin = findViewById(R.id.botaoLogin);

        // Configurar o OnClickListener para o botão de login
        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obter o texto dos campos quando o botão for clicado
                String email = editEmail.getText().toString().trim();
                String senha = textInputLayoutSenha.getText().toString().trim();
                // Se o campo de senha for um EditText normal, use: String senha = editTextSenha.getText().toString().trim();

                // Lógica simples de "login" (apenas para demonstração)
                if (email.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                } else {
                    // Exibir os dados em um Toast (substitua por sua lógica de login real)
                    String mensagemLogin = "Email: " + email + "\nSenha: " + senha;
                    Toast.makeText(MainActivity.this, mensagemLogin, Toast.LENGTH_LONG).show();

                    // Aqui você adicionaria a lógica para validar o login,
                    // verificar com um servidor, navegar para outra Activity, etc.
                }
            }
        });

        /*
        // Se você estiver usando ViewBinding (recomendado para projetos maiores para evitar findViewById)
        // ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        // setContentView(binding.getRoot());
        //
        // editTextEmail = binding.editEmail;
        // textInputEditTextSenha = binding.editSenha;
        // buttonLogin = binding.botaoLogin;
        //
        // buttonLogin.setOnClickListener(v -> { ... });
        */
    }
}
