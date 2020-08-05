package mil.system.lokomotifdieseldiindonesia;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    //Private Constructor to avoid object creation from outside classes

    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    //return a singleton instance of Database Access
    public static DatabaseAccess getInstance(Context context){
        if(instance == null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    //Open Database Connection
    public void open(){
        this.database = openHelper.getWritableDatabase();
    }

    public void close(){
        if(database != null){
            this.database.close();
        }
    }

    //Read Data of Lokomotif
    public List<String> getDaftarLokomotif(){
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM lokomotif", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            list.add(cursor.getString(0));
            System.out.println("loko: " + cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public void getDataLokomotif(String idLokomotif){
        String queryString = "SELECT * FROM lokomotif WHERE _id='"+ idLokomotif +"'";
        Cursor cursor = database.rawQuery(queryString, null);
        cursor.moveToFirst();
        for(int i = 0; i < 38; i++){
            if(cursor.getString(i).equalsIgnoreCase("?") || cursor.getString(i).equalsIgnoreCase("-")){
                GeneralVariable.dataLokomotif[i] = "Tidak diketahui";
            }
            else{
                if(i >= 8 && i <= 16) {
                    GeneralVariable.dataLokomotif[i] = cursor.getString(i) + " mm";
                }
                else if(i >= 17 && i <= 18){
                    GeneralVariable.dataLokomotif[i] = cursor.getString(i) + " ton";
                }
                else if(i >= 19 && i <= 22){
                    GeneralVariable.dataLokomotif[i] = cursor.getString(i) + " liter";
                }
                else if(i == 28){
                    GeneralVariable.dataLokomotif[i] = cursor.getString(i) + " km/h";
                }
                else if(i >= 29 && i <= 30){
                    GeneralVariable.dataLokomotif[i] = cursor.getString(i) + " hp";
                }
                else if(i == 31){
                    GeneralVariable.dataLokomotif[i] = cursor.getString(i) + " meter";
                }
                else{
                    GeneralVariable.dataLokomotif[i] = cursor.getString(i);
                }
            }


        }
        cursor.close();
    }

    public String getNamaLokomotif(String idLokomotif){
        String queryString = "SELECT * FROM lokomotif WHERE _id='"+ idLokomotif +"'";
        Cursor cursor = database.rawQuery(queryString, null);
        cursor.moveToFirst();
        String status = cursor.getString(1);
        cursor.close();
        return status;
    }

    public String getProdusenLokomotif(String idLokomotif){
        String queryString = "SELECT * FROM Lokomotif WHERE _id='"+ idLokomotif +"'";
        Cursor cursor = database.rawQuery(queryString, null);
        cursor.moveToFirst();
        String status = cursor.getString(3);
        cursor.close();
        return status;
    }

    public String getModelLokomotif(String idLokomotif){
        String queryString = "SELECT * FROM Lokomotif WHERE _id='"+ idLokomotif +"'";
        Cursor cursor = database.rawQuery(queryString, null);
        cursor.moveToFirst();
        String status = cursor.getString(4);
        cursor.close();
        return status;
    }
}
