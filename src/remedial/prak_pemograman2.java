package remedial;

	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class prak_pemograman2 extends JFrame {

	    private JTextField textFieldNama, textFieldNomorHP;
	    private JRadioButton radioButtonLaki, radioButtonPerempuan;
	    private JTextArea textAreaAlamat;

	    public prak_pemograman2() {
	        // Setup frame
	        setTitle("Aplikasi Biodata");
	        setSize(400, 300);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);

	        // Create components
	        JLabel labelNama = new JLabel("Nama:");
	        textFieldNama = new JTextField(20);

	        JLabel labelJenisKelamin = new JLabel("Jenis Kelamin:");
	        radioButtonLaki = new JRadioButton("Laki-laki");
	        radioButtonPerempuan = new JRadioButton("Perempuan");
	        ButtonGroup groupJenisKelamin = new ButtonGroup();
	        groupJenisKelamin.add(radioButtonLaki);
	        groupJenisKelamin.add(radioButtonPerempuan);

	        JLabel labelNomorHP = new JLabel("Nomor HP:");
	        textFieldNomorHP = new JTextField(20);

	        JLabel labelAlamat = new JLabel("Alamat:");
	        textAreaAlamat = new JTextArea(5, 20);
	        JScrollPane scrollPane = new JScrollPane(textAreaAlamat);

	        JButton buttonSimpan = new JButton("Simpan");
	        buttonSimpan.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                simpanBiodata();
	            }
	        });

	        // Set layout
	        setLayout(new GridBagLayout());
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.anchor = GridBagConstraints.WEST;

	        // Add components to the frame
	        add(labelNama, gbc);
	        gbc.gridy++;
	        add(textFieldNama, gbc);
	        gbc.gridy++;
	        add(labelJenisKelamin, gbc);
	        gbc.gridy++;
	        add(radioButtonLaki, gbc);
	        gbc.gridy++;
	        add(radioButtonPerempuan, gbc);
	        gbc.gridy++;
	        add(labelNomorHP, gbc);
	        gbc.gridy++;
	        add(textFieldNomorHP, gbc);
	        gbc.gridy++;
	        add(labelAlamat, gbc);
	        gbc.gridy++;
	        add(scrollPane, gbc);
	        gbc.gridy++;
	        add(buttonSimpan, gbc);

	        // Display the frame
	        setVisible(true);
	    }

	    private void simpanBiodata() {
	        // Validasi data
	        if (textFieldNama.getText().isEmpty() || (!radioButtonLaki.isSelected() && !radioButtonPerempuan.isSelected())
	                || textFieldNomorHP.getText().isEmpty() || textAreaAlamat.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Semua data harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
	        } else {
	            // Konfirmasi sebelum simpan
	            int result = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menyimpan biodata?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
	            if (result == JOptionPane.YES_OPTION) {
	                // Proses penyimpanan data (bisa disesuaikan dengan kebutuhan)
	                String nama = textFieldNama.getText();
	                String jenisKelamin = radioButtonLaki.isSelected() ? "Laki-laki" : "Perempuan";
	                String nomorHP = textFieldNomorHP.getText();
	                String alamat = textAreaAlamat.getText();

	            
	                // Setelah penyimpanan berhasil
	                JOptionPane.showMessageDialog(this, "Biodata berhasil disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);

	                // Reset input fields
	                textFieldNama.setText("");
	                radioButtonLaki.setSelected(false);
	                radioButtonPerempuan.setSelected(false);
	                textFieldNomorHP.setText("");
	                textAreaAlamat.setText("");
	            }
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new prak_pemograman2();
	            }
	        });
	    }
	}