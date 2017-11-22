import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

/**
 * THIS CLASS HAS NO ROLE IN THE ACTUAL SOFTWARE. I JUST USE IT AS A REFERENCE FOR WHAT EACH PART DOES.
 * THE FUNCTIONAL VERSION OF THIS CLASS IS NESTED INSIDE PLANNERMAINJFRAME
 * @author Vishal
 *
 */
public class AddCourseDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtTeacher;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			AddCourseDialog dialog = new AddCourseDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Create the dialog.
	 */
	public AddCourseDialog() {
		setBounds(100, 100, 472, 343);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 0, 12, 321);
			contentPanel.add(buttonPane);
			buttonPane.setBorder(null);
			buttonPane.setBackground(UIManager.getColor("textHighlight"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		}
		{
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					AddCourseDialog.this.setVisible(false);
					AddCourseDialog.this.dispatchEvent(new WindowEvent(
		                    AddCourseDialog.this, WindowEvent.WINDOW_CLOSING));		
				}
			});
			okButton.setBounds(293, 277, 75, 36);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AddCourseDialog.this.setVisible(false);
					AddCourseDialog.this.dispatchEvent(new WindowEvent(
							AddCourseDialog.this, WindowEvent.WINDOW_CLOSING));
				}
			});
			cancelButton.setBounds(380, 277, 86, 36);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
		{
			JLabel lblAddACourse = new JLabel("Add A Course");
			lblAddACourse.setForeground(UIManager.getColor("textHighlight"));
			lblAddACourse.setBounds(135, 36, 232, 49);
			lblAddACourse.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 30));
			contentPanel.add(lblAddACourse);
		}
		{
			txtName = new JTextField();
			txtName.setForeground(UIManager.getColor("textInactiveText"));
			txtName.setFont(new Font("Microsoft Sans Serif", Font.ITALIC, 13));
			txtName.setText("Name...");
			txtName.setBackground(UIManager.getColor("window"));
			txtName.setBounds(88, 101, 279, 36);
			contentPanel.add(txtName);
			txtName.setColumns(10);
		}
		{
			txtTeacher = new JTextField();
			txtTeacher.setForeground(UIManager.getColor("textInactiveText"));
			txtTeacher.setFont(new Font("Microsoft Sans Serif", Font.ITALIC, 13));
			txtTeacher.setText("Teacher...");
			txtTeacher.setColumns(10);
			txtTeacher.setBackground(SystemColor.window);
			txtTeacher.setBounds(88, 149, 279, 36);
			contentPanel.add(txtTeacher);
		}
		{
			txtEmail = new JTextField();
			txtEmail.setForeground(UIManager.getColor("textInactiveText"));
			txtEmail.setFont(new Font("Microsoft Sans Serif", Font.ITALIC, 13));
			txtEmail.setText("Email...");
			txtEmail.setColumns(10);
			txtEmail.setBackground(SystemColor.window);
			txtEmail.setBounds(88, 197, 279, 36);
			contentPanel.add(txtEmail);
			
			
		}
		
	}

}
