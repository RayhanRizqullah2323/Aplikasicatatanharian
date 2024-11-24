# Aplikasicatatanharian
 Muhammad Rayhan Rizqullah-2210010489-UTS

Tugas UTS Aplikas Catatan Harian

Tambahkan baru
Suntinglah
Menghapus
Simpan catatan ke teks
Ekspor tidak ada
Aplikasi ini menggunakan antarmuka pengguna grafis (GUI) yang dibangun dengan komponen Swing dan mengintegrasikan pemilih tanggal untuk menambahkan catatan terkait tanggal.

Fitur
Simpan Catatan : Simpan entricatatan.txt).
Edit Catatan : Muat dan ubah catatan yang ada dari
Hapus Catatan : Hapus semua yang tidak
Catatan Ekspor : Simpan catatan.txtformat.
Pemilihan Tanggal : Kami
Bagian Memo: Tambahkan memo berbasis teks ke aplikasi
Memerlukan
Jawa :
Perpustakaan :
Swing : Bahasa pemrograman bawaan Java
JDateChooser : GunakanUnduh di sini .
Instalasi
Langkah 1: Unduh S
Klon repositori atau unduh GuiCatatanHariankode sumber.

Langkah 2: S
Pastikan Anda memiliki lingkungan Java yang diperlukan. Anda dapat menyiapkan proyek dengan membuka sumbernya

Langkah 3: A
Pastikan Anda menambahkan JDateChooserlibr).

Langkah 4: Jalankan
Setelah melakukan pengaturan, jalankan saja GuiCatatanHarian.javafile dari I Anda

Bagaimana
Simpan Catatan : Masukkan teks
Catatan Beban : Klik "Ubah/catatan.txtmengajukan.
Hapus Catatan : Klik "D
Catatan Ekspor : Klik "Kirim/Ekspor" untuk mengekspor
Penjelasan Kode
Komponen GUI : GUI adalah cJTextArea, 'J'JButton, JLabel, dan JFileChooser. Ini memungkinkan
Operasi File : Catatan disimpan dan dimuatcatatan.txt), dan diekspor ke au
JDateChooser : Komponen ini
Contoh Screenshot
Sisipkan gambar tangkapan layar di sini untuk memperlihatkan antarmuka pengguna.

Peningkatan di Masa Depan
Menerapkan kemampuan melaut
Tambahkan dukungan untuk beberapa kategori catatan.
Meningkatkan penanganan kesalahan
Terapkan enkripsi untuk catatan sensitif.

Penjelasan Per Bagian
1. Impor Perpustakaan
Jawa

Salin kode
import GuiCatatatan.GuiCatatan;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import com.toedter.calendar.JDateChooser;
GuiCatatatan.GuiCatatan: Mengimpor kelas GUI terkait, jika ada.
javax.swing.*: Digunakan untuk komponen GUI seperti JFrame, JTextArea, JButton, dll.
java.awt.event.*: Mengatur event listener untuk aksi tombol dan komponen.
java.io.*: Digunakan untuk operasi file seperti membaca atau menulis catatan.
com.toedter.calendar.JDateChooser: Perpustakaan I
2. Kelas GuiCatatanHarian
Kelas ini adalah turunan dari javax.swing.JFrame dan merupakan kerangka utama aplikasi.

3. Atribut dan Komponen
JTextArea jTextAreaCatatan: Area teks tempat pengguna menulis catatan.
JFileChooser jFileChooser1: Komponen untuk memilih file atau lokasi penyimpanan file.
JDateChooser jDateChooser1: Menggabungkan
Tombol:
Simpan: Untuk makan
Ubah: Untuk memuat catatan yang disimpan ke dalam aplikasi.
Hapus: Untuk menghapus isi catatan.
Kirim/Export: Untuk menyimpan catatan ke file yang dipilih oleh pengguna.
4. Konstruktor
Jawa

Salin kode
public GuiCatatanHarian() {
    initComponents();
    
    jTextAreaCatatan = new JTextArea();
    jTextAreaCatatan.setWrapStyleWord(true);

    JScrollPane scrollPane = new JScrollPane(jTextAreaCatatan);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    jPanel1.add(scrollPane);
}
Memanggil initComponents() untuk menginisialisasi komponen GUI.
Membuat JTextArea dengan pengaturan agar teks terbungkus kata.
Menambahkan JScrollPane agar area teks memiliki scroll.
5. Metode initComponents()
Metode ini mengatur tata letak GUI menggunakan Swing. Di sini, semua komponen seperti tombol, panel, label, dan text area diatur posisi dan properti visualnya.

6. Fungsi Tombol
Tombol Simpan

Jawa

Salin kode
private void button1ActionPerformed(java.awt.event.ActionEvent evt) {
    String catatan = jTextAreaCatatan.getText().trim();
    if (catatan.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Catatan kosong, tidak bisa disimpan!", "Peringatan", JOptionPane.WARNING_MESSAGE);
    } else {
        String filePath = "catatan.txt";
        saveNoteToFile(catatan, filePath);
        JOptionPane.showMessageDialog(this, "Catatan berhasil disimpan!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
    }
}
Memeriksa apakah area catatan kosong.
Jika ada teks, menyimpan catatan ke file catatan.txt.
Tombol Ubah

Jawa

Salin kode
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    try (BufferedReader reader = new BufferedReader(new FileReader("catatan.txt"))) {
        jTextAreaCatatan.setText(""); 
        String baris;
        while ((baris = reader.readLine()) != null) {
            jTextAreaCatatan.append(baris + "\n");
        }
        JOptionPane.showMessageDialog(this, "Catatan berhasil dimuat!");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "File catatan tidak ditemukan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
Membaca file catatan.txt menggunakan BufferedReader.
Menampilkan isi file ke dalam area catatan.
Tombol Hapus

Jawa

Salin kode
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    if (jTextAreaCatatan.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Tidak ada catatan untuk dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
    } else {
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus catatan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            jTextAreaCatatan.setText("");
            JOptionPane.showMessageDialog(this, "Catatan berhasil dihapus.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
Memastikan pengguna yakin sebelum menghapus catatan.
Jika disetujui, teks dihapus dari area catatan.
Tombol Kirim/Export

Jawa

Salin kode
private void button2ActionPerformed(java.awt.event.ActionEvent evt) {
    JFileChooser fileChooser = new JFileChooser();
    int userSelection = fileChooser.showSaveDialog(this);

    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToSave = fileChooser.getSelectedFile();
        if (!fileToSave.getName().endsWith(".txt")) {
            fileToSave = new File(fileToSave.getAbsolutePath() + ".txt");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
            String text = jTextAreaCatatan.getText();
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tidak ada data untuk diekspor!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            writer.write(text);
            JOptionPane.showMessageDialog(this, "Catatan berhasil diekspor ke: " + fileToSave.getAbsolutePath());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
            JOpt
this, "Gagal mengekspor catatan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
Menampilkan JFileChooser untuk memilih lokasi penyimpanan.
Mengekspor catatan ke file yang dipilih.
7. Metode Utama
Jawa

Salin kode
public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(() -> {
        
    java.awt.EventQueue.invokeLater(()

    jav
new GuiCatatanHarian().setVisible(true);
    });
}

    })
Memastikan aplikasi berjalan menggunakan Event Dispatch Thread (EDT) untuk thread-safe.
Membuat instance GuiCatatanHarian dan menampilkannya.
Fitur yang Diterapkan
CRUD (Create, Read, Update, Delete) untuk catatan.
Ekspor File menggunakan
JCalendar Integration untuk tanggal.
Swing untuk desain GUI.


Pembuat 
Muhammad Rayhan Rizqullah
NPM
2210010489
Kelas 5A Reg pagi BJM
