package com.apps.bksystem.appbinnacle.SyncPackage;

import android.util.Log;

import com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.Entitys.ActividadEntity;
import com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.Entitys.ErpColaboradorEntity;
import com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.Entitys.OficinaEntity;
import com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.Entitys.RutaEntity;
import com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.Entitys.SysDbVersionEntity;
import com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.Entitys.TipoActividadEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jcarl on 13/03/2017.
 */

public class SynAuxHandlerParse {

    public static List<OficinaEntity> OficinaParse(String jsonStr){
        List<OficinaEntity> oficinas = null;
        try {
            JSONObject jsonObj = new JSONObject(jsonStr);

            JSONArray oficinasArray = jsonObj.getJSONArray("oficinas");

            oficinas = new ArrayList<>();

            for (int i = 0; i < oficinasArray.length(); i++) {

                JSONObject oficinaObject = oficinasArray.getJSONObject(i);

                JSONObject osObj = oficinaObject.getJSONObject("oficina");

                Integer id = osObj.getInt("id");
                Integer cc = osObj.getInt("cc");
                String direccion = osObj.getString("direccion").trim();
                String subdireccion = osObj.getString("subdireccion").trim();
                String region = osObj.getString("region").trim();
                String os = osObj.getString("oficina").trim();

                OficinaEntity oficina = new OficinaEntity(id, cc, direccion, subdireccion, region, os);

                oficinas.add(oficina);

            }
        } catch (final JSONException e) {
            Log.e("ParseOficina", "Json parsing error: " + e.getMessage());
        }
        return oficinas;
    }

    public static List<ErpColaboradorEntity> ErpColaboradorParse(String jsonStr) {
        List<ErpColaboradorEntity> erpColaboradores = null;
        try {
            JSONObject jsonObj = new JSONObject(jsonStr);
            JSONArray colErpArray = jsonObj.getJSONArray("colaboradores");
            erpColaboradores = new ArrayList<>();
            for (int i = 0; i < colErpArray.length(); i++) {
                JSONObject erpColObject = colErpArray.getJSONObject(i);
                JSONObject erpObj = erpColObject.getJSONObject("colaborador");
                Integer id = erpObj.getInt("id");
                Integer cc = erpObj.getInt("cc");
                Integer nomina = erpObj.getInt("nomina");
                String colaborador = erpObj.getString("colaborador").trim();
                String puesto = erpObj.getString("puesto").trim();
                ErpColaboradorEntity erpColEntity = new ErpColaboradorEntity(id, cc, nomina, colaborador, puesto);
                erpColaboradores.add(erpColEntity);
            }
        } catch (final JSONException e) {
            Log.e("ParseErp", "Json parsing error: " + e.getMessage());
        }
        return erpColaboradores;
    }

    public static  List<RutaEntity> RutaParse(String jsonStr){
        List<RutaEntity> rutas = null;
        try{
            JSONObject jsonObject = new JSONObject(jsonStr);
            JSONArray jsonArrayRutas = jsonObject.getJSONArray("rutas");
            rutas = new ArrayList<>();
            for (int i = 0; i < jsonArrayRutas.length(); i++){
                JSONObject rutaObject = jsonArrayRutas.getJSONObject(i);
                JSONObject rtObject = rutaObject.getJSONObject("ruta");
                Integer id = rtObject.getInt("id");
                Integer cc = rtObject.getInt("cc");
                //String oficina = rtObject.getString("oficina");
                String colaborador = rtObject.getString("colaborador").trim();
                int nomina = rtObject.getInt("nomina");
                String idruta = rtObject.getString("ruta").trim();
                RutaEntity ruta = new RutaEntity(id, cc, "", nomina, colaborador, idruta);
                rutas.add(ruta);
            }
        }catch (final  JSONException e){
            Log.e("ParseRuta", "Json parsing error: " + e.getMessage());
        }
        return rutas;
    }

    public static SysDbVersionEntity DB_versionParse(String jsonStrVersionDB) {
        SysDbVersionEntity objVersion = null;
        try {
            JSONObject jsonObj = new JSONObject(jsonStrVersionDB);
            JSONArray arrayVersionJSON = jsonObj.getJSONArray("versions");

            JSONObject objJsonVersion = arrayVersionJSON.getJSONObject(0);
            JSONObject verObj = objJsonVersion.getJSONObject("version");
            Integer id = verObj.getInt("id");
            String fecha = verObj.getString("fecha");
            int tableOficina = verObj.getInt("tableOficina");
            int tableColaboradores = verObj.getInt("tableColaboradores");
            int tableRutas = verObj.getInt("tableRutas");
            int tableActividades = verObj.getInt("tableActividades");
            int tableTiposActividades = verObj.getInt("tableTiposActividades");
            String descripcion = verObj.getString("descripcion");

            objVersion = new SysDbVersionEntity(id, fecha, descripcion, tableOficina, tableColaboradores, tableRutas, tableActividades, tableTiposActividades);

        } catch (final JSONException e) {
            Log.e("ParseVer", "Json parsing error: " + e.getMessage());
        }
        return objVersion;
    }

    public static List<ActividadEntity> ActividadParse(String jsonStrActividades) {
        List<ActividadEntity> actividadesList = null;
        try{
            JSONObject jsonObject = new JSONObject(jsonStrActividades);
            JSONArray jsonArrayActividades = jsonObject.getJSONArray("actividades");
            actividadesList = new ArrayList<>();
            for (int i = 0; i < jsonArrayActividades.length(); i++){
                JSONObject actividadObject = jsonArrayActividades.getJSONObject(i);
                JSONObject actObject = actividadObject.getJSONObject("actividad");
                Integer id = actObject.getInt("id");
                String actividad = actObject.getString("actividad").trim();
                String descripcion = actObject.getString("descripcion").trim();
                int sys_actividad_tipo_id = actObject.getInt("sys_actividad_tipo_id");
                ActividadEntity act = new ActividadEntity(id, actividad, descripcion, sys_actividad_tipo_id);
                actividadesList.add(act);
            }
        }catch (final  JSONException e){
            Log.e("ParseActividad", "Json parsing error: " + e.getMessage());
        }
        return actividadesList;
    }

    public static List<TipoActividadEntity> TipoActividadParse(String jsonStrTipoActividades) {
        List<TipoActividadEntity> tiposActividadList = null;
        try{
            JSONObject jsonObject = new JSONObject(jsonStrTipoActividades);
            JSONArray jsonArrayTipos = jsonObject.getJSONArray("tipos");
            tiposActividadList = new ArrayList<>();
            for(int i = 0; i < jsonArrayTipos.length(); i++){
                JSONObject jsonObjectTipo = jsonArrayTipos.getJSONObject(i);
                JSONObject tipoObjJSON = jsonObjectTipo.getJSONObject("tipo");
                Integer id = tipoObjJSON.getInt("id");
                String tipo = tipoObjJSON.getString("tipo");
                String descripcion = tipoObjJSON.getString("descripcion");
                Integer status = tipoObjJSON.getInt("estatus");
                TipoActividadEntity tipoActividadEntity = new TipoActividadEntity(id, tipo, descripcion, status);
                tiposActividadList.add(tipoActividadEntity);
            }
        }catch (final JSONException e){
            Log.e("ParseTipoActividad", "Json parsing error: " + e.getMessage());
        }
        return tiposActividadList;
    }
}
