package edu.washington.maxoneal.quizdroid;

import java.util.ArrayList;


public class QuizAppSingleton implements TopicRepository {
    public ArrayList<Topic> topics;
    private static QuizAppSingleton instance;
    public String customVar;

    private QuizAppSingleton() { }
    public void customSingletonMethod() { }

    public static void initInstance() {
        if (instance == null) {
            instance = new QuizAppSingleton();
        }
    }

    public static QuizAppSingleton getInstance() {
        return instance;
    }

    public ArrayList<Topic> getElements() {
        topics = new ArrayList<>();

        Topic m = new Topic();
        Topic p = new Topic();
        Topic msh = new Topic();

        Quiz m1 = new Quiz();
        Quiz m2 = new Quiz();
        Quiz m3 = new Quiz();

        Quiz p1 = new Quiz();
        Quiz p2 = new Quiz();
        Quiz p3 = new Quiz();

        Quiz msh1 = new Quiz();
        Quiz msh2 = new Quiz();
        Quiz msh3 = new Quiz();


        m.setTitle("Math");
        m.setShortDesc("This is a quiz on mathematics.");
        m.setLongDesc("This is a quiz on mathematics, the study of the measurement," +
                " relationships, and properties of quantities and sets, using numbers" +
                " and symbols.");

        m1.setQuestion("What are the first three digits of pi?");
        m2.setQuestion("What does 0-0 equal");
        m3.setQuestion("What is 4x4?");

        m1.setAns1("Raspberry");
        m1.setAns2("3.41");
        m1.setAns3("3.14");
        m1.setAns4("3.15");
        m1.setIndexOfCorrect(3);

        m2.setAns1("-1");
        m2.setAns2("Castle Kingside");
        m2.setAns3("0");
        m2.setAns4("1");
        m2.setIndexOfCorrect(3);

        m3.setAns1("Another name for an SUV");
        m3.setAns2("16");
        m3.setAns3("12");
        m3.setAns4("44");
        m3.setIndexOfCorrect(2);

        ArrayList<Quiz> mathQs = new ArrayList<>();
        mathQs.add(m1);
        mathQs.add(m2);
        mathQs.add(m3);
        m.setQuestions(mathQs);


        p.setTitle("Physics");
        p.setShortDesc("This is a quiz on physics.");
        p.setLongDesc("This is a quiz on physics, the science that deals with matter, " +
                "energy, motion, and force.");

        p1.setQuestion("An airplane accelerates down a runway at 3.20 m/s2 for 32.8 s until it" +
                " finally lifts off the ground. The distance traveled before takeoff is: ");
        p2.setQuestion("A feather is dropped on the moon from a height of 1.40 meters. The" +
                " acceleration of gravity on the moon is 1.67 m/s2. The time for the feather to" +
                " fall to the surface of the moon is: ");
        p3.setQuestion("A kangaroo is capable of jumping to a height of 2.62 m. The takeoff speed" +
                " of the kangaroo is: ");

        p1.setAns1("1720 meters");
        p1.setAns2("1620 meters");
        p1.setAns3("1910 meters");
        p1.setAns4("1750 meters");
        p1.setIndexOfCorrect(1);

        p2.setAns1("2.02 seconds");
        p2.setAns2("1.29 seconds");
        p2.setAns3("1.31 seconds");
        p2.setAns4("1.07 seconds");
        p2.setIndexOfCorrect(2);

        p3.setAns1("71.7 m/s");
        p3.setAns2("1.77 m/s");
        p3.setAns3("7.71 m/s");
        p3.setAns4("7.17 m/s");
        p3.setIndexOfCorrect(4);

        ArrayList<Quiz> physicsQs = new ArrayList<>();
        physicsQs.add(p1);
        physicsQs.add(p2);
        physicsQs.add(p3);
        p.setQuestions(physicsQs);


        msh.setTitle("Marvel Super Heroes");
        msh.setShortDesc("This is a quiz on Marvel Super Heroes");
        msh.setLongDesc("This is a quiz on Marvel Super Heroes, the heroes that have" +
                " taken your money via comics, action figures, and movies for as long" +
                " as you can remember.");

        msh1.setQuestion("Which villain killed Gwen Stacy, Spiderman's true love?");
        msh2.setQuestion("Who founded the X-Men?");
        msh3.setQuestion("What team included Thor, the Hulk, Giant-man, the Wasp and Iron Man" +
                " as the founding members?");

        msh1.setAns1("Sandman");
        msh1.setAns2("Lex Luther");
        msh1.setAns3("Rhino");
        msh1.setAns4("Green Goblin");
        msh1.setIndexOfCorrect(4);

        msh2.setAns1("Wolverine");
        msh2.setAns2("Magneto");
        msh2.setAns3("Professor X");
        msh2.setAns4("Mr. Fantastic");
        msh2.setIndexOfCorrect(3);

        msh3.setAns1("The Avengers");
        msh3.setAns2("The X-Men");
        msh3.setAns3("The Fabulous Five");
        msh3.setAns4("The Avenging Team");
        msh3.setIndexOfCorrect(1);

        ArrayList<Quiz> mshQs = new ArrayList<>();
        mshQs.add(msh1);
        mshQs.add(msh2);
        mshQs.add(msh3);
        msh.setQuestions(mshQs);

        topics.add(0, m);
        topics.add(1, p);
        topics.add(2, msh);

        return topics;
    }
}