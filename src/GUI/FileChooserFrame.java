package GUI;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.WindowEvent;
import java.io.File;

public class FileChooserFrame extends JFileChooser {

    File selected_file;

    //report -1 for errors, 0 for normal
    public int construct(){
        setSize(512,512);
        setCurrentDirectory(new File(System.getProperty("user.dir").toString() + "\\cities"));
        setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.getName().endsWith(".json");
            }

            @Override
            public String getDescription() {
                return null;
            }
        });

        int returnValue = showOpenDialog(null);

        if(returnValue == JFileChooser.APPROVE_OPTION){
            selected_file = getSelectedFile();
            if(!selected_file.exists()) {
                JOptionPane.showMessageDialog(this, "File doesn't exist.", "Message", JOptionPane.OK_OPTION);
                return -1;
            }
            System.out.println(selected_file.getName());
            setEnabled(false);
        }

        else if(returnValue == JFileChooser.CANCEL_OPTION){
            setEnabled(false);
        }

        else if(returnValue == JFileChooser.ERROR_OPTION){
            JOptionPane.showMessageDialog(this, "Illegal Option", "Message", JOptionPane.OK_OPTION);
            return -1;
        }
        return 0;
    }

}
