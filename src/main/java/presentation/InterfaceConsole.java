package presentation;

import dto.StudentDTO;
import business.EtudiantService;
import business.EtudiantServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class InterfaceConsole {

    private final EtudiantService service = new EtudiantServiceImpl();
    private final Scanner sc = new Scanner(System.in);

    public void start(){

        int choix = 0;

        do {
            System.out.println("Que faire?");
            System.out.println(" 1 - afficher etudiants");
            System.out.println(" 2 - afficher section");
            System.out.println(" 3 - quitter");

            choix = sc.nextInt();
            sc.nextLine();

            switch (choix){
                case 1:
                    displayStudents();
                    break;
                case 2:
                    //
                    break;
                case 3:
                    System.out.println("au revoir");
                    break;
                default:
                    System.out.println("entrée incorrecte");
            }


        } while (choix != 3);

    }

    void displayStudents(){
        try{
            List<StudentDTO> listEtudiant = service.getAllStudents();
            System.out.println("------ ETUDIANTS ------");
            for (StudentDTO studentDTO : listEtudiant) {
                System.out.format("%d - %s - %s[%d/20]\n",
                        studentDTO.getId(),
                        studentDTO.getName(),
                        studentDTO.getSectionName(),
                        studentDTO.getYearResult());
            }
        }
        catch (SQLException ex){
            System.out.println("Erreur de connection aux sources: " + ex.getMessage());
        }

    }

    void displaySections(){
        // TODO
    }



}
