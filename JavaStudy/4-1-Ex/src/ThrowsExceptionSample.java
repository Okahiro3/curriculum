import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
 
class ThrowsExceptionSample {

    public static FileReader fr;
 
    public static void main(String[] args) {
        try {
            inputFile();
        } catch (FileNotFoundException e) { 
            System.out.print("指定されたファイルが存在しませんでした。"); 
        } catch (IOException e) {
            System.out.print("ファイル読み込み中にエラーが発生しました。"); 
        } finally {
            // fr != null でも可
            if (Objects.nonNull(fr)) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
 
    private static void inputFile() throws FileNotFoundException, IOException { 
 
        // 指定ファイルが未存在の場合に例外発生
        fr = new FileReader("sample.txt");
 
        System.out.print("ファイルを読み込みました"); 
 
        outputFileContents(fr);
    }
 
    private static void outputFileContents(final FileReader fr) throws IOException {
 
        int textData;
 
        // テキストを1文字ずつ読み込む（readの返り値はint型で、読み込むデータが無い場合に-1を返す）
        // 文字コードの ASCIIコード を返すため、charへキャストして出力
        while ((textData = fr.read()) != -1) {
            System.out.print((char) textData);
        }
    }
}