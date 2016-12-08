package com.bobman.vectors;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main {

  private JFrame frmVectorpanel;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Main window = new Main();
          window.frmVectorpanel.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public Main() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmVectorpanel = new JFrame();
    frmVectorpanel.setTitle("VectorPanel");
    frmVectorpanel.setBounds(100, 100, 450, 300);
    frmVectorpanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    VectorPanel vectorPanel = new VectorPanel();
    frmVectorpanel.getContentPane().add(vectorPanel, BorderLayout.CENTER);
  }

}
