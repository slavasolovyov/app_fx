import java.io.File;


public class FileProcessors {

    private final static String SOURCE_FOLDER = "c:\\Users\\vsolovyev\\Screens\\";
    private final static String TARGET_FOLDER = "c:\\Users\\vsolovyev\\Target_folder\\";

    private File[] getFolderList(String path) {
        File folder = new File(path);
        return folder.listFiles();
    }

    public boolean renameFiles(String path) {
        File[] folderList = getFolderList(path);
        for (int i = 0; i < folderList.length; i++) {
            File[] fileList = folderList[i].listFiles();
            for (int j = 0; j < fileList.length; j++) {
                if (fileList[j].isFile()) {
                    fileList[j].renameTo(new File(TARGET_FOLDER, folderList[i].getName() + "_" + j + ".png"));
                    System.out.println(fileList[j].getName() + " : Done");
                } else {
                    renameFiles(fileList[j].getAbsolutePath());
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        FileProcessors fileProcessors =new FileProcessors();
        fileProcessors.renameFiles(SOURCE_FOLDER);
    }
}