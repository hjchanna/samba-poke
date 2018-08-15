package com.hjchanna.samba;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SambaPoke {
    public static void main(String[] args) throws Exception {
        //initializing
        System.out.println("----------------------------------------------------");
        System.out.println("J A V A  S A M B A  P O K E");
        System.out.println("----------------------------------------------------");

        //reading arguments
        if (args.length < 2) {
            System.out.println("Invalid number of arguments. Please input arguments in following format.");
            System.out.println("samba-poke smb://whatever/your/path domain username password");

            throw new Exception("Invalid number of arguments.");
        }
        String path = args[0];
        String domain = args[1];
        String user = args[2];
        String password = args[3];

        System.out.println("Initializing samba connection");
        System.out.println("\tPath     : " + path);
        System.out.println("\tDomain   : " + domain);
        System.out.println("\tUser     : " + user);
        System.out.println("\tPassword : " + password);

        //initializing samba connection
        NtlmPasswordAuthentication authentication = new NtlmPasswordAuthentication(domain, user, password);

        try {
            System.out.println("----------------------------------------------------");
            SmbFile smbFile = new SmbFile(path, authentication);

            //log contents
            if (smbFile.isDirectory()) {
                System.out.println("A DIRECTORY FOUND, LISTING FILES");
                System.out.println("----------------------------------------------------");

                System.out.println("|-" + smbFile.getName());
                for (String child : smbFile.list()) {
                    System.out.println("|\t|-" + child);
                }
            } else {
                System.out.println("A FILE FOUND, PRINTING FILE CONTENT");
                System.out.println("----------------------------------------------------");

                SmbFileInputStream inputStream = new SmbFileInputStream(smbFile);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
            System.out.println("----------------------------------------------------");
        } catch (IOException ex) {
            //error
            System.out.println("SMB_ERROR: " + ex.getMessage());
            throw ex;
        }
    }
}
