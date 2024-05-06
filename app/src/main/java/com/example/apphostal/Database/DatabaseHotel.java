package com.example.apphostal.Database;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHotel extends SQLiteOpenHelper {

    // Nombre de la base de datos
    private static final String DATABASE_NAME = "hostal.db";
    // Versión de la base de datos
    private static final int DATABASE_VERSION = 1;

    // Nombre y columnas de la tabla "registros"
    public static final String TABLE_REGISTROS = "registros";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_FECHA = "fecha";
    public static final String COLUMN_HABITACION = "habitacion";
    public static final String COLUMN_ESTADO = "estado";
    public static final String COLUMN_BAJERAS = "bajeras";
    public static final String COLUMN_ENCIMERAS = "encimeras";
    public static final String COLUMN_FUNDA_ALMOHADA = "funda_almohada";
    public static final String COLUMN_PROTECTOR_ALMOHADA = "protector_almohada";
    public static final String COLUMN_NORDICA = "nordica";
    public static final String COLUMN_TOALLA_DUCHA = "toalla_ducha";
    public static final String COLUMN_TOALLA_LAVABO = "toalla_lavabo";
    public static final String COLUMN_ALFOMBRIN = "alfombrin";
    public static final String COLUMN_PAID = "paid";
    public static final String COLUMN_PROTECTOR_COLCHON = "protector_colchon";

    // Sentencia SQL para crear la tabla "registros"
    private static final String SQL_CREATE_TABLE_REGISTROS =
            "CREATE TABLE " + TABLE_REGISTROS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_FECHA + " TEXT, " +
                    COLUMN_HABITACION + " TEXT, " +
                    COLUMN_ESTADO + " TEXT, " +
                    COLUMN_BAJERAS + " INTEGER DEFAULT 0, " +
                    COLUMN_ENCIMERAS + " INTEGER DEFAULT 0, " +
                    COLUMN_FUNDA_ALMOHADA + " INTEGER DEFAULT 0, " +
                    COLUMN_PROTECTOR_ALMOHADA + " INTEGER DEFAULT 0, " +
                    COLUMN_NORDICA + " INTEGER DEFAULT 0, " +
                    COLUMN_TOALLA_DUCHA + " INTEGER DEFAULT 0, " +
                    COLUMN_TOALLA_LAVABO + " INTEGER DEFAULT 0, " +
                    COLUMN_ALFOMBRIN + " INTEGER DEFAULT 0, " +
                    COLUMN_PAID + " INTEGER DEFAULT 0, " +
                    COLUMN_PROTECTOR_COLCHON + " INTEGER DEFAULT 0)";

    // Constructor
    public DatabaseHotel(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear la tabla "registros"
        db.execSQL(SQL_CREATE_TABLE_REGISTROS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No se requiere actualización para esta versión
    }
}