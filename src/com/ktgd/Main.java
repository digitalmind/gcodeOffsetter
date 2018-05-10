package com.ktgd;

public class Main {

    public static void main(String[] args) {
	// write your code here

        if(args.length>1) {
            System.out.println(args[0]);
            System.out.println(args[1]);

            FileHelper fh = new FileHelper(args[0], args[1]);

            fh.parse();
        }
        else
        {
            System.out.println("Invalid arguments");
        }
    }
}
