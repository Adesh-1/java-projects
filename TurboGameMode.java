// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;

// public class TurboGameMode extends JFrame {
//     private boolean turboEnabled = false;
//     private JLabel statusLabel;
//     private JButton toggleButton;

//     public TurboGameMode() {
//         setTitle("Turbo Game Mode");
//         setSize(400, 200);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLayout(new BorderLayout());

//         // Header Label
//         JLabel titleLabel = new JLabel("Turbo Game Mode", SwingConstants.CENTER);
//         titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
//         add(titleLabel, BorderLayout.NORTH);

//         // Status Label
//         statusLabel = new JLabel("Status: OFF", SwingConstants.CENTER);
//         statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
//         add(statusLabel, BorderLayout.CENTER);

//         // Toggle Button
//         toggleButton = new JButton("Enable Turbo Mode");
//         toggleButton.setFont(new Font("Arial", Font.BOLD, 14));
//         toggleButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 toggleTurboMode();
//             }
//         });
//         add(toggleButton, BorderLayout.SOUTH);

//         setVisible(true);
//     }

//     private void toggleTurboMode() {
//         turboEnabled = !turboEnabled;
//         if (turboEnabled) {
//             enableTurboMode();
//         } else {
//             disableTurboMode();
//         }
//         updateUI();
//     }

//     private void updateUI() {
//         statusLabel.setText("Status: " + (turboEnabled ? "ON" : "OFF"));
//         toggleButton.setText(turboEnabled ? "Disable Turbo Mode" : "Enable Turbo Mode");
//     }

//     private void enableTurboMode() {
//         String os = System.getProperty("os.name").toLowerCase();
//         try {
//             if (os.contains("win")) {
//                 // Windows command to enable high-performance mode
//                 executeCommand("powercfg /setactive SCHEME_MIN");
//             } else if (os.contains("linux")) {
//                 // Linux command to enable performance governor
//                 executeCommand("echo performance | sudo tee /sys/devices/system/cpu/cpu*/cpufreq/scaling_governor");
//             }
//             System.out.println("Turbo Mode Enabled!");
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     private void disableTurboMode() {
//         String os = System.getProperty("os.name").toLowerCase();
//         try {
//             if (os.contains("win")) {
//                 // Windows command to restore balanced mode
//                 executeCommand("powercfg /setactive SCHEME_BALANCED");
//             } else if (os.contains("linux")) {
//                 // Linux command to restore powersave mode
//                 executeCommand("echo powersave | sudo tee /sys/devices/system/cpu/cpu*/cpufreq/scaling_governor");
//             }
//             System.out.println("Turbo Mode Disabled!");
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     private void executeCommand(String command) throws IOException {
//         Process process = Runtime.getRuntime().exec(command);
//         BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//         String line;
//         while ((line = reader.readLine()) != null) {
//             System.out.println(line);
//         }
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(TurboGameMode::new);
//     }
// }
