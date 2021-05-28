package com.codecademy.fatosesquecidosapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificacaoBoatos();
        }


    public void irFatos(View v) {
        Intent irAosFatos = new Intent(this, Fatos.class);
        startActivity(irAosFatos);
    }

    public void irBoatos(View v) {
        Intent irAosBoatos = new Intent(this, Boatos.class);
        startActivity(irAosBoatos);
    }

    private String CHANNEL_ID = "not_boatos";

    private void notificacaoBoatos() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Novo boato";
            String description = "O total de Boatos";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager =
                    getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    public static int notificacaoId = 1;
    public void notificationAction(View v) {
        int boatos = Boatos.contarTotal;
        if (Boatos.contarTotal>=2){
            boatos = Boatos.contarTotal-2;
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Total de boatos")
                .setContentText("Por enquanto temos o total de "+boatos+" boatos")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(notificacaoId, builder.build());
    }

    public void pesquisaFatos(View v){
        startActivity(new Intent(this, RecycleFatosActivity.class));
    }
    public void zararNot(View v){
        Boatos.contarTotal = 2;
        Toast.makeText(this, "Notificações dos Boatos zerada.", Toast.LENGTH_SHORT).show();
    }

}