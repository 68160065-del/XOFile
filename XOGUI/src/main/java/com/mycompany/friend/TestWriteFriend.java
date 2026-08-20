/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.friend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author admin
 */
public class TestWriteFriend {

    public static void main(String[] args) {
        FileOutputStream fos = null;
        Friend f1 = new Friend("Sumalee", 20, "0834325636");
        Friend f2 = new Friend("Kittiya", 20, "0834325635");
        System.out.println(f1);
        System.err.println(f2);
        try {
            File file = new File("friend.dat");
            fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(f1);
            oos.writeObject(f2);
            oos.close();
            fos.close();
            
        } catch (FileNotFoundException ex) {
            System.getLogger(TestWriteFriend.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
            System.getLogger(TestWriteFriend.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } finally {
            try {
                if(fos != null){
                    fos.close();
                }
                fos.close();
            } catch (IOException ex) {
                System.getLogger(TestWriteFriend.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
    }
}
