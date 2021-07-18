package sanskar.kumar.kumarsanskar.texttospeechapp;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText enterText;
    Button listenInEnglish;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterText = (EditText) findViewById(R.id.editText);
        listenInEnglish = (Button) findViewById(R.id.button);
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                textToSpeech.setLanguage(Locale.ENGLISH);// used to set the Language
                textToSpeech.setSpeechRate(1.0f); // the value of speech Rate is always given in Float
            }
        });
        listenInEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = enterText.getText().toString();
                textToSpeech.speak(inputText, TextToSpeech.QUEUE_FLUSH, null); // QUEUE_FLUSH makes sure that no pevious data is stored
            }
        });
    }
}