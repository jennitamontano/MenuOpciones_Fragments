package mx.jennifermontano.petsjenny;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import mx.jennifermontano.petsjenny.ADAPTER.PetsAdapter;
import mx.jennifermontano.petsjenny.POJO.Pets;

public class FavoritePets extends AppCompatActivity {

    ArrayList<Pets> favoritepets;
    private RecyclerView listaMascotas;
    public PetsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_pets);

        listaMascotas = (RecyclerView) findViewById(R.id.rvPets);

        LinearLayoutManager linlama = new LinearLayoutManager(this);
        linlama.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(linlama);
        inicializarListaMascotas();
        inicializarAdaptador();
    }
    public void inicializarAdaptador(){
        PetsAdapter adaptador = new PetsAdapter(favoritepets,this);
        listaMascotas.setAdapter(adaptador);
    }
    public void  inicializarListaMascotas(){
        favoritepets = new ArrayList<Pets>();
        //Lista de MASCOTAS FAVORITAS:
        favoritepets.add(new Pets(R.drawable.perro2,"Tuxie",6));
        favoritepets.add(new Pets(R.drawable.perro5,"Chiquis",9));
        favoritepets.add(new Pets(R.drawable.perro6,"Kiwi",10));
        favoritepets.add(new Pets(R.drawable.perro8,"Shoko",12));
        favoritepets.add(new Pets(R.drawable.perro10,"Kiara",15));
    }

    public static class ActivityContacto extends AppCompatActivity {

        EditText user;
        EditText key;
        EditText email;
        EditText commentary;
        Button send;
        Session session;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_contacto);

            user = (EditText) findViewById(R.id.et_nombre);
            key = (EditText) findViewById(R.id.et_password);
            email = (EditText) findViewById(R.id.et_correo);
            commentary = (EditText) findViewById(R.id.et_comentario);
            send = (Button) findViewById(R.id.btnEnviarComentario);


            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);

                    Properties p = new Properties();
                    // Nombre del host de correo, es smtp.gmail.com
                    p.put("mail.smtp.host", "smtp.gmail.com");
                    p.put("mail.smtp.socketFactory.port", "465");
                    p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                    p.put("mail.smtp.auth", "true");
                    p.put("mail.smtp.port", "465");

                    //Disposición de obtener la instancia de Session:
                    session = Session.getDefaultInstance(p);
                    session.setDebug(true);

                    //Instanciar la clase MimeMessage para pasar el objeto sesion:
                    MimeMessage message = new MimeMessage(session);
                    //Quien envia el e-mail:
                    try {
                        message.setFrom(new InternetAddress(user.getText().toString()));
                        //A quien va dirigido:
                        message.addRecipient(Message.RecipientType.TO, new InternetAddress("jennita@gmail.com"));
                        //Asunto del e-mail:
                        message.setSubject("@string/comentario");
                        //Mensaje o Comentario del e-mail:
                        message.setText(commentary.getText().toString());
                        //Transport.send(message);
                        Transport t = session.getTransport("smtp");
                        t.connect(user.getText().toString(),"la password");
                        //Enviar mensaje del e-mail:
                        t.sendMessage(message,message.getAllRecipients());
                        t.close();
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    }
}
