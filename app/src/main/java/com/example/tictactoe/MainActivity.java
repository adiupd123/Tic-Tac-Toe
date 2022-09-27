package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Which Player will tap ?
    // 0 - O
    //1 - X

    int activePlayer=1;

    //Which cell contains 'x' , 'o' and which is empty?
    // 0 - O
    //1 - X
    //2 - Empty

    int CellState[]={2,2,2,
                     2,2,2,
                     2,2,2};

    int winPos[][]={{0,1,2},{3,4,5},{6,7,8},
                    {0,3,6},{1,4,7},{2,5,8},
                    {0,4,8},{2,4,6}};
    //boolean gameActive=true;
    int winner=-1;
    public void playerTap(View view)
    {
        ImageView img=(ImageView)view;
        int tappedImage=Integer.parseInt(img.getTag().toString());
        if(winner==0 || winner==1)
            gameClear(view);
        if(CellState[tappedImage]==2 && winner==-1)
        {
            img.setTranslationY(-1000f);
            CellState[tappedImage]=activePlayer;
            TextView status=findViewById(R.id.status);
            if(activePlayer==1)
            {
                img.setImageResource(R.drawable.x);
                activePlayer=0;
                status.setText("Turn for O - Tap to Play.");
            }
            else
            {
                img.setImageResource(R.drawable.o);
                activePlayer=1;
                status.setText("Turn for X - Tap to Play.");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        winner=-1;
        for(int i = 0; i<8; i++)
        {
            if (CellState[winPos[i][0]] == CellState[winPos[i][1]] && CellState[winPos[i][1]] == CellState[winPos[i][2]] && CellState[winPos[i][0]]!=2)
            {
                winner = CellState[winPos[i][0]];
                //gameActive=false;
                break;
            }
        }
        TextView status=(TextView)findViewById(R.id.status);
        if(winner==0)
            status.setText("O has Won");
        else if(winner==1)
                status.setText("X has Won");
        else if(winner==2)
        {

        }
    }

    public void gameClear(View view)
    {
        //gameActive=true;
        activePlayer=1;
        for(int i=0;i<9;i++)
            CellState[i] = 2;
        ((ImageView)findViewById(R.id.ImageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.ImageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.ImageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.ImageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.ImageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.ImageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.ImageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.ImageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.ImageView9)).setImageResource(0);

        TextView status=findViewById(R.id.status);
        status.setText("Turn for X - Tap to Play.");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}