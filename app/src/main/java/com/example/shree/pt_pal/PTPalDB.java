package com.example.shree.pt_pal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
public class PTPalDB extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "PTPal.db";
    public static final String TBL_PATIENT = "Patient";
    public static final String PATIENT_ID = "Patient_ID";
    public static final String PATIENT_FN = "First_Name";
    public static final String PATIENT_LN = "Last_Name";
    public static final String PATIENT_EMAIL = "Email";
    public static final String PATIENT_PASSWORD = "Password";
    public static final String PATIENT_HEIGHT = "Height";
    public static final String PATIENT_GENDER = "Gender";
    public static final String PATIENT_CREATED_DATE = "Created_Date";
    public static final String TBL_THERAPIST = "Therapist";
    public static final String THERAPIST_ID = "Therapist_ID";
    public static final String THERAPIST_FN = "First_Name";
    public static final String THERAPIST_LN = "Last_Name";
    public static final String THERAPIST_EMAIL = "Email";
    public static final String THERAPIST_PASSWORD = "Password";
    public static final String THERAPIST_CREATED_DATE = "Created Date";
    public static final String TBL_COMPLIANCE = "Compliance";
    public static final String COMPLIANCE_TID = "Therapy_ID";
    public static final String COMPLIANCE_PID = "Patient_ID";
    public static final String COMPLIANCE_EID = "Exercise_ID";
    public static final String COMPLIANCE_DSC = "Daily_Sessions_Completed";
    public static final String COMPLIANCE_TDC = "Total_Days_Completed";
    public static final String COMPLIANCE_CDC = "Consecutive_Days_Completed";
    public static final String COMPLIANCE_SD = "Start_Date";
    public static final String COMPLIANCE_ED = "End_Date";
    public static final String TBL_THERAPY = "Therapy";
    public static final String THERAPY_ID = "Therapy_ID";
    public static final String THERAPY_THERAPIST_ID = "Therapist_ID";
    public static final String THERAPY_PATIENT_ID = "Patient_ID";
    public static final String THERAPY_EXERCISE_ID = "Exercise_ID";
    public static final String THERAPY_SPD = "Sessions_Per_Day";
    public static final String THERAPY_DURATION = "Session_Duration";
    public static final String THERAPY_DPW = "Days_Per_Week";
    public static final String THERAPY_TS = "Total_Sessions";
    public static final String THERAPY_SD = "Start_Date";
    public static final String THERAPY_CREATED_DATE = "Created_Date";
    public static final String TBL_SESSION = "Session";
    public static final String SESSION_ID = "Session_ID";
    public static final String SESSION_PATIENT_ID = "Patient_ID";
    public static final String SESSION_EXERCISE_ID = "Exercise_ID";
    public static final String SESSION_DURATION = "Duration";
    public static final String SESSION_OEXTENTIONS = "Over_Extensions";
    public static final String SESSION_OEXERTIONS = "Over_Exertions";
    public static final String SESSION_FF = "Form_Failures";
    public static final String SESSION_DATE = "Session_Date";
    public static final String TBL_EXERCISES = "Exercises";
    public static final String EXERCISES_ID = "Exercise_ID";
    public static final String EXERCISES_DESCRIPTION = "Description";
    public static final String TBL_TPL = "Therapist_Patient_List";
    public static final String TPL_THERAPIST_ID = "Therapist_ID";
    public static final String TPL_PATIENT_ID = "PATIENT_ID";
    public PTPalDB(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + TBL_PATIENT + " (" +
                PATIENT_ID + " INTEGER UNIQUE PRIMARY KEY AUTOINCREMENT," +
                PATIENT_FN + " TEXT," +
                PATIENT_LN + " TEXT," +
                PATIENT_EMAIL + " TEXT UNIQUE," +
                PATIENT_PASSWORD + " TEXT," +
                PATIENT_HEIGHT + " INTEGER," +
                PATIENT_GENDER + " TEXT, " +
                PATIENT_CREATED_DATE + " TEXT)");
        db.execSQL("create table " + TBL_THERAPIST + " (" +
                THERAPIST_ID + " INTEGER UNIQUE PRIMARY KEY AUTOINCREMENT," +
                THERAPIST_FN + " TEXT," +
                THERAPIST_LN + " TEXT," +
                THERAPIST_EMAIL + " TEXT UNIQUE," +
                THERAPIST_PASSWORD + " TEXT," +
                THERAPIST_CREATED_DATE + " ,TEXT)");

        db.execSQL("create table " + TBL_TPL + " (" +
                TPL_THERAPIST_ID + " INTEGER PRIMARY KEY," +
                TPL_PATIENT_ID + " INTEGER)");
        db.execSQL("create table " + TBL_COMPLIANCE + " (" +
                COMPLIANCE_TID + " INTEGER PRIMARY KEY," +
                COMPLIANCE_PID + " INTEGER," +
                COMPLIANCE_EID + " INTEGER," +
                COMPLIANCE_DSC + " INTEGER," +
                COMPLIANCE_TDC + " INTEGER," +
                COMPLIANCE_CDC + " INTEGER," +
                COMPLIANCE_SD + " TEXT," +
                COMPLIANCE_ED + " TEXT)");
        db.execSQL("create table " + TBL_THERAPY + " (" +
                THERAPY_ID + " INTEGER UNIQUE PRIMARY KEY AUTOINCREMENT," +
                THERAPY_THERAPIST_ID + " INTEGER," +
                THERAPY_PATIENT_ID + " INTEGER," +
                THERAPY_EXERCISE_ID + " INTEGER," +
                THERAPY_DURATION + " INTEGER," +
                THERAPY_SPD + " INTEGER," +
                THERAPY_DPW + " INTEGER," +
                THERAPY_TS + " INTEGER," +
                THERAPY_SD + " TEXT," +
                THERAPY_CREATED_DATE + " TEXT)");
        db.execSQL("create table " + TBL_SESSION + " (" +
                SESSION_ID + " INTEGER UNIQUE PRIMARY KEY AUTOINCREMENT," +
                SESSION_PATIENT_ID + " INTEGER," +
                SESSION_EXERCISE_ID + " INTEGER," +
                SESSION_DURATION + " INTEGER," +
                SESSION_OEXTENTIONS + " TEXT," +
                SESSION_OEXERTIONS + " INTEGER," +
                SESSION_FF + " INTEGER," +
                SESSION_DATE + " TEXT)");
        db.execSQL("create table " + TBL_EXERCISES + " (" +
                EXERCISES_ID + " INTEGER UNIQUE PRIMARY KEY," +
                EXERCISES_DESCRIPTION + " TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TBL_PATIENT);
        db.execSQL("DROP TABLE IF EXISTS " + TBL_THERAPIST);
        db.execSQL("DROP TABLE IF EXISTS " + TBL_COMPLIANCE);
        db.execSQL("DROP TABLE IF EXISTS " + TBL_THERAPY);
        db.execSQL("DROP TABLE IF EXISTS " + TBL_SESSION);
        db.execSQL("DROP TABLE IF EXISTS " + TBL_EXERCISES);
        db.execSQL("DROP TABLE IF EXISTS " + TBL_TPL);
        onCreate(db);
    }
    public boolean insertPatient(String FirstName, String LastName, String Email, String Password, String Gender, int height, String CreatedDate)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PATIENT_FN, FirstName);
        values.put(PATIENT_LN, LastName);
        values.put(PATIENT_EMAIL, Email);
        values.put(PATIENT_GENDER, Gender);
        values.put(PATIENT_PASSWORD, Password);
        values.put(PATIENT_HEIGHT, height);
        values.put(PATIENT_CREATED_DATE, CreatedDate);
        long result = db.insert(TBL_PATIENT, null, values);
        if(result == -1)
        {
            return false;
        }
        else{
            return true;
        }
    }
    public boolean insertTherapist(String FirstName, String LastName, String Email, String Password, String CreatedDate)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(THERAPIST_FN, FirstName);
        values.put(THERAPIST_LN, LastName);
        values.put(THERAPIST_EMAIL, Email);
        values.put(THERAPIST_PASSWORD, Password);
        values.put(THERAPIST_CREATED_DATE, CreatedDate);
        long result = db.insert(TBL_THERAPIST, null, values);
        if(result == -1)
        {
            return false;
        }
        else{
            return true;
        }
    }
    public boolean insertTherapy(int therapistID, int patientID, int exerciseID, int duration, int spd , int dpw, int ts, String sd, String CreatedDate)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(THERAPY_THERAPIST_ID, therapistID);
        values.put(THERAPY_PATIENT_ID, patientID);
        values.put(THERAPY_EXERCISE_ID, exerciseID);
        values.put(THERAPY_DURATION, duration);
        values.put(THERAPY_SPD, spd);
        values.put(THERAPY_DPW, dpw);
        values.put(THERAPY_TS, ts);
        values.put(THERAPY_SD, sd);
        values.put(THERAPY_CREATED_DATE, CreatedDate);
        long result = db.insert(TBL_THERAPY, null, values);
        if(result == -1)
        {
            return false;
        }
        else{
            return true;
        }
    }
    public boolean insertSession(int patientID, int exerciseID, int duration, int ff , int oexert, int oexten, String ed, String CreatedDate)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SESSION_PATIENT_ID, patientID);
        values.put(SESSION_EXERCISE_ID, exerciseID);
        values.put(SESSION_DURATION, exerciseID);
        values.put(SESSION_FF, duration);
        values.put(SESSION_OEXERTIONS, oexert);
        values.put(SESSION_OEXTENTIONS, oexten);
        values.put(SESSION_DATE, CreatedDate);
        long result = db.insert(TBL_SESSION, null, values);
        if(result == -1)
        {
            return false;
        }
        else{
            return true;
        }
    }
    public boolean insertCompliance(int therapyID, int patientID, int exerciseID, int dsc, int tdc , int cdc, String sd, String ed, String CreatedDate)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COMPLIANCE_TID, therapyID);
        values.put(COMPLIANCE_PID, patientID);
        values.put(COMPLIANCE_EID, exerciseID);
        values.put(COMPLIANCE_DSC, dsc);
        values.put(COMPLIANCE_TDC, tdc);
        values.put(COMPLIANCE_CDC, cdc);
        values.put(COMPLIANCE_SD, sd);
        values.put(COMPLIANCE_ED, ed);
        values.put(THERAPY_CREATED_DATE, CreatedDate);
        long result = db.insert(TBL_COMPLIANCE, null, values);
        if(result == -1)
        {
            return false;
        }
        else{
            return true;
        }
    }
    public boolean insertTPL(int therapistID, int patientID)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TPL_THERAPIST_ID, therapistID);
        values.put(TPL_PATIENT_ID, patientID);
        long result = db.insert(TBL_TPL, null, values);
        if(result == -1)
        {
            return false;
        }
        else{
            return true;
        }
    }
    public boolean insertExercises(int exerciseID, String Description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EXERCISES_ID, exerciseID);
        values.put(EXERCISES_DESCRIPTION, Description);
        long result = db.insert(TBL_EXERCISES, null, values);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
}