package com.deetsquad.paperwalletapp;

import java.util.EnumMap;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.io.IOException;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class PaperWalletDriver {
  public static void main(String[] args)
    throws WriterException, IOException
  {
    Scanner scan = new Scanner(System.in);

    //Ask user to enter public key
    System.out.print("Enter public key: ");
    String publicKey = scan.nextLine();

    //Ask user to enter private key
    System.out.print("Enter private key: ");
    String privateKey = scan.nextLine();

    //Close scanner
    scan.close();

    //Create hash map
    Map<EncodeHintType, Object> hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
    //Map<EncodeHintType, Object> hashMap = new HashMap<EncodeHintType, Object>();

    hints.put(EncodeHintType.MARGIN, 0); /* default = 4 */
    hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

    //Assign paths for generated QR Codes
    String publicCodePath = "publicCode.png";
    String privateCodePath = "privateCode.png";

    //Generate QR codes
    CodeGenerator.createQR( publicKey, publicCodePath, "UTF-8", hints, 300, 300);     //public key
    CodeGenerator.createQR( privateKey, privateCodePath, "UTF-8", hints, 300, 300);   //private key
  }
}