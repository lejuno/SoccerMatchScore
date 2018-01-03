package com.example.android.soccermatchscore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int MAX_SUBSTITUTION_PER_TEAM = 3;
    // Global Variables
    private int iTeamHomeScore;
    private int iTeamAwayScore;
    private int iTeamHomeSubstitution;
    private int iTeamAwaySubstitution;
    private TextView tvHomeScore;
    private TextView tvAwayScore;
    private TextView tvHomeSubstitution;
    private TextView tvAwaySubstitution;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        tvHomeScore = (TextView) findViewById(R.id.tv_team_home_score);
        tvAwayScore = (TextView) findViewById(R.id.tv_team_away_score);
        tvHomeSubstitution = (TextView) findViewById(R.id.tv_team_home_substitution);
        tvAwaySubstitution = (TextView) findViewById(R.id.tv_team_away_substitution);
        // Initialize score values
        RestartMatch();
    }

    private void updateScoreByTextView(TextView tv, int score) {
        tv.setText("" + score);
    }

    private void updatSubstitutionByTextView(TextView tv, int score) {
        tv.setText("" + score + "/" + MAX_SUBSTITUTION_PER_TEAM);
    }
    public void scoreTeamHome(View v) {
        iTeamHomeScore++;
        updateScoreByTextView(tvHomeScore, iTeamHomeScore);
    }

    public void scoreTeamAway(View v) {
        iTeamAwayScore++;
        updateScoreByTextView(tvAwayScore, iTeamAwayScore);
    }

    public void RestartMatch(View v){
        RestartMatch();
    }

    private void RestartMatch() {
        iTeamHomeScore = 0;
        iTeamAwayScore = 0;
        iTeamHomeSubstitution = MAX_SUBSTITUTION_PER_TEAM;
        iTeamAwaySubstitution = MAX_SUBSTITUTION_PER_TEAM;
        updateScoreByTextView(tvHomeScore, iTeamHomeScore);
        updateScoreByTextView(tvAwayScore, iTeamAwayScore);
        updatSubstitutionByTextView(tvHomeSubstitution, iTeamHomeSubstitution);
        updatSubstitutionByTextView(tvAwaySubstitution, iTeamAwaySubstitution);
    }

    public void teamHomeSubstitution(View v){
        iTeamHomeSubstitution--;
        if (iTeamHomeSubstitution <= 0) {
            iTeamHomeSubstitution = 0;
        }
        updatSubstitutionByTextView(tvHomeSubstitution,iTeamHomeSubstitution);
    }

    public void teamAwaySubstitution(View v){
        iTeamAwaySubstitution--;
        if (iTeamAwaySubstitution <= 0) {
            iTeamAwaySubstitution = 0;
        }
        updatSubstitutionByTextView(tvAwaySubstitution,iTeamAwaySubstitution);
    }
}
