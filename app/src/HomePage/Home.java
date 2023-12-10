import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Find views
        TextView profileLink = findViewById(R.id.profileLink);
        Button buttonPage1 = findViewById(R.id.buttonPage1);
        Button buttonPage2 = findViewById(R.id.buttonPage2);

        // Set click listeners
        profileLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the profile page
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
        });

        buttonPage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Page 1
                startActivity(new Intent(MainActivity.this, Page1Activity.class));
            }
        });

        buttonPage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Page 2
                startActivity(new Intent(MainActivity.this, Page2Activity.class));
            }
        });

        // Add click listeners for other buttons as needed
    }
}