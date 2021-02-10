package perso.jordan.happyremember;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.*;

public class MainActivity extends AppCompatActivity {

    Button addButton = null;

    EditText namePeople = null;
    EditText dateBirthday = null;

    TextView test = null;

    @SuppressLint("SimpleDateFormat")
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addButton = (Button)findViewById(R.id.addButton);
        namePeople = (EditText)findViewById(R.id.peopleAdded);
        dateBirthday = (EditText)findViewById(R.id.dateAdded);

        test = (TextView)findViewById(R.id.textView);

        addButton.setOnClickListener(addedListener);
    }

    private View.OnClickListener addedListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String nameEntered = namePeople.getText().toString();
            
            if (!nameEntered.isEmpty()) {
                Date dateObject = null;
                String dateBirthdayEdited = (dateBirthday.getText().toString());

                try {
                    dateObject = formatter.parse(dateBirthdayEdited);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                DateTime dateAdded = new DateTime(dateObject);
                People people = new People(namePeople.getText().toString(), dateAdded);
                String haha = people.getName() + people.getBirthday().getDayOfMonth() + "/" + people.getBirthday().getMonthOfYear() + "/" + people.getBirthday().getYear();
                test.setText(haha);
            } else {
                test.setText("putin mais entre un nom, t'es con ou quoi ?!");
            }

        }
    };
}