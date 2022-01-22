import java.io.*;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Пожалуйста, укажите путь к файлу:"); //C:\Users\messo\Desktop\Lessons\TeachMeSkills_HW_Lesson_11\Lesson_11_Docs.txt
        String PTF = sc.next(); // PTF - PathToFile

        String dataFile;
        String infoFile;
        String PTFValidFile = "C:\\Users\\messo\\Desktop\\Lessons\\TeachMeSkills_HW_Lesson_11\\ValidDocs.txt";
        String PTFNotValidFile = "C:\\Users\\messo\\Desktop\\Lessons\\TeachMeSkills_HW_Lesson_11\\NotValidDocs.txt";

        try (FileInputStream DocsFile = new FileInputStream(PTF);
             FileOutputStream ValidFile = new FileOutputStream(PTFValidFile);
             FileOutputStream NotValidFile = new FileOutputStream(PTFNotValidFile);
             BufferedReader DocsFileBuff = new BufferedReader(new InputStreamReader(DocsFile));
             BufferedWriter ValidOutBuff = new BufferedWriter(new OutputStreamWriter(ValidFile));
             BufferedWriter NotValidOutBuff = new BufferedWriter(new OutputStreamWriter(NotValidFile))) {

            while ((dataFile = DocsFileBuff.readLine()) != null) {
                infoFile = Docs.checkDocs(dataFile);
                if (infoFile.isEmpty()) {
                    ValidOutBuff.write(dataFile);
                    ValidOutBuff.newLine();
                    ValidOutBuff.flush();
                } else {
                    NotValidOutBuff.write(dataFile + " - " + infoFile);
                    NotValidOutBuff.newLine();
                    NotValidOutBuff.flush();
                }
                System.out.println(dataFile);
            }

            System.out.println("Хмм...Успешненько?!");


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
