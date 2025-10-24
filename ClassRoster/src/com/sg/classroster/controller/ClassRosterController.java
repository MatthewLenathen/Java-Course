package com.sg.classroster.controller;

import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.service.ClassRosterDataValidationException;
import com.sg.classroster.service.ClassRosterDuplicateIdException;
import com.sg.classroster.service.ClassRosterServiceLayer;
import com.sg.classroster.ui.ClassRosterView;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dto.Student;

import java.util.List;

public class ClassRosterController {
    private final ClassRosterView view;
    //private final ClassRosterDao dao; // If your program has a service layer, controller shouldn't
    // use the DAOs
    private final ClassRosterServiceLayer service;

    public ClassRosterController(ClassRosterServiceLayer service, ClassRosterView view) {
        //this.dao = dao;
        this.service = service;
        this.view = view;
    }


    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listStudents();
                        break;
                    case 2:
                        createStudent();
                        break;
                    case 3:
                        viewStudent();
                        break;
                    case 4:
                        deleteStudent();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        }catch(ClassRosterPersistenceException e){
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }

    private void createStudent() throws ClassRosterPersistenceException {
        view.displayCreateStudentBanner();
        boolean hasErrors = false;
        do{
            Student currentStudent = view.getNewStudentInfo();
            try{
                service.createStudent(currentStudent);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            }catch(ClassRosterDuplicateIdException | ClassRosterDataValidationException e){
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }

        } while(hasErrors);

    }

    private void listStudents() throws ClassRosterPersistenceException {
        view.displayDisplayAllBanner();
        List<Student> studentList = service.getAllStudents();
        view.displayStudentList(studentList);
    }

    private void viewStudent() throws ClassRosterPersistenceException {
        view.displaySingleStudentBanner();
        String stuID = view.getStudentIdChoice();
        Student stu = service.getStudent(stuID);
        view.displayStudent(stu);
    }

    private void deleteStudent() throws ClassRosterPersistenceException {
        view.displayRemoveStudentBanner();
        String studentID = view.getStudentIdChoice();
        Student removedStudent = service.removeStudent(studentID);
        view.displayRemoveResult(removedStudent);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}

