/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbparlor;

import java.awt.Color;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author user
 */
public class HappinessBarChart {
    
    ArrayList<Customer> custArray;
            
    public void happinessBarChart(ArrayList<Customer> custArray)
    {
        if(custArray.size()==0)
        {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();   
            JFreeChart chart = ChartFactory.createBarChart3D("Happiness Bar Chart", "Name", "Happiness", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p=chart.getCategoryPlot();
            p.setBackgroundPaint(SystemColor.inactiveCaption);
            p.setRangeGridlinePaint(Color.BLUE);
            p.setNoDataMessage("There are no customers in the Ice Cream parlor.");
            ChartFrame frame = new ChartFrame("Happiness Bar Chart", chart);
            frame.setVisible(true);
            frame.setSize(850,350);
        }
        else
        {
            this.custArray = custArray;

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();   
            int i=0;
            String tempName;
            int tempHappiness;
            int maxHappiness = 0;

            /*Collections.sort(custArray, (Customer o1, Customer o2) -> {
                if(o1.gethappy() == o2.gethappy())
                {
                    return 0;
                }
                else if(o1.gethappy() < o2.gethappy())
                {
                    return -1;
                }
                return 1;
            });*/

            Collections.sort(custArray,
                     new Comparator<Customer>()
                     {
                         public int compare(Customer o1,
                                            Customer o2)
                         {
                             if (o1.gethappy()==
                                     o2.gethappy())
                             {
                                 return 0;
                             }
                             else if (o1.gethappy() <
                                          o2.gethappy())
                             {
                                 return -1;
                             }
                             return 1;
                         }
                    });

            while(i<(custArray.size()))
            {
                tempName=custArray.get(i).getName();
                tempHappiness=custArray.get(i).gethappy();
                if(tempHappiness>maxHappiness)
                {
                    maxHappiness=tempHappiness;
                }
                dataset.setValue(tempHappiness, "Happiness", tempName);
                i++;
            }

            JFreeChart chart = ChartFactory.createBarChart3D("Happiness Bar Chart", "Name", "Happiness", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p=chart.getCategoryPlot();
            p.setBackgroundPaint(SystemColor.inactiveCaption);
            p.setForegroundAlpha( 0.50f );
            ((BarRenderer)p.getRenderer()).setBarPainter(new StandardBarPainter());
            BarRenderer r = (BarRenderer)chart.getCategoryPlot().getRenderer();
            r.setSeriesPaint(0, Color.magenta);
            
            if (maxHappiness == 0)
            {
                NumberAxis axis = new NumberAxis();
                axis.setRange(0, 5);
                p.setRangeAxis(axis);
            }
            p.setRangeGridlinePaint(Color.BLUE);
            p.setNoDataMessage("There is no happiness in the ice cream parlor.");
            ChartFrame frame = new ChartFrame("Happiness Bar Chart", chart);
            frame.setVisible(true);
            frame.setSize(850,350);
        }
    }
}
