package econtroller.modeler;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.jfree.chart.JFreeChart;

/**
 * 
 * @author Amir Moulavi
 * @date 2011-05-18
 *
 */

public class ModelerSnapshot {
	
	private int id;
	private Date date = Calendar.getInstance().getTime();
	private JFreeChart cpuChart;
	private JFreeChart responseTimeChart;
	private JFreeChart bandwidthChart;
	private JFreeChart nrInstancesChart;
	private JFreeChart totalCostChart;
	private JFreeChart averageThroughputChart;
	private String logText;
	
	public ModelerSnapshot(int id) {
		this.id = id;
	}

	public void setCpuChart(JFreeChart cpuChart) {
		this.cpuChart = cpuChart;
	}

	public void setResponseTimeChart(JFreeChart responseTimeChart) {
		this.responseTimeChart = responseTimeChart;
	}

	public void setBandwidthChart(JFreeChart bandwidthChart) {
		this.bandwidthChart = bandwidthChart;
	}

	public void setNrInstanceChart(JFreeChart nrInstancesChart) {
		this.nrInstancesChart = nrInstancesChart;
	}

	public void setTotalCostChart(JFreeChart totalCostChart) {
		this.totalCostChart = totalCostChart;		
	}

	public void setAverageThroughputChart(JFreeChart averageThroughputChart) {
		this.averageThroughputChart = averageThroughputChart;
	}

	public int getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public JFreeChart getCpuChart() {
		return cpuChart;
	}

	public JFreeChart getResponseTimeChart() {
		return responseTimeChart;
	}

	public JFreeChart getBandwidthChart() {
		return bandwidthChart;
	}

	public JFreeChart getNrInstancesChart() {
		return nrInstancesChart;
	}

	public JFreeChart getTotalCostChart() {
		return totalCostChart;
	}

	public JFreeChart getAverageThroughputChart() {
		return averageThroughputChart;
	}

	public void addLogText(String text) {
		this.logText = text;		
	}

	public String getLogText() {
		return logText;
	}

}