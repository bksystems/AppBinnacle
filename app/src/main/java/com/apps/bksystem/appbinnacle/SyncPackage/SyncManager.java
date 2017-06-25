package com.apps.bksystem.appbinnacle.SyncPackage;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.DataBase.DB_Helper;
import com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.Entitys.ActividadEntity;
import com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.Entitys.ErpColaboradorEntity;
import com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.Entitys.OficinaEntity;
import com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.Entitys.RutaEntity;
import com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.Entitys.SysDbVersionEntity;
import com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.Entitys.TipoActividadEntity;

import java.net.ProtocolException;
import java.util.List;

/**
 * Created by jcarl on 12/03/2017.
 */

public class SyncManager extends AsyncTask<Void, String, Void> {
    private String TAG = SyncManager.class.getSimpleName();
    private Context context;
    private ProgressDialog pDialog;
    private static String hostname = "http://192.168.1.72";
    private static String port = "8080";
    private static String pageName = "CoreBitacora/core";
    private DB_Helper db_helper;
    //HttpURLConnection urlConnection;

    public SyncManager(Context context) {
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... params) {

        HttpHandler sh = new HttpHandler();

        SysDbVersionEntity db_version_cloud = null;

        db_helper = new DB_Helper(context);

        try{
            publishProgress("Buscando nueva versión..");
            String jsonStrVersionDB = sh.makeServiceCall(hostname + ":" + port + "/" + pageName + "/update_version.php");
            if(jsonStrVersionDB != null){
                db_version_cloud = SynAuxHandlerParse.DB_versionParse(jsonStrVersionDB);
                SQLiteDatabase db = db_helper.getWritableDatabase();
                if(db.getVersion() < db_version_cloud.getId()){
                    //db.setVersion(db_version_cloud.getId());
                }
            }
        }catch (ProtocolException e) {
            e.printStackTrace();
        }

        if(db_version_cloud != null){

            publishProgress("Preparando la actualización....");

            if(db_version_cloud.getTableOficinas() == 1){
                try {
                    List<OficinaEntity> oficinasList = null;
                    publishProgress("Obteniendo oficinas....");
                    String jsonStrOficinas = sh.makeServiceCall(hostname + ":" + port + "/" + pageName + "/oficinas_get_all.php");
                    if (jsonStrOficinas != null) {
                        oficinasList = SynAuxHandlerParse.OficinaParse(jsonStrOficinas);
                        if(oficinasList != null && oficinasList.size() > 0){
                            publishProgress("Actualizando estructura de oficinas....");
                            db_helper.updateOficinas(oficinasList);
                            publishProgress("Se actualizo la estructura de oficinas....");
                        }
                    }
                } catch (ProtocolException e) {
                    e.printStackTrace();
                }
            }

            if(db_version_cloud.getTableColaboradores() == 1){
                List<ErpColaboradorEntity> erpColList = null;
                try {
                    publishProgress("Obteniendo colaboradores....");
                    String jsonStrErpCol = sh.makeServiceCall(hostname + ":" + port + "/" + pageName + "/colaboradores_get_all.php");
                    if (jsonStrErpCol != null) {
                        erpColList = SynAuxHandlerParse.ErpColaboradorParse(jsonStrErpCol);
                        if(erpColList != null && erpColList.size() > 0){
                            publishProgress("Actualizando estructura de colaboradores");
                            db_helper.updateColErp(erpColList);
                            publishProgress("Se actualizo la estructura de colaboradores....");
                        }
                    }
                } catch (ProtocolException e) {
                    e.printStackTrace();
                }
            }

            if(db_version_cloud.getTableRutas() == 1){
                List<RutaEntity> rutasList = null;
                try {
                    publishProgress("Obteniendo rutas....");
                    String jsonStrRuta = sh.makeServiceCall(hostname + ":" + port + "/" + pageName + "/rutas_get_all.php");
                    if (jsonStrRuta != null) {
                        rutasList = SynAuxHandlerParse.RutaParse(jsonStrRuta);
                        if(rutasList != null && rutasList.size() > 0){
                            publishProgress("Actualizando estructura de rutas");
                            db_helper.updateRutas(rutasList);
                            publishProgress("Se actualizo la estructura de rutas....");
                        }
                    }
                } catch (ProtocolException e) {
                    e.printStackTrace();
                }
            }

            if(db_version_cloud.getTableActividades() == 1){
                List<ActividadEntity> actividadesList = null;
                try{
                    publishProgress("Obteniendo actividades....");
                    String jsonStrActividades = sh.makeServiceCall(hostname + ":" + port + "/" + pageName + "/actividades_get_all.php");
                    if(jsonStrActividades != null){
                        actividadesList = SynAuxHandlerParse.ActividadParse(jsonStrActividades);
                        if(actividadesList != null && actividadesList.size() > 0){
                            publishProgress("Actualizando catalogo de actividades....");
                            db_helper.updateActividades(actividadesList);
                            publishProgress("Catalogos de actividades actualizado....");
                        }
                    }
                }catch (ProtocolException e){
                    e.printStackTrace();
                }
            }

            if(db_version_cloud.getTableTiposActividades() == 1){
                List<TipoActividadEntity> tipoActividadesListList = null;
                try{
                    publishProgress("Obteniendo tipos actividades....");
                    String jsonStrTipoActividades = sh.makeServiceCall(hostname + ":" + port + "/" + pageName + "/tipo_actividad_get_all.php");
                    if(jsonStrTipoActividades != null){
                        tipoActividadesListList = SynAuxHandlerParse.TipoActividadParse(jsonStrTipoActividades);
                        if(tipoActividadesListList != null && tipoActividadesListList.size() > 0){
                            publishProgress("Actualizando catalogo de tipos de actividades....");
                            db_helper.updateTipoActividades(tipoActividadesListList);
                            publishProgress("Catalogos de tipos de actividades actualizado....");
                        }
                    }
                }catch (ProtocolException e){
                    e.printStackTrace();
                }
            }

        }


        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        pDialog.setMessage(values[0]);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(context);
        pDialog.setTitle("Actualizando Bitacora");
        pDialog.setMessage("Conectando con el servidor");
        pDialog.setCancelable(false);
        pDialog.show();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        pDialog.cancel();

    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected void onCancelled(Void aVoid) {
        super.onCancelled(aVoid);
    }
}
