import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main {
    private static JFrame frame;
    static JTextField originalPrice;
    static JTextField sale;
    static JTextField priceWithSale;
    static JButton clear;
    static JButton calculate;
    static JButton change;
    static JLabel label1;
    static boolean booleanChange = true;


    public void calculate(){
        int finalePriceInt = getPriceInt() - ((getPriceInt() * getSaleInt()) / 100);
        String finalePriceString = String.valueOf(finalePriceInt);
        priceWithSale.setText(finalePriceString);
    }

    public int getPriceInt(){
        String inputText = originalPrice.getText();
        int priceInt = Integer.parseInt(inputText);
        return priceInt;
    }

    public int getSaleInt(){
        String inputSale = sale.getText();
        int saleInt = Integer.parseInt(inputSale);
        return saleInt;
    }

     public static void makeFrame(){
        frame = new JFrame("sale calculator");
        makeContentPane();

        frame.pack();
        frame.setVisible(true);
    }

    public static void refresh(){
        frame.setVisible(false);
    }

    public static void makeContentPane(){
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());

        if (booleanChange) {
            contentPane.setLayout(new FlowLayout());
            originalPrice = new JTextField(10);
            contentPane.add(originalPrice);

            sale = new JTextField(10);
            contentPane.add(sale);

            clear = new JButton("clear");
            contentPane.add(clear);
            classListener listener = new classListener();
            clear.addActionListener(listener);

            calculate = new JButton("calculate");
            contentPane.add(calculate);
            classListener listener1 = new classListener();
            calculate.addActionListener(listener1);

            priceWithSale = new JTextField(10);
            contentPane.add(priceWithSale);


            change = new JButton("change");
            contentPane.add(change);
            classListener listener2 = new classListener();
            change.addActionListener(listener2);
        }
        else {

            contentPane.setLayout(new GridLayout(1,1,160,90));

            label1 = new JLabel("good programmer ");
            contentPane.add(label1);
        }

    }

    public static void main(String[] args) {
        makeFrame();
    }
}

class classListener extends Main implements ActionListener {
    public void actionPerformed(ActionEvent event)
    {
        String command = event.getActionCommand();
        if(command.equals("clear")){
            originalPrice.setText("");
            sale.setText("");
        }
        if(command.equals("calculate")){
            calculate();
        }
        if(command.equals("change")){
            booleanChange = false;
            refresh();
            makeFrame();
        }

    }
}

