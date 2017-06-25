package com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.DataBase;

/**
 * Created by jcarl on 18/03/2017.
 */

public class DataBaseManager {
    /*Atributos para la tabla db_version*/
    public static final String TABLE_NAME_DB_VERSION = "sys_db_version";
    public static final String DB_VERSION_CN_ID = "_id";
    public static final String DB_VERSION_CN_FECHA = "fecha";
    public static final String DB_VERSION_CN_TABLE_OFICINA = "tableoficina";
    public static final String DB_VERSION_CN_TABLE_COLABORADORES = "tablecolaboradores";
    public static final String DB_VERSION_CN_TABLE_RUTAS = "tablerutas";
    public static final String DB_VERSION_CN_TABLE_ACTIVIDADES = "tableactividades";
    public static final String DB_VERSION_CN_TABLE_TIPOS_ACTIVIDADES = "tabletiposactividades";
    public static final String DB_VERSION_CN_DESCRIPCION = "descripcion";


    public static final String CREATE_TABLE_DB_VERSION = "create table " + TABLE_NAME_DB_VERSION + " ("
            + DB_VERSION_CN_ID + " integer primary key autoincrement, "
            + DB_VERSION_CN_FECHA + " date, "
            + DB_VERSION_CN_TABLE_OFICINA + " numeric, "
            + DB_VERSION_CN_TABLE_COLABORADORES + " numeric, "
            + DB_VERSION_CN_TABLE_RUTAS + " numeric, "
            + DB_VERSION_CN_TABLE_ACTIVIDADES + " numeric, "
            + DB_VERSION_CN_TABLE_TIPOS_ACTIVIDADES + " numeric, "
            + DB_VERSION_CN_DESCRIPCION + " text); ";


    /*Atributos para la tabla oficinas*/
    public static final String TABLE_NAME_OFICINAS = "sys_oficinas";
    public static final String OFICINAS_CN_ID = "_id";
    public static final String OFICINAS_CN_CC = "cc";
    public static final String OFICINAS_CN_DIRECCION = "direccion";
    public static final String OFICINAS_CN_SUBDIRECCION = "subdireccion";
    public static final String OFICINAS_CN_REGION = "region";
    public static final String OFICINAS_CN_OFICINA = "oficina";

    public static final String CREATE_TABLE_OFICINAS = "create table " + TABLE_NAME_OFICINAS + " ("
            + OFICINAS_CN_ID + " integer primary key autoincrement, "
            + OFICINAS_CN_CC + " integer, "
            + OFICINAS_CN_DIRECCION + " text, "
            + OFICINAS_CN_SUBDIRECCION + " text, "
            + OFICINAS_CN_REGION + " text, "
            + OFICINAS_CN_OFICINA + " text); ";

    /*Atributos para la tabla colaboradores*/
    public static final String TABLE_NAME_COLABORADORES = "sys_colaboradores";
    public static final String COLABORADORES_CN_ID = "_id";
    public static final String COLABORADORES_CN_CC = "cc";
    public static final String COLABORADORES_CN_NOMIA = "nomina";
    public static final String COLABORADORES_CN_COLABORADOR = "colaborador";
    public static final String COLABORADORES_CN_PUESTO = "puesto";

    public static final String CREATE_TABLE_COLABORADORES = "create table " + TABLE_NAME_COLABORADORES + " ("
            + COLABORADORES_CN_ID + " integer primary key autoincrement, "
            + COLABORADORES_CN_CC + " integer, "
            + COLABORADORES_CN_NOMIA + " integer, "
            + COLABORADORES_CN_COLABORADOR + " text, "
            + COLABORADORES_CN_PUESTO + " text); ";

    /*Atributos para la tabla rutas*/
    public static final String TABLE_NAME_RUTAS = "sys_rutas";
    public static final String RUTAS_CN_ID = "_id";
    public static final String RUTAS_CN_CC = "cc";
    public static final String RUTAS_CN_IDRUTA = "idruta";

    public static final String CREATE_TABLE_RUTAS = "create table " + TABLE_NAME_RUTAS + " ("
            + RUTAS_CN_ID + " integer primary key autoincrement, "
            + RUTAS_CN_CC + " integer, "
            + RUTAS_CN_IDRUTA + " text); ";


    //Atributos para la tabla actividades
    public static  final  String TABLE_NAME_ACTIVIDADES = "sys_actividades";
    public static final String ACTIVIDADES_CN_ID = "_id";
    public static final String ACTIVIDADES_CN_ACTIVIDAD = "actividad";
    public static final String ACTIVIDADES_CN_DESCRIPCION = "descripcion";
    public static final String ACTIVIDADES_CN_SYS_ACTIVIDAD_TIPO_ID = "sys_actividad_tipo_id";

    public static final String CREATE_TABLE_ACTIVIDADES = "create table " + TABLE_NAME_ACTIVIDADES + " ("
            + ACTIVIDADES_CN_ID + " integer primary key autoincrement, "
            + ACTIVIDADES_CN_ACTIVIDAD + " text, "
            + ACTIVIDADES_CN_DESCRIPCION + " text, "
            + ACTIVIDADES_CN_SYS_ACTIVIDAD_TIPO_ID + " integer); ";

    //Atributos para la tabla tipo actividades
    public static  final  String TABLE_NAME_ACTIVIDAD_TIPOS = "sys_actividad_tipos";
    public static final String ACTIVIDAD_TIPOS_CN_ID = "_id";
    public static final String ACTIVIDAD_TIPOS_CN_TIPO = "tipo";
    public static final String ACTIVIDAD_TIPOS_CN_DESCRIPCION = "descripcion";
    public static final String ACTIVIDAD_TIPOS_CN_STATUS = "status";

    public static final String CREATE_TABLE_ACTIVIDAD_TIPOS = "create table " + TABLE_NAME_ACTIVIDAD_TIPOS + " ("
            + ACTIVIDAD_TIPOS_CN_ID + " integer primary key autoincrement, "
            + ACTIVIDAD_TIPOS_CN_TIPO + " text, "
            + ACTIVIDAD_TIPOS_CN_DESCRIPCION + " text, "
            + ACTIVIDAD_TIPOS_CN_STATUS + " integer); ";


}
