import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private static final Map<String, Double> exchangeRates = new HashMap<>();
    
    static {
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.92);
        exchangeRates.put("GBP", 0.78);
        exchangeRates.put("INR", 83.0);
        exchangeRates.put("JPY", 148.5);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
    
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel amountLabel = new JLabel("Enter Amount:");
        JTextField amountField = new JTextField();
        JLabel fromLabel = new JLabel("From Currency:");
        JComboBox<String> fromCurrency = new JComboBox<>(exchangeRates.keySet().toArray(new String[0]));
        JLabel toLabel = new JLabel("To Currency:");
        JComboBox<String> toCurrency = new JComboBox<>(exchangeRates.keySet().toArray(new String[0]));
        JButton convertButton = new JButton("Convert");
        JLabel resultLabel = new JLabel("Result: ");

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    String from = (String) fromCurrency.getSelectedItem();
                    String to = (String) toCurrency.getSelectedItem();
                    
                    double convertedAmount = (amount / exchangeRates.get(from)) * exchangeRates.get(to);
                    resultLabel.setText("Result: " + String.format("%.2f", convertedAmount) + " " + to);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.add(amountLabel);
        frame.add(amountField);
        frame.add(fromLabel);
        frame.add(fromCurrency);
        frame.add(toLabel);
        frame.add(toCurrency);
        frame.add(convertButton);
        frame.add(resultLabel);

        frame.setVisible(true);
    }
}