package com.fmi.proiect;

import Models.Medic;
import Services.MedicJDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CreateMedicBox extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel titlucomanda;
    private JTextPane info;

    public CreateMedicBox() {
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
                MedicJDBC.getInstance().CreateTableMedic();
            }
        });

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void showMedicBox(){

        CreateMedicBox dialog = new CreateMedicBox();

        dialog.setPreferredSize(new Dimension(500, 500));
        dialog.info.setEditable(false);
        dialog.pack();
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        CreateMedicBox dialog = new CreateMedicBox();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
