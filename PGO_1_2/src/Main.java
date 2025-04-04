public class Main {
    public static void main(String[] args) {
        SklepKomputerowy sklep = new SklepKomputerowy();

        // Dodawanie produktów
        Produkt laptop = new Produkt(1, "Laptop Dell XPS 13", "Laptop", 4999.99, 10);
        Produkt mysz = new Produkt(2, "Mysz Logitech MX Master 3", "Akcesoria", 349.99, 30);
        sklep.dodajProdukt(laptop);
        sklep.dodajProdukt(mysz);

        // Dodawanie klientów
        Klient klient1 = new Klient(1, "Jan", "Kowalski", "jan@example.com", true);
        sklep.dodajKlienta(klient1);

        // Tworzenie zamówienia
        Produkt[] produktyZamowienia = {laptop, mysz};
        int[] ilosci = {1, 2};
        Zamowienie zamowienie1 = sklep.utworzZamowienie(klient1, produktyZamowienia, ilosci, "2023-05-01");
        zamowienie1.zastosujZnizke();
        sklep.aktualizujStanMagazynowy(zamowienie1);

        // Wyświetlanie informacji
        System.out.println("=== Informacje o zamówieniu ===");
        zamowienie1.wyswietlSzczegoly();

        System.out.println("\n=== Stan magazynu ===");
        sklep.wyswietlProduktyWKategorii("Laptop");
    }
}