package com.fmi.proiect;

import Models.Medic;
import Models.Pacient;
import Services.MedicJDBC;
import Services.PacientService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class FereastraPacienti {
    private JPanel mainPacienti;
    private JButton ButonVarsta;
    private JTable PacientiTable;
    private JButton ButonAlfabetic;


    public FereastraPacienti() {
        ButonVarsta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                SwingWorker<java.util.List<Pacient>, String> worker = new SwingWorker<java.util.List<Pacient>, String>() {
                    @Override
                    protected java.util.List<Pacient> doInBackground() throws Exception {
                        return PacientService.getInstance().PacientiDupaVarstaCrescatorList();
                    }

                    @Override
                    protected void done(){
                        try {
                            List<Pacient> lista = get();

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
                                    defaultTableModel.addColumn("nume");
                                    defaultTableModel.addColumn("prenume");
                                    defaultTableModel.addColumn("cnp");
                                    defaultTableModel.addColumn("varsta");


                                    for(Pacient pacient: lista){
                                        defaultTableModel.addRow(new Object[]{pacient.getNume(), pacient.getPrenume(), pacient.getCnp(), pacient.getVarsta()});
                                    }

                                    PacientiTable.setModel(defaultTableModel);

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
        ButonAlfabetic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                SwingWorker<java.util.List<Pacient>, String> worker = new SwingWorker<java.util.List<Pacient>, String>() {
                    @Override
                    protected java.util.List<Pacient> doInBackground() throws Exception {
                        return PacientService.getInstance().PacientiAlfabeticList();
                    }

                    @Override
                    protected void done(){
                        try {
                            List<Pacient> lista = get();

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
                                    defaultTableModel.addColumn("nume");
                                    defaultTableModel.addColumn("prenume");
                                    defaultTableModel.addColumn("cnp");
                                    defaultTableModel.addColumn("varsta");


                                    for(Pacient pacient: lista){
                                        defaultTableModel.addRow(new Object[]{pacient.getNume(), pacient.getPrenume(), pacient.getCnp(), pacient.getVarsta()});
                                    }

                                    PacientiTable.setModel(defaultTableModel);

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
    }

    private void initFramePacienti(){

        JFrame jFrame = new JFrame("Pacienti");
        jFrame.setPreferredSize(new Dimension(600, 600));
        jFrame.setContentPane(this.mainPacienti);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );

        jFrame.pack();
        jFrame.setVisible(true);

    }

    public void ShowFramePacienti(){

        FereastraPacienti fereastraPacienti = new FereastraPacienti();


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                fereastraPacienti.initFramePacienti();
            }
        });
    }
}
