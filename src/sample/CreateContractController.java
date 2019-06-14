package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.awt.*;

public class CreateContractController {

    @FXML
    private TextField note;

    @FXML
    private Button registercontractButton;

    @FXML
    private ChoiceBox<String> meeting_stage;

    @FXML
    private TextField court_number;

    @FXML
    private TextField a_sign_of_special_importance;

    @FXML
    private TextField amount_payable;

    @FXML
    private TextField subject_email;

    @FXML
    private TextField date_of_court_hearing;

    @FXML
    private TextField subject_tin;

    @FXML
    private TextField executor;

    @FXML
    private TextField outgoing_number;

    @FXML
    private TextField effective_date;

    @FXML
    private TextField contract_details;

    @FXML
    private TextField pretension_date;

    @FXML
    private ChoiceBox<String> state_of_pretension;

    @FXML
    private TextField type_of_claim;

    @FXML
    private TextField details_of_the_pretension;

    @FXML
    private TextField court_name;

    @FXML
    private TextField payment_term;

    @FXML
    private TextField subject_of_the_contract;

    @FXML
    private TextField contract_object;

    @FXML
    private TextField the_claim_filing_date;

    @FXML
    private ChoiceBox<String> state_of_claim;

    @FXML
    private TextField subject_name;

    @FXML
    private TextField the_courts_decision;

    @FXML
    private TextField full_name_of_judge;

    @FXML
    private ChoiceBox<String> status;

    @FXML
    private DatePicker date_picker;

    @FXML
    void initialize() {

        status.getItems().add("Подготовка");
        status.getItems().add("Стартует");
        status.getItems().add("В процессе");
        status.getItems().add("Завершено");


        state_of_pretension.getItems().add("Подготовка");
        state_of_pretension.getItems().add("Стартует");
        state_of_pretension.getItems().add("В процессе");
        state_of_pretension.getItems().add("Завершено");


        state_of_claim.getItems().add("Подготовка");
        state_of_claim.getItems().add("Стартует");
        state_of_claim.getItems().add("В процессе");
        state_of_claim.getItems().add("Завершено");


        meeting_stage.getItems().add("Предварительное");
        meeting_stage.getItems().add("Основное");
        meeting_stage.getItems().add("Апелляция");
        meeting_stage.getItems().add("Кассация");


        registercontractButton.setOnAction(event -> {

            registercontract();

        });

    }

    private void registercontract() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String subjectofthecontract = subject_of_the_contract.getText();
        String executorr = executor.getText();
        String subjecttin = subject_tin.getText();
        String subjectname = subject_name.getText();
        String contractdetails = contract_details.getText();
        String subjectemail = subject_email.getText();
        String contractobject = contract_object.getText();
        String casestatus = status.getValue();
        String detailsofthe_pretension = details_of_the_pretension.getText();
        String pretensiondate = pretension_date.getText();
        String paymentterm = payment_term.getText();
        String amountpayable = amount_payable.getText();
        String stateofpretension = state_of_pretension.getValue();
        String typeofclaim = type_of_claim.getText();
        String asignofspecialimportance = a_sign_of_special_importance.getText();
        String theclaimfilingdate = the_claim_filing_date.getText();
        String outgoingnumber = outgoing_number.getText();
        String stateofclaim = state_of_claim.getValue();
        String dateofcourthearing = date_of_court_hearing.getText();
        String courtname = court_name.getText();
        String courtnumber = court_number.getText();
        String fullnameofjudge = full_name_of_judge.getText();
        String meetingstage = meeting_stage.getValue();
        String thecourtsdecision = the_courts_decision.getText();
        String effectivedate = effective_date.getText();
        String notee = note.getText();

        Contracts contracts = new Contracts(executorr, subjectname, subjecttin, subjectemail, contractdetails, subjectofthecontract, contractobject, casestatus, detailsofthe_pretension, pretensiondate,
                paymentterm, amountpayable, stateofpretension, typeofclaim, asignofspecialimportance, theclaimfilingdate, outgoingnumber, stateofclaim, dateofcourthearing, courtname, courtnumber,
                fullnameofjudge, meetingstage, thecourtsdecision, effectivedate, notee);

        dbHandler.registercontract(contracts);
    }
}



