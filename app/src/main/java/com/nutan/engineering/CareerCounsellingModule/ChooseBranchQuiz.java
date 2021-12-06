package com.nutan.engineering.CareerCounsellingModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.nutan.engineering.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChooseBranchQuiz extends AppCompatActivity {

    @BindView(R.id.questionCounter_id)
    TextView questionCounter;

    @BindView(R.id.question_id)
    TextView question;

    @BindView(R.id.compBtn_id)
    Button compBtn;

    @BindView(R.id.itBtn_id)
    Button itBtn;

    @BindView(R.id.elecBtn_id)
    Button elecBtn;

    @BindView(R.id.entcBtn_id)
    Button entcBtn;

    @BindView(R.id.civilBtn_id)
    Button civilBtn;

    @BindView(R.id.mechBtn_id)
    Button mechBtn;

    @BindView(R.id.nxtBtn_id)
    Button nxtBtn;

    public int it=0,comp =0,elec=0,entc=0,mech=0,civil=0;
    public int count=1;
    boolean selected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_branch_quiz);


        ButterKnife.bind(this);

        ArrayList<ChooseBranchQuizModal> quiz = new ArrayList<>();
        getQuestions(quiz);
        setQuestion(quiz,count);


        nxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selected == true) {
                    selected = false;
                    count++;
                    setQuestion(quiz, count);
                }
                else
                {
                    Toast.makeText(ChooseBranchQuiz.this,"Choose atleast one option",Toast.LENGTH_LONG).show();
                }
            }
        });




        compBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count==1){comp+= 5; it+= 5;}else if(count==2){comp+= 5; it+= 5; entc+=5; }else if(count==3){comp+= 5; it+= 5;}else if(count==4){comp+= 5; it+= 5;}else if(count==5){comp+= 5; it+= 5;}else if(count==6){comp+= 10; it+= 10;}
                else if(count==7 || count==8 || count==9){comp+=10;}else if(count==10){mech+=5;}else if(count==11){mech+=5;}
                else if(count==12){elec+=5;}else if(count==13){comp+= 5; it+= 5;}else if(count==14){}else if(count==15){comp+= 10; it+= 10;}
                compBtn.setAlpha(0.5F);
                compBtn.setEnabled(false);
                selected = true;

            }
        });

        itBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count==1){elec+=5;}else if(count==2){civil+=5;}else if(count==3){elec+=5;entc+=5;}else if(count==4){elec+=5;entc+=5;mech+=5;}else if(count==5){elec+=5;entc+=5;mech+=5;}else if(count==6){elec+=10;entc+=10;}
                else if(count==7 || count==8 || count==9){it+=10;}else if(count==10){elec+=5;}else if(count==11){civil+=5;}
                else if(count==12){entc+=5;}else if(count==13){elec+=5;}else if(count==14){comp+= 5; it+= 5;}else if(count==15){elec+=10;}
                itBtn.setAlpha(0.5F);
                itBtn.setEnabled(false);
                selected = true;
            }
        });
        elecBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count==1){entc+=5;}else if(count==2){elec+=5; mech+=5;}else if(count==3){civil+=5;}else if(count==4){civil+=5;}else if(count==5){civil+=5;}else if(count==6){civil+=10;}
                else if(count==7 || count==8 || count==9){elec+=10;}else if(count==10){entc+=5;}else if(count==11){elec+=5; entc+=5;}
                else if(count==12){comp+= 5; it+= 5;}else if(count==13){entc+=5;}else if(count==14){elec+=5; entc+=5;}else if(count==15){entc+=10;}
                elecBtn.setAlpha(0.5F);
                elecBtn.setEnabled(false);
                selected = true;
            }
        });
        entcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count==1){civil+=5;mech+=5;}else if(count==2){}else if(count==3){mech+=5;}else if(count==4){}else if(count==5){}else if(count==6){mech+=10;}
                else if(count==7 || count==8 || count==9){entc+=10;}else if(count==10){comp+= 5; it+= 5;}else if(count==11){comp+= 5; it+= 5;}
                else if(count==12){civil+=5;}else if(count==13){civil+=5;}else if(count==14){civil+=5;}else if(count==15){civil+=10;}
                entcBtn.setAlpha(0.5F);
                entcBtn.setEnabled(false);
                selected = true;
            }
        });
        civilBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count==1){}else if(count==2){}else if(count==3){}else if(count==4){}else if(count==5){}else if(count==6){}
                else if(count==7 || count==8 || count==9){civil+=10;}else if(count==10){civil+=5;}else if(count==11){}
                else if(count==12){mech+=5;}else if(count==13){mech+=5;}else if(count==14){mech+=5;}else if(count==15){mech+=10;}
                civilBtn.setAlpha(0.5F);
                civilBtn.setEnabled(false);
                selected = true;
            }
        });
        mechBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count==1){}else if(count==2){}else if(count==3){}else if(count==4){}else if(count==5){}else if(count==6){}
                else if(count==7 || count==8 || count==9){mech+=10;}else if(count==10){}else if(count==11){}
                else if(count==12){}else if(count==13){}else if(count==14){}else if(count==15){}
                mechBtn.setAlpha(0.5F);
                mechBtn.setEnabled(false);
                selected = true;
            }
        });

    }

    private void setQuestion(ArrayList<ChooseBranchQuizModal> quiz, int count) {

        if(count>15)
        {
            Intent intent = new Intent(ChooseBranchQuiz.this,ChooseBranchConclusion.class);
            intent.putExtra("comp", comp);
            intent.putExtra("it", it);
            intent.putExtra("elec", elec);
            intent.putExtra("entc", entc);
            intent.putExtra("civil", civil);
            intent.putExtra("mech", mech);
            startActivity(intent);
            finish();
        }
        else{
            compBtn.setAlpha(1);
            compBtn.setEnabled(true);
            itBtn.setAlpha(1);
            itBtn.setEnabled(true);
            elecBtn.setAlpha(1);
            elecBtn.setEnabled(true);
            entcBtn.setAlpha(1);
            entcBtn.setEnabled(true);
            civilBtn.setAlpha(1);
            civilBtn.setEnabled(true);
            mechBtn.setAlpha(1);
            mechBtn.setEnabled(true);

            compBtn.setVisibility(View.VISIBLE);
            itBtn.setVisibility(View.VISIBLE);
            elecBtn.setVisibility(View.VISIBLE);
            entcBtn.setVisibility(View.VISIBLE);
            civilBtn.setVisibility(View.VISIBLE);
            mechBtn.setVisibility(View.VISIBLE);


            ChooseBranchQuizModal temp = quiz.get(count - 1);
            questionCounter.setText(String.valueOf(count)+"/15");
            question.setText(temp.getQuestion());
            compBtn.setText(temp.getOp1());
            itBtn.setText(temp.getOp2());
            elecBtn.setText(temp.getOp3());
            if (temp.getOp4() != null) {
                entcBtn.setText(temp.getOp4());
            } else {
                entcBtn.setVisibility(View.GONE);
            }
            if (temp.getOp5() != null) {
                civilBtn.setText(temp.getOp5());
            } else {
                civilBtn.setVisibility(View.GONE);
            }
            if (temp.getOp6() != null) {
                mechBtn.setText(temp.getOp6());
            } else {
                mechBtn.setVisibility(View.GONE);
            }
        }
    }

    private void getQuestions(ArrayList<ChooseBranchQuizModal> quiz) {
        quiz.add(new ChooseBranchQuizModal("In your free time, what would you prefer to do ?","Sudoku or Coding Games","Play with Solar or WInd Power Car","Play with Robots","Play with LEGO blocks",null,null));

        quiz.add(new ChooseBranchQuizModal("What kind of person are you","Logical ","Crafty ( making of decorative objects and other things by hand)","Tinkerer ( a person who enjoys fixing and experimenting with machines and their parts)",null,null,null));

        quiz.add(new ChooseBranchQuizModal("What is your most favorite topic among these ?","Computer Science","Physics and Electronics","Drawing","Machines  and Robotics",null,null));

        quiz.add(new ChooseBranchQuizModal("Your ideal workplace would be ?","At desk: In office 5","An industrial plant /In a manufacturing facility","On field on a construction site",null,null,null));

        quiz.add(new ChooseBranchQuizModal("What would you prefer to do in your leisure time ?","Learn new computer language and write a code to make your own customized calculator on PC","Assembling a robot or Flying a Drone","Craft monuments using clay or paper",null,null,null));

        quiz.add(new ChooseBranchQuizModal("Which of these sounds most exciting to you ?", "Creating your own board game with new rules", "Inventing an automobile or phone powered by the Sun","Designing an ultra modern city", "Tuning an automobile engine to get more power",null,null));

        quiz.add(new ChooseBranchQuizModal("Which of the following would be an interesting class for you ?", "Computer architecture - a set of rules and methods that describe the functionality, organization, and implementation of computer systems", "Android Application development class - how to create your own applications for mobile phone", "Power systems - Generation and distribution of electricity", "Image Processing - tools used for applications such as face recognition", "Building technology - learning about the fundamental processes of physics related to buildings and construction ", "Automotive Vehicle Design" ));

        quiz.add(new ChooseBranchQuizModal("In future, you would like to ?", "Build supercomputers", "Practice Ethical Hacking", "Build fast charging stations for Electric vehicles", "Build satellite communication systems", "Design tall buildings and bridges", "Design, manufacture, and maintenance of mechanical devices, such as automobiles, refrigerators, robotics etc.." ));

        quiz.add(new ChooseBranchQuizModal("Which of these projects sounds most exciting to you ?", "An online auction wherein buyers and sellers engage in transactional business and buyers purchase items through online bidding", "Android local train ticketing system - customers can purchase tickets using android app", "Wireless Mobile Charging - Mobile phone quickly gets charged without a physical wire", "Home Automation : Room Light, fans, AC and other Electronic Devices can be operated remotely and intelligently to save power", "Design of Green Buildings - Such buildings in their design, construction or operation, reduces or eliminates negative impacts on environment", "Chainless Bicycle - Chainless provides a far superior experience than any traditional bike" ));

        quiz.add(new ChooseBranchQuizModal("You are a part of a team working on a project called 'Intelligent Refrigerator'. The team is ", "Group working on mechanical aspects such as condenser, compressor, valves, etc", "Group working on electrical wiring and stabilizer (stabilizer has been designed to protect your refrigerator from power cuts or voltage fluctuations", "Group working on Electronics part of a project such as Display Design and door sensors", "Group responsible for design of an android application to monitor the fridge remotely", "I would rather design a home architecture plan wherein Refrigerator occupies least space", null ));

        quiz.add(new ChooseBranchQuizModal("What would you prefer most ?", "Designing and working with machines and mechanical systems in a workshop", "designing buildings and working on-site", "Be a part of team which generate and distribute electricity to rural areas", "Writing a code for a software", null, null));

        quiz.add(new ChooseBranchQuizModal("Which of the following makes you most curious and you want to know science behind it ? ", "How do they generate electricity from renewable energy resources like Sun and Wind", "How can you see a live telecast of a cricket match being played in Australia or How robots like Alexa work", "How do they design complex gaming applications", "How do they construct dams, skyscappers and other defining architectures", "How advanced automobiles are manufactured and what are their different parts", null ));

        quiz.add(new ChooseBranchQuizModal("Which invention would you like to have been involved in ?", "The internet", "Solar Power Plants & The wind turbine", "The cell phone and TV", "Suspension bridge", "Gear Box for achieving a very high speed in a car", null));

        quiz.add(new ChooseBranchQuizModal("You would rather design something that..", "Achieves very high speed computers", "Solves Electricity Needs by Utilizing renewable energy resources effectively", "Improves our cities' infrastructures", "That brings breakthrough in transportation as well as machines used in industries", null, null));

        quiz.add(new ChooseBranchQuizModal("If given opportunity at NASA, you would like to do ?", "Research and design computer systems that measure activity in outer space", "Design solar panels for rockets", "Design instrument panels, flight systems and communication systems", "Finalize the launchpad locations and preparation of rocket launching site", "Create the sensors, tools, engines, or other machines that support space missions",null));
    }
}