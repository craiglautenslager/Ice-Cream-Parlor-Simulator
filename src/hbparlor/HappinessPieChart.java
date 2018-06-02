/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbparlor;

import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author user
 */
public class HappinessPieChart {
 
    public ArrayList<Customer> custArray;
    public int totalCustomers;
    public int i;
    public String tempName;
    public int tempHappy;
    public JFreeChart hPieChart;
    public PiePlot3D P;
    public ChartFrame frame;
    
            
    
    public void happinessPieChart(ArrayList<Customer> custArray)
    {
        int i = 0;
        if (custArray.size()==0)
        {
            DefaultPieDataset pieDataset = new DefaultPieDataset();
            hPieChart = ChartFactory.createPieChart3D("Happiness Pie Chart", pieDataset, true, true, true);
            P=(PiePlot3D)hPieChart.getPlot();
            P.setBackgroundPaint(SystemColor.inactiveCaption);
            P.setNoDataMessage("There are no customers in the Ice Cream parlor.");
            P.setForegroundAlpha( 0.60f );
            P.setInteriorGap( 0.02 );
            frame = new ChartFrame("Happiness Pie Chart", hPieChart);
            frame.setVisible(true);
            frame.setSize(500,500);
        }
        else
        {
            this.custArray = custArray;
            totalCustomers = custArray.size();

            DefaultPieDataset pieDataset = new DefaultPieDataset();   




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

            while(i<totalCustomers)
            {
                tempName=custArray.get(i).getName();
                tempHappy=custArray.get(i).gethappy();
                pieDataset.setValue(tempName,tempHappy);
                i++;
            }

            hPieChart = ChartFactory.createPieChart3D("Happiness Pie Chart", pieDataset, true, true, true);
            P=(PiePlot3D)hPieChart.getPlot();
            P.setBackgroundPaint(SystemColor.inactiveCaption);
            P.setNoDataMessage("There is no happiness in the ice cream parlor.");
            P.setForegroundAlpha( 0.60f );
            P.setInteriorGap( 0.02 );
            frame = new ChartFrame("Happiness Pie Chart", hPieChart);
            frame.setVisible(true);
            frame.setSize(500,500);
        }
    }
}

