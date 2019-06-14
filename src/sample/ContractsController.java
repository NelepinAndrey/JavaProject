package sample;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;
import java.util.ResourceBundle;

public class ContractsController implements Initializable {

    @FXML
    private TableColumn<Contracts, String> note;

    @FXML
    private TableColumn<Contracts, String> the_claim_filing_date;

    @FXML
    private TableColumn<Contracts, String> meeting_stage;

    @FXML
    private TableView<Contracts> tableContracts;

    @FXML
    private TableColumn<Contracts, String> date_of_court_hearing;

    @FXML
    private TableColumn<Contracts, String> court_number;

    @FXML
    private TableColumn<Contracts, String> a_sign_of_special_importance;

    @FXML
    private TableColumn<Contracts, String> amount_payable;

    @FXML
    private TableColumn<Contracts, String> subject_email;

    @FXML
    private TableColumn<Contracts, String> executor;

    @FXML
    private TableColumn<Contracts, String> subject_tin;

    @FXML
    private TableColumn<Contracts, String> outgoing_number;

    @FXML
    private TableColumn<Contracts, String> effective_date;

    @FXML
    private TableColumn<Contracts, String> contract_details;

    @FXML
    private TableColumn<Contracts, String> pretension_date;

    @FXML
    private TableColumn<Contracts, String> state_of_pretension;

    @FXML
    private TableColumn<Contracts, String> type_of_claim;

    @FXML
    private TableColumn<Contracts, String> details_of_the_pretension;

    @FXML
    private TableColumn<Contracts, String> court_name;

    @FXML
    private TableColumn<Contracts, String> id_contracts;

    @FXML
    private TableColumn<Contracts, String> payment_term;

    @FXML
    private TableColumn<Contracts, String> subject_of_the_contract;

    @FXML
    private TableColumn<Contracts, String> contract_object;

    @FXML
    private TextField searchfield;

    @FXML
    private TableColumn<Contracts, String> state_of_claim;

    @FXML
    private TableColumn<Contracts, String> case_status;

    @FXML
    private TableColumn<Contracts, String> subject_name;

    @FXML
    private TableColumn<Contracts, String> the_courts_decision;

    @FXML
    private TableColumn<Contracts, String> full_name_of_judge;

    ObservableList<Contracts> oblist = FXCollections.observableArrayList();
    ListView list = new ListView();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Connection con = null;
        try {
            con = DatabaseHandler.getDbConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet rs = null;
        try {
            rs = con.createStatement().executeQuery("select * from table_for_signup.contracts");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                oblist.add(new Contracts(rs.getString("executor"), rs.getString("subject_name"), rs.getString("subject_tin"),
                        rs.getString("subject_email"), rs.getString("contract_details"), rs.getString("subject_of_the_contract"), rs.getString("contract_object")
                        , rs.getString("case_status"), rs.getString("details_of_the_pretension"), rs.getString("pretension_date"), rs.getString("payment_term"),
                        rs.getString("amount_payable"), rs.getString("state_of_pretension"), rs.getString("type_of_claim"), rs.getString("a_sign_of_special_importance"),
                        rs.getString("the_claim_filing_date"), rs.getString("outgoing_number"), rs.getString("state_of_claim"), rs.getString("date_of_court_hearing"),
                        rs.getString("court_name"), rs.getString("court_number"), rs.getString("full_name_of_judge"), rs.getString("meeting_stage"),
                        rs.getString("the_courts_decision"), rs.getString("effective_date"), rs.getString("note")));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        executor.setCellValueFactory(new PropertyValueFactory<>("executor"));
        subject_name.setCellValueFactory(new PropertyValueFactory<>("subject_name"));
        subject_tin.setCellValueFactory(new PropertyValueFactory<>("subject_tin"));
        subject_email.setCellValueFactory(new PropertyValueFactory<>("subject_email"));
        contract_details.setCellValueFactory(new PropertyValueFactory<>("contract_details"));
        subject_of_the_contract.setCellValueFactory(new PropertyValueFactory<>("subject_of_the_contract"));
        contract_object.setCellValueFactory(new PropertyValueFactory<>("contract_object"));
        case_status.setCellValueFactory(new PropertyValueFactory<>("case_status"));
        details_of_the_pretension.setCellValueFactory(new PropertyValueFactory<>("details_of_the_pretension"));
        pretension_date.setCellValueFactory(new PropertyValueFactory<>("pretension_date"));
        payment_term.setCellValueFactory(new PropertyValueFactory<>("payment_term"));
        amount_payable.setCellValueFactory(new PropertyValueFactory<>("amount_payable"));
        state_of_pretension.setCellValueFactory(new PropertyValueFactory<>("state_of_pretension"));
        type_of_claim.setCellValueFactory(new PropertyValueFactory<>("type_of_claim"));
        a_sign_of_special_importance.setCellValueFactory(new PropertyValueFactory<>("a_sign_of_special_importance"));
        the_claim_filing_date.setCellValueFactory(new PropertyValueFactory<>("the_claim_filing_date"));
        outgoing_number.setCellValueFactory(new PropertyValueFactory<>("outgoing_number"));
        state_of_claim.setCellValueFactory(new PropertyValueFactory<>("state_of_claim"));
        date_of_court_hearing.setCellValueFactory(new PropertyValueFactory<>("date_of_court_hearing"));
        court_name.setCellValueFactory(new PropertyValueFactory<>("court_name"));
        court_number.setCellValueFactory(new PropertyValueFactory<>("court_number"));
        full_name_of_judge.setCellValueFactory(new PropertyValueFactory<>("full_name_of_judge"));
        meeting_stage.setCellValueFactory(new PropertyValueFactory<>("meeting_stage"));
        the_courts_decision.setCellValueFactory(new PropertyValueFactory<>("the_courts_decision"));
        effective_date.setCellValueFactory(new PropertyValueFactory<>("effective_date"));
        note.setCellValueFactory(new PropertyValueFactory<>("note"));
        tableContracts.setItems(oblist);

    }

    public void searchRecord(javafx.scene.input.KeyEvent keyEvent) {
        FilteredList<Contracts> filteredData = new FilteredList<>(oblist, p -> true);
        searchfield.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(pers -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String typedText = newValue.toLowerCase();
                if (pers.getExecutor().toLowerCase().indexOf(typedText) != -1) {
                    return true;
                }
                if (pers.getExecutor().toLowerCase().indexOf(typedText) != -1) {
                    return true;
                }
                if (pers.getSubject_name().toLowerCase().indexOf(typedText) != -1) {
                    return true;
                }
                if (pers.getSubject_name().toLowerCase().indexOf(typedText) != -1) {
                    return true;
                }
                if (pers.getSubject_tin().toLowerCase().indexOf(typedText) != -1) {
                    return true;
                }
                if (pers.getSubject_tin().toLowerCase().indexOf(typedText) != -1) {
                    return true;
                }
                if (pers.getSubject_email().toLowerCase().indexOf(typedText) != -1) {
                    return true;
                }
                if (pers.getSubject_email().toLowerCase().indexOf(typedText) != -1) {
                    return true;
                }
                if (pers.getContract_details().toLowerCase().indexOf(typedText) != -1) {
                    return true;
                }
                if (pers.getContract_details().toLowerCase().indexOf(typedText) != -1) {
                    return true;
                }
                if (pers.getSubject_of_the_contract().toLowerCase().indexOf(typedText) != -1) {
                    return true;
                }
                if (pers.getSubject_of_the_contract().toLowerCase().indexOf(typedText) != -1) {
                    return true;
                }
                if (pers.getContract_object().toLowerCase().indexOf(typedText) != -1) {
                    return true;
                }
                if (pers.getContract_object().toLowerCase().indexOf(typedText) != -1) {
                    return true;
                }
                if (pers.getCase_status().toLowerCase().indexOf(typedText) != -1) {
                    return true;
                }
                if (pers.getCase_status().toLowerCase().indexOf(typedText) != -1) {
                    return true;
                }
                return false;
            });
            SortedList<Contracts> sortedList = new SortedList<>(filteredData);
            sortedList.comparatorProperty().bind(tableContracts.comparatorProperty());
            tableContracts.setItems(sortedList);
        });
    }
}

