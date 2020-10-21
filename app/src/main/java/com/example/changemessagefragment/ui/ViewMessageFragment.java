package com.example.changemessagefragment.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.changemessagefragment.R;
import com.example.changemessagefragment.model.Message;

public class ViewMessageFragment extends Fragment {

    public static final String TAG = "ViewMessageFragment";

    //Creamos la variable tvMessage de tipo TextView que sera la que pase el tamaño y el texto al textView de nuestro mensaje final
    private TextView tvMessage;

    //Ponemos un constructor vacio de la clase
    public ViewMessageFragment() {
        // Required empty public constructor
    }

    //En lugar de poner un constructor con argumentos, se utiliza newInstance y asi nos aseguramos de que los argumentos de fragmentos estan siempre presentes
    //Esto es debido a que si android utiliza el fragmento, luego lo elimina y luego lo vuelve a restaurar, android utilizara un constructor vacio llamado internamente

    /**
     * Se le dara por parametros un bundle que llevara los datos del texto es decir, el texto, el tamaño...
     * @param bundle
     * @return
     */
    public static ViewMessageFragment newInstance(Bundle bundle) {
        ViewMessageFragment v = new ViewMessageFragment();

        //Si el bundle no esta vacio se introduciran los argumentos en el objeto que se ha creado antes
        if (bundle != null) {
            v.setArguments(bundle);
        }
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_message, container, false);

        //Buscamos el TextView de nuestro fragmento para igualarlo a nuestra variable
        //Es importante saber que al estar en una vista tendremos que utilizar view.findViewById()
        tvMessage = view.findViewById(R.id.tvMessage);

        //Recogemos los argumentos que pusimos en la instancia y los metemos en una variable Bundle
        Bundle bundle = getArguments();

        //Tenemos que comprobar si el objeto tiene valores.
        if (bundle != null) {

            //Recordar mirar las clases Message y User ubicadas en el package model
            Message message = (Message) bundle.getSerializable("message");

            //Actualizamos el texto y el tamaño.
            tvMessage.setText(message.getMessage());
            tvMessage.setTextSize(message.getSize());
        }
        return view;
    }
}