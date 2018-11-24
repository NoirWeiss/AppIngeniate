package ingeniate.appingeniate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TopicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent fragment_theory = getIntent();
        int topic = fragment_theory.getIntExtra("topic", 0);
        int option = fragment_theory.getIntExtra("option", 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        String[] theory_titles;
        String[] theory_contents;
        List<Integer> theory_images = new ArrayList<Integer>();

        if (topic == 0){
            theory_titles = getResources().getStringArray(R.array.pm_theory_titles);
            theory_contents = getResources().getStringArray(R.array.pm_theory_contents);

            theory_images.add(R.drawable.img_pm_suma_resta_de_fracciones); // Fracciones
            theory_images.add(R.drawable.img_pm_proporciones); // Proporciones
            theory_images.add(R.drawable.img_pm_porcentajes); // Porcentajes
            theory_images.add(R.drawable.img_pm_ley_de_signos); // Ley de signos
            theory_images.add(R.drawable.img_pm_ley_de_exponentes); // Ley de exponentes
            theory_images.add(R.drawable.img_pm_productos_notables); // Productos notables
            theory_images.add(R.drawable.img_pm_factorizacion); // Factorización
            theory_images.add(R.drawable.img_pm_descomposicion_raices); // Descomposición de raíces
            theory_images.add(R.drawable.img_pm_ecuaciones_lineales); // Ecuaciones lineales
            theory_images.add(R.drawable.img_blank); // Método de suma y resta
            theory_images.add(R.drawable.img_pm_angulos); // Geometría y trigonometría
            theory_images.add(R.drawable.img_pm_figuras_proporcionales); // Figuras proporcionales
            theory_images.add(R.drawable.img_pm_area_volumen_perimetro); // Área, volúmen y perímetro
            theory_images.add(R.drawable.img_pm_teorema_pitagoras); // Teorema de pitágoras
            theory_images.add(R.drawable.img_pm_funciones_trigonometricas); // Funciones trigonométricas
            theory_images.add(R.drawable.img_blank); // Estadística

        }

        else if (topic == 1){
            theory_titles = getResources().getStringArray(R.array.pa_theory_titles);
            theory_contents = getResources().getStringArray(R.array.pa_theory_contents);

            theory_images.add(R.drawable.img_blank);

        }

        else if (topic == 2){
            theory_titles = getResources().getStringArray(R.array.el_theory_titles);
            theory_contents = getResources().getStringArray(R.array.el_theory_contents);

            theory_images.add(R.drawable.img_blank); // Estadística

        }

        else {
            theory_titles = getResources().getStringArray(R.array.cl_theory_titles);
            theory_contents = getResources().getStringArray(R.array.cl_theory_contents);

            theory_images.add(R.drawable.img_blank); // Estadística

        }

        TextView theory_title = findViewById(R.id.theory_title);
        theory_title.setText(theory_titles[option]);
        TextView theory_content = findViewById(R.id.theory_content);
        theory_content.setText(theory_contents[option]);
        ImageView theory_image = findViewById(R.id.theory_image);
        theory_image.setImageResource(theory_images.get(option));

    }
}
