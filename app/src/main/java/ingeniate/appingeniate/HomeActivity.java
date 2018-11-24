package ingeniate.appingeniate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Poner icono en ActionBar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        TextView contenedorInicio1 = (TextView)findViewById(R.id.cont_consejos);
        String rellenoConsejos1 = getResources().getString(R.string.consejos_inicio);
        contenedorInicio1.setText(rellenoConsejos1);

        TextView contenedorInicio2 = (TextView)findViewById(R.id.cont_previo);
        String rellenoConsejos2 = getResources().getString(R.string.consejos_previo);
        contenedorInicio2.setText(rellenoConsejos2);

        TextView contenedorInicio3 = (TextView)findViewById(R.id.cont_durante);
        String rellenoConsejos3 = getResources().getString(R.string.consejos_durante);
        contenedorInicio3.setText(rellenoConsejos3);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the HomeActivity/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "Vamos Tu Puedes!!!",Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        //Se han agregado los fragmentos con ayuda de la siguiente linea de código
        FragmentManager fragmentManager = getSupportFragmentManager();

        Intent intent = new Intent(this, SubjectActivity.class);
        int option=0;

        if      (id == R.id.nav_math)     option = 0;
        else if (id == R.id.nav_analytic) option = 1;
        else if (id == R.id.nav_lenguaje) option = 2;
        else if (id == R.id.nav_lecture)  option = 3;

        intent.putExtra("option",   option);
        startActivity(intent);

        /*if (id == R.id.nav_math) {
            Intent intent = new Intent(this, SubjectActivity.class);
            startActivity(intent);
            //fragmentManager.beginTransaction().replace(R.id.container_Home, new PensamientoMatematicoFragment()).commit();
        } else if (id == R.id.nav_analytic) {
            Intent intent = new Intent(this, AnalyticThinking.class);
            startActivity(intent);
        } else if (id == R.id.nav_lenguaje) {
            Intent intent = new Intent(this, StructureLenguaje.class);
            startActivity(intent);
        } else if (id == R.id.nav_lecture) {
            Intent intent = new Intent(this, LectureComprehension.class);
            startActivity(intent);
        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}

