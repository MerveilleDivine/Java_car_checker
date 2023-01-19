import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class form1 extends JFrame implements ActionListener {
    JLabel info = new JLabel("Enter the Car's information", JLabel.CENTER);
    JLabel Brand = new JLabel("Choose the Brand: ");
    JComboBox Choose = new JComboBox();
    JLabel GearBox = new JLabel("Choose the GearBox: ");
    JRadioButton Manual = new JRadioButton("Manual",false);
    JRadioButton Auto = new JRadioButton("Automatic",false);
    ButtonGroup RGroup = new ButtonGroup();
    JLabel Model = new JLabel("Enter the Model: ");
    JTextField textModel = new JTextField(10);
    JLabel Year = new JLabel("Enter the Year: ");
    JTextField textYear = new JTextField(10);
    JLabel Speed = new JLabel("Enter the Max Speed: ");
    JTextField textSpeed = new JTextField(10);
    JLabel Color = new JLabel("Enter the Color: ");
    JTextField textColor = new JTextField(10);

    JButton Add = new JButton("Add Car to the File");
    JButton Open = new JButton("Open the Search Form");

    public form1(){
        setTitle("Car info");
        setSize(600,400);
        //setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Choose.addItem("Choose");
        Choose.addItem("Mercedes");
        Choose.addItem("BMW");
        Choose.addItem("HONDA");
        Choose.addItem("Mazda");
        Choose.addItem("Suzuki");
        Choose.addItem("Hyundai");

        add(info);
        add(Brand);
        add(Choose);
        add(GearBox);

        this.RGroup.add(Manual);
        this.RGroup.add(Auto);

        add(Manual);
        add(Auto);
        add(Model);
        add(textModel);
        add(Year);
        add(textYear);
        add(Speed);
        add(textSpeed);
        add(Color);
        add(textColor);
        add(Add);
        add(Open);

        Add.setBackground(java.awt.Color.GREEN);
        Open.setBackground(java.awt.Color.GREEN);
        Add.setOpaque(true);
        Open.setOpaque(true);

        Add.addActionListener(this);
        Open.addActionListener(this);

        info.setFont(new Font("Arial", Font.BOLD, 16));
        info.setHorizontalAlignment(JLabel.RIGHT);
        info.setVerticalAlignment(JLabel.TOP);
        info .setForeground(java.awt.Color.BLUE);

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5, 5, 5, 5);
        gc.anchor = GridBagConstraints.WEST;


        gc.gridx = 0;
        gc.gridy = 1;
        add(Brand, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(Choose, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(GearBox, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        add(Manual, gc);

        gc.gridx = 2;
        gc.gridy = 2;
        add(Auto, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        add(Model, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        add(textModel, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        add(Year, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        add(textYear, gc);

        gc.gridx = 0;
        gc.gridy = 5;
        add(Speed, gc);

        gc.gridx = 1;
        gc.gridy = 5;
        add(textSpeed, gc);

        gc.gridx = 0;
        gc.gridy = 6;
        add(Color, gc);

        gc.gridx = 1;
        gc.gridy = 6;
        add(textColor, gc);

        gc.gridx = 1;
        gc.gridy = 8;
        add(Add, gc);

        gc.gridx =1;
        gc.gridy = 9;
        add(Open, gc);


        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String brand = (String) Choose.getSelectedItem();
        String gearbox;
        if (Manual.isSelected()) {
            gearbox = "Manual";
        } else if (Auto.isSelected()){
            gearbox = "Automatic";
        }else {
        JOptionPane.showMessageDialog(null,"Please select a gearbox (Manual or Automatic)");
        return;
        }
        String model = textModel.getText();
        String year = textYear.getText();
        String speed = textSpeed.getText();
        String color = textColor.getText();

        String carInfo = brand + " " + gearbox + " " + model + " " + year + " " + speed + " " + color + "\n";

        if (e.getSource() == Add) {
            try {
                while (brand.equals("Choose") || textModel.getText().isEmpty() || textYear.getText().isEmpty() || textSpeed.getText().isEmpty() || textColor.getText().isEmpty()) {
                    if(brand.equals("Choose")){
                        JOptionPane.showMessageDialog(null,"Please select the brand of the car!");
                    }else {
                        JOptionPane.showMessageDialog(null,"Please fill in all the fields!");
                    }
                    return;
                }

                    if(!isValidYear(year)){
                        JOptionPane.showMessageDialog(null,"Please enter a valid year.");
                        return;
                    }


            File myFile = new File("C:\\Users\\User\\Desktop\\cars.txt");
            if (!myFile.exists()) {
                try {
                    myFile.createNewFile();
                    FileWriter fw = new FileWriter("C:\\Users\\User\\Desktop\\cars.txt", true);
                    fw.write(carInfo);
                    fw.close();
                    textModel.setText("");
                    textYear.setText("");
                    textSpeed.setText("");
                    textColor.setText("");
                    Choose.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(this, "File created and car added in the file");
                    return;
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else if (myFile.exists()) {
                try {
                    FileWriter fw = new FileWriter("C:\\Users\\User\\Desktop\\cars.txt", true);
                    fw.write(carInfo);
                    fw.close();
                    textModel.setText("");
                    textYear.setText("");
                    textSpeed.setText("");
                    textColor.setText("");
                    Choose.setSelectedIndex(0);

                    JOptionPane.showMessageDialog(this, "Car added in the file");
                    return;
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }


        }catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }

            if (e.getSource()==Open){
           new form2();
        }
        else {
            dispose();




    }
}
    private boolean isValidYear(String year) {
        try {
            int yearInt = Integer.parseInt(year);
            if(yearInt >= 1900 && yearInt <= java.util.Calendar.getInstance().get(java.util.Calendar.YEAR))
                return true;
            else
                return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
