package br.com.udacity.androidbasics.tomazmartins.volleyscorer;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView ref_score_set1_teamA;
    private TextView ref_score_set2_teamA;
    private TextView ref_score_set3_teamA;
    private TextView ref_score_set4_teamA;
    private TextView ref_score_set5_teamA;
    private TextView ref_aces_teamA;

    private TextView ref_score_set1_teamB;
    private TextView ref_score_set2_teamB;
    private TextView ref_score_set3_teamB;
    private TextView ref_score_set4_teamB;
    private TextView ref_score_set5_teamB;
    private TextView ref_aces_teamB;

    private TextView general_info;

    private ImageView ball_possession_teamA;
    private ImageView ball_possession_teamB;

    private TextView score_teamA;
    private TextView score_teamB;

    private AppCompatButton btn_addPoint_teamA;
    private AppCompatButton btn_addPoint_teamB;
    private AppCompatButton btn_reset_match;
    private AppCompatButton btn_ace_teamA;
    private AppCompatButton btn_ace_teamB;

    private int aces_teamA;
    private int aces_teamB;
    private int points_teamA;
    private int points_teamB;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        points_teamA = 0;
        points_teamB = 0;
        aces_teamA = 0;
        aces_teamB = 0;

        setComponents();
        setButtons();
    }

    private void setButtons() {
        onClickAddPointTeamA();
        onClickAddPointTeamB();
        onClickAddAceTeamA();
        onClickAddAceTeamB();
        onClickResetGame();
    }

    private void onClickAddPointTeamA() {

    }

    private void onClickAddPointTeamB() {

    }

    private void onClickAddAceTeamA() {
        btn_ace_teamA.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                addAceTeamA();
            }
        } );
    }

    private void addAceTeamA() {
        ++aces_teamA;
        ref_aces_teamA.setText( String.valueOf( aces_teamA ) );
    }

    private void onClickAddAceTeamB() {
        btn_ace_teamB.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                addAceTeamB();
            }
        } );
    }

    private void addAceTeamB() {
        ++aces_teamB;
        ref_aces_teamB.setText( String.valueOf( aces_teamB ) );
    }

    private void onClickResetGame() {
        btn_reset_match.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                resetGame();
            }
        } );
    }

    private void resetGame() {
        resetSetPoints();
        resetMatchPoints();
    }

    private void resetMatchPoints() {
        ref_score_set1_teamA.setText( String.valueOf( 0 ) );
        ref_score_set2_teamA.setText( String.valueOf( 0 ) );
        ref_score_set3_teamA.setText( String.valueOf( 0 ) );
        ref_score_set4_teamA.setText( String.valueOf( 0 ) );
        ref_score_set5_teamA.setText( String.valueOf( 0 ) );
        ref_aces_teamA.setText( String.valueOf( 0 ) );

        ref_score_set1_teamB.setText( String.valueOf( 0 ) );
        ref_score_set2_teamB.setText( String.valueOf( 0 ) );
        ref_score_set3_teamB.setText( String.valueOf( 0 ) );
        ref_score_set4_teamB.setText( String.valueOf( 0 ) );
        ref_score_set5_teamB.setText( String.valueOf( 0 ) );
        ref_aces_teamB.setText( String.valueOf( 0 ) );
    }

    private void resetSetPoints() {
        score_teamA.setText( String.valueOf( 0 ) );
        score_teamB.setText( String.valueOf( 0 ) );
    }


    @SuppressLint( "WrongViewCast" )
    private void setComponents() {
        ref_score_set1_teamA = (TextView) findViewById( R.id.ref_score_set1_teamA );
        ref_score_set2_teamA = (TextView) findViewById( R.id.ref_score_set2_teamA );
        ref_score_set3_teamA = (TextView) findViewById( R.id.ref_score_set3_teamA );
        ref_score_set4_teamA = (TextView) findViewById( R.id.ref_score_set4_teamA );
        ref_score_set5_teamA = (TextView) findViewById( R.id.ref_score_set5_teamA );
        ref_aces_teamA = (TextView) findViewById( R.id.ref_aces_teamA );

        ref_score_set1_teamB = (TextView) findViewById( R.id.ref_score_set1_teamB );
        ref_score_set2_teamB = (TextView) findViewById( R.id.ref_score_set2_teamB );
        ref_score_set3_teamB = (TextView) findViewById( R.id.ref_score_set3_teamB );
        ref_score_set4_teamB = (TextView) findViewById( R.id.ref_score_set4_teamB );
        ref_score_set5_teamB = (TextView) findViewById( R.id.ref_score_set5_teamB );
        ref_aces_teamB = (TextView) findViewById( R.id.ref_aces_teamB );

        general_info = (TextView) findViewById( R.id.general_info );

        ball_possession_teamA = (ImageView) findViewById( R.id.ball_possession_teamA );
        ball_possession_teamB = (ImageView) findViewById( R.id.ball_possession_teamB );

        score_teamA = (TextView) findViewById( R.id.score_teamA );
        score_teamB = (TextView) findViewById( R.id.score_teamB );

        btn_addPoint_teamA = (AppCompatButton) findViewById( R.id.btn_addPoint_teamA );
        btn_addPoint_teamB = (AppCompatButton) findViewById( R.id.btn_addPoint_teamB );
        btn_ace_teamA = (AppCompatButton) findViewById( R.id.btn_ace_teamA );
        btn_ace_teamB = (AppCompatButton) findViewById( R.id.btn_ace_teamB );
        btn_reset_match = (AppCompatButton) findViewById( R.id.btn_reset_match );
    }
}

