package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;

	/**
	 * Creates a new SimplePresentationScreen.
	 * @param studentData A student, whose data will be displayed by the new SimplePresentationScreen.
	 */
	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		try {
			setIconImage(ImageIO.read(new File("src/images/tdp.png")));
		} catch (IOException e) {
			System.out.println("Error al cargar el icono");
			e.printStackTrace();
		}
		
		init();
	}
	
	/**
	 * Initializes the graphic objects in this frame.
	 */
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		
		JLabel luLabel 			= new JLabel("LU");
		JLabel lastNameLabel 	= new JLabel("Apellido");
		JLabel firstNameLabel 	= new JLabel("Nombre");
		JLabel mailLabel 		= new JLabel("E-mail");
		JLabel githubLabel 		= new JLabel("Github URL");
		
		JTextField luTField 		= new JTextField("" + studentData.getId(),		30);
		JTextField lastnameTField 	= new JTextField(studentData.getLastName(),		30);
		JTextField firstNameTField 	= new JTextField(studentData.getFirstName(),	30);
		JTextField mailTField 		= new JTextField(studentData.getMail(),			30);
		JTextField githubTField 	= new JTextField(studentData.getGithubURL(),	30);
		
		luTField		.setEditable(false);
		lastnameTField	.setEditable(false);
		firstNameTField	.setEditable(false);
		mailTField		.setEditable(false);
		githubTField	.setEditable(false);
		
		GroupLayout groupLayout = new GroupLayout(tabInformation);
		
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(githubLabel)
						.addComponent(mailLabel)
						.addComponent(firstNameLabel)
						.addComponent(lastNameLabel)
						.addComponent(luLabel))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(luTField, 		GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lastnameTField, 	GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(firstNameTField, 	GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(mailTField, 		GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)	
						.addComponent(githubTField, 	GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(luLabel)
						.addComponent(luTField, 		GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lastNameLabel)
						.addComponent(lastnameTField, 	GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(firstNameLabel)
						.addComponent(firstNameTField,	GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(mailLabel)
						.addComponent(mailTField, 		GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(githubLabel)
						.addComponent(githubTField, 	GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		tabInformation.setLayout(groupLayout);
		contentPane.add(tabbedPane, BorderLayout.WEST);
		
		initImageLabel();
		initDateLabel();
	}
	
	/**
	 * Initializes the label used to display the student's photo.
	 */
	private void initImageLabel() {
		JLabel imageLabel;
		BufferedImage photo = null;
		try {
			photo = ImageIO.read(new File(studentData.getPathPhoto()));
		} catch (IOException e) {
			System.out.println("Error al cargar la foto del estudiante.");
			e.printStackTrace();
		}
		imageLabel = new JLabel(new ImageIcon(new ImageIcon(photo).getImage().getScaledInstance(150, 190, Image.SCALE_SMOOTH)));
		contentPane.add(imageLabel, BorderLayout.EAST);
	}
	
	/**
	 * Initializes the label that displays the date on which this presentation screen was created.
	 */
	private void initDateLabel() {
		Calendar calendar = Calendar.getInstance();
		StringBuilder sb = new StringBuilder("Esta ventana fue generada el ")
				.append(calendar.get(Calendar.DAY_OF_MONTH))
				.append("/")
				.append(String.format("%02d", calendar.get(Calendar.MONTH) + 1))
				.append("/")
				.append(calendar.get(Calendar.YEAR))
				.append(" a las: ")
				.append(String.format("%02d", calendar.get(Calendar.HOUR_OF_DAY)))
				.append(":")
				.append(String.format("%02d", calendar.get(Calendar.MINUTE)))
				.append(":")
				.append(String.format("%02d", calendar.get(Calendar.SECOND)));
		JLabel dateLabel = new JLabel(sb.toString());
		contentPane.add(dateLabel, BorderLayout.SOUTH);
	}
}
