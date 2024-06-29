import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

class Patient {
    String name;
    String address;
    String phone;
    String age;
    String illness;
    String dateOfAdmission;
    String gender;
    String doctorNote;
    String month;
    double billAmount;
    String appointmentDate;
    String appointmentTime;

    public Patient(String name, String address, String phone, String age, String illness, String dateOfAdmission, String gender, String doctorNote, String month) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.age = age;
        this.illness = illness;
        this.dateOfAdmission = dateOfAdmission;
        this.gender = gender;
        this.doctorNote = doctorNote;
        this.month = month;
        this.billAmount = 0.0;
        this.appointmentDate = "";
        this.appointmentTime = "";
    }
}

public class MenuPage {
    private JPanel mainbodypanel;
    private Map<Integer, Patient> patientDB = new HashMap<>();
    private int patientIdCounter = 1;
    private JTable patientTable;

    public MenuPage() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame menupageframe = new JFrame("Menu Page");
        menupageframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menupageframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menupageframe.setVisible(true);
        menupageframe.setLayout(null);

        JPanel headerpanel = new JPanel();
        headerpanel.setLayout(null);
        headerpanel.setBounds(10, 10, screenSize.width - 20, 100);
        headerpanel.setBorder(new BevelBorder(BevelBorder.RAISED));

        JLabel heading = new JLabel("SIMPSONS MILITARY HOSPITAL");
        heading.setFont(new Font("Garamond", Font.BOLD, 35));
        heading.setForeground(new Color(0, 255, 226));
        heading.setBounds(screenSize.width - 700, 30, 700, 45);

        headerpanel.add(heading);
        menupageframe.add(headerpanel);

        mainbodypanel = new JPanel();
        mainbodypanel.setLayout(null);
        mainbodypanel.setBounds(5, 110, screenSize.width - 10, screenSize.height - (screenSize.height / 4));
        mainbodypanel.setBackground(Color.WHITE);

        JTabbedPane tabpane = new JTabbedPane();
        tabpane.setBounds(5, 115, screenSize.width - 10, screenSize.height - (screenSize.height / 4));
        menupageframe.add(tabpane);

        JPanel panel1 = createOutPatientFormPanel();
        JPanel patientdbpanel = createPatientDatabasePanel();
        JPanel billingPanel = createBillingPanel();
        JPanel appointmentPanel = createAppointmentPanel();
        JPanel reportPanel = createReportPanel();

        tabpane.add("Out Patient Registration Form", panel1);
        tabpane.add("Patient Database", patientdbpanel);
        tabpane.add("Billing Page", billingPanel);
        tabpane.add("Appointment Page", appointmentPanel);
        tabpane.add("Reports", reportPanel);
    }

    private JPanel createOutPatientFormPanel() {
        JPanel panel1 = new JPanel();
        panel1.setOpaque(true);
        panel1.setLayout(null);

        JPanel outform = new JPanel();
        outform.setLayout(null);
        outform.setBounds(410, 1, 450, 650);
        outform.setBorder(new EtchedBorder(EtchedBorder.RAISED));

        JLabel outlabel = new JLabel("Enter Details of Out Patient");
        outlabel.setBounds(140, 20, 300, 40);
        JTextField outname = new JTextField("Enter Name");
        outname.setBounds(80, 70, 300, 40);
        outname.setForeground(Color.GRAY);
        outname.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (outname.getText().equals("Enter Name")) {
                    outname.setText("");
                    outname.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (outname.getText().isEmpty()) {
                    outname.setForeground(Color.GRAY);
                    outname.setText("Enter Name");
                }
            }
        });

        JTextField outaddress = new JTextField("Enter Address");
        outaddress.setBounds(80, 120, 300, 40);
        outaddress.setForeground(Color.GRAY);
        outaddress.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (outaddress.getText().equals("Enter Address")) {
                    outaddress.setText("");
                    outaddress.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (outaddress.getText().isEmpty()) {
                    outaddress.setForeground(Color.GRAY);
                    outaddress.setText("Enter Address");
                }
            }
        });

        JTextField outnumber = new JTextField("Enter Ph no");
        outnumber.setBounds(80, 170, 300, 40);
        outnumber.setForeground(Color.GRAY);
        outnumber.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (outnumber.getText().equals("Enter Ph no")) {
                    outnumber.setText("");
                    outnumber.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (outnumber.getText().isEmpty()) {
                    outnumber.setForeground(Color.GRAY);
                    outnumber.setText("Enter Ph no");
                }
            }
        });

        JTextField outage = new JTextField("Enter Age");
        outage.setBounds(80, 220, 300, 40);
        outage.setForeground(Color.GRAY);
        outage.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (outage.getText().equals("Enter Age")) {
                    outage.setText("");
                    outage.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (outage.getText().isEmpty()) {
                    outage.setForeground(Color.GRAY);
                    outage.setText("Enter Age");
                }
            }
        });

        JTextField outillness = new JTextField("Enter Illness");
        outillness.setBounds(80, 270, 300, 40);
        outillness.setForeground(Color.GRAY);
        outillness.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (outillness.getText().equals("Enter Illness")) {
                    outillness.setText("");
                    outillness.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (outillness.getText().isEmpty()) {
                    outillness.setForeground(Color.GRAY);
                    outillness.setText("Enter Illness");
                }
            }
        });

        JTextField outdateofadmission = new JTextField("Date of Admission (YYYY-MM-DD)");
        outdateofadmission.setBounds(80, 320, 300, 40);
        outdateofadmission.setForeground(Color.GRAY);
        outdateofadmission.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (outdateofadmission.getText().equals("Date of Admission (YYYY-MM-DD)")) {
                    outdateofadmission.setText("");
                    outdateofadmission.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (outdateofadmission.getText().isEmpty()) {
                    outdateofadmission.setForeground(Color.GRAY);
                    outdateofadmission.setText("Date of Admission (YYYY-MM-DD)");
                }
            }
        });

        JTextArea outnote = new JTextArea("Doctor's Note");
        outnote.setBounds(80, 370, 300, 70);
        outnote.setForeground(Color.GRAY);
        outnote.setLineWrap(true);
        outnote.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (outnote.getText().equals("Doctor's Note")) {
                    outnote.setText("");
                    outnote.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (outnote.getText().isEmpty()) {
                    outnote.setForeground(Color.GRAY);
                    outnote.setText("Doctor's Note");
                }
            }
        });

        String[] genderOptions = {"Male", "Female"};
        JComboBox<String> genderComboBox = new JComboBox<>(genderOptions);
        genderComboBox.setBounds(80, 450, 300, 40);

        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        JComboBox<String> monthComboBox = new JComboBox<>(months);
        monthComboBox.setBounds(80, 500, 300, 40);

        JButton outbutton = new JButton("Register");
        outbutton.setBounds(150, 550, 150, 40);

        outform.add(outlabel);
        outform.add(outname);
        outform.add(outaddress);
        outform.add(outnumber);
        outform.add(outage);
        outform.add(outillness);
        outform.add(outdateofadmission);
        outform.add(outnote);
        outform.add(genderComboBox);
        outform.add(monthComboBox);
        outform.add(outbutton);

        outbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = outname.getText();
                String address = outaddress.getText();
                String phone = outnumber.getText();
                String age = outage.getText();
                String illness = outillness.getText();
                String dateOfAdmission = outdateofadmission.getText();
                String gender = (String) genderComboBox.getSelectedItem();
                String doctorNote = outnote.getText();
                String month = (String) monthComboBox.getSelectedItem();

                Patient newPatient = new Patient(name, address, phone, age, illness, dateOfAdmission, gender, doctorNote, month);
                patientDB.put(patientIdCounter++, newPatient);
                refreshPatientTable();
                JOptionPane.showMessageDialog(null, "Patient registered successfully!");
            }
        });

        panel1.add(outform);
        return panel1;
    }

    private JPanel createPatientDatabasePanel() {
        JPanel patientdbpanel = new JPanel();
        patientdbpanel.setLayout(new BorderLayout());

        String[] columnNames = {"ID", "Name", "Address", "Phone", "Age", "Illness", "Date of Admission", "Gender", "Doctor's Note", "Month"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        patientTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(patientTable);
        patientdbpanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = patientTable.getSelectedRow();
                if (selectedRow >= 0) {
                    int patientId = (int) patientTable.getValueAt(selectedRow, 0);
                    Patient patient = patientDB.get(patientId);

                    JTextField nameField = new JTextField(patient.name);
                    JTextField addressField = new JTextField(patient.address);
                    JTextField phoneField = new JTextField(patient.phone);
                    JTextField ageField = new JTextField(patient.age);
                    JTextField illnessField = new JTextField(patient.illness);
                    JTextField dateField = new JTextField(patient.dateOfAdmission);
                    JTextField doctorNoteField = new JTextField(patient.doctorNote);

                    String[] genderOptions = {"Male", "Female"};
                    JComboBox<String> genderComboBox = new JComboBox<>(genderOptions);
                    genderComboBox.setSelectedItem(patient.gender);

                    String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
                    JComboBox<String> monthComboBox = new JComboBox<>(months);
                    monthComboBox.setSelectedItem(patient.month);

                    JPanel panel = new JPanel(new GridLayout(0, 1));
                    panel.add(new JLabel("Name:"));
                    panel.add(nameField);
                    panel.add(new JLabel("Address:"));
                    panel.add(addressField);
                    panel.add(new JLabel("Phone:"));
                    panel.add(phoneField);
                    panel.add(new JLabel("Age:"));
                    panel.add(ageField);
                    panel.add(new JLabel("Illness:"));
                    panel.add(illnessField);
                    panel.add(new JLabel("Date of Admission:"));
                    panel.add(dateField);
                    panel.add(new JLabel("Gender:"));
                    panel.add(genderComboBox);
                    panel.add(new JLabel("Doctor's Note:"));
                    panel.add(doctorNoteField);
                    panel.add(new JLabel("Month:"));
                    panel.add(monthComboBox);

                    int result = JOptionPane.showConfirmDialog(null, panel, "Edit Patient", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                    if (result == JOptionPane.OK_OPTION) {
                        patient.name = nameField.getText();
                        patient.address = addressField.getText();
                        patient.phone = phoneField.getText();
                        patient.age = ageField.getText();
                        patient.illness = illnessField.getText();
                        patient.dateOfAdmission = dateField.getText();
                        patient.gender = (String) genderComboBox.getSelectedItem();
                        patient.doctorNote = doctorNoteField.getText();
                        patient.month = (String) monthComboBox.getSelectedItem();

                        refreshPatientTable();
                        JOptionPane.showMessageDialog(null, "Patient information updated successfully!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a patient to edit.");
                }
            }
        });

        JButton generateReportButton = new JButton("Generate Report");
        generateReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField monthField = new JTextField();
                JPanel panel = new JPanel(new GridLayout(0, 1));
                panel.add(new JLabel("Enter Month:"));
                panel.add(monthField);

                int result = JOptionPane.showConfirmDialog(null, panel, "Generate Report", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    String month = monthField.getText();
                    List<Patient> reportPatients = new ArrayList<>();
                    for (Patient patient : patientDB.values()) {
                        if (patient.month.equalsIgnoreCase(month)) {
                            reportPatients.add(patient);
                        }
                    }
                    if (reportPatients.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No patients found for the specified month.");
                    } else {
                        StringBuilder report = new StringBuilder();
                        report.append("Report for ").append(month).append(":\n");
                        for (Patient patient : reportPatients) {
                            report.append("ID: ").append(patientDB.entrySet().stream().filter(entry -> entry.getValue().equals(patient)).map(Map.Entry::getKey).findFirst().orElse(null)).append("\n");
                            report.append("Name: ").append(patient.name).append("\n");
                            report.append("Address: ").append(patient.address).append("\n");
                            report.append("Phone: ").append(patient.phone).append("\n");
                            report.append("Age: ").append(patient.age).append("\n");
                            report.append("Illness: ").append(patient.illness).append("\n");
                            report.append("Date of Admission: ").append(patient.dateOfAdmission).append("\n");
                            report.append("Gender: ").append(patient.gender).append("\n");
                            report.append("Doctor's Note: ").append(patient.doctorNote).append("\n");
                            report.append("Bill Amount: ").append(patient.billAmount).append("\n");
                            report.append("Appointment Date: ").append(patient.appointmentDate).append("\n");
                            report.append("Appointment Time: ").append(patient.appointmentTime).append("\n");
                            report.append("--------------------------------------------------\n");
                        }
                        JTextArea reportArea = new JTextArea(report.toString());
                        JScrollPane scrollPane = new JScrollPane(reportArea);
                        scrollPane.setPreferredSize(new Dimension(500, 500));
                        JOptionPane.showMessageDialog(null, scrollPane, "Monthly Report", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        buttonPanel.add(editButton);
        buttonPanel.add(generateReportButton);
        patientdbpanel.add(buttonPanel, BorderLayout.SOUTH);

        return patientdbpanel;
    }

    private void refreshPatientTable() {
        DefaultTableModel model = (DefaultTableModel) patientTable.getModel();
        model.setRowCount(0);
        for (Map.Entry<Integer, Patient> entry : patientDB.entrySet()) {
            Patient patient = entry.getValue();
            model.addRow(new Object[]{
                entry.getKey(),
                patient.name,
                patient.address,
                patient.phone,
                patient.age,
                patient.illness,
                patient.dateOfAdmission,
                patient.gender,
                patient.doctorNote,
                patient.month
            });
        }
    }

    private JPanel createBillingPanel() {
        JPanel billingPanel = new JPanel();
        billingPanel.setLayout(null);

        JLabel billingLabel = new JLabel("Billing System");
        billingLabel.setFont(new Font("Garamond", Font.BOLD, 35));
        billingLabel.setBounds(400, 30, 300, 40);
        billingPanel.add(billingLabel);

        JTextField patientIDField = new JTextField("Enter Patient ID");
        patientIDField.setBounds(300, 100, 300, 40);
        patientIDField.setForeground(Color.GRAY);
        patientIDField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (patientIDField.getText().equals("Enter Patient ID")) {
                    patientIDField.setText("");
                    patientIDField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (patientIDField.getText().isEmpty()) {
                    patientIDField.setForeground(Color.GRAY);
                    patientIDField.setText("Enter Patient ID");
                }
            }
        });

        JTextField billAmountField = new JTextField("Enter Bill Amount");
        billAmountField.setBounds(300, 150, 300, 40);
        billAmountField.setForeground(Color.GRAY);
        billAmountField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (billAmountField.getText().equals("Enter Bill Amount")) {
                    billAmountField.setText("");
                    billAmountField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (billAmountField.getText().isEmpty()) {
                    billAmountField.setForeground(Color.GRAY);
                    billAmountField.setText("Enter Bill Amount");
                }
            }
        });

        JButton generateBillButton = new JButton("Generate Bill");
        generateBillButton.setBounds(350, 200, 200, 40);
        generateBillButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int patientID;
                double billAmount;
                try {
                    patientID = Integer.parseInt(patientIDField.getText());
                    billAmount = Double.parseDouble(billAmountField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter numeric values.");
                    return;
                }

                Patient patient = patientDB.get(patientID);
                if (patient == null) {
                    JOptionPane.showMessageDialog(null, "Patient not found.");
                } else {
                    patient.billAmount = billAmount;
                    JOptionPane.showMessageDialog(null, "Bill generated successfully for " + patient.name);
                }
            }
        });

        billingPanel.add(patientIDField);
        billingPanel.add(billAmountField);
        billingPanel.add(generateBillButton);

        return billingPanel;
    }

    private JPanel createAppointmentPanel() {
        JPanel appointmentPanel = new JPanel();
        appointmentPanel.setLayout(null);

        JLabel appointmentLabel = new JLabel("Appointment System");
        appointmentLabel.setFont(new Font("Garamond", Font.BOLD, 35));
        appointmentLabel.setBounds(400, 30, 400, 40);
        appointmentPanel.add(appointmentLabel);

        JTextField patientIDField = new JTextField("Enter Patient ID");
        patientIDField.setBounds(300, 100, 300, 40);
        patientIDField.setForeground(Color.GRAY);
        patientIDField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (patientIDField.getText().equals("Enter Patient ID")) {
                    patientIDField.setText("");
                    patientIDField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (patientIDField.getText().isEmpty()) {
                    patientIDField.setForeground(Color.GRAY);
                    patientIDField.setText("Enter Patient ID");
                }
            }
        });

        JTextField appointmentDateField = new JTextField("Enter Appointment Date (YYYY-MM-DD)");
        appointmentDateField.setBounds(300, 150, 300, 40);
        appointmentDateField.setForeground(Color.GRAY);
        appointmentDateField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (appointmentDateField.getText().equals("Enter Appointment Date (YYYY-MM-DD)")) {
                    appointmentDateField.setText("");
                    appointmentDateField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (appointmentDateField.getText().isEmpty()) {
                    appointmentDateField.setForeground(Color.GRAY);
                    appointmentDateField.setText("Enter Appointment Date (YYYY-MM-DD)");
                }
            }
        });

        JTextField appointmentTimeField = new JTextField("Enter Appointment Time (HH:MM)");
        appointmentTimeField.setBounds(300, 200, 300, 40);
        appointmentTimeField.setForeground(Color.GRAY);
        appointmentTimeField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (appointmentTimeField.getText().equals("Enter Appointment Time (HH:MM)")) {
                    appointmentTimeField.setText("");
                    appointmentTimeField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (appointmentTimeField.getText().isEmpty()) {
                    appointmentTimeField.setForeground(Color.GRAY);
                    appointmentTimeField.setText("Enter Appointment Time (HH:MM)");
                }
            }
        });

        JButton generateAppointmentButton = new JButton("Generate Appointment");
        generateAppointmentButton.setBounds(350, 250, 200, 40);
        generateAppointmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int patientID;
                try {
                    patientID = Integer.parseInt(patientIDField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter numeric values.");
                    return;
                }

                String appointmentDate = appointmentDateField.getText();
                String appointmentTime = appointmentTimeField.getText();

                Patient patient = patientDB.get(patientID);
                if (patient == null) {
                    JOptionPane.showMessageDialog(null, "Patient not found.");
                } else {
                    patient.appointmentDate = appointmentDate;
                    patient.appointmentTime = appointmentTime;
                    JOptionPane.showMessageDialog(null, "Appointment generated successfully for " + patient.name);
                }
            }
        });

        appointmentPanel.add(patientIDField);
        appointmentPanel.add(appointmentDateField);
        appointmentPanel.add(appointmentTimeField);
        appointmentPanel.add(generateAppointmentButton);

        return appointmentPanel;
    }

    private JPanel createReportPanel() {
        JPanel reportPanel = new JPanel();
        reportPanel.setLayout(new BorderLayout());

        JLabel reportLabel = new JLabel("Reports");
        reportLabel.setFont(new Font("Garamond", Font.BOLD, 35));
        reportLabel.setHorizontalAlignment(JLabel.CENTER);
        reportPanel.add(reportLabel, BorderLayout.NORTH);

        JTextArea reportArea = new JTextArea();
        reportArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reportArea);
        reportPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton generateReportButton = new JButton("Generate Monthly Report");
        generateReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField monthField = new JTextField();
                JPanel panel = new JPanel(new GridLayout(0, 1));
                panel.add(new JLabel("Enter Month:"));
                panel.add(monthField);

                int result = JOptionPane.showConfirmDialog(null, panel, "Generate Monthly Report", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    String month = monthField.getText();
                    List<Patient> reportPatients = new ArrayList<>();
                    for (Patient patient : patientDB.values()) {
                        if (patient.month.equalsIgnoreCase(month)) {
                            reportPatients.add(patient);
                        }
                    }
                    if (reportPatients.isEmpty()) {
                        reportArea.setText("No patients found for the specified month.");
                    } else {
                        StringBuilder report = new StringBuilder();
                        report.append("Report for ").append(month).append(":\n");
                        for (Patient patient : reportPatients) {
                            report.append("ID: ").append(patientDB.entrySet().stream().filter(entry -> entry.getValue().equals(patient)).map(Map.Entry::getKey).findFirst().orElse(null)).append("\n");
                            report.append("Name: ").append(patient.name).append("\n");
                            report.append("Address: ").append(patient.address).append("\n");
                            report.append("Phone: ").append(patient.phone).append("\n");
                            report.append("Age: ").append(patient.age).append("\n");
                            report.append("Illness: ").append(patient.illness).append("\n");
                            report.append("Date of Admission: ").append(patient.dateOfAdmission).append("\n");
                            report.append("Gender: ").append(patient.gender).append("\n");
                            report.append("Doctor's Note: ").append(patient.doctorNote).append("\n");
                            report.append("Bill Amount: ").append(patient.billAmount).append("\n");
                            report.append("Appointment Date: ").append(patient.appointmentDate).append("\n");
                            report.append("Appointment Time: ").append(patient.appointmentTime).append("\n");
                            report.append("--------------------------------------------------\n");
                        }
                        reportArea.setText(report.toString());
                    }
                }
            }
        });

        buttonPanel.add(generateReportButton);
        reportPanel.add(buttonPanel, BorderLayout.SOUTH);

        return reportPanel;
    }

    public static void main(String[] args) {
        new MenuPage();
    }
}