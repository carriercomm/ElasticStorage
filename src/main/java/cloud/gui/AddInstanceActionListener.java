/**
 * Copyright 2011 Amir Moulavi (amir.moulavi@gmail.com)
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package cloud.gui;

import cloud.common.NodeConfiguration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Amir Moulavi
 * @date 2011-03-26
 *
 */

public class AddInstanceActionListener implements ActionListener {

	private CloudGUI gui;

	public AddInstanceActionListener(CloudGUI gui) {
		this.gui = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (gui.getCloudAPI() != null) {
			NodeConfiguration nodeConfiguration = getNodeConfiguration();
			if (nodeConfiguration != null) gui.getCloudAPI().initialize(nodeConfiguration, false);
		} else {
			gui.log("ERROR: CloudAPI component is not started or is dead");
		}
	}

	private NodeConfiguration getNodeConfiguration() {
		double cpu = Double.parseDouble(gui.getCpuSpeed().getSelectedItem().toString());
		double bandwidth = Double.parseDouble(gui.getBandwidthes().getSelectedItem().toString());
		int memory = Integer.parseInt(gui.getMemories().getSelectedItem().toString());
		int sDownloads = 0;
		boolean valid = true;
		try {
			sDownloads = Integer.parseInt(gui.getsDownloads().getText());
			if (sDownloads <= 0) valid = false; 
		} catch(NumberFormatException e) {
			valid = false;
		}
		if (valid) {
			NodeConfiguration nodeConfiguration = new NodeConfiguration(cpu, bandwidth, memory, sDownloads);
			return nodeConfiguration;
		} else {
			showErrorDialog();
			return null;
		}
	}

	private void showErrorDialog() {
		final JDialog errorDialog = new JDialog();
		errorDialog.setLocation(gui.getX(), gui.getY()+gui.getHeight()/2);
		errorDialog.setSize(400, 100);
		errorDialog.setTitle("Error");
		errorDialog.setLayout(new GridLayout(2,0));
		
		JLabel message = new JLabel("The configuration(s) is wrong, please correct it");
		errorDialog.add(message);
		
		JButton button = new JButton("Close");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				errorDialog.setVisible(false);
			}
		});
		button.setBounds(0, 0, 50, 50);
		errorDialog.add(button);
		
		errorDialog.setVisible(true);
	}

}
