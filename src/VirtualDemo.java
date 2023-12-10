import java.util.*;
import java.text.*;

public class VirtualDemo {
    // Define a static username and password for login
    private static final String USERNAME = "meisa";
    private static final String PASSWORD = "meisa123";
    
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean inputValid = false;
        Date hariSekarang = new Date();
        SimpleDateFormat tanggal = new SimpleDateFormat("E, dd/MM/yyyy");
        SimpleDateFormat waktu = new SimpleDateFormat("hh:mm:ss a zzz");

        // Add login and captcha logic
        if (login(scanner)) {
            String generatedCaptcha = generateCaptcha();

            do {
                try {
                    System.out.println("Captcha\t\t\t: " + generatedCaptcha);
                    System.out.print("Enter the captcha\t: ");
                    String enteredCaptcha = scanner.next();

                    if (validateCaptcha(generatedCaptcha, enteredCaptcha)) {
                        // Existing code for invoice input

                        System.out.print("Masukkan kode barang\t\t: ");
                        String nomorFaktur = scanner.next();
                
                        System.out.print("Masukkan nama pelanggan\t\t: ");
                        String namaPelanggan = scanner.next();
                
                        System.out.print("Masukkan nomor HP pelanggan\t: ");
                        String nomorHP = scanner.next();
                
                        System.out.print("Masukkan alamat pelanggan\t: ");
                        scanner.nextLine(); 
                        String alamatPelanggan = scanner.nextLine();
                
                        System.out.print("Masukkan nama barang\t\t: ");
                        String namaBarang = scanner.next();
                
                        System.out.print("Masukkan harga barang\t\t: ");
                        double hargaBarang = scanner.nextDouble();
                
                        System.out.print("Masukkan jumlah barang\t\t: ");
                        int jumlahBeli = scanner.nextInt();
                
                        // Membuat objek Invoice
                        Invoice invoice = new Invoice(nomorFaktur, namaPelanggan, nomorHP, alamatPelanggan, namaBarang, hargaBarang, jumlahBeli);
                
                        // Menampilkan detail Invoice dan total bayar
                        System.out.println("==============================================");
                        System.out.println("\t\tAB MART");
                        System.out.println("----------------------------------------------");
                        System.out.println("Tanggal\t\t: " + tanggal.format(hariSekarang));
                        System.out.println("Waktu\t\t: " + waktu.format(hariSekarang));
                        System.out.println("==============================================");
                        System.out.println("\t\tDATA PELANGGAN\t");
                        System.out.println("----------------------------------------------");
                        System.out.println(invoice);
                        System.out.println("TOTAL BAYAR\t: " + invoice.hitungTotalBayar());
                        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                        System.out.println("Kasir\t\t: MEISA");

                        inputValid = true; // If no exception occurs, exit the loop
                    } else {
                        System.out.println("Captcha is incorrect. Please try again.");
                    }
                } catch (Exception e) {
                    System.out.println("Input error \n");
                    System.out.println("====================RETRY=====================\n");
                    scanner.nextLine(); // Clear input buffer
                }
            } while (!inputValid);
        } else {
            System.out.println("Login failed. Please try again.");
        }
        scanner.close();
    }

    // Method to handle login
    private static boolean login(Scanner scanner) {
        System.out.println("====================LOGIN=====================");
        System.out.print("Enter username\t\t: ");
        String enteredUsername = scanner.next();

        System.out.print("Enter password\t\t: ");
        String enteredPassword = scanner.next();

        return USERNAME.equals(enteredUsername) && PASSWORD.equals(enteredPassword);
    }

    // Method to generate a random 4-digit captcha
    private static String generateCaptcha() {
        Random random = new Random();
        int captchaNumber = random.nextInt(9000) + 1000;
        return String.valueOf(captchaNumber);
    }

    // Method to validate the entered captcha
    private static boolean validateCaptcha(String generatedCaptcha, String enteredCaptcha) {
        return generatedCaptcha.equals(enteredCaptcha);
    }
}