package de.gebelcl.disentis2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private GridLayout gridLayout;
    private ImageView[][] images;

    ArraySquare square = new ArraySquare();

    public void onImageViewClicked(View view) {
        ImageView imageView = (ImageView) view;

        // if square is hidden with a tile then react, else do nothing
        if (square.getImageState(square.getXTag(view), square.getYTag(view))) {
            square.changeArraySquare(square.getXTag(view), square.getYTag(view));
            for (int y = 0; y < 5; y++) {
                for (int x = 0; x < 5; x++) {
                    if (square.getImageState(x, y))
                        images[x][y].setAlpha(1.0f);
                    else
                        images[x][y].setAlpha(0.0f);
                }
            }

            // if every tile is hidden, then show the text "Herzlichen Glückwunsch, Sie haben gewonnen!"
            boolean won = true;
            int counter = 0;
            for (boolean[] is : square.getImageStates()) {
                for (boolean is2 : is) {
                    if (is2 == false) {
                        counter++;
                        Log.i("ABC", String.valueOf(counter));
                    }
                }
            }
            // if all tiles except a single one are invisible then the player has won
            if (counter == 24) {
                textView.setVisibility(View.VISIBLE);
                textView.setText("Herzlichen Glückwunsch, Sie haben gewonnen!");
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        gridLayout = findViewById(R.id.gridLayout);
        images = new ImageView[5][5];

        // Read all images from GridLayout
        int counter = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                images[j][i] = (ImageView) gridLayout.getChildAt(counter);
                counter++;
            }
        }
    }
}