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
//import java.util.Comparator;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * Ice Cream Avengers   
 */
public class MoneyPieChart {
    
    ArrayList<Worker> workerArray;
    int totalWorkers;
            
    public void WorkerPieChart(ArrayList<Worker> workerArray)
    {
        if (workerArray.size()==0)
        {
            DefaultPieDataset pieDataset = new DefaultPieDataset();  
            JFreeChart wPieChart = ChartFactory.createPieChart3D("Money Pie Chart", pieDataset, true, true, true);
            PiePlot3D P=(PiePlot3D)wPieChart.getPlot();
            P.setBackgroundPaint(SystemColor.inactiveCaption);
            P.setForegroundAlpha( 0.60f );
            P.setInteriorGap( 0.02 );
            P.setNoDataMessage("There are no workers in the Ice Cream parlor.");
            ChartFrame frame = new ChartFrame("Money Pie Chart", wPieChart);
            frame.setVisible(true);
            frame.setSize(500,500);
        }
        else
        {
            this.workerArray = workerArray;
            totalWorkers = workerArray.size();

            DefaultPieDataset pieDataset = new DefaultPieDataset();   
            int i=0;
            String tempName;
            double tempMoney;

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

            while(i<totalWorkers)
            {
                tempName=workerArray.get(i).getName();
                tempMoney=workerArray.get(i).getMoney();
                pieDataset.setValue(tempName,tempMoney);
                i++;
            }
            JFreeChart wPieChart = ChartFactory.createPieChart3D("Money Pie Chart", pieDataset, true, true, true);
            PiePlot3D P=(PiePlot3D)wPieChart.getPlot();
            P.setBackgroundPaint(SystemColor.inactiveCaption);
            P.setForegroundAlpha( 0.60f );
            P.setInteriorGap( 0.02 );
            P.setNoDataMessage("No money has been brought in to the ice cream parlor.");
            ChartFrame frame = new ChartFrame("Money Pie Chart", wPieChart);
            frame.setVisible(true);
            frame.setSize(500,500);
        }
    }
}
