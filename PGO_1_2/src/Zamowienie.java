public class Zamowienie {
    private int id;
    private Klient klient;
    private Produkt[] produkty;
    private int[] ilosci;
    private String dataZamowienia;
    private String status;

    public Zamowienie(int id, Klient klient, Produkt[] produkty, int[] ilosci, String dataZamowienia) {
        this.id = id;
        this.klient = klient;
        this.produkty = produkty;
        this.ilosci = ilosci;
        this.dataZamowienia = dataZamowienia;
        this.status = "Nowe";
    }

    // Gettery i settery
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Klient getKlient() { return klient; }
    public void setKlient(Klient klient) { this.klient = klient; }

    public Produkt[] getProdukty() { return produkty; }
    public void setProdukty(Produkt[] produkty) { this.produkty = produkty; }

    public int[] getIlosci() { return ilosci; }
    public void setIlosci(int[] ilosci) { this.ilosci = ilosci; }

    public String getDataZamowienia() { return dataZamowienia; }
    public void setDataZamowienia(String dataZamowienia) { this.dataZamowienia = dataZamowienia; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double obliczWartoscZamowienia() {
        double suma = 0;
        for (int i = 0; i < produkty.length; i++) {
            suma += produkty[i].getCena() * ilosci[i];
        }
        return suma;
    }

    public void zastosujZnizke() {
        if (klient.isCzyStaly()) {
            for (Produkt produkt : produkty) {
                produkt.setCena(produkt.getCena() * 0.9);
            }
        }
    }

    public void wyswietlSzczegoly() {
        System.out.println("Zamówienie ID: " + id);
        System.out.println("Klient: " + klient.getImie() + " " + klient.getNazwisko());
        System.out.println("Data: " + dataZamowienia);
        System.out.println("Status: " + status);
        System.out.println("Produkty:");
        for (int i = 0; i < produkty.length; i++) {
            System.out.println("- " + produkty[i].getNazwa() + " (x" + ilosci[i] + "): " + produkty[i].getCena() + " PLN");
        }
        System.out.println("Łączna wartość: " + obliczWartoscZamowienia() + " PLN");
    }
}