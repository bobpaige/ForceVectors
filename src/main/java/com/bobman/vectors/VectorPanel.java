package com.bobman.vectors;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class VectorPanel extends JPanel {

  private List<ForceVector> vectors = new ArrayList<>();
  private Point start = null;

  public VectorPanel() {
    vectors.add(ForceVector.builder()
        .radians(Math.PI / 2)
        .length(50)
        .build());
    vectors.add(ForceVector.builder()
        .radians(Math.PI / 6)
        .length(22)
        .build());
    vectors.add(ForceVector.builder()
        .radians(Math.PI / 3)
        .length(22)
        .build().reverse());
    start = new Point(100, 100);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    ForceVector otherVector = null;
    g.setColor(Color.BLUE);
    for (ForceVector v : vectors) {

      plotVector(g, start, v);

      if (otherVector == null) {
        otherVector = v;
      } else {
        otherVector = otherVector.add(v);
      }
    }

    g.setColor(Color.RED);
    plotVector(g, start, otherVector);

  }

  protected void plotVector(Graphics g, Point p, ForceVector v) {
    double x = Math.cos(v.getRadians()) * v.getLength();
    double y = Math.sin(v.getRadians()) * v.getLength();
    g.drawLine((int) p.getX(), (int) p.getY(), (int) (p.getX() + x), (int) (p.getY() + y));
  }

}
