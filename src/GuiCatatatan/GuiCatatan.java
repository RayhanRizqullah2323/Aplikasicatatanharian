/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GuiCatatatan;

import javax.swing.*;
import java.io.*;

public class GuiCatatan {

    // Method to save the notes to a file
    public static void saveNoteToFile(String catatan, String filePath) {
        if (catatan.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Catatan kosong, tidak bisa disimpan!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(catatan);
            JOptionPane.showMessageDialog(null, "Catatan berhasil disimpan.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan catatan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to load notes from a file
    public static String loadNoteFromFile(String filePath) {
        StringBuilder catatan = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                catatan.append(line).append("\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Gagal memuat catatan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return catatan.toString();
    }

    // Method to delete the content of a note
    public static void deleteNoteContent(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("");
            JOptionPane.showMessageDialog(null, "Catatan berhasil dihapus.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Gagal menghapus catatan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to export the note content to a specified file path
    public static void exportNoteToFile(String catatan, String filePath) {
        if (catatan.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tidak ada catatan untuk diekspor!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(catatan);
            JOptionPane.showMessageDialog(null, "Catatan berhasil diekspor ke: " + filePath);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengekspor catatan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
