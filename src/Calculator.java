import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JTextField textfield2;
    JTextField operatortext;
    JButton[] numberButtons = new JButton[10];
    JButton [] functionButtons = new JButton[8];
    JButton addButton , subButton , mulButton , divButton ,decButton , equButton , delButton , clrButton;
    JPanel panel;
    JRadioButton radioButton;
    JLabel label;
    Panel2 fullPanel2;
    public static JPanel fullPanel1;

    Font myFont= new Font("Arial" ,Font.BOLD ,25);

    double num1=0 , num2=0 , result=0;
    char operator;

    public JPanel getPanel1 (){
        return fullPanel1;
    }

    Calculator(){

        frame= new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420 ,550);
        frame.setLayout(null);
        frame.setResizable(false);

        textfield= new JTextField();
        textfield.setBounds(50,25,300,30);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        textfield2= new JTextField();
        textfield2.setBounds(50,100,300,30);
        textfield2.setFont(myFont);
        textfield2.setEditable(false);

        operatortext= new JTextField();
        operatortext.setBounds(50,65,50,26);
        operatortext.setFont(myFont);
        operatortext.setEditable(false);

        radioButton = new JRadioButton();
        radioButton.setBounds(300, 145 ,50,40);
        radioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radioButton.setSelected(false);
                frame.remove(fullPanel1);
                frame.revalidate();
                frame.repaint();
                frame.add(fullPanel2);

            }
        });

        label= new JLabel();
        label.setText("Check this for math functions calculator : ");
        Font labelFont = new Font("Arial" ,Font.BOLD ,12);
        label.setFont(labelFont);
        label.setBounds(50, 145 ,250,40);


        addButton = new JButton ("+");
        subButton = new JButton ("-");
        mulButton = new JButton ("*");
        divButton = new JButton ("/");
        decButton = new JButton (".");
        equButton = new JButton ("=");
        delButton = new JButton ("Delete");
        clrButton = new JButton ("Clear");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for(int i=0;i<8;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for(int i=0;i<10;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(true);
        }

        delButton.setBounds(50,450,145,30);
        clrButton.setBounds(205,450,145,30);

        panel =new JPanel();
        panel.setBounds(50,200,300,200);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);



        fullPanel2 = new Panel2();
        fullPanel2.setBounds(0,0,420,550);


        fullPanel1=new JPanel();
        fullPanel1.add(panel);
        fullPanel1.add(clrButton);
        fullPanel1.add(delButton);
        fullPanel1.add(textfield);
        fullPanel1.add(textfield2);
        fullPanel1.add(operatortext);
        fullPanel1.add(radioButton);
        fullPanel1.add(label);
        fullPanel1.setVisible(true);
        fullPanel1.setBounds(0,0,420,550);
        fullPanel1.setLayout(null);


        frame.setVisible(true);
        frame.add(fullPanel1);


    }

    public static void main(String[] args) {

        Calculator calculator= new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        for(int i=0;i<10 ;i++){

            if(e.getSource()==numberButtons[i] ){
                if(textfield.getText().equals("0")){return;}
                   if(operatortext.getText().isEmpty())
                   {textfield.setText(textfield.getText().concat(String.valueOf(i)));
                   }else if(textfield2.getText().equals("0")){return;}else{
                    textfield2.setText(textfield2.getText().concat(String.valueOf(i)));
                }

            }
        }

        if(e.getSource()==decButton){
            if(!textfield.getText().contains(".") && !textfield.getText().isEmpty() && operatortext.getText().isEmpty())
            { textfield.setText(textfield.getText().concat("."));}
            else if(!textfield2.getText().contains(".") && !textfield2.getText().isEmpty()){
                textfield2.setText(textfield2.getText().concat("."));
            }
        }
        if(e.getSource()==addButton){
            num1=Double.parseDouble(textfield.getText());
            operator ='+';
            String sign = Character.toString(operator);
            operatortext.setText(sign);
        }
        if(e.getSource()==subButton){
            num1=Double.parseDouble(textfield.getText());
            operator ='-';
            String sign = Character.toString(operator);
            operatortext.setText(sign);
        }
        if(e.getSource()==mulButton){
            num1=Double.parseDouble(textfield.getText());
            operator ='*';
            String sign = Character.toString(operator);
            operatortext.setText(sign);
        }
        if(e.getSource()==divButton){
            num1=Double.parseDouble(textfield.getText());
            operator ='/';
            String sign = Character.toString(operator);
            operatortext.setText(sign);
        }
        if(e.getSource()==clrButton){
            textfield.setText("");
            operatortext.setText("");
            textfield2.setText("");
        }
        if(e.getSource()==delButton){
            String string=textfield.getText();
            textfield.setText("");
            for(int i=0;i<string.length()-1;i++){
                textfield.setText(textfield.getText() +string.charAt(i));
            }
        }
        if(e.getSource()==equButton){
            num2=Double.parseDouble(textfield2.getText());
            switch (operator){
                case'+' :
                    result =num1+num2;
                    break;
                case'-' :
                    result =num1-num2;
                    break;
                case'*' :
                    result =num1*num2;
                    break;
                case'/' :
                    result =num1/num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            textfield2.setText("");
            operatortext.setText("");
            num1=result;


        }
    }

}
