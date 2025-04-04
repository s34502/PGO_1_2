public class SklepKomputerowy {
    private Produkt[] produkty = new Produkt[100];
    private Klient[] klienci = new Klient[100];
    private Zamowienie[] zamowienia = new Zamowienie[100];
    private int liczbaProduktow = 0;
    private int liczbaKlientow = 0;
    private int liczbaZamowien = 0;

    public void dodajProdukt(Produkt produkt) {
        produkty[liczbaProduktow++] = produkt;
    }

    public void dodajKlienta(Klient klient) {
        klienci[liczbaKlientow++] = klient;
    }

    public Zamowienie utworzZamowienie(Klient klient, Produkt[] produkty, int[] ilosci, String data) {
        Zamowienie zamowienie = new Zamowienie(liczbaZamowien + 1, klient, produkty, ilosci, data);
        zamowienia[liczbaZamowien++] = zamowienie;
        return zamowienie;
    }

    public void aktualizujStanMagazynowy(Zamowienie zamowienie) {
        Produkt[] produktyZamowienia = zamowienie.getProdukty();
        int[] ilosci = zamowienie.getIlosci();

        for (int i = 0; i < produktyZamowienia.length; i++) {
            Produkt produkt = produktyZamowienia[i];
            produkt.setIloscWMagazynie(produkt.getIloscWMagazynie() - ilosci[i]);
        }
    }

    public void zmienStatusZamowienia(int idZamowienia, String nowyStatus) {
        for (Zamowienie zamowienie : zamowienia) {
            if (zamowienie != null && zamowienie.getId() == idZamowienia) {
                zamowienie.setStatus(nowyStatus);
                break;
            }
        }
    }

    public void wyswietlProduktyWKategorii(String kategoria) {
        System.out.println("Produkty w kategorii '" + kategoria + "':");
        for (Produkt produkt : produkty) {
            if (produkt != null && produkt.getKategoria().equalsIgnoreCase(kategoria)) {
                produkt.wyswietlInformacje();
                System.out.println("----------");
            }
        }
    }

    public void wyswietlZamowieniaKlienta(int idKlienta) {
        System.out.println("Zamówienia klienta ID " + idKlienta + ":");
        for (Zamowienie zamowienie : zamowienia) {
            if (zamowienie != null && zamowienie.getKlient().getId() == idKlienta) {
                zamowienie.wyswietlSzczegoly();
                System.out.println("----------");
            }
        }
    }
}