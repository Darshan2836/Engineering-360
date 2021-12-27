package com.nutan.engineering.addCollege;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nutan.engineering.CareerCounsellingModule.ChooseBranchQuizModal;
import com.nutan.engineering.CareerCounsellingModule.EngineeringRightDegreeConculsion;
import com.nutan.engineering.CareerCounsellingModule.EngineeringRightDegreeQuiz;
import com.nutan.engineering.CareerCounsellingModule.EngineeringRightDegreeQuizModal;
import com.nutan.engineering.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddCollegeQuiz extends AppCompatActivity {

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

    @BindView(R.id.opt4_id)
    Button opt4;

    @BindView(R.id.opt5_id)
    Button opt5;

    public int count =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_college_quiz);


        ButterKnife.bind(this);

        ArrayList<AddCollegeModalClass> quiz = new ArrayList<>();
        getQuestions(quiz);
        setQuestion(quiz,count);


        opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count++;
                setQuestion(quiz,count);
            }
        });
        opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count++;
                setQuestion(quiz,count);
            }
        });
        opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count++;
                setQuestion(quiz,count);
            }
        });
        opt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count++;
                setQuestion(quiz,count);
            }
        });
        opt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count++;
                setQuestion(quiz,count);
            }
        });
    }

    private void setQuestion(ArrayList<AddCollegeModalClass> quiz, int count) {

        if(count>quiz.size())
        {
            Intent intent = new Intent(AddCollegeQuiz.this, AddCollegeConclusion.class);
            startActivity(intent);
            finish();
        }
        else
        {
            opt1.setVisibility(View.VISIBLE);
            opt2.setVisibility(View.VISIBLE);
            opt3.setVisibility(View.VISIBLE);
            opt4.setVisibility(View.VISIBLE);
            opt5.setVisibility(View.VISIBLE);

            AddCollegeModalClass temp = quiz.get(count - 1);
            questionCounter.setText(String.valueOf(count)+"/18");
            question.setText(temp.getQuestion());
            opt1.setText(temp.getOp1());
            opt2.setText(temp.getOp2());
            if (temp.getOp3() != null) {
                opt3.setText(temp.getOp3());
            } else {
                opt3.setVisibility(View.GONE);
            }
            if (temp.getOp4() != null) {
                opt4.setText(temp.getOp4());
            } else {
                opt4.setVisibility(View.GONE);
            }
            if (temp.getOp5() != null) {
                opt5.setText(temp.getOp5());
            } else {
                opt5.setVisibility(View.GONE);
            }

        }
    }

    private void getQuestions(ArrayList<AddCollegeModalClass> quiz) {

        quiz.add(new AddCollegeModalClass("WHAT PERCENTAGE OF ELIGIBLE STUDENTS ARE PLACED IN INDUSTRIES FROM ENTC DEPARTMENT","Less than 10%","10%-25%","25%-50%","50%-75%","More than 75%"));
        quiz.add(new AddCollegeModalClass("WHAT PERCENTAGE OF STUDENTS ARE PLACED IN CORE COMPANIES","LESS THAN 10%", "10% TO 25%", "25% TO 50%", "50% TO 75%", "MORE THAN 75%" ));
        quiz.add(new AddCollegeModalClass("WHAT PERCENTAGE OF STUDENTS GOT PACKAGE OF MORE THAN 5LPA","LESS THAN 10%", "10% TO 25%", "25% TO 50%", "50% TO 75%", "MORE THAN 75%"));
        quiz.add(new AddCollegeModalClass("DO YOU HAVE HIGHER EDUCATION CELL WHICH PROVIDES TRAINING FOR ENTRANCE EXAM AND HIGHER EDUCATION", "YES","NO",null,null,null));
        quiz.add(new AddCollegeModalClass("DO YOU HAVE INDUSTRIAL PROJECTS FOR UNDERGRADUATE STUDENTS","YES","NO",null,null,null));
        quiz.add(new AddCollegeModalClass("CAN I GET SUMMER INTERNSHIP SUPPORT THROUGH DEPT","YES","NO",null,null,null));
        quiz.add(new AddCollegeModalClass("DO YOU HAVE DIGITAL OSCILLOSCOPES IN LABORATORY","YES","NO",null,null,null));
        quiz.add(new AddCollegeModalClass("DO YOU HAVE DSP AND MICROCONTROLLER KITS IN LAB","YES","NO",null,null,null));
        quiz.add(new AddCollegeModalClass("HOW MANY PHD FACULTIES ARE THERE IN YOUR DEPT","NONE","1-2","3-4",">=5",null));
        quiz.add(new AddCollegeModalClass("DO YOU HAVE TECHNICAL CLUBS","YES","NO",null,null,null));
        quiz.add(new AddCollegeModalClass("DO YOU PROVIDE IN HOUSE TRAINING FOR FOREIGN LANGUAGES","YES","NO",null,null,null));
        quiz.add(new AddCollegeModalClass("DO YOUR HAVE ANY FACULTY WORKING ON FUNDED OR INSDUSTRY SPONSERED PROJECTS SO THAT I CAN GET THE CHANCE TO WORK ON RELEVANT PROJECTS","YES","NO",null,null,null));
        quiz.add(new AddCollegeModalClass("DO YOU HAVE ANY RESEARCH CENTER IN THE DEPARTMENT DEDICATED TO SOME SPECIFIC AREA","YES","NO",null,null,null));
        quiz.add(new AddCollegeModalClass("IN ALL HOW MANY POST GRAD AND PHD STUDENTS YOU HAVE IN YOUR DEPT","NONE","1-2","3-4",">=5",null));
        quiz.add(new AddCollegeModalClass("HOW MANY SCIENTIFIC JOURNAL PAPERS ARE PRODUCED BY THE DEPARTMENT LAST YEAR","NONE","1-2","3-4",">=5",null));
        quiz.add(new AddCollegeModalClass("HAS THE DEPARTMENT SUBMITTED ANY PATENTS OR COPYRIGHT APPLICATIONS LAST YEAR","NO","YES, BUT JUST 1 OR 2","YES, ATLEAST 3 OR MORE",null,null));
        quiz.add(new AddCollegeModalClass("DO YOU HAVE ANY LAB IN THE DEPARTMENT WHICH IS SET UP AND FUNDED BY THE COMPANY","YES","NO",null,null,null));
        quiz.add(new AddCollegeModalClass("DO YOU PROVIDE ANY COURSES SUCH AS VLSI, PROGRAMMABLE LOGIC CONTROLLERS, ETC TO IMPROVE STUDENTS EMPLOYABILITY","YES","NO",null,null,null));
        }
}