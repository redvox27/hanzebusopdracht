package hanze.nl.bussimulator;

import java.util.ArrayList;

public class Bericht {
    String lijnNaam;
    String eindpunt;
    String bedrijf;
    String busID;
    int tijd;
    ArrayList<ETA> ETAs;

    Bericht(String lijnNaam, String bedrijf, String busID, int tijd) {
        this.lijnNaam = lijnNaam;
        this.bedrijf = bedrijf;
        this.eindpunt = "";
        this.busID = busID;
        this.tijd = tijd;
        this.ETAs = new ArrayList<ETA>();
    }

    @Override
    public String toString() {
        return "Bericht{" +
                "lijnNaam='" + lijnNaam + '\'' +
                ", eindpunt='" + eindpunt + '\'' +
                ", bedrijf='" + bedrijf + '\'' +
                ", busID='" + busID + '\'' +
                ", tijd=" + tijd +
                ", ETAs=" + ETAs +
                '}';
    }
}
