import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;


/**
 * THIS CLASS HAS NO ROLE IN THE ACTUAL SOFTWARE. I JUST USE IT AS A REFERENCE FOR WHAT EACH PART DOES.
 * THE FUNCTIONAL VERSION OF THIS CLASS IS NESTED INSIDE PLANNERMAINJFRAME
 * @author Vishal
 *
 */
public class AddAssignmentDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtAssDescription;
	private boolean pressOk = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddAssignmentDialog dialog = new AddAssignmentDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddAssignmentDialog() {
		setBounds(100, 100, 473, 344);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						pressOk = true;
						AddAssignmentDialog.this.setVisible(false);
						AddAssignmentDialog.this.dispatchEvent(new WindowEvent(
			                    AddAssignmentDialog.this, WindowEvent.WINDOW_CLOSING));

				}
			});
			okButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
			okButton.setBounds(378, 268, 75, 36);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
			cancelButton.setBounds(277, 268, 86, 36);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
		{
			JLabel lblAddAnAssignment = new JLabel("Add An Assignment");
			lblAddAnAssignment.setForeground(SystemColor.textHighlight);
			lblAddAnAssignment.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 30));
			lblAddAnAssignment.setBounds(108, 34, 291, 49);
			contentPanel.add(lblAddAnAssignment);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(null);
			panel.setBackground(SystemColor.textHighlight);
			panel.setBounds(0, 0, 12, 321);
			contentPanel.add(panel);
			panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		}
		
		@SuppressWarnings("rawtypes")
		JComboBox courseDropDown = new JComboBox();
		courseDropDown.setBackground(SystemColor.window);
		courseDropDown.setBounds(108, 95, 255, 27);
		contentPanel.add(courseDropDown);
		
		txtAssDescription = new JTextField();
		txtAssDescription.setBackground(SystemColor.window);
		txtAssDescription.setHorizontalAlignment(SwingConstants.CENTER);
		txtAssDescription.setForeground(Color.LIGHT_GRAY);
		txtAssDescription.setFont(new Font("Microsoft Sans Serif", Font.ITALIC, 13));
		txtAssDescription.setText("Description...");
		txtAssDescription.setBounds(108, 138, 255, 65);
		contentPanel.add(txtAssDescription);
		txtAssDescription.setColumns(10);
		
		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setForeground(SystemColor.textHighlight);
		lblDueDate.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		lblDueDate.setBounds(92, 229, 73, 16);
		contentPanel.add(lblDueDate);
		
		JComboBox<String> drpMonth = new JComboBox<String>();
		drpMonth.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		drpMonth.setBounds(159, 225, 91, 27);
		drpMonth.addItem("January"); drpMonth.addItem("February"); drpMonth.addItem("March"); drpMonth.addItem("April"); drpMonth.addItem("May");
		 drpMonth.addItem("June"); drpMonth.addItem("July"); drpMonth.addItem("August"); drpMonth.addItem("September"); drpMonth.addItem("October");
		 drpMonth.addItem("November"); drpMonth.addItem("December");
		contentPanel.add(drpMonth);
		
		JComboBox<Integer> drpDay = new JComboBox<Integer>();
		drpDay.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		for(int i=1; i<=31; i++) {
			drpDay.addItem(i);
		}
		drpDay.setBounds(251, 225, 61, 27);
		contentPanel.add(drpDay);
		
		JComboBox<Integer> drpYear = new JComboBox<Integer>();
		drpYear.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		for(int i=2017; i<=2020; i++) {
			drpYear.addItem(i);
		}
		drpYear.setBounds(313, 225, 75, 27);
		contentPanel.add(drpYear);
	}
}
