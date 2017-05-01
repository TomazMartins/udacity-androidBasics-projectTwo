package br.com.udacity.androidbasics.tomazmartins.volleyscorer;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.widget.ImageView;
import android.widget.TextView;

import static android.R.attr.onClick;

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

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
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

    }

    private void onClickAddAceTeamB() {

    }

    private void onClickResetGame() {

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
