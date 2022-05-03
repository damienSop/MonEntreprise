// import java.text.ParseException;
// import java.text.SimpleDateFormat; 
// import java.time.LocalDate;  // import the LocalDate class
//import java.util.Date;
import java.util.Calendar;   // Import the calendar class
public class Employe {
    // Définition des attributs de la classe et leurs mode d'accès (Getter et Setter)

    private String mMatricule;
        // Getter 
        public String getmMatricule() {
            return mMatricule;
        } 
        // Setter
        public void setmMatricule(String newmMatricule) {
            this.mMatricule = newmMatricule;
        }

    private String mNom;
        //Getter
        public String getmNom() {
            return mNom;
        }
        //Setter
        public void setmNom(String newmNom) {
            this.mNom = newmNom;
        }

    private String mPrenom;
        //Getter
        public String getmPrenom() {
            return mPrenom;
        }
        //Setter
        public void setmPrenom(String newmPrenom) {
            this.mPrenom = newmPrenom;
        }
    
    private double mSalaireBase;
        //Getter
        public double getmSalaireBase() {
            return mSalaireBase; 
        }
        //Setter
        public void setmSalaireBase(double newmSalaireBase) {
            this.mSalaireBase = newmSalaireBase;
        }
    
    private Calendar mDateNaissance;
        // Getter
        public Calendar getmDateNaissance() {
            return mDateNaissance;
        }
        // Setter
        public void setmDateNaissance(Calendar newmDateNaissance) {
            this.mDateNaissance = newmDateNaissance;
        }

    private Calendar mDateEmbauche;
        // Getter
        public Calendar getmDateEmbauche() {
            return mDateEmbauche;
        }
        // Setter
        public void setmDateEmbauche(Calendar newmDateEmbauche) {
            this.mDateEmbauche = newmDateEmbauche;
        }

    //*******  Définition du constructeur ****************//

    public Employe(String matricule, String nom, String prenom, Calendar dateNaissance, Calendar dateEmbauche, double salaireBase) {
        mMatricule = matricule;
        mNom = nom;
        mPrenom = prenom;
        mDateNaissance = dateNaissance;
        mDateEmbauche = dateEmbauche;
        mSalaireBase = salaireBase;

    }

    //****** Définition des méthodes de la classe  ********//

    // Méthode  Calcul age()
    public int calculAge() {
        Calendar dateActuelle = Calendar.getInstance(); 
        dateActuelle.setTime(dateActuelle.getTime()); // Définition date actuelle
        int age = dateActuelle.get(Calendar.YEAR) - this.mDateNaissance.get(Calendar.YEAR); 

        return age;
    }

    // Méthode  Calcul anciennete()
    public int calculAnciennete() {
        Calendar dateActuelle = Calendar.getInstance(); 
        dateActuelle.setTime(dateActuelle.getTime()); // Définition date actuelle
        int anciennete = dateActuelle.get(Calendar.YEAR) - this.mDateEmbauche.get(Calendar.YEAR);

        return anciennete;
    }

    // Méthode calcul augmentation()
    public double calculAugmentation() {
        if (this.calculAnciennete() < 5) {
            double augmentation = 0.02 * this.mSalaireBase;
            return augmentation;
        } else if (this.calculAnciennete() < 10) {
            double augmentation = 0.05 * this.mSalaireBase;
            return augmentation;
        } else {
            double augmentation = 0.1 * this.mSalaireBase;
            return augmentation;  
        }
    } 

    // Méthode Afficher Employe()
    public void afficherEmployer() {
        System.out.println("********************* EMPLOYE **********************");
        System.out.println(" ");
        System.out.println("-   Matricule : " + this.mMatricule);
        System.out.println(" ");

        String nomComplet = this.mNom.toUpperCase() + " " + this.mPrenom.substring(0, 1).toUpperCase() + this.mPrenom.substring(1, this.mPrenom.length()).toLowerCase();
        System.out.println("-   NOM Complet : " + nomComplet);
        System.out.println(" ");

        System.out.println("-   Age : " + this.calculAge() + " ans");
        System.out.println(" ");

        System.out.println("-   Ancienneté : " + this.calculAnciennete() + " ans");
        System.out.println(" ");

        double salaireTotal = this.mSalaireBase + this.calculAugmentation();
        System.out.println("-   Salaire avec augmentation : " + salaireTotal + " euros/an");
        System.out.println(" ");

        System.out.println("NOTE: Pour une ancienneté de " + this.calculAnciennete() + " ans" + " on applique une augmentation de " + this.calculAugmentation() + " " + " euros/an");
        System.out.println(" ");

    } 

}