package com.fmi.proiect;

import models.Medic;
import services.AuditService;
import services.MedicJDBC;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class AppMain {

    private JPanel mainPanel;
    private JButton AdaugaMedicButton;
    private JButton creeazaTabelaMediciButton;
    private JButton incarcaTabelaDeMediciButton;
    private JTable TabelMedici;
    private JButton stergeMedicButton;
    private JButton ButonFereastraPacienti;

    public AppMain() {
        AdaugaMedicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AddMedicBox addMedicBox = new AddMedicBox();
                addMedicBox.showDialogBox();


            }
        });
        creeazaTabelaMediciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CreateMedicBox createMedicBox = new CreateMedicBox();
                createMedicBox.showMedicBox();

            }
        });
        incarcaTabelaDeMediciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SwingWorker<java.util.List<Medic>, String> worker = new SwingWorker<List<Medic>, String>() {
                    @Override
                    protected List<Medic> doInBackground() throws Exception {
                        return MedicJDBC.getInstance().ReadMedicList();
                    }

                    @Override
                    protected void done(){
                        try {
                            List<Medic> lista = get();

                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {

                                    DefaultTableModel defaultTableModel = new DefaultTableModel(){
                                        @Override
                                        public boolean isCellEditable(int row, int column) {
                                            return false;
                                        }
                                    }
                                            ;
                                    defaultTableModel.addColumn("id");
                                    defaultTableModel.addColumn("parola");
                                    defaultTableModel.addColumn("nume");
                                    defaultTableModel.addColumn("prenume");
                                    defaultTableModel.addColumn("data angajare");
                                    defaultTableModel.addColumn("salariu");
                                    defaultTableModel.addColumn("specializare");
                                    defaultTableModel.addColumn("vechime");

                                    for(Medic medic: lista){
                                        defaultTableModel.addRow(new Object[]{medic.getId(), medic.getPassword(), medic.getNume(), medic.getPrenume(), medic.getDataAngajare(), medic.getSalary(), medic.getSpecializare(), medic.getVechime()});
                                    }

                                    TabelMedici.setModel(defaultTableModel);

                                }
                            });


                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        } catch (ExecutionException e1) {
                            e1.printStackTrace();
                        }
                    }
                };

                worker.execute();

            }
        });
        stergeMedicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DeleteMedicBox deleteMedicBox = new DeleteMedicBox();
                deleteMedicBox.showDeleteBox();
            }
        });
        ButonFereastraPacienti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FereastraPacienti fereastraPacienti = new FereastraPacienti();
                fereastraPacienti.ShowFramePacienti();
            }
        });
    }

    private void initFrame(){

        AuditService.getInstance().writeAuditLine("AppMain: initFrame " + ", Thread: " + Thread.currentThread());

        JFrame jFrame = new JFrame("PAOgui");
        jFrame.setPreferredSize(new Dimension(1000, 800));
        jFrame.setContentPane(this.mainPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar jMenuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitMenu = new JMenuItem("exit");

        exitMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //AddMedicBox dialogBox = new AddMedicBox();
                //dialogBox.showDialogBox();
                System.exit(0);
            }
        });

        fileMenu.add(exitMenu);
        jMenuBar.add(fileMenu);
        jFrame.setJMenuBar(jMenuBar);

        jFrame.pack();
        jFrame.setVisible(true);


    }

    public static void main(String[] args){

        AppMain appMain = new AppMain();
        AuditService.getInstance().writeAuditLine("AppMain " + ", Thread: " + Thread.currentThread());


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                appMain.initFrame();
            }
        });

    }

}
