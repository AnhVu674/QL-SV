package SinhVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.List;
import javax.swing.table.DefaultTableModel;

public class ViewSv extends javax.swing.JFrame {
	java.util.List<SinhVien> dssv = new ArrayList<>();
	DefaultTableModel tableModel;
	private JPanel contentPane;
	private JTextField Text_fullname;
	private JTextField text_SoDT;
	private JTextField Text_age;
	private JTextField text_Email;
	private JTable table_form;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSv frame = new ViewSv();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public ViewSv() {
		tableModel = (DefaultTableModel) table_form.getModel();
		showStudent();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Text_fullname = new JTextField();
		Text_fullname.setFont(new Font("Symbol", Font.PLAIN, 20));
		Text_fullname.setBounds(184, 33, 418, 27);
		contentPane.add(Text_fullname);
		Text_fullname.setColumns(10);

		JLabel lblNewLabel = new JLabel("Ho va ten");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(20, 29, 99, 27);
		contentPane.add(lblNewLabel);

		JLabel lblGioiTinh = new JLabel("Gioi Tinh");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGioiTinh.setBounds(20, 78, 99, 27);
		contentPane.add(lblGioiTinh);

		JLabel lblTuoi = new JLabel("Tuoi");
		lblTuoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTuoi.setBounds(20, 126, 61, 27);
		contentPane.add(lblTuoi);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(20, 165, 61, 27);
		contentPane.add(lblEmail);

		JLabel lblSoDt = new JLabel("So DT");
		lblSoDt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoDt.setBounds(20, 218, 61, 27);
		contentPane.add(lblSoDt);

		text_SoDT = new JTextField();
		text_SoDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text_SoDT.setColumns(10);
		text_SoDT.setBounds(184, 218, 418, 27);
		contentPane.add(text_SoDT);

		Text_age = new JTextField();
		Text_age.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Text_age.setColumns(10);
		Text_age.setBounds(184, 126, 418, 27);
		contentPane.add(Text_age);

		text_Email = new JTextField();
		text_Email.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text_Email.setColumns(10);
		text_Email.setBounds(184, 169, 418, 27);
		contentPane.add(text_Email);

		JComboBox comboBoxGender = new JComboBox();
		comboBoxGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxGender.setModel(new DefaultComboBoxModel(new String[] { "Nam", "Nu" }));
		comboBoxGender.setBounds(194, 78, 70, 27);
		contentPane.add(comboBoxGender);

		JButton btn_Luu = new JButton("Luu");
		btn_Luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fullName = Text_fullname.getText();
				int age = Integer.parseInt(Text_age.getText());
				String gender = comboBoxGender.getSelectedItem().toString();
				String email = text_Email.getText();
				String phoneNumber = text_SoDT.getText();
				SinhVien sv = new SinhVien(fullName, gender, email, phoneNumber, age);
				Student_Modify.insert(sv);
				showStudent();

			}
		});
		btn_Luu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Luu.setBounds(184, 255, 85, 33);
		contentPane.add(btn_Luu);

		JButton btnXoa = new JButton("Xoa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = table_form.getSelectedRow();
				if (selectedIndex >= 0) {
					SinhVien sv = dssv.get(selectedIndex);
					int opption = JOptionPane.showConfirmDialog(this, "Do you want to delete student");
					if (opption == 0) {
						Student_Modify.delete(sv.getID());
						showStudent();
					}
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoa.setBounds(298, 255, 85, 33);
		contentPane.add(btnXoa);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Text_fullname.setText("");
				Text_age.setText("");
				comboBoxGender.setSelectedIndex(0);
				text_Email.setText("");
				text_SoDT.setText("");

			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReset.setBounds(404, 255, 85, 33);
		contentPane.add(btnReset);

		JButton btnTim = new JButton("Tim");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showConfirmDialog(this, "Enter fullname to search:");
				if (input != null && input.length() > 0) {
					dssv = Student_Modify.findStudentByFullname(input);
					tableModel.setRowCount(0);
					dssv.forEach((student) -> {
						tableModel.addRow(new Object[] { tableModel.getRowCount() + 1, student.getFullName(),
								student.getGender(), student.getEmail(), student.getPhoneNumber(), student.getAge() });
					});
				} else {
					showStudent();
				}
			}
		});
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTim.setBounds(517, 255, 85, 33);
		contentPane.add(btnTim);

		table_form = new JTable();
		table_form.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table_form.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "ID", "Ho va ten", "Gioi Tinh", "Email", "So DT" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, Object.class, Object.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		JScrollPane scrollPane = new JScrollPane(table_form);
		scrollPane.setBounds(0, 298, 635, 139);
		contentPane.add(scrollPane);
	}

	private void showStudent() {
		java.util.List<SinhVien> dssv = Student_Modify.showAll();
		tableModel.setRowCount(0);
		dssv.forEach((student) -> {
			tableModel.addRow(new Object[] { tableModel.getRowCount() + 1, student.getFullName(), student.getGender(),
					student.getEmail(), student.getPhoneNumber(), student.getAge() });
		});
	}

}
