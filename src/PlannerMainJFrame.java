import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Canvas;

import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.DefaultListModel;

import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

/*
 * SLDJFLKSDJFLKSJDFLKSDJFLKSDFLKSJDFLKSJDFLKJSDLFKJSLDKFJLSKDJFLKSDJFLKSDJF
 */
public class PlannerMainJFrame {

	private JFrame frame;
	Courseload courseload = new Courseload();
	Date date = new Date();
	Calendar cal = new GregorianCalendar();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlannerMainJFrame window = new PlannerMainJFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlannerMainJFrame() {
		initialize();
		cal.setTime(date);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 577, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel pnlWelcome = new JPanel();
		pnlWelcome.setBackground(new Color(0, 0, 51));
		frame.getContentPane().add(pnlWelcome, "name_117420766608876");
		pnlWelcome.setLayout(null);
		
		final JPanel pnlNoCourses = new JPanel();
		frame.getContentPane().add(pnlNoCourses, "name_155968823267700");
		pnlNoCourses.setBackground(new Color(0, 0, 51));
		pnlNoCourses.setLayout(null);
		
		JPanel pnlHomePage = new JPanel();
		pnlHomePage.setBackground(new Color(0, 0, 51));
		frame.getContentPane().add(pnlHomePage, "name_120616608857892");
		
		final JPanel pnlDeadlinePage = new JPanel();
		pnlDeadlinePage.setBorder(null);
		pnlDeadlinePage.setForeground(new Color(255, 255, 255));
		pnlDeadlinePage.setBackground(new Color(0, 0, 51));
		frame.getContentPane().add(pnlDeadlinePage, "name_116702024281665");
		
		JLabel lblItAppearsAs = new JLabel("You Have No Courses");
		lblItAppearsAs.setFont(new Font("Microsoft Sans Serif", Font.ITALIC, 30));
		lblItAppearsAs.setForeground(SystemColor.textHighlight);
		lblItAppearsAs.setBackground(SystemColor.textHighlight);
		lblItAppearsAs.setBounds(127, 133, 311, 47);
		pnlNoCourses.add(lblItAppearsAs);
		
		JLabel lblAddOneTo = new JLabel("Add One to Get Started!");
		lblAddOneTo.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		lblAddOneTo.setForeground(SystemColor.textHighlight);
		lblAddOneTo.setBounds(211, 181, 148, 16);
		pnlNoCourses.add(lblAddOneTo);
		
		
		JButton btnAddACourse = new JButton("Add A Course");
		btnAddACourse.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					AddCourseDi dialog = new AddCourseDi();
					dialog.setLocationRelativeTo(frame);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);

					//Code will not run until dialog is closed
					String name = dialog.txtName.getText();
					String teach = dialog.txtTeacher.getText();
					String email = dialog.txtEmail.getText();


					if(dialog.pressOk) {	
						if(name.equals("") || teach.equals("") || email.equals("")) {
							JOptionPane.showMessageDialog(null, "Enter Actual Words Please");
						}else {
							courseload.newCourse(name, teach, email);
							
							pnlNoCourses.setVisible(false);
							pnlHomePage.setVisible(true);

						}
					}
				}  catch (Exception x) {
					x.printStackTrace();
				}
			}
		});
		btnAddACourse.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		btnAddACourse.setBounds(211, 281, 148, 47);
		pnlNoCourses.add(btnAddACourse);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 577, 47);
		pnlNoCourses.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("QuickPlan");
		label.setBounds(6, 0, 159, 41);
		panel.add(label);
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 35));
		
		JLabel lblWelcome = new JLabel("QuickPlan");
		lblWelcome.setForeground(SystemColor.textHighlight);
		lblWelcome.setBounds(128, 17, 320, 78);
		lblWelcome.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 67));
		pnlWelcome.add(lblWelcome);
		
		//
		//Get Started Button
		//
		JButton btnGetStarted = new JButton("Get Started");
		btnGetStarted.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		btnGetStarted.setForeground(SystemColor.activeCaptionText);
		btnGetStarted.setBackground(SystemColor.activeCaptionText);
		btnGetStarted.setBounds(164, 167, 239, 45);
		pnlWelcome.add(btnGetStarted);
		
		//Button Press functionality
		btnGetStarted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlWelcome.setVisible(false);
				if(courseload.getCount()==0) {
					pnlNoCourses.setVisible(true);
				}else {
					pnlHomePage.setVisible(true);
				}
			}
		});
		
		JLabel lblTheUltimatePlanning = new JLabel("The Ultimate Planning Experience");
		lblTheUltimatePlanning.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		lblTheUltimatePlanning.setForeground(SystemColor.textHighlight);
		lblTheUltimatePlanning.setBounds(185, 92, 243, 16);
		pnlWelcome.add(lblTheUltimatePlanning);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(0, 338, 184, 21);
		pnlWelcome.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 102, 255));
		panel_2.setBounds(185, 338, 208, 21);
		pnlWelcome.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 102, 102));
		panel_3.setBounds(393, 338, 184, 21);
		pnlWelcome.add(panel_3);
		
		DefaultListModel<String> modelHome = new DefaultListModel<>();
		JList<String> list = new JList<>(modelHome);
		list.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.inactiveCaptionText, SystemColor.textHighlight, null, null));
		
		Iterator<Entry<String, Course>> listOfClasses = courseload.getClasses();
		while(listOfClasses.hasNext()) {
			modelHome.addElement(listOfClasses.next().getKey());
		}
		pnlHomePage.setLayout(null);
		
		JButton btnViewDeadlines = new JButton("View Deadlines");
		btnViewDeadlines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlHomePage.setVisible(false);
				pnlDeadlinePage.setVisible(true);
			}
		});
		btnViewDeadlines.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		btnViewDeadlines.setBounds(16, 266, 137, 42);
		pnlHomePage.add(btnViewDeadlines);
		

		
		JLabel label_1 = new JLabel("QuickPlan");
		label_1.setBounds(6, -11, 165, 62);
		label_1.setForeground(SystemColor.textHighlight);
		label_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 35));
		pnlHomePage.add(label_1);
	
		list.setBounds(185, 63, 365, 240);
		list.setBackground(SystemColor.window);
		pnlHomePage.add(list);
		
		JPanel TodayStripe = new JPanel();
		TodayStripe.setBounds(0, 334, 577, 15);
		TodayStripe.setLayout(null);
		TodayStripe.setBorder(null);
		TodayStripe.setBackground(SystemColor.textHighlight);
		pnlHomePage.add(TodayStripe);
		pnlDeadlinePage.setLayout(null);
		
		JLabel lblFuture = new JLabel("FUTURE");
		lblFuture.setBounds(442, -13, 129, 72);
		lblFuture.setForeground(new Color(255, 102, 102));
		lblFuture.setFont(new Font("Microsoft Sans Serif", Font.ITALIC, 30));
		pnlDeadlinePage.add(lblFuture);
		
		/*
		 * LDKFJLSKDJFLKSDJFLKSDJFLKSDJFLKSDJFLKSDJFLKSDJFLKSDJFLKSDJFLKSDJFLKSDJFLSKDFJLSKDFJLSDKFJLSDKFJLSKDFJLSDKFJ
		 */
		DefaultListModel<String> modelDeadline = new DefaultListModel<>();
		JList<String> DeadlineList = new JList<String>(modelDeadline);
		DeadlineList.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), new Color(164, 205, 255), null, null));
		DeadlineList.setForeground(Color.BLACK);
		DeadlineList.setBounds(185, 63, 365, 240);
		DeadlineList.setBackground(SystemColor.window);
		pnlDeadlinePage.add(DeadlineList);
		
		JButton button = new JButton("New Assignment");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAssignmentDi assDialog = new AddAssignmentDi();
				assDialog.setLocationRelativeTo(frame);
				assDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				assDialog.setVisible(true);
				
				if(assDialog.pressOk) {
					String course = (String)assDialog.courseDropDown.getSelectedItem();
					String description = assDialog.txtAssDescription.getText();
					
					int dueMonth = monthConverter((String)assDialog.drpMonth.getSelectedItem());
					int dueDay = (Integer)assDialog.drpDay.getSelectedItem();
					int dueYear = (Integer) assDialog.drpYear.getSelectedItem();
					
					courseload.viewCourse(course).newAssignment(description, ""+dueMonth, ""+dueDay, ""+dueYear);
					
					if(dueMonth==cal.get(Calendar.MONTH) + 1) {
						if(dueDay==cal.get(Calendar.DAY_OF_MONTH)) {
							if(dueYear==cal.get(Calendar.YEAR)) {
								modelHome.addElement(course.toUpperCase() + "------------->" + description);
								modelDeadline.addElement(course.toUpperCase() + "------------->" + description + " | " + dueMonth + "/" + dueDay + "/" + dueYear);
							}
						}
					}else {
						modelDeadline.addElement(course.toUpperCase() + "------------->" + description + " | " + dueMonth + "/" + dueDay + "/" + dueYear);
						
					}

				}
			}
		});
		button.setBounds(16, 63, 137, 42);
		button.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		pnlDeadlinePage.add(button);
		
		JButton btnTodayAssignment = new JButton("Today's Assignments");
		btnTodayAssignment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlDeadlinePage.setVisible(false);
				pnlHomePage.setVisible(true);
			}
		});
		btnTodayAssignment.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		btnTodayAssignment.setBounds(16, 261, 144, 42);
		pnlDeadlinePage.add(btnTodayAssignment);
		
		JPanel FutureStripe = new JPanel();
		FutureStripe.setBounds(0, 334, 577, 15);
		FutureStripe.setBackground(new Color(255, 102, 102));
		pnlDeadlinePage.add(FutureStripe);
		FutureStripe.setLayout(null);
		
		JLabel label_3 = new JLabel("QuickPlan");
		label_3.setBounds(6, 1, 159, 41);
		pnlDeadlinePage.add(label_3);
		label_3.setForeground(new Color(255, 102, 102));
		label_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 35));
		
		JButton btnNewAssignment = new JButton("New Assignment");
		btnNewAssignment.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AddAssignmentDi assDialog = new AddAssignmentDi();
				assDialog.setLocationRelativeTo(frame);
				assDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				assDialog.setVisible(true);
				
				if(assDialog.pressOk) {
					String course = (String)assDialog.courseDropDown.getSelectedItem();
					String description = assDialog.txtAssDescription.getText();
					
					int dueMonth = monthConverter((String)assDialog.drpMonth.getSelectedItem());
					int dueDay = (Integer)assDialog.drpDay.getSelectedItem();
					int dueYear = (Integer) assDialog.drpYear.getSelectedItem();
					
					courseload.viewCourse(course).newAssignment(description, ""+dueMonth, ""+dueDay, ""+dueYear);
					
					if(dueMonth==cal.get(Calendar.MONTH) + 1) {
						if(dueDay==cal.get(Calendar.DAY_OF_MONTH)) {
							if(dueYear==cal.get(Calendar.YEAR)) {
								modelHome.addElement(course.toUpperCase() + "------------->" + description);	
								modelDeadline.addElement(course.toUpperCase() + "------------->" + description + " | " + dueMonth + "/" + dueDay + "/" + dueYear);
							}
						}
					}else {
						
						modelDeadline.addElement(course.toUpperCase() + "------------->" + description + " | " + dueMonth + "/" + dueDay + "/" + dueYear);
						
					}
				}
			}
		});
		btnNewAssignment.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		btnNewAssignment.setBounds(16, 115, 137, 42);
		pnlHomePage.add(btnNewAssignment);
		
		JButton btnNewCourseHome = new JButton("New Course");
		btnNewCourseHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddCourseDi dialog = new AddCourseDi();
					dialog.setLocationRelativeTo(frame);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);

					//Code will not run until dialog is closed
					String name = dialog.txtName.getText();
					String teach = dialog.txtTeacher.getText();
					String email = dialog.txtEmail.getText();


					if(dialog.pressOk) {	
						if(name.equals("") || teach.equals("") || email.equals("")) {
							JOptionPane.showMessageDialog(null, "Enter Actual Words Please");
						}else {
							courseload.newCourse(name, teach, email);
							
							pnlNoCourses.setVisible(false);
							pnlHomePage.setVisible(true);

						}
					}
				}  catch (Exception x) {
					x.printStackTrace();
				}
			}
		});
		btnNewCourseHome.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		btnNewCourseHome.setBounds(16, 63, 137, 42);
		pnlHomePage.add(btnNewCourseHome);
		
		JLabel lblToday = new JLabel("TODAY");
		lblToday.setForeground(SystemColor.textHighlight);
		lblToday.setFont(new Font("Microsoft Sans Serif", Font.ITALIC, 30));
		lblToday.setBounds(461, -14, 116, 72);
		pnlHomePage.add(lblToday);
		
	}
	
	public int monthConverter(String month) {
		if(month.equals("January")) return 1;
		if(month.equals("February")) return 2;
		if(month.equals("March")) return 3;
		if(month.equals("April")) return 4;
		if(month.equals("May")) return 5;
		if(month.equals("June")) return 6;
		if(month.equals("July")) return 7;
		if(month.equals("August")) return 8;
		if(month.equals("September")) return 9;
		if(month.equals("October")) return 10;
		if(month.equals("November")) return 11;
		if(month.equals("December")) return 12;
		return 0;
				
	}
	/**
	 * Class that creates the add course dialog
	 * @author Vishal
	 *
	 */
	class AddCourseDi extends JDialog {

		private static final long serialVersionUID = 1L;
		private boolean pressOk;
		private final JPanel contentPanel = new JPanel();
		private JTextField txtName;
		private JTextField txtTeacher;
		private JTextField txtEmail;

		/**
		 * Create the dialog.
		 */
		public AddCourseDi() {
			
			setBounds(100, 100, 472, 343);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBackground(new Color(0, 0, 51));
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(null);
			setModalityType(this.DEFAULT_MODALITY_TYPE);
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setBounds(0, 0, 12, 321);
				contentPanel.add(buttonPane);
				buttonPane.setBorder(null);
				buttonPane.setBackground(new Color(153, 102, 255));
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			}
			{
				JButton okButton = new JButton("OK");

				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						pressOk = true;
						AddCourseDi.this.setVisible(false);
						AddCourseDi.this.dispatchEvent(new WindowEvent(
			                    AddCourseDi.this, WindowEvent.WINDOW_CLOSING));
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
						AddCourseDi.this.setVisible(false);
						AddCourseDi.this.dispatchEvent(new WindowEvent(
								AddCourseDi.this, WindowEvent.WINDOW_CLOSING));
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

	/**
	 * Class that creates the 'add assignment' dialog
	 * @author Vishal
	 *
	 */
	class AddAssignmentDi extends JDialog {

		private final JPanel contentPanel = new JPanel();
		private JTextField txtAssDescription;
		private JComboBox <String> courseDropDown;
		private JComboBox<String> drpMonth;
		private JComboBox<Integer> drpDay;
		private JComboBox<Integer> drpYear;
		private boolean pressOk = false;


		/**
		 * Create the dialog.
		 */
		public AddAssignmentDi() {
			setBounds(100, 100, 473, 344);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBackground(new Color(0, 0, 51));
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(null);
			setModalityType(this.DEFAULT_MODALITY_TYPE);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							pressOk = true;
							AddAssignmentDi.this.setVisible(false);
							AddAssignmentDi.this.dispatchEvent(new WindowEvent(
				                    AddAssignmentDi.this, WindowEvent.WINDOW_CLOSING));

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
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AddAssignmentDi.this.setVisible(false);
						AddAssignmentDi.this.dispatchEvent(new WindowEvent(
								AddAssignmentDi.this, WindowEvent.WINDOW_CLOSING));
					}
				});
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
				panel.setBackground(new Color(153, 102, 255));
				panel.setBounds(0, 0, 12, 321);
				contentPanel.add(panel);
				panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			}
			
			courseDropDown = new JComboBox<String>();
			courseDropDown.setBounds(108, 116, 255, 27);
			Iterator<Entry<String, Course>> listOfClasses = courseload.getClasses();
			while(listOfClasses.hasNext()) {
				courseDropDown.addItem(listOfClasses.next().getKey());
			}
			contentPanel.add(courseDropDown);
			
			txtAssDescription = new JTextField();
			txtAssDescription.setHorizontalAlignment(SwingConstants.CENTER);
			txtAssDescription.setForeground(Color.LIGHT_GRAY);
			txtAssDescription.setFont(new Font("Microsoft Sans Serif", Font.ITALIC, 13));
			txtAssDescription.setText("Description...");
			txtAssDescription.setBounds(108, 150, 255, 65);
			contentPanel.add(txtAssDescription);
			txtAssDescription.setColumns(10);
			
			JLabel lblDueDate = new JLabel("Due Date");
			lblDueDate.setForeground(SystemColor.textHighlight);
			lblDueDate.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
			lblDueDate.setBounds(92, 229, 73, 16);
			contentPanel.add(lblDueDate);
			
			drpMonth = new JComboBox<String>();
			drpMonth.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
			drpMonth.setBounds(159, 225, 91, 27);
			drpMonth.addItem("January"); drpMonth.addItem("February"); drpMonth.addItem("March"); drpMonth.addItem("April"); drpMonth.addItem("May");
			 drpMonth.addItem("June"); drpMonth.addItem("July"); drpMonth.addItem("August"); drpMonth.addItem("September"); drpMonth.addItem("October");
			 drpMonth.addItem("November"); drpMonth.addItem("December");
			contentPanel.add(drpMonth);
			
			drpDay = new JComboBox<Integer>();
			drpDay.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
			for(int i=1; i<=31; i++) {
				drpDay.addItem(i);
			}
			drpDay.setBounds(251, 225, 61, 27);
			contentPanel.add(drpDay);
			
			drpYear = new JComboBox<Integer>();
			drpYear.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
			for(int i=2017; i<=2020; i++) {
				drpYear.addItem(i);
			}
			drpYear.setBounds(313, 225, 75, 27);
			contentPanel.add(drpYear);
		}
	}
}
