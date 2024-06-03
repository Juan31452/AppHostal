package com.example.apphostal.Database;
import android.content.ContentValues;
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
    public static final String COLUMN_ID = "_id", COLUMN_FECHA = "fecha", COLUMN_HABITACION = "habitacion", COLUMN_ESTADO = "estado",
            COLUMN_BAJERAS = "bajeras", COLUMN_ENCIMERAS = "encimeras", COLUMN_FUNDA_ALMOHADA = "funda_almohada",
            COLUMN_PROTECTOR_ALMOHADA = "protector_almohada", COLUMN_NORDICA = "nordica", COLUMN_COLCHA_VERANO = "colchav",  COLUMN_TOALLA_DUCHA = "toalla_ducha",
            COLUMN_TOALLA_LAVABO = "toalla_lavabo", COLUMN_ALFOMBRIN = "alfombrin", COLUMN_PAID = "paid",
            COLUMN_PROTECTOR_COLCHON = "protector_colchon";
    public static final String TABLE_EXTRAS = "extras";
    public static final String COLUMN_IDEXTRA = "_idextra", COLUMN_REGISTRO_ID = "idregistro", COLUMN_AGUA = "agua", COLUMN_PAPELH = "papelH", COLUMN_CAFEN = "cafeN",
            COLUMN_CAFEC = "cafe_c", COLUMN_LECHE = "leche", COLUMN_TE_MANZANILLA = "te_manzanilla",
            COLUMN_TE_NEGRO = "te_negro", COLUMN_GALLETAS = "galletas", COLUMN_AZUCAR = "azucar",
            COLUMN_SACARINA = "sacarina", COLUMN_MAQUILLAJE = "maquillaje", COLUMN_DULCE_EXTRA = "dulce_extra";


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
                    COLUMN_COLCHA_VERANO + " INTEGER DEFAULT 0, " +
                    COLUMN_TOALLA_DUCHA + " INTEGER DEFAULT 0, " +
                    COLUMN_TOALLA_LAVABO + " INTEGER DEFAULT 0, " +
                    COLUMN_ALFOMBRIN + " INTEGER DEFAULT 0, " +
                    COLUMN_PAID + " INTEGER DEFAULT 0, " +
                    COLUMN_PROTECTOR_COLCHON + " INTEGER DEFAULT 0)";

    // Sentencia SQL para crear la tabla "extras"
    private static final String SQL_CREATE_TABLE_EXTRAS =
            "CREATE TABLE " + TABLE_EXTRAS + " (" +
                    COLUMN_IDEXTRA + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_REGISTRO_ID + " INTEGER, " +
                    COLUMN_AGUA + " INTEGER DEFAULT 0, " +
                    COLUMN_PAPELH + " INTEGER DEFAULT 0, " +
                    COLUMN_CAFEN + " INTEGER DEFAULT 0, " +
                    COLUMN_CAFEC + " INTEGER DEFAULT 0, " +
                    COLUMN_LECHE + " INTEGER DEFAULT 0, " +
                    COLUMN_TE_MANZANILLA + " INTEGER DEFAULT 0, " +
                    COLUMN_TE_NEGRO + " INTEGER DEFAULT 0, " +
                    COLUMN_GALLETAS + " INTEGER DEFAULT 0, " +
                    COLUMN_AZUCAR + " INTEGER DEFAULT 0, " +
                    COLUMN_SACARINA + " INTEGER DEFAULT 0, " +
                    COLUMN_MAQUILLAJE + " INTEGER DEFAULT 0, " +
                    COLUMN_DULCE_EXTRA + " INTEGER DEFAULT 0, " +
                    "FOREIGN KEY(" + COLUMN_REGISTRO_ID + ") REFERENCES " + TABLE_REGISTROS + "(" + COLUMN_ID + "))";

    // Constructor
    public DatabaseHotel(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear las tablas "registros" y "extras"
        db.execSQL(SQL_CREATE_TABLE_REGISTROS);
        db.execSQL(SQL_CREATE_TABLE_EXTRAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No se requiere actualización para esta versión
    }

    // Método para borrar la base de datos
    public void borrarBaseDatos(Context context) {
        context.deleteDatabase(DATABASE_NAME);
    }


    public void update(String extras, ContentValues values, String s, String[] strings) {


    }
}
