package com.samauntung.samauntung_mobile.databases;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vectorcoder.androidecommerce.models.user_model.UserDetails;


/**
 * User_Info_DB creates the table User_Record and handles all CRUD operations relevant to User_Record
 **/

public class User_Info_DB {

    SQLiteDatabase db;

    // Table Name
    public static final String customer = "customer";
    // Table Columns
    public static final String id_customer                      = "id_customer";
    public static final String username                         = "username";
    public static final String nama                             = "nama";
    public static final String email_cs                         = "email";
    public static final String alamat                           = "alamat";
    public static final Date date                               = "date_register";
    public static final String foto                             = "foto";




    //*********** Returns the Query to Create TABLE_USER_INFO ********//

    public static String createTable() {

        return "CREATE TABLE "+ customer +
                "(" +
                    id_customer      +" TEXT," +
                    usename          +" TEXT," +
                    nama             +" TEXT," +
                    email_cs         +" TEXT," +
                    alamat           +" TEXT," +
                    date_register    +" DATE," +
                    foto             +" IMAGE," +
          
                ")";
    }



    //*********** Insert New User Data ********//

    public void insertUserData(UserDetails user){
        // get and open SQLiteDatabase Instance from static method of DB_Manager class
        db = DB_Manager.getInstance().openDatabase();

        ContentValues values = new ContentValues();

        values.put(id_customer,              user.getid_customer());
        values.put(nama,                     user.getnama());
        values.put(email_cs,                 user.getEmail());
        values.put(alamat,                   user.getalamat());
        values.put(date_register,            user.getdate_register());
        values.put(foto,                     user.getfoto());

        db.insert(customer, null, values);

        // close the Database
        DB_Manager.getInstance().closeDatabase();
    }



    //*********** Get the Details of single User ********//

    public UserDetails getUserData(String userID){
        // get and open SQLiteDatabase Instance from static method of DB_Manager class
        db = DB_Manager.getInstance().openDatabase();

        Cursor cursor =  db.rawQuery( "SELECT * FROM "+ customer +" WHERE "+ id_customer +" =?", new String[] {userID});

        UserDetails userInfo = new UserDetails();


        if (cursor.moveToFirst()) {
            do {
                userInfo.setId_customer(cursor.getString(0));
                userInfo.setnama(cursor.getString(1));
                userInfo.setemail_cs(cursor.getString(2));
                userInfo.setalamat(cursor.getString(3));
                userInfo.setdate_register(cursor.getDate(3));
                userInfo.setfoto(cursor.getString(3));

            } while (cursor.moveToNext());


            // close the Database
            DB_Manager.getInstance().closeDatabase();

            return userInfo;
        }

        return null;
    }



    //*********** Update the Details of existing User ********//

    public void updateUserData(UserDetails user){
        // get and open SQLiteDatabase Instance from static method of DB_Manager class
        db = DB_Manager.getInstance().openDatabase();

        ContentValues values = new ContentValues();

        values.put(id_customer, user.getid_customer());
        values.put(nama, user.getnama());
      

        db.update(customer, values, email +" = ?", new String[]{user.getCustomersEmailAddress()});

        // close the Database
        DB_Manager.getInstance().closeDatabase();
    }



    //*********** Update the Password of existing User ********//

    public void updateUserPassword(UserDetails user){
        // get and open SQLiteDatabase Instance from static method of DB_Manager class
        db = DB_Manager.getInstance().openDatabase();

        ContentValues values = new ContentValues();

        values.put(password,  user.getCustomersPassword());

        db.update(customer, values, id_customer +" = ?", new String[]{user.getCustomersId()});

        // close the Database
        DB_Manager.getInstance().closeDatabase();
    }



    //*********** Delete the Data of the User ********//

    public void deleteUserData(String userID){
        // get and open SQLiteDatabase Instance from static method of DB_Manager class
        db = DB_Manager.getInstance().openDatabase();

        db.delete(customer, id_customer +" = ?", new String[] {userID});

        // close the Database
        DB_Manager.getInstance().closeDatabase();
    }
}
