package com.scasc.clase09;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private Button btnPlay,btnStop,btnPause,btnResume;
    private RadioButton rb1,rb2,rb3,rb4,rb5,rb6,rb7;
    private int posicion=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ///INICIAR VARIABLES
        btnPlay=(Button) findViewById(R.id.btnPlay);
        btnStop=(Button) findViewById(R.id.btnStop);
        btnPause=(Button) findViewById(R.id.btnPause);
        btnResume=(Button) findViewById(R.id.btnResume);

        rb1=(RadioButton)findViewById(R.id.pista1);
        rb2=(RadioButton)findViewById(R.id.pista2);
        rb3=(RadioButton)findViewById(R.id.pista3);
        rb4=(RadioButton)findViewById(R.id.pista4);
        rb5=(RadioButton)findViewById(R.id.pista5);
        rb6=(RadioButton)findViewById(R.id.pista6);
        rb7=(RadioButton)findViewById(R.id.pista7);

    }

    public void destruir(){
        if(mediaPlayer!=null){
            mediaPlayer.release();
        }
    }

    public void reproducir(View view){
        destruir();
        if(rb1.isChecked())
            mediaPlayer = MediaPlayer.create(this, R.raw.pista1);
        else if(rb2.isChecked())
            mediaPlayer = MediaPlayer.create(this, R.raw.pista2);
        else if(rb3.isChecked())
            mediaPlayer = MediaPlayer.create(this, R.raw.pista3);
        else if(rb4.isChecked())
            mediaPlayer = MediaPlayer.create(this, R.raw.pista4);
        else if(rb5.isChecked())
            mediaPlayer = MediaPlayer.create(this, R.raw.pista5);
        else if(rb6.isChecked()){
            try{
                mediaPlayer=new MediaPlayer();
                mediaPlayer.setDataSource("https://techtransfer.com.py/music/pista06.mp3");
                mediaPlayer.prepare();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        else if(rb7.isChecked()){
            //http://tajysoftware.com/assets/mp3/pista7.mp3
            try{
                mediaPlayer=new MediaPlayer();
                mediaPlayer.setDataSource("https://techtransfer.com.py/music/pista06.mp3");
                mediaPlayer.prepare();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        //Play
        mediaPlayer.start();
    }

    public void pausar(View view){
        if(mediaPlayer!=null && mediaPlayer.isPlaying()){
            posicion=mediaPlayer.getCurrentPosition();
            mediaPlayer.pause();
        }
    }

    public void resumen(View view){
        if(mediaPlayer!=null && !mediaPlayer.isPlaying()){
            mediaPlayer.seekTo(posicion);
            mediaPlayer.start();
        }
    }

    public void stop(View view){
        if(mediaPlayer!=null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            destruir();
        }
    }
}