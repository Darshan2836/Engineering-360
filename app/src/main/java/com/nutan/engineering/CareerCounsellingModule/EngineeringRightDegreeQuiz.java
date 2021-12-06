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
        result.add(new EngineeringRightDegreeQuizResultModal("ʏᴏᴜ ᴇɴᴊᴏʏ ʟᴇᴀʀɴɪɴɢ ᴘʜʏsɪᴄs. ɪɴ ᴇɴɢɪɴᴇᴇɪʀɴɢɴ, ᴛʜᴇ ᴄᴏɴᴄᴇᴘᴛs ʟᴇᴀʀɴᴛ ɪɴ ᴘʜʏsɪᴄs ᴀʀᴇ ᴏꜰᴛᴇɴ ᴇɴxᴛᴇɴᴅᴇᴅ ᴛᴏ sᴏʟᴠᴇ sᴏᴍᴇ ʀᴇᴀʟ ᴛɪᴍᴇ ᴘʀᴏʙʟᴇᴍ. ᴛʜᴜs, ᴋɴᴏᴡʟᴇᴅɢᴇ ᴏꜰ ᴘʜʏsɪᴄs ɪs ᴛʜᴇ ꜰᴏᴜɴᴅᴀᴛɪᴏɴ ꜰᴏʀ ᴇɴɢɪɴᴇᴇʀɪɴɢ. ","ʏᴏᴜʀ ʀᴇsᴘᴏɴsᴇ ɪɴᴅɪᴄᴀᴛᴇs ᴛʜᴀᴛ ʏᴏᴜ ᴅᴏ ɴᴏᴛ ᴍᴜᴄʜ ᴇɴᴊᴏʏ ʟᴇᴀʀɴɪɴɢ ᴘʜʏsɪᴄs. ɴᴏᴛᴇ ᴛʜᴀᴛ ᴋɴᴏᴡʟᴇᴅɢᴇ ᴏꜰ ᴘʜʏsɪᴄs ɪs ᴛʜᴇ ꜰᴏᴜɴᴅᴀᴛɪᴏɴ ꜰᴏʀ ᴇɴɢɪɴᴇᴇʀɪɴɢ. ɪꜰ ʏᴏᴜ ᴅᴏɴ'ᴛ ꜰɪɴᴅ ᴘʜʏsɪᴄs ɪɴᴛᴇʀᴇsᴛɪɴɢ ᴛʜᴇɴ ᴘʀᴏʙᴀʙʟʏ ʏᴏᴜ ᴍᴀʏ ɴᴏᴛ ꜰɪɴᴅ ᴇɴɢɪɴᴇᴇʀɪɴɢ ɪɴᴛᴇʀᴇsᴛɪɴɢ ᴛᴏᴏ!",null));
        result.add(new EngineeringRightDegreeQuizResultModal("ɪᴛ ɪs ɢᴏᴏᴅ ᴛʜᴀᴛ ʏᴏᴜ ʜᴀᴠᴇ ᴀɴ ɪɴᴛᴇʀᴇsᴛ ɪɴ sᴘᴇᴄɪꜰɪᴄ ʙʀᴀɴᴄʜ ᴏꜰ ᴇɴɢɪɴᴇᴇʀɪɴɢ. ᴘᴜʀsᴜᴇ ʏᴏᴜʀ ɪɴᴛᴇʀᴇsᴛ ᴀɴᴅ ᴅᴏ ᴇɴɢɪɴᴇᴇʀɪɴɢ ɪɴ ᴛʜᴇ ʙʀᴀɴᴄʜ ᴏꜰ ʏᴏᴜʀ ɪɴᴛᴇʀᴇsᴛ. ᴅᴏ ɴᴏᴛ ᴄᴏᴍᴘʀᴏᴍɪsᴇ ᴛʜᴇ ʙʀᴀɴᴄʜ ꜰᴏʀ ʜɪɢʜᴇʀ ʀᴀɴᴋᴇᴅ ᴄᴏʟʟᴇɢᴇ.","Try to develop interest in at least one branch of engineering. Know what is beinbg offered to learn in different streams then check which stream makes you more curious. ᴘᴜʀsᴜᴇ ʏᴏᴜʀ ɪɴᴛᴇʀᴇsᴛ ᴀɴᴅ ᴅᴏ ᴇɴɢɪɴᴇᴇʀɪɴɢ ɪɴ ᴛʜᴇ ʙʀᴀɴᴄʜ ᴏꜰ ʏᴏᴜʀ ɪɴᴛᴇʀᴇsᴛ. ᴅᴏ ɴᴏᴛ ᴄᴏᴍᴘʀᴏᴍɪsᴇ ᴛʜᴇ ʙʀᴀɴᴄʜ ꜰᴏʀ ʜɪɢʜᴇʀ ʀᴀɴᴋᴇᴅ ᴄᴏʟʟᴇɢᴇ.",null));
        result.add(new EngineeringRightDegreeQuizResultModal("Engineering is all about solving world problems and make people's life easier. You need to have that problem solving skill and courage to propose and implement new solutions.","Engineering is all about solving world problems and make people's life easier. You need to have that problem solving skill and courage to propose and implement new solutions.",null));
        result.add(new EngineeringRightDegreeQuizResultModal("ꜰɪᴇʟᴅs sᴜᴄʜ ᴀs ᴍᴇᴅɪᴄɪɴᴇ ʀᴇǫᴜɪʀᴇ sᴛʀᴏɴɢ ᴍᴇᴍᴏʀʏ sᴋɪʟʟs. ʜᴏᴡᴇᴠᴇʀ, ᴇɴɢɪɴᴇᴇʀs ɴᴇᴇᴅ ᴛᴏ ʙᴇ ᴄʀᴇᴀᴛɪᴠᴇ. ɪꜰ ʏᴏᴜ ʜᴀᴠᴇ sᴋɪʟʟs ᴛᴏ ꜰɪɴᴅ ᴀɴ ᴜɴɪǫᴜᴇ ᴀɴᴅ ᴇᴀsʏ sᴏʟᴜᴛɪᴏɴ ᴛᴏ ᴘʀᴏʙʟᴇᴍs ꜰᴀᴄᴇᴅ ɪɴ ᴀ ᴅᴀʏ-ᴛᴏ-ᴅᴀʏ ʟɪꜰᴇ, ᴛʜᴇʀᴇ ᴀʀᴇ ʙᴇᴛᴛᴇʀ ᴄʜᴀɴᴄᴇs ᴛʜᴀᴛ ʏᴏᴜ ᴄᴀɴ ʙᴇᴄᴏᴍᴇ ᴀ ɢᴏᴏᴅ ᴇɴɢɪɴᴇᴇʀ.","ꜰɪᴇʟᴅs sᴜᴄʜ ᴀs ᴍᴇᴅɪᴄɪɴᴇ ʀᴇǫᴜɪʀᴇ sᴛʀᴏɴɢ ᴍᴇᴍᴏʀʏ sᴋɪʟʟs. ʜᴏᴡᴇᴠᴇʀ, ᴇɴɢɪɴᴇᴇʀs ɴᴇᴇᴅ ᴛᴏ ʙᴇ ᴄʀᴇᴀᴛɪᴠᴇ. ɪꜰ ʏᴏᴜ ʜᴀᴠᴇ STRONG MEMORY SKILLS YOU MAY RATHER THINK OF PROFESSIONS SUCH AS MEDICINE, Law etc",null));
        result.add(new EngineeringRightDegreeQuizResultModal("Few people get ɪɴꜰʟᴜᴇɴᴄᴇᴅ ʙʏ ᴘᴀʀᴇɴᴛs ᴏʀ ꜰʀɪᴇɴᴅs ᴛᴏ ᴘᴜʀsᴜᴇ ᴇɴɢɪɴᴇᴇʀɪɴɢ. Good to know that you are not one of them. ᴜɴᴅᴇʀsᴛᴀɴᴅ ᴛʜᴀᴛ ᴛʜɪs ɪs ʏᴏᴜʀ ʟɪꜰᴇ. ʏᴏᴜ sʜᴏᴜʟᴅ ᴅᴏ ᴡʜᴀᴛ ʏᴏᴜ ʟɪᴋᴇ. ɪꜰ ʏᴏᴜ ꜰᴀᴄᴇ ᴀɴʏ ᴘʀᴏʙʟᴇᴍ ʟᴀᴛᴇʀ sᴜᴄʜ ᴀs ʟᴀᴄᴋ ᴏꜰ ɪɴᴛᴇʀᴇsᴛ ᴏʀ ʟᴀᴄᴋ ᴏꜰ ᴜɴᴅᴇʀsᴛᴀɴᴅɪɴɢ ɪɴ ʏᴏᴜʀ ᴘʀᴏꜰᴇssɪᴏɴ, ɴᴏ ᴏɴᴇ ᴍᴀʏ ᴄᴏᴍᴇ ᴛᴏ ʏᴏᴜʀ ʀᴇsᴄᴜᴇ. ʏᴏᴜ ᴡɪʟʟ ʙᴇ ᴏɴ ʏᴏᴜʀ ᴏᴡɴ. sᴏ ᴄʜᴏᴏsᴇ ʏᴏᴜʀ ᴘʀᴏꜰᴇssɪᴏɴ ᴡɪsᴇʟʏ!!","ʏᴏᴜʀ ʀᴇsᴘᴏɴsᴇ ɪɴᴅɪᴄᴀᴛᴇs ᴛʜᴀᴛ ʏᴏᴜ ᴀʀᴇ ɢᴇᴛᴛɪɴɢ ɪɴꜰʟᴜᴇɴᴄᴇᴅ ʙʏ ʏᴏᴜʀ ᴘᴀʀᴇɴᴛs ᴏʀ ꜰʀɪᴇɴᴅs ᴛᴏ ᴘᴜʀsᴜᴇ ᴇɴɢɪɴᴇᴇʀɪɴɢ. ᴜɴᴅᴇʀsᴛᴀɴᴅ ᴛʜᴀᴛ ᴛʜɪs ɪs ʏᴏᴜʀ ʟɪꜰᴇ. ʏᴏᴜ sʜᴏᴜʟᴅ ᴅᴏ ᴡʜᴀᴛ ʏᴏᴜ ʟɪᴋᴇ. ɪꜰ ʏᴏᴜ ꜰᴀᴄᴇ ᴀɴʏ ᴘʀᴏʙʟᴇᴍ ʟᴀᴛᴇʀ sᴜᴄʜ ᴀs ʟᴀᴄᴋ ᴏꜰ ɪɴᴛᴇʀᴇsᴛ ᴏʀ ʟᴀᴄᴋ ᴏꜰ ᴜɴᴅᴇʀsᴛᴀɴᴅɪɴɢ ɪɴ ʏᴏᴜʀ ᴘʀᴏꜰᴇssɪᴏɴ, ɴᴏ ᴏɴᴇ ᴍᴀʏ ᴄᴏᴍᴇ ᴛᴏ ʏᴏᴜʀ ʀᴇsᴄᴜᴇ. ʏᴏᴜ ᴡɪʟʟ ʙᴇ ᴏɴ ʏᴏᴜʀ ᴏᴡɴ. sᴏ ᴄʜᴏᴏsᴇ ʏᴏᴜʀ ᴘʀᴏꜰᴇssɪᴏɴ ᴡɪsᴇʟʏ!!","ʏᴏᴜʀ ʀᴇsᴘᴏɴsᴇ ɪɴᴅɪᴄᴀᴛᴇs ᴛʜᴀᴛ ʏᴏᴜ ᴀʀᴇ ɢᴇᴛᴛɪɴɢ ɪɴꜰʟᴜᴇɴᴄᴇᴅ ʙʏ ʏᴏᴜʀ ᴘᴀʀᴇɴᴛs ᴏʀ ꜰʀɪᴇɴᴅs ᴛᴏ ᴘᴜʀsᴜᴇ ᴇɴɢɪɴᴇᴇʀɪɴɢ. ᴜɴᴅᴇʀsᴛᴀɴᴅ ᴛʜᴀᴛ ᴛʜɪs ɪs ʏᴏᴜʀ ʟɪꜰᴇ. ʏᴏᴜ sʜᴏᴜʟᴅ ᴅᴏ ᴡʜᴀᴛ ʏᴏᴜ ʟɪᴋᴇ. ɪꜰ ʏᴏᴜ ꜰᴀᴄᴇ ᴀɴʏ ᴘʀᴏʙʟᴇᴍ ʟᴀᴛᴇʀ sᴜᴄʜ ᴀs ʟᴀᴄᴋ ᴏꜰ ɪɴᴛᴇʀᴇsᴛ ᴏʀ ʟᴀᴄᴋ ᴏꜰ ᴜɴᴅᴇʀsᴛᴀɴᴅɪɴɢ ɪɴ ʏᴏᴜʀ ᴘʀᴏꜰᴇssɪᴏɴ, ɴᴏ ᴏɴᴇ ᴍᴀʏ ᴄᴏᴍᴇ ᴛᴏ ʏᴏᴜʀ ʀᴇsᴄᴜᴇ. ʏᴏᴜ ᴡɪʟʟ ʙᴇ ᴏɴ ʏᴏᴜʀ ᴏᴡɴ. sᴏ ᴄʜᴏᴏsᴇ ʏᴏᴜʀ ᴘʀᴏꜰᴇssɪᴏɴ ᴡɪsᴇʟʏ!!"));
        result.add(new EngineeringRightDegreeQuizResultModal(null,null,null));
        result.add(new EngineeringRightDegreeQuizResultModal(null,null,null));
        result.add(new EngineeringRightDegreeQuizResultModal(null,null,null));
        result.add(new EngineeringRightDegreeQuizResultModal("Your participation in technical events in the past shows your curiosity and interest in Engineering","You need to be part of technical events such as technical projects, quizes, etc to let keep your engineeirng mind working.",null));
    }

    private void setQuestion(ArrayList<EngineeringRightDegreeQuizModal> quiz, int count) {

        if(count>10)
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
        quiz.add(new EngineeringRightDegreeQuizModal("Do you enjoy studying Physics and get fascinated by concepts learned in it ?","Yes","No",null));
        quiz.add(new EngineeringRightDegreeQuizModal("Do you have interest in at least one branch of Engineering such as computers, electronics, civil, mechanical, aeronautics, robotics, etc.?  ","Yes","No",null));
        quiz.add(new EngineeringRightDegreeQuizModal("How often you think of some unique and easy solution to the problems you observe in a day to day to life?","Yes","No",null));
        quiz.add(new EngineeringRightDegreeQuizModal("What is more important to you?","Creativity","Memory",null));
        quiz.add(new EngineeringRightDegreeQuizModal("What is motivation behind doing Engineering","Engineering is my passion and pursuing it is my own choice?","I am influenced by my parents or relatives to pursue Engineering","I decided to do Engineering because it is a trend and all my close friends are doing it"));
        quiz.add(new EngineeringRightDegreeQuizModal("In Studies, do you often Prefer?","Understand the concept","Memorize the solution",null));
        quiz.add(new EngineeringRightDegreeQuizModal("Does advancements in areas such as Automobiles (Cars), Robotics , Gadgets makes you feel that you should also contribute in these fields?","Yes","No",null));
        quiz.add(new EngineeringRightDegreeQuizModal("Where do you prefer yourself working in stable phase of your career?","In areas such as Automobile, Electronics, Manufacturing , Civil or Software Industry","Civil Services such as IASA,IPS","Medicine Field (Doctor, Physician)"));
        quiz.add(new EngineeringRightDegreeQuizModal("Have you participated in any technical event or competition (eg: coding challege, Robotics, etc) in the past?","Yes","No",null));
    }
}