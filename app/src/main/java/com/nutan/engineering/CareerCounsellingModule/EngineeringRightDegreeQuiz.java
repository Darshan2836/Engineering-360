package com.nutan.engineering.CareerCounsellingModule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nutan.engineering.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EngineeringRightDegreeQuiz extends AppCompatActivity {


    @BindView(R.id.questionCounter_id)
    TextView questionCounter;

    @BindView(R.id.question_id)
    TextView question;

    @BindView(R.id.opt1_id)
    Button opt1;

    @BindView(R.id.opt2_id)
    Button opt2;

    @BindView(R.id.opt3_id)
    Button opt3;

    public ArrayList<String> finalResult = new ArrayList<>();
    public int count =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engineering_right_degree_quiz);

        ButterKnife.bind(this);

        ArrayList<EngineeringRightDegreeQuizModal> quiz = new ArrayList<>();
        ArrayList<EngineeringRightDegreeQuizResultModal> result = new ArrayList<>();
        getQuestions(quiz);
        getResults(result);
        setQuestion(quiz,count);

        opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finalResult.add(result.get(count-1).getAns1());
                count++;
                setQuestion(quiz,count);
            }
        });

        opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalResult.add(result.get(count-1).getAns2());
                count++;
                setQuestion(quiz,count);
            }
        });

        opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalResult.add(result.get(count-1).getAns3());
                count++;
                setQuestion(quiz,count);
            }
        });

    }

    private void getResults(ArrayList<EngineeringRightDegreeQuizResultModal> result) {

        result.add(new EngineeringRightDegreeQuizResultModal("ʏᴏᴜ ʟɪᴋᴇ ᴍᴀᴛʜᴇᴍᴀᴛɪᴄs ᴀɴᴅ ᴄᴏʀᴇ ᴇɴɢɪɴᴇᴇʀɪɴɢ ᴡᴏʀᴋ ɪɴᴠᴏʟᴠᴇs ᴀ ʟᴏᴛ ᴏꜰ ᴄᴀʟᴄᴜʟᴀᴛɪᴏɴs. ɪꜰ ʏᴏᴜ ᴀʀᴇ ᴄᴏᴍꜰᴏʀᴛᴀʙʟᴇ ᴡɪᴛʜ sᴏʟᴠɪɴɢ ᴄᴏᴍᴘʟᴇx ᴍᴀᴛʜᴇᴍᴀᴛɪᴄᴀʟ ᴘʀᴏʙʟᴇᴍs, ʏᴏᴜ ʜᴀᴠᴇ ᴀɴ ᴀᴅᴅᴇᴅ ᴀᴅᴠᴀɴᴛᴀɢᴇ","ʏᴏᴜ ᴍᴇɴᴛɪᴏɴᴇᴅ ʏᴏᴜ ᴅᴏɴ'ᴛ ʟɪᴋᴇ ᴍᴀᴛʜᴇᴍᴀᴛɪᴄs. ʀᴇᴍᴇᴍʙᴇʀ ᴛʜᴀᴛ ᴄᴏʀᴇ ᴇɴɢɪɴᴇᴇʀɪɴɢ ᴡᴏʀᴋ ɪɴᴠᴏʟᴠᴇs ʟᴏᴛ ᴏꜰ ᴄᴀʟᴄᴜʟᴀᴛɪᴏɴs. ᴛʜᴜs, ʏᴏᴜ ɴᴇᴇᴅ ᴛᴏ ʙᴇ ᴄᴏᴍꜰᴏʀᴛᴀʙʟᴇ ᴡɪᴛʜ sᴏʟᴠɪɴɢ ᴍᴀᴛʜᴇᴍᴀᴛɪᴄᴀʟ ᴘʀᴏʙʟᴇᴍs ᴡʜᴇɴᴇᴠᴇʀ ɴᴇᴄᴇssᴀʀʏ.",null));

    }

    private void setQuestion(ArrayList<EngineeringRightDegreeQuizModal> quiz, int count) {

        if(count>1)
        {
            Intent intent = new Intent(EngineeringRightDegreeQuiz.this,EngineeringRightDegreeConculsion.class);
            intent.putExtra("result", finalResult);
            startActivity(intent);
            finish();
        }
        else
        {
            opt1.setVisibility(View.VISIBLE);
            opt2.setVisibility(View.VISIBLE);
            opt3.setVisibility(View.VISIBLE);

            EngineeringRightDegreeQuizModal temp = quiz.get(count - 1);
            questionCounter.setText(String.valueOf(count)+"/10");
            question.setText(temp.getQuestion());
            opt1.setText(temp.getOp1());
            opt2.setText(temp.getOp2());
            if (temp.getOp3() != null) {
                opt3.setText(temp.getOp3());
            } else {
                opt3.setVisibility(View.GONE);
            }

        }
    }

    private void getQuestions(ArrayList<EngineeringRightDegreeQuizModal> quiz) {

        quiz.add(new EngineeringRightDegreeQuizModal("Do you like Mathematics ?","Yes","No",null));
    }
}