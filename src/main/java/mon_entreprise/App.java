package mon_entreprise;

import java.util.Scanner;
import java.io.File;
import java.text.SimpleDateFormat;
//import java.time.LocalDate;  // import the LocalDate class
import java.util.Calendar;
//import java.text.ParseException;

public class App {
    public static void main(String[] args) throws Exception {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar newmDateNaissance = Calendar.getInstance();
        Calendar newmDateEmbauche = Calendar.getInstance();
        try {
            // Lecture données employés depuis un fichier
            File myFile = new File("/Users/damien_sop/Documents/Formations/FormationIT/JAVA/Projects/MonEntreprise/employes/DB_Employes.txt");
            Scanner scan = new Scanner(myFile);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] splitLine = line.split(";");

                String newmMatricule = splitLine[0];

                String newmNom = splitLine[1];

                String newmPrenom = splitLine[2];

                String dateNai = splitLine[3];
                 newmDateNaissance.setTime(simpleDateFormat.parse(dateNai));

                String dateEmb = splitLine[4];
                 newmDateEmbauche.setTime(simpleDateFormat.parse(dateEmb));

                String salaire = splitLine[5];
                double newmSalaireBase = Double.parseDouble(salaire);

                // Création de l'instance myEmploye
                Employe myEmploye = new Employe(newmMatricule, newmNom, newmPrenom, newmDateNaissance, newmDateEmbauche, newmSalaireBase);

                myEmploye.afficherEmployer();

        
            } scan.close(); 
             
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
    }  
}
