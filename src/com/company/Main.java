package com.company;
import java.io.*;

public class Main
{
    public static void main(String[] args) {
        String s, str;
        int i = 0;
        System.out.println("Текст в файле: ");
        try(BufferedReader br = new BufferedReader (new FileReader("text.txt")))
        {
            while((s = br.readLine()) != null){
                System.out.println(s);
                i++;
            }
        }catch (IOException exc){
            System.out.println("Ошибка ввода-вывода: " + exc);
        }
        BufferedReader br1 = new BufferedReader (new InputStreamReader(System.in) );
        System.out.println("Вы можете перезаписать в файл только " + i + " строки.\nДля перехода на новую строку нажмине 'Enter'");
        try(FileWriter writer = new FileWriter("text.txt"))
        {
            do {
                System.out.print(": ");
                str = br1.readLine();
                str = str + "\r\n";
                writer.write(str);
                i--;
            }while (i > 0);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Текст успешно записан в файл!");
    }
}
