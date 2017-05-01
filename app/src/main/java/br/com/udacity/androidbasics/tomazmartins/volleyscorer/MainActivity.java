package br.com.udacity.androidbasics.tomazmartins.volleyscorer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static br.com.udacity.androidbasics.tomazmartins.volleyscorer.MainActivity.Sets.SET_1;
import static br.com.udacity.androidbasics.tomazmartins.volleyscorer.MainActivity.Sets.SET_2;
import static br.com.udacity.androidbasics.tomazmartins.volleyscorer.MainActivity.Sets.SET_3;
import static br.com.udacity.androidbasics.tomazmartins.volleyscorer.MainActivity.Sets.SET_4;
import static br.com.udacity.androidbasics.tomazmartins.volleyscorer.MainActivity.Sets.SET_5;


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

    private int qtdSetsOverdueTeamA;
    private int qtdSetsOverdueTeamB;
    private int currentPointsTeamA;
    private int currentPointsTeamB;
    private int acesTeamA;
    private int acesTeamB;

    private TextView[] refMatchPointsTeamA;
    private TextView[] refMatchPointsTeamB;
    private int[] matchPointsTeamA;
    private int[] matchPointsTeamB;

    private Sets currentSet;

    enum Sets {
        SET_1, SET_2, SET_3, SET_4, SET_5;

        public Sets next() {
            Sets next = null;

            switch( this ) {
                case SET_1:
                    next = SET_2;
                    break;
                case SET_2:
                    next = SET_3;
                    break;
                case SET_3:
                    next = SET_4;
                    break;
                case SET_4:
                    next = SET_5;
                    break;
                case SET_5:
                    next = SET_1;
                    break;
            }

            return next;
        }
    }

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        currentSet = SET_1;

        setComponents();

        refMatchPointsTeamA = new TextView[] {
                ref_score_set1_teamA, ref_score_set2_teamA,
                ref_score_set3_teamA, ref_score_set4_teamA,
                ref_score_set5_teamA
        };

        refMatchPointsTeamB = new TextView[] {
                ref_score_set1_teamB, ref_score_set2_teamB,
                ref_score_set3_teamB, ref_score_set4_teamB,
                ref_score_set5_teamB
        };

        matchPointsTeamA = new int[] {0, 0, 0, 0, 0};
        matchPointsTeamB = new int[] {0, 0, 0, 0, 0};
        qtdSetsOverdueTeamA = 0;
        qtdSetsOverdueTeamB = 0;
        currentPointsTeamA = 0;
        currentPointsTeamB = 0;
        acesTeamA = 0;
        acesTeamB = 0;

        setButtons();
        updateGeneralInfo( "Game Begin" );
    }

    private void setButtons() {
        onClickAddPointTeamA();
        onClickAddPointTeamB();
        onClickAddAceTeamA();
        onClickAddAceTeamB();
        onClickResetGame();
    }

    private void onClickAddPointTeamA() {
        btn_addPoint_teamA.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                addPointTo( "Team A" );
            }
        } );
    }

    private void onClickAddPointTeamB() {
        btn_addPoint_teamB.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                addPointTo( "Team B" );
            }
        } );

    }

    private void addPointTo( String nameTeam ) {
        switch( currentSet ) {
            case SET_1:
                addSetPointTo( SET_1, nameTeam );
                break;
            case SET_2:
                addSetPointTo( SET_2, nameTeam );
                break;
            case SET_3:
                addSetPointTo( SET_3, nameTeam );
                break;
            case SET_4:
                addSetPointTo( SET_4, nameTeam );
                break;
            case SET_5:
                addSetPointTo( SET_5, nameTeam );
        }

        checkWinner();
    }

    private void checkWinner() {
        updateGeneralInfo( "Normal Game" );

        boolean ruleToSpecialPoint = (currentPointsTeamA-currentPointsTeamB) >= 1 ||
                (currentPointsTeamB-currentPointsTeamA) >= 1;

        boolean ruleToTriggerSpecialPoint = currentPointsTeamA > 23 || currentPointsTeamB > 23;

        if( ruleToTriggerSpecialPoint && ruleToSpecialPoint ) {
            if( qtdSetsOverdueTeamA == 3 || qtdSetsOverdueTeamB == 3 ) {
                updateGeneralInfo( "Match Point!!" );
            } else {
                updateGeneralInfo( "Set Point!" );
            }
        }

        boolean firstRuleToWin = (currentPointsTeamA >= 25) || (currentPointsTeamB >= 25);

        if( firstRuleToWin ) {
            boolean ruleToWinTeamA = (currentPointsTeamA-currentPointsTeamB) >= 2;
            boolean ruleToWinTeamB = (currentPointsTeamB-currentPointsTeamA) >= 2;

            if( ruleToWinTeamA || ruleToWinTeamB ) {
                if( ruleToWinTeamA ) {
                    ++qtdSetsOverdueTeamA;
                    updateGeneralInfo( "Team A Win this Set" );
                } else {
                    ++qtdSetsOverdueTeamB;
                    updateGeneralInfo( "Team B Win this Set" );
                }

                currentSet = currentSet.next();

                currentPointsTeamA = 0;
                updateScoreTeamA( currentPointsTeamA );

                currentPointsTeamB = 0;
                updateScoreTeamB( currentPointsTeamB );
            }
        }
    }

    private void updateScoreTeamA( int score ) {
        score_teamA.setText( String.valueOf( score ) );
    }

    private void updateScoreTeamB( int score ) {
        score_teamB.setText( String.valueOf( score ) );
    }

    private void updateGeneralInfo( String info ) {
        general_info.setText( info );
    }

    @SuppressLint( "SetTextI18n" )
    private void addSetPointTo( Sets setNumber, String nameTeam ) {
        int set = setNumber.ordinal();

        if( nameTeam.equals( "Team A" ) ) {
            ++matchPointsTeamA[ set ];
            refMatchPointsTeamA[ set ].setText( Integer.toString( matchPointsTeamA[ set ] ) );

            ++currentPointsTeamA;
            updateScoreTeamA( currentPointsTeamA );
        } else if( nameTeam.equals( "Team B" ) ) {
            ++matchPointsTeamB[ set ];
            refMatchPointsTeamB[ set ].setText( Integer.toString( matchPointsTeamB[ set ] ) );

            ++currentPointsTeamB;
            updateScoreTeamB( currentPointsTeamB );
        }
    }

    private void onClickAddAceTeamA() {
        btn_ace_teamA.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                addPointTo( "Team A" );
                addAceTeamA();
            }
        } );
    }

    private void addAceTeamA() {
        ++acesTeamA;
        ref_aces_teamA.setText( String.valueOf( acesTeamA ) );
    }

    private void onClickAddAceTeamB() {
        btn_ace_teamB.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                addPointTo( "Team B" );
                addAceTeamB();
            }
        } );
    }

    private void addAceTeamB() {
        ++acesTeamB;
        ref_aces_teamB.setText( String.valueOf( acesTeamB ) );
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

