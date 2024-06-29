// BillingPage.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.Map;

public class BillingPage {
    private JPanel mainbodypanel;
    private Map<Integer, Patient> patientDB = new HashMap<>();
    private JTable patientTable;

    public BillingPage() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame billingPageFrame = new JFrame("Billing Page");
        billingPageFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        billingPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        billingPageFrame.setVisible(true);
        billingPageFrame.setLayout(null);

        JPanel headerpanel = new JPanel();
        headerpanel.setLayout(null);
        headerpanel.setBounds(10, 10, screenSize.width - 20, 100);
        headerpanel.setBorder(new BevelBorder(BevelBorder.RAISED));

        JLabel heading = new JLabel("SIMPSONS MILITARY HOSPITAL - BILLING");
        heading.setFont(new Font("Garamond", Font.BOLD, 35));
        heading.setForeground(new Color(0, 255, 226));
        heading.setBounds(screenSize.width - 800, 30, 800, 45);

        headerpanel.add(heading);
        billingPageFrame.add(headerpanel);

        mainbodypanel = new JPanel();
        mainbodypanel.setLayout(null);
        mainbodypanel.setBounds(5, 110, screenSize.width - 10, screenSize.height - (screenSize.height / 4));
        mainbodypanel.setBackground(Color.WHITE);

        JTabbedPane tabpane = new JTabbedPane();
        tabpane.setBounds(5, 115, screenSize.width - 10, screenSize.height - (screenSize.height / 4));
        billingPageFrame.add(tabpane);

        JPanel billingPanel = new JPanel();
        billingPanel.setOpaque(true);
        billingPanel.setLayout(null);

        JPanel billForm = new JPanel();
        billForm.setLayout(null);
        billForm.setBounds(410, 25, 450, 600);
        billForm.setBorder(new EtchedBorder(EtchedBorder.RAISED));

        JLabel billLabel = new JLabel("Enter Billing Details");
        billLabel.setBounds(140, 20, 300, 40);

        JTextField patientIdField = new JTextField("Enter Patient ID");
        patientIdField.setBounds(80, 70, 300, 40);
        patientIdField.setForeground(Color.GRAY);
        patientIdField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (patientIdField.getText().equals("Enter Patient ID")) {
                    patientIdField.setText("");
                    patientIdField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (patientIdField.getText().isEmpty()) {
                    patientIdField.setForeground(Color.GRAY);
                    patientIdField.setText("Enter Patient ID");
                }
            }
        });

        JTextField amountField = new JTextField("Enter Amount");
        amountField.setBounds(80, 120, 300, 40);
        amountField.setForeground(Color.GRAY);
        amountField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (amountField.getText().equals("Enter Amount")) {
                    amountField.setText("");
                    amountField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (amountField.getText().isEmpty()) {
                    amountField.setForeground(Color.GRAY);
                    amountField.setText("Enter Amount");
                }
            }
        });

        JTextField paymentModeField = new JTextField("Enter Payment Mode");
        paymentModeField.setBounds(80, 170, 300, 40);
        paymentModeField.setForeground(Color.GRAY);
        paymentModeField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (paymentModeField.getText().equals("Enter Payment Mode")) {
                    paymentModeField.setText("");
                    paymentModeField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (paymentModeField.getText().isEmpty()) {
                    paymentModeField.setForeground(Color.GRAY);
                    paymentModeField.setText("Enter Payment Mode");
                }
            }
        });

        JTextField dateField = new JTextField("Date of Payment (YYYY-MM-DD)");
        dateField.setBounds(80, 220, 300, 40);
        dateField.setForeground(Color.GRAY);
        dateField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (dateField.getText().equals("Date of Payment (YYYY-MM-DD)")) {
                    dateField.setText("");
                    dateField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (dateField.getText().isEmpty()) {
                    dateField.setForeground(Color.GRAY);
                    dateField.setText("Date of Payment (YYYY-MM-DD)");
                }
            }
        });

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(100, 320, 250, 40);

        billForm.add(billLabel);
        billForm.add(patientIdField);
        billForm.add(amountField);
        billForm.add(paymentModeField);
        billForm.add(dateField);
        billForm.add(submitButton);

        billingPanel.add(billForm);
        tabpane.add("Billing Form", billingPanel);

        JPanel paymentHistoryPanel = new JPanel();
        paymentHistoryPanel.setOpaque(true);
        paymentHistoryPanel.setLayout(null);

        String[] columnNames = {"Patient ID", "Name", "Amount", "Payment Mode", "Date of Payment"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        patientTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(patientTable);
        scrollPane.setBounds(50, 60, 1800, 600);
        paymentHistoryPanel.add(scrollPane);

        tabpane.add("Payment History", paymentHistoryPanel);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int patientId = Integer.parseInt(patientIdField.getText());
                String amount = amountField.getText();
                String paymentMode = paymentModeField.getText();
                String date = dateField.getText();
                Patient patient = patientDB.get(patientId);
                if (patient != null) {
                    Object[] rowData = {patientId, patient.name, amount, paymentMode, date};
                    tableModel.addRow(rowData);
                } else {
                    JOptionPane.showMessageDialog(billingPageFrame, "Patient ID not found");
                }
            }
        });
    }
    public JPanel getBillingPanel() {
        return mainbodypanel;
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BillingPage());
    }
}
