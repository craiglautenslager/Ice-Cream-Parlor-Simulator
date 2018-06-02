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
public class MoneyBarChart {
    
    ArrayList<Worker> workerArray;
            
    public void WorkerBarChart(ArrayList<Worker> workerArray)
    {
        if(workerArray.size()==0)
        {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();   
            JFreeChart chart = ChartFactory.createBarChart3D("Money Bar Chart", "Name", "Money", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p=chart.getCategoryPlot();
            p.setBackgroundPaint(SystemColor.inactiveCaption);
            p.setRangeGridlinePaint(Color.BLUE);
            p.setNoDataMessage("There are no workers in the Ice Cream parlor");
            ChartFrame frame = new ChartFrame("Money Bar Chart", chart);
            frame.setVisible(true);
            frame.setSize(850,350);
        }
        else
        {
            this.workerArray = workerArray;

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();   
            int i=0;
            String tempName;
            double tempMoney;
            double maxMoney = 0.00;

            /*Collections.sort(workerArray, (Worker o1, Worker o2) -> {
                if(o1.getMoney() == o2.getMoney())
                {
                    return 0;
                }
                else if(o1.getMoney() < o2.getMoney())
                {
                    return -1;
                }
                return 1;
            });*/

            Collections.sort(workerArray,
                     new Comparator<Worker>()
                     {
                         @Override
                         public int compare(Worker o1,
                                            Worker o2)
                         {
                             if (o1.getMoney()==
                                     o2.getMoney())
                             {
                                 return 0;
                             }
                             else if (o1.getMoney() <
                                          o2.getMoney())
                             {
                                 return -1;
                             }
                             return 1;
                         }
                    });

            while(i<(workerArray.size()))
            {
                tempName=workerArray.get(i).getName();
                tempMoney=workerArray.get(i).getMoney();
                if(tempMoney>maxMoney)
                {
                    maxMoney=tempMoney;
                }
                dataset.setValue(tempMoney, "Money", tempName);
                i++;
            }

            JFreeChart chart = ChartFactory.createBarChart3D("Money Bar Chart", "Name", "Money", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p=chart.getCategoryPlot();
            p.setBackgroundPaint(SystemColor.inactiveCaption);
            p.setForegroundAlpha( 0.50f );
            ((BarRenderer)p.getRenderer()).setBarPainter(new StandardBarPainter());
            BarRenderer r = (BarRenderer)chart.getCategoryPlot().getRenderer();
            r.setSeriesPaint(0, Color.magenta);
            
            if (maxMoney == 0.00)
            {
                NumberAxis axis = new NumberAxis();
                axis.setRange(0, 5);
                p.setRangeAxis(axis);
            }
            p.setRangeGridlinePaint(Color.BLUE);
            p.setNoDataMessage("No money has been brought in to the ice cream parlor");
            ChartFrame frame = new ChartFrame("Money Bar Chart", chart);
            frame.setVisible(true);
            frame.setSize(850,350);
        }
    }
}
