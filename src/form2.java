import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class form2 extends JFrame implements ActionListener{
    JLabel Brand = new JLabel("Brand");
    JTextField txtBrand = new JTextField(8);
    JLabel GBox = new JLabel("GearBox");
    JTextField txtGBox = new JTextField(8);
    JLabel Mdl = new JLabel("Model");
    JTextField txtMdl= new JTextField(8);
    JLabel year = new JLabel("Year");
    JTextField txtyear = new JTextField(8);
    JLabel mxSpd = new JLabel("Max Speed");
    JTextField txtSpd = new JTextField(8);
    JLabel Col= new JLabel("Color");
    JTextField txtCol = new JTextField(8);

    JButton Find = new JButton("Find the fastest Car");
    JButton clr = new JButton("Clear");

    public form2(){
        setTitle("new Frame");
        setSize(1000,200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(Brand);
        add(txtBrand);
        add(GBox);
        add(txtGBox);
        add(Mdl);
        add(txtMdl);
        add(year);
        add(txtyear);
        add(mxSpd);
        add(txtSpd);
        add(Col);
        add(txtCol);

        add(Find);
        add(clr);
        txtCol.setEditable(false);
        txtBrand.setEditable(false);
        txtyear .setEditable(false);
        txtMdl.setEditable(false);
        txtSpd.setEditable(false);
        txtGBox.setEditable(false);

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(18, 50, 5, 5);
        gc.anchor = GridBagConstraints.WEST;

        gc.gridx = 0;
        gc.gridy = 0;
        add(Brand, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(txtBrand, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        add(GBox, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(txtGBox, gc);

        gc.gridx = 2;
        gc.gridy = 0;
        add(Mdl, gc);

        gc.gridx = 2;
        gc.gridy = 1;
        add(txtMdl, gc);

        gc.gridx = 3;
        gc.gridy = 0;
        add(year, gc);

        gc.gridx = 3;
        gc.gridy = 1;
        add(txtyear, gc);

        gc.gridx = 4;
        gc.gridy = 0;
        add(mxSpd, gc);

        gc.gridx = 4;
        gc.gridy = 1;
        add(txtSpd, gc);

        gc.gridx = 5;
        gc.gridy = 0;
        add(Col, gc);

        gc.gridx = 5;
        gc.gridy = 1;
        add(txtCol, gc);

        gc.gridx = 0;
        gc.gridy = 7;
        add(Find, gc);

        gc.gridx = 1;
        gc.gridy = 7;
        add(clr, gc);


        Find.setBackground(Color.GREEN);
        clr.setBackground(Color.GREEN);
        Find.setOpaque(true);
        clr.setOpaque(true);



        Find.addActionListener(this);
        clr.addActionListener(this);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Find) {
            String fastestBrand = "";
            String fastestGearbox = "";
            String fastestModel = "";
            String fastestYear = "";
            String fastestColor = "";
            int fastestSpeed = 0;
            try {
                File myFile = new File("C:\\Users\\User\\Desktop\\cars.txt");
                Scanner myReader = new Scanner(myFile);
                while (myReader.hasNextLine()) {
                    String line = myReader.nextLine();
                    String[] carInfo = line.split(" ");
                    System.out.println(Arrays.toString(carInfo)); // print contents of carInfo array
                    String brand = carInfo[0];
                    String gearbox = carInfo[1];
                    String model = carInfo[2];
                    String year = carInfo[3];
                    int speed = Integer.parseInt(carInfo[4]);
                    String color = carInfo[5];
                    if (speed > fastestSpeed) {
                        fastestBrand = brand;
                        fastestGearbox = gearbox;
                        fastestModel = model;
                        fastestYear = year;
                        fastestColor = color;
                        fastestSpeed = speed;
                    }
                }
                myReader.close();


            } catch (IOException e1) {
                JOptionPane.showMessageDialog(this, "Error reading file");
            }
            txtBrand.setText(fastestBrand);
            txtGBox.setText(fastestGearbox);
            txtMdl.setText(fastestModel);
            txtyear.setText(fastestYear);
            txtCol.setText(fastestColor);
            txtSpd.setText(Integer.toString(fastestSpeed));
        }else if (e.getSource()==clr){
            txtBrand.setText("");
            txtGBox.setText("");
            txtMdl.setText("");
            txtyear.setText("");
            txtCol.setText("");
            txtSpd.setText("");
        }
    }
}