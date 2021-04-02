import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel2 extends JPanel  {

    JRadioButton backRadioButton;
    JLabel backLabel;


    public Panel2(){
        super();
        init();
        setUp();
        addComponents();
    }

    private void init() {
        backRadioButton=new JRadioButton();
        backLabel= new JLabel();

    }

    private void setUp() {
        backRadioButton.setBounds(155,475,20,20);
        backRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backRadioButton.setSelected(false);
                backRadioButton.getParent().getParent().add(Calculator.fullPanel1);
                backRadioButton.getParent().getParent().revalidate();
                backRadioButton.getParent().getParent().repaint();
                backRadioButton.getParent().getParent().remove(0);

            }
        });
        backLabel.setBounds(10, 470 ,150 , 30);
        backLabel.setText("Back to simple calculator ");






    }

    private void addComponents() {
        this.add(backRadioButton);
        this.add(backLabel);



    }


}
