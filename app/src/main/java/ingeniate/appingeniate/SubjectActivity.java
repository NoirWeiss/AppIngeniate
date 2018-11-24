package ingeniate.appingeniate;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class SubjectActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        final int option = intent.getIntExtra("option", 0);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        String[] subjects = getResources().getStringArray(R.array.subjects);
        TextView subject = findViewById(R.id.subject);
        subject.setText(subjects[option]);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container_theory, new TheoryFragment(option)).commit();


        // Barra de navegación
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bnvMathThinking);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                switch(menuItem.getItemId()) {

                    case R.id.btntheory:
                        fragmentManager.beginTransaction().replace(R.id.container_theory, new TheoryFragment(option)).commit();
                        break;
                    case R.id.btnexam:
                        fragmentManager.beginTransaction().replace(R.id.container_theory, new ExamFragment(option)).commit();
                        break;
                }


                return true;
            }
        });
        //Fin de navegación



    }

}
