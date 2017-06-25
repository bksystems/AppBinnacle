package com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.Entitys.ActividadEntity;
import com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.Entitys.ErpColaboradorEntity;
import com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.Entitys.OficinaEntity;
import com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.Entitys.RutaEntity;
import com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.Entitys.TipoActividadEntity;

import java.util.List;

/**
 * Created by jcarl on 18/03/2017.
 */

public class DB_Helper extends SQLiteOpenHelper {

    private static final String DB_NAME = "db_binacle_2017.s3db";
    private static int DB_VERSION = 3;


    public DB_Helper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataBaseManager.CREATE_TABLE_DB_VERSION);
        db.execSQL(DataBaseManager.CREATE_TABLE_OFICINAS);
        db.execSQL(DataBaseManager.CREATE_TABLE_RUTAS);
        db.execSQL(DataBaseManager.CREATE_TABLE_COLABORADORES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseManager.TABLE_NAME_DB_VERSION);
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseManager.TABLE_NAME_OFICINAS);
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseManager.TABLE_NAME_COLABORADORES);
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseManager.TABLE_NAME_RUTAS);
        onCreate(db);
    }


    //Actualización de la base de datos

    public boolean updateOficinas(List<OficinaEntity> oficinas){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseManager.TABLE_NAME_OFICINAS);
        db.execSQL(DataBaseManager.CREATE_TABLE_OFICINAS);

        int idOficina = 0;

        if(db!=null){
            for (OficinaEntity os : oficinas) {
                ContentValues values = new ContentValues();
                //values.put("_id", os.getId());
                values.put("cc", os.getCc());
                values.put("direccion", os.getDireccion());
                values.put("subdireccion", os.getSubdireccion());
                values.put("region", os.getRegion());
                values.put("oficina", os.getOficina());

                if(db.isOpen()) {
                    idOficina = (int) db.insert(DataBaseManager.TABLE_NAME_OFICINAS, null, values);
                }
            }

        }

        return true;
    }

    public boolean updateColErp(List<ErpColaboradorEntity> erpColList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseManager.TABLE_NAME_COLABORADORES);
        db.execSQL(DataBaseManager.CREATE_TABLE_COLABORADORES);

        int idColaborador= 0;

        if(db!=null){
            for (ErpColaboradorEntity col : erpColList) {
                ContentValues values = new ContentValues();
                //values.put("_id", os.getId());
                values.put("cc", col.getCc());
                values.put("nomina", col.getNomina());
                values.put("colaborador", col.getColaborador());
                values.put("puesto", col.getPuesto());

                if(db.isOpen()) {
                    idColaborador = (int) db.insert(DataBaseManager.TABLE_NAME_COLABORADORES, null, values);
                }
            }

        }

        return true;
    }

    public boolean updateRutas(List<RutaEntity> rutas){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseManager.TABLE_NAME_RUTAS);
        db.execSQL(DataBaseManager.CREATE_TABLE_RUTAS);

        int idRuta = 0;

        if(db!=null){
            for (RutaEntity ruta : rutas) {
                ContentValues values = new ContentValues();
                //values.put("_id", os.getId());
                values.put("cc", ruta.getCc());
                //values.put("nomina", ruta.getNomina());
                //values.put("colaborador", ruta.getColaborador());
                values.put("idruta", ruta.getRuta());

                if(db.isOpen()) {
                    idRuta = (int) db.insert(DataBaseManager.TABLE_NAME_RUTAS, null, values);
                }
            }

        }

        return true;
    }

    public boolean updateActividades(List<ActividadEntity> actividadesList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseManager.TABLE_NAME_ACTIVIDADES);
        db.execSQL(DataBaseManager.CREATE_TABLE_ACTIVIDADES);

        int idActividad = 0;

        if(db!=null){
            for (ActividadEntity actividad : actividadesList) {
                ContentValues values = new ContentValues();
                values.put("actividad", actividad.getActividad());
                values.put("descripcion", actividad.getDescripcion());
                values.put("sys_actividad_tipo_id", actividad.getSys_actividad_tipo_id());

                if(db.isOpen()) {
                    idActividad = (int) db.insert(DataBaseManager.TABLE_NAME_ACTIVIDADES, null, values);
                }
            }

        }

        return true;
    }

    public boolean updateTipoActividades(List<TipoActividadEntity> tipoActividadesListList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseManager.TABLE_NAME_ACTIVIDAD_TIPOS);
        db.execSQL(DataBaseManager.CREATE_TABLE_ACTIVIDAD_TIPOS);
        int idTipo = 0;
        if(db != null){
            for (TipoActividadEntity tipo : tipoActividadesListList){
                ContentValues values = new ContentValues();
                values.put("tipo", tipo.getTipo());
                values.put("descripcion", tipo.getDescripcion());
                values.put("status", tipo.getStatus());

                if(db.isOpen()){
                    idTipo = (int) db.insert(DataBaseManager.TABLE_NAME_ACTIVIDAD_TIPOS, null, values);
                }
            }
        }
        return true;
    }
}
