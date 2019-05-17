package com.fmi.proiect;

import models.Medic;
import services.MedicJDBC;

import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AddMedicBox extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField IdTextBox;
    private JTextField PasswordTextBox;
    private JTextField NumeTextBox;
    private JTextField PrenumeTextBox;
    private JTextField SalariuTextBox;
    private JTextField SpecializareTextBox;
    private JTextField VechimeTextBox;

    public AddMedicBox() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                //MedicJDBC.getInstance().CreateTableMedic();

                Medic medic = null;
                String id = IdTextBox.getText();
                String password = PasswordTextBox.getText();
                String nume = NumeTextBox.getText();
                String prenume = PrenumeTextBox.getText();

                Calendar calendar = GregorianCalendar.getInstance();
                java.util.Date date = calendar.getTime();

                Integer salariu = Integer.parseInt(SalariuTextBox.getText());
                String specializare = SpecializareTextBox.getText();
                Integer vechime = Integer.parseInt(VechimeTextBox.getText());

                medic = new Medic(id, password, nume, prenume, date, salariu, specializare, vechime);

                MedicJDBC.getInstance().InsertMedic(medic);
            }
        });


        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void showDialogBox(){

        AddMedicBox dialog = new AddMedicBox();
        dialog.pack();
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        AddMedicBox dialog = new AddMedicBox();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
