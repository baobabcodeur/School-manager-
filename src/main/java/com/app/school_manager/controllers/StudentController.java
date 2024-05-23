package com.app.school_manager.controllers;

import com.app.school_manager.models.Classroom;
import com.app.school_manager.models.Student;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentController implements Initializable {


    @FXML
    private ComboBox<String> classroomText;

    @FXML
    private DatePicker dateOfBirthText;

    @FXML
    private TextField firstnameText;

    @FXML
    private TextField lastnameText;

    @FXML
    private TextField placeOfBirthText;

    @FXML
    private Button register;

    private int currentClassroomIndex = 0;
    private Classroom classroom;
    private final Student student = new Student();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        classroom = new Classroom();
        classroomText.getItems().clear();

      try {
          for (int i = 0; i < classroom.list().size(); i++) {
              classroomText.getItems().add(classroom.list().get(i).getName());

          }

      } catch (Exception e) {

      }
        EventHandler<ActionEvent> classroomsEvent =
                e -> {
                    currentClassroomIndex = classroomText.getSelectionModel().getSelectedIndex();

                };
        classroomText.setOnAction(classroomsEvent);

    }


    @FXML
    private void onSubmitStudent() throws SQLException {
        String firstname = firstnameText.getText().trim();
        String lastname = lastnameText.getText().trim();
        String classroom = String.valueOf(classroomText.getTooltip());
        String dateOfBirth = String.valueOf(dateOfBirthText.getValue());
        String placeOfBirth = placeOfBirthText.getText().trim();


        if (!firstname.isEmpty() &&  !lastname.isEmpty() && !classroom.isEmpty() && !dateOfBirth.isEmpty() && !placeOfBirth.isEmpty()) {
            try {

                student.setFirstname(firstname);
                student.setLastname(lastname);
                student.setClassroom(this.classroom.list().get(currentClassroomIndex));
                student.setDateOfBirth(dateOfBirth);
                student.setPlaceOfBirth(placeOfBirth);




                if (student.getId() == 0) {
                    student.create(student);
                } else {

                }
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Reussie");
                alert.setHeaderText("vous avez bien ajouter l'eleve");
                alert.setContentText("Cliquer sur OK pour continuer a ajouter ");
                alert.show();
              //  fadeTransition("out", modalCoverVBox);
             //   populateProducts();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
