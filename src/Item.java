public class Item implements HitungTotalBayar {
    private String itemName;
    private double itemPrice;
    private int quantity;

    // Konstruktor
    public Item(String itemName, double itemPrice,int quantity){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.quantity = quantity;

    }

     // Implementasi metode dari interface HitungTotalBayar
    public double hitungTotalBayar(){
        return itemPrice*quantity;
    }

    // Representasi string dari objek Item
    @Override
    public String toString(){
        return "Nama Barang\t: " + itemName + "\nHarga Barang\t: " + itemPrice + "\nJumlah Beli\t: " + quantity ;
    }


    
}