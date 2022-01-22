public class Docs {

    static String checkDocs(String str) {

        String infoDoc = "";

        if (str.length() != 15) {
            infoDoc = "Длина номера документа должна быть 15 символов";
        } else if (!((str.contains("contract")) || (str.contains("docnum")))){
            infoDoc = "Номер документа не содержит сontract или docnum";
        } else {
            infoDoc = "";
        }

        return infoDoc;

    }
}
