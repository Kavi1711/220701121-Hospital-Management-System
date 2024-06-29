import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.util.HashMap;
import java.util.Map;

class HomePage {

    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(Image image) {
            this.backgroundImage = image;
            setLayout(null);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    HomePage() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        ImageIcon backgroundIcon = new ImageIcon("C:\\hms\\Hospital-Management-System-master (4)\\Hospital-Management-System-master\\Images\\medical-background-vector.jpg");
        Image backgroundImage = backgroundIcon.getImage();

        final JFrame homepageframe = new JFrame("K116");
        homepageframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        homepageframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        backgroundPanel.setBounds(0, 0, screenSize.width, screenSize.height);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(screenSize);

        JPanel wrapper = new JPanel();
        wrapper.setLayout(null);
        wrapper.setOpaque(false);
        wrapper.setBounds(0, 0, screenSize.width, screenSize.height);

        JPanel headerpanel = new JPanel();
        headerpanel.setLayout(null);
        headerpanel.setBounds(10, 10, screenSize.width - 20, 100);
        headerpanel.setBorder(new BevelBorder(BevelBorder.RAISED));
        headerpanel.setBackground(Color.WHITE);
        headerpanel.setOpaque(true);

        JPanel headerpanelsh = new JPanel();
        headerpanelsh.setLayout(null);
        headerpanelsh.setBounds(16, 16, screenSize.width - 20, 100);
        headerpanelsh.setBackground(new Color(200, 200, 200));
        headerpanelsh.setOpaque(true);

        JLabel heading = new JLabel("K116");
        Font font = new Font("airstri", Font.BOLD, 80);
        heading.setFont(font);
        heading.setForeground(new Color(0, 255, 226));
        heading.setBounds(screenSize.width, 30, 70, 45);

        JLabel heading1 = new JLabel("K116");
        Font font1 = new Font("Garamond", Font.BOLD, 80);
        heading1.setFont(font1);
        heading1.setForeground(new Color(0, 126, 112));
        heading1.setBounds(screenSize.width - 697, 33, 700, 45);

        ImageIcon image = new ImageIcon("C:\\hms\\Hospital-Management-System-master (4)\\Hospital-Management-System-master\\Images\\logo.png");
        JLabel label = new JLabel("", image, JLabel.CENTER);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);
        panel.setBounds(50, 5, 100, 90);
        panel.setOpaque(false);

        JButton home = new JButton("Home");
        home.setBounds((screenSize.width / 2) - 140, 650, 100, 30);
        homepageframe.add(home);

        JButton aboutus = new JButton("About Us");
        aboutus.setBounds((screenSize.width / 2) - 40, 650, 100, 30);
        aboutus.addActionListener(ae -> new AboutUs());
        homepageframe.add(aboutus);

        JButton contactus = new JButton("Contact Us");
        contactus.setBounds((screenSize.width / 2) + 60, 650, 100, 30);
        contactus.addActionListener(ae -> new ContactUs());
        homepageframe.add(contactus);

        JPanel loginpanel = new JPanel();
        loginpanel.setLayout(null);
        loginpanel.setBounds(450, 130, 450, 450);
        loginpanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        loginpanel.setBackground(Color.WHITE);
        loginpanel.setOpaque(true);

        JLabel loginlabel = new JLabel("LOGIN");
        loginlabel.setBounds(200, 0, 300, 100);
        loginlabel.setFont(new Font("TimesNewRoman", Font.BOLD, 18));

        final JTextField username = new JTextField("Enter Username");
        username.setBounds(100, 120, 300, 50);
        username.setForeground(Color.GRAY);

        final JPasswordField password = new JPasswordField("Enter Password");
        password.setBounds(100, 210, 300, 50);
        password.setForeground(Color.GRAY);
        password.setEchoChar((char) 0);

        username.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (username.getText().equals("Enter Username")) {
                    username.setText("");
                    username.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (username.getText().isEmpty()) {
                    username.setForeground(Color.GRAY);
                    username.setText("Enter Username");
                }
            }
        });

        password.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (new String(password.getPassword()).equals("Enter Password")) {
                    password.setText("");
                    password.setForeground(Color.BLACK);
                    password.setEchoChar('*');
                }
            }

            public void focusLost(FocusEvent e) {
                if (new String(password.getPassword()).isEmpty()) {
                    password.setForeground(Color.GRAY);
                    password.setText("Enter Password");
                    password.setEchoChar((char) 0);
                }
            }
        });

        JButton loginbutton = new JButton("LOGIN");
        loginbutton.setBounds(150, 320, 200, 50);

        loginbutton.addActionListener(ae -> {
            String user = username.getText();
            String pwd = new String(password.getPassword());

            if (user.equals("Enter Username") || user.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Empty fields detected! Please fill up all fields");
            } else if (pwd.equals("Enter Password") || pwd.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Empty fields detected! Please fill up all fields");
            } else if (user.equals("kavi") && pwd.equals("rec")) {
                JOptionPane.showMessageDialog(null, "Correct Login Credentials");
                homepageframe.setVisible(false);
                new MenuPage();
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Login Credentials");
            }
        });

        headerpanel.add(heading);
        headerpanel.add(heading1);
        wrapper.add(headerpanel);
        wrapper.add(headerpanelsh);
        loginpanel.add(loginlabel);
        loginpanel.add(username);
        loginpanel.add(password);
        loginpanel.add(loginbutton);
        wrapper.add(loginpanel);

        layeredPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(wrapper, JLayeredPane.PALETTE_LAYER);

        homepageframe.setContentPane(layeredPane);
        homepageframe.pack();

        homepageframe.setVisible(true);
    }

    public static void main(String[] args) {
        new HomePage();
    }
}

class AboutUs {
    AboutUs() {
        JFrame frame = new JFrame("About Us");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}

class ContactUs {
    ContactUs() {
        JFrame frame = new JFrame("Contact Us");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}

class MenuPage {
    private Map<Integer, Patient> patientDB = new HashMap<>();
    //private int patientIdCounter = 1;

    MenuPage() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame menuFrame = new JFrame("Menu Page");
        menuFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLayout(null);

        JPanel headerpanel = new JPanel();
        headerpanel.setLayout(null);
        headerpanel.setBounds(10, 10, screenSize.width - 20, 100);
        headerpanel.setBorder(new BevelBorder(BevelBorder.RAISED));
        headerpanel.setBackground(Color.WHITE);

        JLabel heading = new JLabel("K116 Hospital Management System");
        Font font = new Font("Garamond", Font.BOLD, 40);
        heading.setFont(font);
        heading.setForeground(new Color(0, 126, 112));
        heading.setBounds((screenSize.width / 2) - 350, 30, 700, 45);
        headerpanel.add(heading);

        menuFrame.add(headerpanel);

        JButton patientDBButton = new JButton("Patient DB");
        patientDBButton.setBounds(100, 200, 200, 50);
        patientDBButton.addActionListener(ae -> new PatientDBPage(patientDB));
        menuFrame.add(patientDBButton);

        JButton editPatientButton = new JButton("Edit Patient");
        editPatientButton.setBounds(400, 200, 200, 50);
        editPatientButton.addActionListener(ae -> new EditPatientPage(patientDB));
        menuFrame.add(editPatientButton);

        JButton billingButton = new JButton("Billing Page");
        billingButton.setBounds(700, 200, 200, 50);
        billingButton.addActionListener(ae -> new BillingPage(patientDB));
        menuFrame.add(billingButton);

        JButton appointmentButton = new JButton("Appointment Page");
        appointmentButton.setBounds(1000, 200, 200, 50);
        appointmentButton.addActionListener(ae -> new AppointmentPage());
        menuFrame.add(appointmentButton);

        JButton generateReportButton = new JButton("Generate Report");
        generateReportButton.setBounds(1300, 200, 200, 50);
        generateReportButton.addActionListener(ae -> new GenerateReportPage(patientDB));
        menuFrame.add(generateReportButton);

        menuFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuPage());
    }
}

class PatientDBPage {
    PatientDBPage(Map<Integer, Patient> patientDB) {
        JFrame frame = new JFrame("Patient DB");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}

class EditPatientPage {
    EditPatientPage(Map<Integer, Patient> patientDB) {
        JFrame frame = new JFrame("Edit Patient");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}

class BillingPage {
    BillingPage(Map<Integer, Patient> patientDB) {
        JFrame frame = new JFrame("Billing Page");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}

class AppointmentPage {
    AppointmentPage() {
        JFrame frame = new JFrame("Appointment Page");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public Component getAppointmentPanel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAppointmentPanel'");
    }
}

class GenerateReportPage {
    GenerateReportPage(Map<Integer, Patient> patientDB) {
        JFrame frame = new JFrame("Generate Report");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}

public class Patient {
    String name;
    String address;
    String phone;
    String age;
    String illness;
    String dateOfAdmission;
    String gender;
    String doctorNote;

    public Patient(String name, String address, String phone, String age, String illness, String dateOfAdmission, String gender, String doctorNote) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.age = age;
        this.illness = illness;
        this.dateOfAdmission = dateOfAdmission;
        this.gender = gender;
        this.doctorNote = doctorNote;
    }
}
