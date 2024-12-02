import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Quiz implements ActionListener{

    String[] questions ={
                            "A class member declared protected becomes a member of subclass of which type?",
                            "Which of these process occur automatically by the java runtime system?",
                            "What type of members are not serialized?",
                            "Which of these is used as a default for a member of a class if no access specifier is used for it?",
                            "Which of these classes is not included in java.lang?",
                            "Which of these is a process of converting a simple data type into a class?",
                            "Which of these class have only one field ‘TYPE’?",
                            "Which of these class holds a collection of static methods and variables?",
                            "Which of these method of Object class can generate duplicate copy of the object on which it is called?",
                            "Which of these exceptions is thrown by methods of System class?",
                            "Which of these methods initiates garbage collection?",
                            "Which of these method can set the out stream to OutputStream?",
                            "Which of these method of InputStream is used to read integer representation of next available byte input?",
                            "Which of the following is not a segment of memory in java?",
                            "What is JVM?",
                            "Which class loader loads jar files from JDK directory?",
                            "Classes and Methods are stored in which space?",
                            "Where is String Pool stored?",
                            "Which of these method returns a largest whole number less than or equal to variable X?",
                            "Which of the following constant are defined in Character wrapper?",
                            "Which of these coding techniques is used by method isDefined()?",
                            "Which of the interface contains all the methods used for handling thread related operations in Java?\n",
                            "Which of these class is used to make a thread?",
                            "Serialized object can be transferred via network.",
                            "Which of these is a protocol for breaking and sending packets to an address across a network?\n"

                        };
    String[][] options =  {
                            {"public member", "private member\n", "protected member\n", "static member"},
                            {"Serializable\n" ,"Externalization\n" , " FileFilter\n" , "ObjectInput"},
                            { "Private\n" , "Protected\n", "Static\n" , "Throwable\n"},
                            {"private\n", "public\n","public, within its own package\n" ,"protected"},
                            {"Byte\n" , " Integer\n" , " Array\n" , "Class\n"},
                            {"type wrapping\n", "type conversion\n" , "type casting\n" ,"none of the Mentioned\n"},
                            {"Void\n" , " Process\n" , "System\n" , " Runtime"},
                            {"Void\n" , " Process\n" , "Runtime\n" , "System"},
                            {"clone()\n", "copy()\n" , "duplicate()\n" , "dito()"},
                            {"IOException\n" , " SystemException\n" , "SecurityException\n" ,"InputOutputException\n"},
                            {"gc()\n" , "garbage()\n" , "garbagecollection()\n" , "Systemgarbagecollection()\n"},
                            {"setStream()\n" , "setosteam()\n", "setOut()\n" , "streamtoOstream()"},
                            {"read()","scanf()\n" ,"get()\n" ,"getInteger()\n"},
                            {"Stack Segment\n" , "Heap Segment\n" , "Code Segment\n" , "Register Segment\n"},
                            {"Bootstrap\n" , "Interpreter\n" , "Extension\n" , "Compiler\n"},
                            {"Bootstrap\n" , " Extension\n" , "System\n" , "Heap\n"},
                            {"Eden space\n" ,"Survivor space\n" , "Tenured space\n" , "Permanent spac"},
                            {"Java Stack\n" , "Java Heap\n" , "Permanent Generation\n" , "Metaspace\n"},
                            {"double ceil(double X)\n" , "double floor(double X)\n","double max(double X)\n" , "double min(double X)\n"},
                            {"MAX_RADIX\n","MAX_VALUE\n" , "TYPE\n" , "All of the mentioned\n"},
                            {"Latin\n" ,"ASCII\n" , "ANSI\n" , "UNICODE"},
                            {"Runnable interface\n" , "Math interface\n" , "System interface\n" , "ThreadHandling interface\n"},
                            {"String\n" ,"System\n" ,"Thread\n" ,"Runnable\n"},
                            {"True\n" ,"False\n","None of the above","Both"},
                            {"TCP/IP\n","DNS\n", "Socket\n","Proxy Server"}
                            };
    char[] answers  =       {
                             'B',
                             'B',
                             'C',
                             'A',
                             'C',
                             'A',
                             'A',
                             'D',
                             'A',
                             'C',
                             'A',
                             'C',
                             'A',
                             'D',
                             'B',
                             'B',
                             'D',
                             'B',
                             'B',
                             'D',
                             'D',
                             'A',
                             'C',
                             'A',
                             'A'
                            };
    char guess;
    char answer;
    int index;
    int  correct_guesses =0;
    int total_questions = questions.length;
    int result;
    int seconds= 10;

    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JTextArea textarea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();
    JLabel time_label = new JLabel();
    JLabel seconds_left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();

    Timer timer = new Timer(1000, e -> {
        seconds--;
        seconds_left.setText(String.valueOf(seconds));
        if (seconds<=0){
            displayAnswer();
        }
    });

    public Quiz(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);

        textField.setBounds(0,0,650,50);
        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Ink Free",Font.BOLD,30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);
        //textField.setText("");

        textarea.setBounds(0,50,650,100);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(25,25,25));
        textarea.setForeground(new Color(25,255,0));
        textarea.setFont(new Font("MV Boli",Font.BOLD,25));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);
        //textarea.setText("Sample");

        buttonA.setBounds(0,150,100,100);
        buttonA.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");


        buttonB.setBounds(0,250,100,100);
        buttonB.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0,350,100,100);
        buttonC.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0,450,100,100);
        buttonD.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answer_labelA.setBounds(125,150,500,100);
        answer_labelA.setBackground(new Color(50,50,50));
        answer_labelA.setForeground(new Color(25,255,0));
        answer_labelA.setFont(new Font("MV Boli", Font.PLAIN,35));
        //answer_labelA.setText("testing label");

        answer_labelB.setBounds(125,250,500,100);
        answer_labelB.setBackground(new Color(50,50,50));
        answer_labelB.setForeground(new Color(25,255,0));
        answer_labelB.setFont(new Font("MV Boli", Font.PLAIN,35));
        //answer_labelB.setText("testing label");

        answer_labelC.setBounds(125,350,500,100);
        answer_labelC.setBackground(new Color(50,50,50));
        answer_labelC.setForeground(new Color(25,255,0));
        answer_labelC.setFont(new Font("MV Boli", Font.PLAIN,35));
        //answer_labelC.setText("testing label");

        answer_labelD.setBounds(125,450,500,100);
        answer_labelD.setBackground(new Color(50,50,50));
        answer_labelD.setForeground(new Color(25,255,0));
        answer_labelD.setFont(new Font("MV Boli", Font.PLAIN,35));
        //answer_labelD.setText("testing label");
        seconds_left.setBounds(535,510,100,100);
        seconds_left.setBackground(new Color(25,25,25));
        seconds_left.setForeground(new Color(255,0,0));
        seconds_left.setFont(new Font("Ink Free",Font.BOLD,60));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        time_label.setBounds(535,475,100,25);
        time_label.setBackground(new Color(50,50,50));
        time_label.setForeground(new Color(255,0,0));
        time_label.setFont(new Font("MV Boli",Font.PLAIN,20));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("Timer");

        number_right.setBounds(225,225,200,100);
        number_right.setBackground(new Color(25,25,25));
        number_right.setForeground(new Color(25,255,0));
        number_right.setFont(new Font("Ink Free",Font.BOLD,50));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setEditable(false);

        percentage.setBounds(225,325,200,100);
        percentage.setBackground(new Color(25,25,25));
        percentage.setForeground(new Color(25,255,0));
        percentage.setFont(new Font("Ink Free",Font.BOLD,50));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setEditable(false);

      // frame.add(number_right);
        //frame.add(percentage);
        frame.add(time_label);
        frame.add(seconds_left);
        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textarea);
        frame.add(textField);
        frame.setVisible(true);

        nextQuestion();
    }
    public void nextQuestion(){
        if (index>=total_questions){
            results();
        }
        else{
            textField.setText("Question "+(index+1));
            textarea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);
            timer.start();
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (e.getSource()==buttonA){
            answer = 'A';
            if (answer==answers[index]){
                correct_guesses++;
            }
        }
        if (e.getSource()==buttonB){
            answer = 'B';
            if (answer==answers[index]){
                correct_guesses++;
            }
        }if (e.getSource()==buttonC){
            answer = 'C';
            if (answer==answers[index]){
                correct_guesses++;
            }
        }if (e.getSource()==buttonD){
            answer = 'D';
            if (answer==answers[index]){
                correct_guesses++;
            }
        }
        displayAnswer();
    }
    public void displayAnswer(){
        timer.stop();

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (answers[index] != 'A')
             answer_labelA.setForeground(new Color(255,0,0));
        if (answers[index] != 'B')
            answer_labelB.setForeground(new Color(255,0,0));
        if (answers[index] != 'C')
            answer_labelC.setForeground(new Color(255,0,0));
        if (answers[index] != 'D')
            answer_labelD.setForeground(new Color(255,0,0));

        Timer pause = new Timer(2000, e -> {
            answer_labelA.setForeground(new Color(25,255,0));
            answer_labelB.setForeground(new Color(25,255,0));
            answer_labelC.setForeground(new Color(25,255,0));
            answer_labelD.setForeground(new Color(25,255,0));

            answer = ' ';
            seconds = 10;
            seconds_left.setText(String.valueOf(seconds));
            buttonA.setEnabled(true);
            buttonB.setEnabled(true);
            buttonC.setEnabled(true);
            buttonD.setEnabled(true);
            index++;
            nextQuestion();
        });
        pause.setRepeats(false);
        pause.start();
    }
    public void results(){

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result = ((correct_guesses/total_questions)*100);

        textField.setText("RESULTS!");
        textarea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");

        number_right.setText("Correct Answers:"+correct_guesses);
        percentage.setText(result+"%");


    frame.add(percentage);
    frame.add(number_right);

    }

}
