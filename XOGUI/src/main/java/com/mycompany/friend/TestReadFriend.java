/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.friend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author admin
 */
public class TestReadFriend {

    public static void main(String[] args) {
        FileInputStream fis = null;
        File file = new File("friend.dat");
        try {
            fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Friend f1 = (Friend) ois.readObject();
            Friend f2 = (Friend) ois.readObject();
            System.out.println(f1);
            System.out.println(f2);
            ois.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!!! ");
        } catch (IOException ex) {
            System.getLogger(TestReadFriend.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Can not read class!!!");
        } catch (ClassCastException ex) {
            System.out.println("Can not read class!!!");
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                System.getLogger(TestReadFriend.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }

    }
}
