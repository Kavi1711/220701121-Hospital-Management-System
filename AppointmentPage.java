import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// Import the Appointment class
//import com.yourpackage.Appointment;

public class AppointmentPage {
    private JFrame appointmentFrame;
    private JTable appointmentTable;
    private Map<Integer, Appointment> appointmentDB = new HashMap<>();
    private int appointmentIdCounter = 1;

    public AppointmentPage() {
        initialize();
    }

    private void initialize() {
        appointmentFrame = new JFrame("Appointments");
        appointmentFrame.setSize(1200, 800);
        appointmentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        appointmentFrame.setLayout(new BorderLayout());

        // Create top panel with buttons
        JPanel topPanel = new JPanel();
        JButton addAppointmentButton = new JButton("Add Appointment");
        addAppointmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addAppointment();
            }
        });

        JButton editAppointmentButton = new JButton("Edit Appointment");
        editAppointmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(null, "Enter Appointment ID:");
                if (input != null && !input.isEmpty()) {
                    int appointmentId = Integer.parseInt(input);
                    if (appointmentDB.containsKey(appointmentId)) {
                        editAppointment(appointmentId);
                    } else {
                        JOptionPane.showMessageDialog(null, "Appointment ID not found.");
                    }
                }
            }
        });

        JButton deleteAppointmentButton = new JButton("Delete Appointment");
        deleteAppointmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(null, "Enter Appointment ID:");
                if (input != null && !input.isEmpty()) {
                    int appointmentId = Integer.parseInt(input);
                    if (appointmentDB.containsKey(appointmentId)) {
                        appointmentDB.remove(appointmentId);
                        updateAppointmentTable();
                        JOptionPane.showMessageDialog(null, "Appointment deleted successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Appointment ID not found.");
                    }
                }
            }
        });

        topPanel.add(addAppointmentButton);
        topPanel.add(editAppointmentButton);
        topPanel.add(deleteAppointmentButton);

        appointmentFrame.add(topPanel, BorderLayout.NORTH);

        // Create table to display appointments
        appointmentTable = new JTable();
        appointmentTable.setModel(new DefaultTableModel(
                new Object[]{"ID", "Patient Name", "Appointment Date", "Doctor Name", "Reason"}, 0));
        JScrollPane appointmentTableScrollPane = new JScrollPane(appointmentTable);
        appointmentFrame.add(appointmentTableScrollPane, BorderLayout.CENTER);

        appointmentFrame.setVisible(true);
    }

    private void addAppointment() {
        JTextField patientNameField = new JTextField();
        JTextField appointmentDateField = new JTextField();
        JComboBox<String> doctorComboBox = new JComboBox<>(new String[]{"Kaibalan", "Kavin", "Eniyan"});
        JTextField reasonField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Patient Name:"));
        panel.add(patientNameField);
        panel.add(new JLabel("Appointment Date (dd/MM/yyyy):"));
        panel.add(appointmentDateField);
        panel.add(new JLabel("Doctor:"));
        panel.add(doctorComboBox);
        panel.add(new JLabel("Reason:"));
        panel.add(reasonField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add Appointment", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String patientName = patientNameField.getText();
                String appointmentDateStr = appointmentDateField.getText();
                String doctorName = (String) doctorComboBox.getSelectedItem();
                String reason = reasonField.getText();
                Date appointmentDate = new SimpleDateFormat("dd/MM/yyyy").parse(appointmentDateStr);

                Appointment newAppointment = new Appointment(appointmentIdCounter++, patientName, appointmentDate, doctorName, reason);
                appointmentDB.put(newAppointment.getAppointmentId(), newAppointment);
                updateAppointmentTable();
                JOptionPane.showMessageDialog(null, "Appointment added successfully.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error in date format. Please use dd/MM/yyyy.");
            }
        }
    }

    private void editAppointment(int appointmentId) {
        Appointment appointment = appointmentDB.get(appointmentId);
        JTextField patientNameField = new JTextField(appointment.getPatientName());
        JTextField appointmentDateField = new JTextField(new SimpleDateFormat("dd/MM/yyyy").format(appointment.getAppointmentDate()));
        JComboBox<String> doctorComboBox = new JComboBox<>(new String[]{"Kaibalan", "Kavin", "Eniyan"});
        doctorComboBox.setSelectedItem(appointment.getDoctorName());
        JTextField reasonField = new JTextField(appointment.getReason());

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Patient Name:"));
        panel.add(patientNameField);
        panel.add(new JLabel("Appointment Date (dd/MM/yyyy):"));
        panel.add(appointmentDateField);
        panel.add(new JLabel("Doctor:"));
        panel.add(doctorComboBox);
        panel.add(new JLabel("Reason:"));
        panel.add(reasonField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Edit Appointment", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            try {
                appointment.setPatientName(patientNameField.getText());
                appointment.setAppointmentDate(new SimpleDateFormat("dd/MM/yyyy").parse(appointmentDateField.getText()));
                appointment.setDoctorName((String) doctorComboBox.getSelectedItem());
                appointment.setReason(reasonField.getText());
                updateAppointmentTable();
                JOptionPane.showMessageDialog(null, "Appointment details updated successfully.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error in date format. Please use dd/MM/yyyy.");
            }
        }
    }

    private void updateAppointmentTable() {
        DefaultTableModel model = (DefaultTableModel) appointmentTable.getModel();
        model.setRowCount(0);
        for (Map.Entry<Integer, Appointment> entry : appointmentDB.entrySet()) {
            Appointment appointment = entry.getValue();
            model.addRow(new Object[]{appointment.getAppointmentId(), appointment.getPatientName(),
                    new SimpleDateFormat("dd/MM/yyyy").format(appointment.getAppointmentDate()),
                    appointment.getDoctorName(), appointment.getReason()});
        }
    }

    
    public static void main(String[] args) {
        new AppointmentPage();
    }
}
