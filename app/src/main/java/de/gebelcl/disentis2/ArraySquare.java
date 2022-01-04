package de.gebelcl.disentis2;

import android.util.Log;
import android.view.View;

public class ArraySquare {
    private boolean[][] imageStates;

    public ArraySquare() {
        imageStates = new boolean[][]{
                {true, true, true, true, true},
                {true, true, true, true, true},
                {true, true, true, true, true},
                {true, true, true, true, true},
                {true, true, true, true, true}
        };
    }

    public boolean[][] getImageStates() {
        return imageStates;
    }

    public void setImageStates(boolean[][] imageStates) {
        this.imageStates = imageStates;
    }

    public boolean getImageState(int x, int y) {
        return imageStates[x][y];
    }

    public void changeArraySquare(int x, int y) {
        // First Line
         if (y > 0 && x == 0) {
            imageStates[x][y-1] = !imageStates[x][y-1];
             imageStates[x+1][y-1] = !imageStates[x+1][y-1];
        } else if (y > 0 && x == 4) {
             imageStates[x-1][y-1] = !imageStates[x-1][y-1];
             imageStates[x][y-1] = !imageStates[x][y-1];
         } else if (y > 0){
             imageStates[x-1][y-1] = !imageStates[x-1][y-1];
             imageStates[x][y-1] = !imageStates[x][y-1];
             imageStates[x+1][y-1] = !imageStates[x+1][y-1];
         }

        // Second Line
        if (x == 0) {
            imageStates[x+1][y] =  !imageStates[x+1][y];
        } else if (x == 4) {
            imageStates[x-1][y] = !imageStates[x-1][y];
        } else {
            imageStates[x-1][y] = !imageStates[x-1][y];
            imageStates[x+1][y] = !imageStates[x+1][y];
        }

        //Third Line
        if (y < 4 && x == 0) {
            imageStates[x][y+1] = !imageStates[x][y+1];
            imageStates[x+1][y+1] = !imageStates[x+1][y+1];
        } else if (y < 4 && x == 4) {
            imageStates[x-1][y+1] = !imageStates[x-1][y+1];
            imageStates[x][y+1] = !imageStates[x][y+1];
        } else if (y < 4 && x < 4) {
            imageStates[x-1][y+1] = !imageStates[x-1][y+1];
            imageStates[x][y+1] = !imageStates[x][y+1];
            imageStates[x+1][y+1] = !imageStates[x+1][y+1];
        }
    }

    public int getXTag(View tag) {
        return Integer.parseInt(tag.getTag().toString().substring(0,2));
    }

    public int getYTag(View tag) {
        return Integer.parseInt(tag.getTag().toString().substring(2,4));
    }
}
