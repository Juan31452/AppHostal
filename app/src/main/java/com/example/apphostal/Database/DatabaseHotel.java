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
    public static final String
            COLUMN_ID = "_id",
            COLUMN_FECHA = "fecha",
            COLUMN_HABITACION = "habitacion",
            COLUMN_ESTADO = "estado",
            COLUMN_BAJERAS = "bajeras",
            COLUMN_ENCIMERAS = "encimeras",
            COLUMN_FUNDA_ALMOHADA = "funda_almohada",
            COLUMN_PROTECTOR_ALMOHADA = "protector_almohada",
            COLUMN_NORDICA = "nordica",
            COLUMN_COLCHA_VERANO = "colchav",
            COLUMN_TOALLA_DUCHA = "toalla_ducha",
            COLUMN_TOALLA_LAVABO = "toalla_lavabo",
            COLUMN_ALFOMBRIN = "alfombrin",
            COLUMN_PAID = "paid",
            COLUMN_PROTECTOR_COLCHON = "protector_colchon",
            COLUMN_RELLENO_NORDICO = "relleno_nordico";

    public static final String TABLE_EXTRAS = "extras";
    public static final String
            COLUMN_IDEXTRA = "_idextra",
            COLUMN_REGISTRO_ID = "idregistro",
            COLUMN_AGUA = "agua",
            COLUMN_PAPELH = "papelH",
            COLUMN_CAFEN = "cafeN",
            COLUMN_CAFEC = "cafe_c",
            COLUMN_LECHE = "leche",
            COLUMN_TE_MANZANILLA = "te_manzanilla",
            COLUMN_TE_NEGRO = "te_negro",
            COLUMN_GALLETAS = "galletas",
            COLUMN_AZUCAR = "azucar",
            COLUMN_SACARINA = "sacarina",
            COLUMN_MAQUILLAJE = "maquillaje",
            COLUMN_DULCE_EXTRA = "dulce_extra";

    public static final String TABLE_ROPA_SUCIA = "ropa_sucia";
    public static final String
            ROPA_SUCIA_ID = "_id_ropa_sucia",
            ROPA_SUCIA_FECHA = "fecha_ropa_sucia",
            ROPA_SUCIA_BAJERAS = "bajeras_ropa_sucia",
            ROPA_SUCIA_ENCIMERAS = "encimeras_ropa_sucia",
            ROPA_SUCIA_FUNDA_ALMOHADA = "funda_almohada_ropa_sucia",
            ROPA_SUCIA_PROTECTOR_ALMOHADA = "protector_almohada_ropa_sucia",
            ROPA_SUCIA_NORDICA = "nordica_ropa_sucia",
            ROPA_SUCIA_COLCHA_VERANO = "colchav_ropa_sucia",
            ROPA_SUCIA_TOALLA_DUCHA = "toalla_ducha_ropa_sucia",
            ROPA_SUCIA_TOALLA_LAVABO = "toalla_lavabo_ropa_sucia",
            ROPA_SUCIA_ALFOMBRIN = "alfombrin_ropa_sucia",
            ROPA_SUCIA_PAID = "paid_ropa_sucia",
            ROPA_SUCIA_PROTECTOR_COLCHON = "protector_colchon_ropa_sucia",
            ROPA_SUCIA_RELLENO_NORDICO = "relleno_nordico_ropa_sucia",
            ROPA_SUCIA_ENTREGADO = "entregado_ropa_sucia";

    public static final String TABLE_LAVANDERIA = "lavanderia";
    public static final String
            LAVANDERIA_ID = "_id_lavanderia",
            LAVANDERIA_ROPA_SUCIA_ID = "id_ropa_sucia",
            LAVANDERIA_FECHA = "fecha_lavanderia",
            LAVANDERIA_BAJERAS = "bajeras_lavanderia",
            LAVANDERIA_ENCIMERAS = "encimeras_lavanderia",
            LAVANDERIA_FUNDA_ALMOHADA = "funda_almohada_lavanderia",
            LAVANDERIA_PROTECTOR_ALMOHADA = "protector_almohada_lavanderia",
            LAVANDERIA_NORDICA = "nordica_lavanderia",
            LAVANDERIA_COLCHA_VERANO = "colchav_lavanderia",
            LAVANDERIA_TOALLA_DUCHA = "toalla_ducha_lavanderia",
            LAVANDERIA_TOALLA_LAVABO = "toalla_lavabo_lavanderia",
            LAVANDERIA_ALFOMBRIN = "alfombrin_lavanderia",
            LAVANDERIA_PAID = "paid_lavanderia",
            LAVANDERIA_PROTECTOR_COLCHON = "protector_colchon_lavanderia",
            LAVANDERA_RELLENO_NORDICO = "relleno_nordico_lavanderia";



    // Sentencia SQL corregida para crear la tabla "registros"
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
                    COLUMN_PROTECTOR_COLCHON + " INTEGER DEFAULT 0, " +
                    COLUMN_RELLENO_NORDICO + " INTEGER DEFAULT 0" +
                    ")";


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

                    // Sentencia SQL para crear la tabla "ropa sucia"
                    private static final String SQL_CREATE_TABLE_ROPA_SUCIA =
                    "CREATE TABLE " + TABLE_ROPA_SUCIA + " (" +
                    ROPA_SUCIA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    ROPA_SUCIA_FECHA + " TEXT, " +
                    ROPA_SUCIA_BAJERAS + " INTEGER, " +
                    ROPA_SUCIA_ENCIMERAS + " INTEGER, " +
                    ROPA_SUCIA_FUNDA_ALMOHADA + " INTEGER, " +
                    ROPA_SUCIA_PROTECTOR_ALMOHADA + " INTEGER, " +
                    ROPA_SUCIA_NORDICA + " INTEGER, " +
                    ROPA_SUCIA_COLCHA_VERANO + " INTEGER, " +
                    ROPA_SUCIA_TOALLA_DUCHA + " INTEGER, " +
                    ROPA_SUCIA_TOALLA_LAVABO + " INTEGER, " +
                    ROPA_SUCIA_ALFOMBRIN + " INTEGER, " +
                    ROPA_SUCIA_PAID + " INTEGER, " +
                    ROPA_SUCIA_PROTECTOR_COLCHON + " INTEGER, " +
                    ROPA_SUCIA_RELLENO_NORDICO + " INTEGER, " +
                    ROPA_SUCIA_ENTREGADO + " TEXT" +
                            ");";

            // Sentencia SQL para crear la tabla "lavanderia"
            private static final String SQL_CREATE_TABLE_LAVANDERIA =
                    "CREATE TABLE " + TABLE_LAVANDERIA + " (" +
                            LAVANDERIA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            LAVANDERIA_ROPA_SUCIA_ID + " TEXT, " +
                            LAVANDERIA_FECHA + " TEXT, " +
                            LAVANDERIA_BAJERAS + " INTEGER DEFAULT 0, " +
                            LAVANDERIA_ENCIMERAS + " INTEGER DEFAULT 0, " +
                            LAVANDERIA_FUNDA_ALMOHADA + " INTEGER DEFAULT 0, " +
                            LAVANDERIA_PROTECTOR_ALMOHADA + " INTEGER DEFAULT 0, " +
                            LAVANDERIA_NORDICA + " INTEGER DEFAULT 0, " +
                            LAVANDERIA_COLCHA_VERANO + " INTEGER DEFAULT 0, " +
                            LAVANDERIA_TOALLA_DUCHA + " INTEGER DEFAULT 0, " +
                            LAVANDERIA_TOALLA_LAVABO + " INTEGER DEFAULT 0, " +
                            LAVANDERIA_ALFOMBRIN + " INTEGER DEFAULT 0, " +
                            LAVANDERIA_PAID + " INTEGER DEFAULT 0, " +
                            LAVANDERIA_PROTECTOR_COLCHON + " INTEGER DEFAULT 0," +
                            LAVANDERA_RELLENO_NORDICO + " INTEGER DEFAULT 0, " +
                            "FOREIGN KEY(" + LAVANDERIA_ROPA_SUCIA_ID + ") REFERENCES " + TABLE_ROPA_SUCIA + "(" + ROPA_SUCIA_ID + "))";

    // Constructor
    public DatabaseHotel(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear las tablas "registros" y "extras"
        db.execSQL(SQL_CREATE_TABLE_REGISTROS);
        db.execSQL(SQL_CREATE_TABLE_EXTRAS);
        db.execSQL(SQL_CREATE_TABLE_LAVANDERIA);
        db.execSQL(SQL_CREATE_TABLE_ROPA_SUCIA);

    }



    // Método para borrar la base de datos
    public void borrarBaseDatos(Context context) {

        context.deleteDatabase(DATABASE_NAME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    /*    if (oldVersion < 2) {
            // Agregar el nuevo campo a la tabla registros
            db.execSQL("ALTER TABLE " + TABLE_REGISTROS + " ADD COLUMN " + COLUMN_RELLENO_NORDICO + " INTEGER DEFAULT 0");
        }*/
        /*if (oldVersion < 3) {
            // Crear la nueva tabla lavanderia
            String SQL_CREATE_TABLE_LAVANDERIA = "CREATE TABLE " + TABLE_LAVANDERIA + " (" +
                    LAVANDERIA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    LAVANDERIA_FECHA + " TEXT, " +
                    LAVANDERIA_BAJERAS + " INTEGER DEFAULT 0, " +
                    LAVANDERIA_ENCIMERAS + " INTEGER DEFAULT 0, " +
                    LAVANDERIA_FUNDA_ALMOHADA + " INTEGER DEFAULT 0, " +
                    LAVANDERIA_PROTECTOR_ALMOHADA + " INTEGER DEFAULT 0, " +
                    LAVANDERIA_NORDICA + " INTEGER DEFAULT 0, " +
                    LAVANDERIA_COLCHA_VERANO + " INTEGER DEFAULT 0, " +
                    LAVANDERIA_TOALLA_DUCHA + " INTEGER DEFAULT 0, " +
                    LAVANDERIA_TOALLA_LAVABO + " INTEGER DEFAULT 0, " +
                    LAVANDERIA_ALFOMBRIN + " INTEGER DEFAULT 0, " +
                    LAVANDERIA_PAID + " INTEGER DEFAULT 0, " +
                    LAVANDERIA_PROTECTOR_COLCHON + " INTEGER DEFAULT 0," +
                    LAVANDERA_RELLENO_NORDICO + " INTEGER DEFAULT 0 " +");";
        }*/

            /*if (oldVersion < 4) {
                // Agregar el nuevo campo a la tabla registros
                db.execSQL("ALTER TABLE " + TABLE_LAVANDERIA + " ADD COLUMN " + LAVANDERA_RELLENO_NORDICO + " INTEGER DEFAULT 0");

                db.execSQL(SQL_CREATE_TABLE_LAVANDERIA);
            }*/
            // Puedes manejar futuras actualizaciones incrementales aquí

    }
}
