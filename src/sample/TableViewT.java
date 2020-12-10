package sample;

import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.bazy.*;
import java.sql.Date;
import java.sql.SQLException;

public class TableViewT {
    private static DbAccess db_access;

    static {
        try {
            db_access = new DbAccess();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public static javafx.scene.control.TableView<Klient> getTableKlient() throws SQLException {
        TableView<Klient> table = new TableView<>();
        table.setPrefHeight(700.0);
        ObservableList<Klient> data = db_access.loadKlient();

        TableColumn<Klient, Integer> id_col = new TableColumn<>("ID");
        id_col.setResizable(false);
        id_col.setPrefWidth(50);
        id_col.setCellValueFactory(
                new PropertyValueFactory<>("id_klienta")
        );
        TableColumn<Klient, String> naz_col = new TableColumn<>("Nazwisko");
        naz_col.setResizable(false);
        naz_col.setPrefWidth(400);
        naz_col.setCellValueFactory(
                new PropertyValueFactory<>("nazwisko")
        );
        TableColumn<Klient, String> imie_col = new TableColumn<>("Imię");
        imie_col.setResizable(false);
        imie_col.setPrefWidth(150);
        imie_col.setCellValueFactory(
                new PropertyValueFactory<>("imie")
        );
        TableColumn<Klient, String> firma_col = new TableColumn<>("Firma");
        firma_col.setResizable(false);
        firma_col.setPrefWidth(100);
        firma_col.setCellValueFactory(
                new PropertyValueFactory<>("nazwa_firmy")
        );
        TableColumn<Klient, String> miasto_col = new TableColumn<>("Miasto");
        miasto_col.setResizable(false);
        miasto_col.setPrefWidth(150);
        miasto_col.setCellValueFactory(
                new PropertyValueFactory<>("miasto")
        );
        TableColumn<Klient, String> ulica_col = new TableColumn<>("Ulica, nr domu");
        ulica_col.setResizable(false);
        ulica_col.setPrefWidth(100);
        ulica_col.setCellValueFactory(
                new PropertyValueFactory<>("ulica_nr_domu")
        );
        TableColumn<Klient, Button> edit_col = new TableColumn<>("Edytuj");
        edit_col.setResizable(false);
        edit_col.setPrefWidth(49);
        edit_col.setCellValueFactory(
                new PropertyValueFactory<>("edit")
        );
        TableColumn<Klient, Button> del_col = new TableColumn<>("Usuń");
        del_col.setResizable(false);
        del_col.setPrefWidth(49);
        del_col.setCellValueFactory(
                new PropertyValueFactory<>("delete")
        );

        table.setItems(data);
        table.getColumns().addAll(id_col, naz_col, imie_col, firma_col, miasto_col, ulica_col, edit_col, del_col);
        return table;
    }

    public static javafx.scene.control.TableView<Pracownik> getTablePracownik() throws SQLException {
        TableView<Pracownik> table = new TableView<>();
        table.setPrefHeight(700.0);
        ObservableList<Pracownik> data = db_access.loadPracownik();

        TableColumn<Pracownik, Integer> id_col = new TableColumn<>("ID");
        id_col.setResizable(false);
        id_col.setPrefWidth(50);
        id_col.setCellValueFactory(
                new PropertyValueFactory<>("id_pracownika")
        );
        TableColumn<Pracownik, Integer> id_stan_col = new TableColumn<>("ID stanowiska");
        id_stan_col.setResizable(false);
        id_stan_col.setPrefWidth(50);
        id_stan_col.setCellValueFactory(
                new PropertyValueFactory<>("id_stanowiska")
        );
        TableColumn<Pracownik, Integer> naz_col = new TableColumn<>("Nazwisko");
        naz_col.setResizable(false);
        naz_col.setPrefWidth(224);
        naz_col.setCellValueFactory(
                new PropertyValueFactory<>("nazwisko")
        );
        TableColumn<Pracownik, String> imie_col = new TableColumn<>("Imię");
        imie_col.setResizable(false);
        imie_col.setPrefWidth(225);
        imie_col.setCellValueFactory(
                new PropertyValueFactory<>("imie")
        );
        TableColumn<Pracownik, Date> data_zatr_col = new TableColumn<>("Data zatrudnienia");
        data_zatr_col.setResizable(false);
        data_zatr_col.setPrefWidth(150);
        data_zatr_col.setCellValueFactory(
                new PropertyValueFactory<>("data_zatrudnienia")
        );
        TableColumn<Pracownik, Date> data_zwol_col = new TableColumn<>("Data zwolnienia");
        data_zwol_col.setResizable(false);
        data_zwol_col.setPrefWidth(150);
        data_zwol_col.setCellValueFactory(
                new PropertyValueFactory<>("data_zwolnienia")
        );
        TableColumn<Pracownik, Float> wynagr_col = new TableColumn<>("Wynagrodzenie");
        wynagr_col.setResizable(false);
        wynagr_col.setPrefWidth(150);
        wynagr_col.setCellValueFactory(
                new PropertyValueFactory<>("wynagrodzenie")
        );
        TableColumn<Pracownik, Button> edit_col = new TableColumn<>("Edytuj");
        edit_col.setResizable(false);
        edit_col.setPrefWidth(49);
        edit_col.setCellValueFactory(
                new PropertyValueFactory<>("edit")
        );

        table.setItems(data);
        table.getColumns().addAll(id_col, id_stan_col, naz_col, imie_col, data_zatr_col, data_zwol_col, wynagr_col, edit_col);
        return table;
    }

    public static javafx.scene.control.TableView<Stanowisko> getTableStanowisko() throws SQLException {
        TableView<Stanowisko> table = new TableView<>();
        table.setPrefHeight(700.0);
        ObservableList<Stanowisko> data = db_access.loadStanowisko();

        TableColumn<Stanowisko, Integer> id_col = new TableColumn<>("ID");
        id_col.setResizable(false);
        id_col.setPrefWidth(50);
        id_col.setCellValueFactory(
                new PropertyValueFactory<>("id_stanowiska")
        );
        TableColumn<Stanowisko, String> naz_col = new TableColumn<>("Nazwa");
        naz_col.setResizable(false);
        naz_col.setPrefWidth(949);
        naz_col.setCellValueFactory(
                new PropertyValueFactory<>("nazwa")
        );
        TableColumn<Stanowisko, Button> edit_col = new TableColumn<>("Edytuj");
        edit_col.setResizable(false);
        edit_col.setPrefWidth(49);
        edit_col.setCellValueFactory(
                new PropertyValueFactory<>("edit")
        );
        TableColumn<Zamowienie, Integer> real_col = new TableColumn<>("Zrealizowano");
        real_col.setMinWidth(100);

        table.setItems(data);
        table.getColumns().addAll(id_col, naz_col, edit_col);
        return table;
    }

    public static javafx.scene.control.TableView<Usluga> getTableUsluga() throws SQLException {
        TableView<Usluga> table = new TableView<>();
        table.setPrefHeight(700.0);
        ObservableList<Usluga> data = db_access.loadUsluga();

        TableColumn<Usluga, Integer> id_col = new TableColumn<>("ID");
        id_col.setResizable(false);
        id_col.setPrefWidth(50);
        id_col.setCellValueFactory(
                new PropertyValueFactory<>("id_uslugi")
        );
        TableColumn<Usluga, String> naz_col = new TableColumn<>("Nazwa");
        naz_col.setResizable(false);
        naz_col.setPrefWidth(849);
        naz_col.setCellValueFactory(
                new PropertyValueFactory<>("nazwa")
        );
        TableColumn<Usluga, Float> cena_col = new TableColumn<>("Cena");
        cena_col.setResizable(false);
        cena_col.setPrefWidth(100);
        cena_col.setCellValueFactory(
                new PropertyValueFactory<>("cena")
        );
        TableColumn<Usluga, Button> edit_col = new TableColumn<>("Edytuj");
        edit_col.setResizable(false);
        edit_col.setPrefWidth(49);
        edit_col.setCellValueFactory(
                new PropertyValueFactory<>("edit")
        );

        table.setItems(data);
        table.getColumns().addAll(id_col, naz_col, cena_col, edit_col);
        return table;
    }

    public static TableView<Zamowienie> getTableZamowienie() throws SQLException {
        TableView<Zamowienie> table = new TableView<>();
        table.setPrefHeight(700.0);
        ObservableList<Zamowienie> data = db_access.loadZamowienie();

        TableColumn<Zamowienie, Integer> id_col = new TableColumn<>("ID");
        id_col.setResizable(false);
        id_col.setPrefWidth(142);
        id_col.setCellValueFactory(
                new PropertyValueFactory<>("id_zamowienia")
        );
        TableColumn<Zamowienie, Integer> id_kl_col = new TableColumn<>("ID klienta");
        id_kl_col.setResizable(false);
        id_kl_col.setPrefWidth(142);
        id_kl_col.setCellValueFactory(
                new PropertyValueFactory<>("id_klienta")
        );
        TableColumn<Zamowienie, Integer> id_prac_col = new TableColumn<>("ID pracownika");
        id_prac_col.setResizable(false);
        id_prac_col.setPrefWidth(142);
        id_prac_col.setCellValueFactory(
                new PropertyValueFactory<>("id_pracownika")
        );
        TableColumn<Zamowienie, Integer> id_usl_col = new TableColumn<>("ID usługi");
        id_usl_col.setResizable(false);
        id_usl_col.setPrefWidth(143);
        id_usl_col.setCellValueFactory(
                new PropertyValueFactory<>("id_uslugi")
        );
        TableColumn<Zamowienie, Date> data_zam_col = new TableColumn<>("Data zamówienia");
        data_zam_col.setResizable(false);
        data_zam_col.setPrefWidth(143);
        data_zam_col.setCellValueFactory(
                new PropertyValueFactory<>("data_zamowienia")
        );
        TableColumn<Zamowienie, Date> data_real_col = new TableColumn<>("Data realizacji");
        data_real_col.setResizable(false);
        data_real_col.setPrefWidth(143);
        data_real_col.setCellValueFactory(
                new PropertyValueFactory<>("data_realizacji")
        );
        TableColumn<Zamowienie, Integer> real_col = new TableColumn<>("Zrealizowano");
        real_col.setResizable(false);
        real_col.setPrefWidth(144);
        real_col.setCellValueFactory(
                new PropertyValueFactory<>("zrealizowano")
        );
        TableColumn<Zamowienie, Button> edit_col = new TableColumn<>("Edytuj");
        edit_col.setResizable(false);
        edit_col.setPrefWidth(49);
        edit_col.setCellValueFactory(
                new PropertyValueFactory<>("edit")
        );
        TableColumn<Zamowienie, Button> del_col = new TableColumn<>("Usuń");
        del_col.setResizable(false);
        del_col.setPrefWidth(49);
        del_col.setCellValueFactory(
                new PropertyValueFactory<>("delete")
        );


        table.setItems(data);
        table.getColumns().addAll(id_col, id_kl_col, id_prac_col, id_usl_col, data_zam_col, data_real_col, real_col, edit_col, del_col);
        return table;
    }
}