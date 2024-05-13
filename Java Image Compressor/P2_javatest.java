import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.management.loading.MLet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class P2_javatest extends JFrame implements ActionListener {// main

    JButton output;
    JButton input;
    JTextField select;
    File filec2;
    JTextField select2;
    File save2;
    JButton compress;
    JTextField select3;
    JPanel bottomcon;
    JLabel text5;
    JLabel text6;

    P2_javatest() { // fucntion 
        ImageIcon icon = new ImageIcon("ITE186.png");

        ImageIcon logo = new ImageIcon("ITE186logo.png");
        // This create a screen
        this.setTitle("Image Compressor");
        this.setSize(900, 500);
        this.setResizable(false);
        this.setLayout(null);

        JLabel mylebel = new JLabel();// create a label like set a text
        mylebel.setText("Image Compressor");
        mylebel.setIcon(logo);
        mylebel.setFont(new Font("MV Boli", Font.BOLD, 20));
        mylebel.setIconTextGap(20);
        mylebel.setOpaque(true);
        mylebel.setForeground(new Color(0xffffff));
        mylebel.setBackground(new Color(0x75a4c5));
        mylebel.setBounds(20, 10, 800, 75);

        JPanel topcon = new JPanel();
        topcon.setForeground(new Color(0xffffff));
        topcon.setBackground(new Color(0x75a4c5));
        topcon.setBounds(0, 0, 900, 100);
        topcon.setLayout(null);
        /// this line for input file
        this.add(topcon);
        topcon.add(mylebel);

        JLabel text1 = new JLabel("Select");
        text1.setFont(new Font("MV Boli", Font.BOLD, 20));
        text1.setForeground(new Color(0xffffff));
        text1.setBounds(30, 147, 550, 30);

        select = new JTextField();
        select.setPreferredSize(new Dimension(250, 30));
        select.setBounds(100, 150, 550, 30);

        input = new JButton("browser");
        input.setBounds(725, 150, 80, 30);
        input.addActionListener(this);

        /// This line for save file

        JLabel text2 = new JLabel("Save");
        text2.setFont(new Font("MV Boli", Font.BOLD, 20));
        text2.setForeground(new Color(0xffffff));
        text2.setBounds(35, 222, 550, 30);
        this.add(text2);

        select2 = new JTextField();
        select2.setPreferredSize(new Dimension(250, 30));
        select2.setBounds(100, 225, 550, 30);
        this.add(select2);

        output = new JButton("Save");
        output.setBounds(725, 225, 80, 30);
        output.addActionListener(this);
        this.add(output);

        // this line for ratio and compress

        JLabel text3 = new JLabel("Enter Ratio");
        text3.setFont(new Font("MV Boli", Font.BOLD, 20));
        text3.setForeground(new Color(0xffffff));
        text3.setBounds(15, 300, 550, 30);
        this.add(text3);

        JLabel text4 = new JLabel("1.0 max - 0.1 min");
        text4.setFont(new Font("MV Boli", Font.BOLD, 20));
        text4.setForeground(new Color(0xffffff));
        text4.setBounds(150, 330, 550, 30);
        this.add(text4);

        select3 = new JTextField();
        select3.setPreferredSize(new Dimension(250, 30));
        select3.setBounds(150, 300, 200, 30);
        this.add(select3);

        compress = new JButton("Compress");
        compress.setBounds(635, 290, 100, 50);
        compress.addActionListener(this);
        this.add(compress);

        text5 = new JLabel("Compressing Complete");
        text5.setFont(new Font("MV Boli", Font.BOLD, 20));
        text5.setForeground(new Color(0xffffff));
        text5.setBounds(30, 10, 550, 30);

        text6 = new JLabel("Can't read input file!");
        text6.setFont(new Font("MV Boli", Font.BOLD, 20));
        text6.setForeground(new Color(0xffffff));
        text6.setBounds(30, 10, 550, 30);

        bottomcon = new JPanel();
        bottomcon.setForeground(new Color(0xffffff));
        bottomcon.setBackground(new Color(0x75a4c5));
        bottomcon.setBounds(0, 410, 900, 70);
        bottomcon.setLayout(null);

        // design
        this.getContentPane().setBackground(new Color(0x1b4769));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// this to exit an application
        this.setVisible(true); // to show a screen
        /// the fallowing line this to show in the screen
        this.setIconImage(icon.getImage());
        this.add(select);
        this.add(text1);
        this.add(input);

    }

    @Override
    public void actionPerformed(ActionEvent e) { //main even
        if (e.getSource() == input) {
            JFileChooser file = new JFileChooser();
            int myfile = file.showOpenDialog(null);

            if (myfile == JFileChooser.APPROVE_OPTION) {
                File get_file = new File(file.getSelectedFile().getAbsolutePath());
                select.setText(get_file.toString());
                String file_change = select.getText();
                String filec = file_change.replaceAll("\\\\", "\\\\\\\\");
                filec2 = new File(filec);
                System.out.println(filec);

            }
        }

        if (e.getSource() == output) {
            JFileChooser file2 = new JFileChooser();
            int myfile2 = file2.showSaveDialog(null);

            if (myfile2 == JFileChooser.APPROVE_OPTION) {
                File get_file2 = new File(file2.getSelectedFile().getAbsolutePath());
                select2.setText(get_file2.toString());
                String file_change2 = select2.getText();
                String save = file_change2.replaceAll("\\\\", "\\\\\\\\");
                System.out.println(save);
                save2 = new File(save);
            }
        }
        if (e.getSource() == compress) {
            String value = select3.getText();
            Float value_f = Float.parseFloat(value);
            try {
                ImageCompressor(filec2, save2, value_f);
                System.out.print(value_f);
                System.out.print("done");
                this.add(bottomcon);
                bottomcon.add(text5);
            } catch (IOException e1) {
                e1.printStackTrace();
                this.add(bottomcon);
                bottomcon.add(text6);
                System.out.print("try");
            }
        }
    }

    public static void ImageCompressor(File originalI, File compressI, float Quality) throws IOException {
        RenderedImage Oimage = ImageIO.read(originalI);
        ImageWriter jpegW = ImageIO.getImageWritersByFormatName("jpg").next();
        ImageWriteParam jpegWP = jpegW.getDefaultWriteParam();
        jpegWP.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        jpegWP.setCompressionQuality(Quality);

        try (ImageOutputStream output = ImageIO.createImageOutputStream(compressI)) {
            jpegW.setOutput(output);
            IIOImage outpuI = new IIOImage(Oimage, null, null);
            jpegW.write(null, outpuI, jpegWP);
        }
        jpegW.dispose();
    }
}
