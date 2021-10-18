package br.java.e_commerce_android_firebase_master.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import br.java.e_commerce_android_firebase_master.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Fragment fragment = null;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        Drawable background = getResources().getDrawable(R.drawable.gradient_home, getTheme());
        getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent, getTheme()));
        getWindow().setBackgroundDrawable(background);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.home:

                        fragment = new Home();
                        switchfragment(fragment);

                        break;
                    case R.id.carrinho:

                        break;
                    case R.id.bolsa_compras:

                        break;

                    case R.id.mensagem:

                        break;

                    case R.id.usuario:

                        fragment = new Usuario();
                        switchfragment(fragment);

                        break;

                }

                return false;
            }
        });

        if (savedInstanceState == null ){
            bottomNavigationView.setSelectedItemId(R.id.home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case R.id.todas_categorias: todas_categorias(); break;
            case R.id.pedidos: meus_pedidos(); break;
            case R.id.carrinho: carrinho(); break;
            case R.id.lista_de_compras: break;
            case R.id.conta: break;
            case R.id.notificacoes: break;
            case R.id.politica_de_privacidade: break;
            case R.id.juridico: break;
            case R.id.relatorio: break;
            case R.id.avaliar: break;
            case R.id.compartilhar: break;
            case R.id.sair: break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    void todas_categorias() {

    }

    void meus_pedidos() {

    }

    void carrinho() {
        
    }

    void switchfragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.framelayout, fragment).commit();
    }
}