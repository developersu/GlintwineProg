package glintwineprog;

import jssc.SerialPortList;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileFilter;


public class MainAppUi extends JFrame{
    private JButton selectBtn;
    private JPanel mainPanel;
    private JComboBox<String> comportCBox;
    private JButton flashButton;
    private JPanel bannerPnl;
    private JButton refreshButton;
    private JLabel payloaderNameLbl;
    private JLabel statusLbl;
    private JProgressBar progressBar;
    private JPanel statusJPanel;

    public MainAppUi(String appName){
        super(appName);
        this.setContentPane(mainPanel);

        statusJPanel.setBorder(BorderFactory.createMatteBorder(1, 0,0,0, Color.darkGray));
        progressBar.setVisible(false);
        flashButton.setEnabled(false);
        selectBtn.addActionListener(actionEvent -> {
            JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home"));
            fileChooser.setDialogTitle("Select payload");
            fileChooser.setFileFilter(new BinFileFilter());
            int retval = fileChooser.showOpenDialog(null);
            if (JFileChooser.APPROVE_OPTION == retval)
                setPayloadFile(fileChooser.getSelectedFile());
        });
        refreshButton.addActionListener(actionEvent -> refreshComPortList());
        flashButton.addActionListener(actionEvent -> flash());
        refreshComPortList();
    }

    private void setPayloadFile(File payloadFile){
        payloaderNameLbl.setText(payloadFile.getName());
        flashButton.setEnabled(true);
    }

    private void refreshComPortList(){
        comportCBox.removeAllItems();
        for (String name : SerialPortList.getPortNames())
            comportCBox.addItem(name);
    }

    private void flash(){
        // TODO
    }
}

class BinFileFilter extends javax.swing.filechooser.FileFilter implements FileFilter {

    @Override
    public boolean accept(File file) {
        if (file.isDirectory())
            return true;
        String extension = file.getName().toLowerCase().replaceAll("^.+\\.", "");
        return extension.equals("bin");
    }

    @Override
    public String getDescription() {
        return "*.bin files";
    }
}
